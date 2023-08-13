package com.toolRental.service;

import com.toolRental.domain.RentalAgreementRequest;
import com.toolRental.domain.RentalAgreementResponse;
import com.toolRental.domain.Tool;
import com.toolRental.exception.InvalidDiscountValueException;
import com.toolRental.exception.InvalidRentalDaysException;
import com.toolRental.processor.RentalAgreementProcessor;
import com.toolRental.repository.ToolsRepository;
import com.toolRental.util.DateUtil;
import com.toolRental.helper.PrintHelper;

import java.io.InputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static com.toolRental.domain.constant.Constants.*;
public class RentalToolsCheckoutServiceImpl implements CheckoutService {
    private static PrintStream printOut;
    private static Scanner scanner;
    private static RentalToolsCheckoutServiceImpl instance;

    private RentalToolsCheckoutServiceImpl() {}

    public static RentalToolsCheckoutServiceImpl getRentalToolsCheckoutServiceImpl(InputStream in, PrintStream out) {
        if (instance == null) {
            instance = new RentalToolsCheckoutServiceImpl();
        }
        scanner = new Scanner(in);
        printOut = out;
        return instance;
    }
    @Override
    public void checkout() {
        int selection = 0;
        do {
            try {
                PrintHelper.displayMainMenu();
                printOut.print(MAIN_MENU_DIPLAY_MENU);
                if (scanner.hasNextInt())
                    selection = scanner.nextInt();
                scanner.nextLine();
                switch (selection) {
                    case 1:
                        PrintHelper.displayCheckoutMenu();
                        break;
                    case 2:
                        validateAndCheckoutProcess();
                        break;
                    case 3:
                        printOut.println(EXITING_THE_PROGRAM);
                        break;
                    default:
                        printOut.println(INVALID_SELECTION);
                }
            } catch (Exception exception) {
                printOut.println(UNEXPECTED_ERROR_OCCURRED + exception.getMessage());
            }
        } while (selection != 3);
        scanner.close();
    }
    public void validateAndCheckoutProcess() {
        boolean abortCheckout = false;
        String inputToolCode;
        while (!abortCheckout) {
            printOut.println(ENTER_TOOL_CODE);
            if (scanner.hasNextLine()) {
                inputToolCode = scanner.nextLine().toUpperCase();
                validateAndProcessToolCode(inputToolCode);
            }
            abortCheckout = true;
        }
    }

    private void validateAndProcessToolCode(String inputToolCode) {
        RentalAgreementRequest rentalAgreementRequest = new RentalAgreementRequest();
        Map<String,Tool> tools = ToolsRepository.getToolsRepository().getTools();
        if (tools.containsKey(inputToolCode)) {
            Tool foundTool = tools.get(inputToolCode);
            if (Objects.nonNull(foundTool)) {
                rentalAgreementRequest.setToolCode(inputToolCode);
                validateAndProcessRentalDays(rentalAgreementRequest);
            }
        } else
            printOut.println(INVALID_TOOL_CODE + tools.keySet() + RESTART_THE_CHECKOUT_PROCESS);
    }

    private void validateAndProcessRentalDays(RentalAgreementRequest rentalAgreementRequest) {
        boolean abortCheckout = false;
        while (!abortCheckout) {
            int rentalDays;
            printOut.println("Enter Rental Day Count: ");
            try {
                if (scanner.hasNextLine()) {
                    rentalDays = Integer.parseInt(scanner.nextLine());
                    if (rentalDays <= 0) {
                        throw new InvalidRentalDaysException(INVALID_RENTAL_DAYS_EXCEPTION_MESSAGE);
                    } else {
                        rentalAgreementRequest.setRentalDayCount(rentalDays);
                        validateAndProcessDiscountPercent(rentalAgreementRequest);
                    }
                }
                abortCheckout = true;
            } catch (NumberFormatException | InvalidRentalDaysException e) {
                printOut.println(e.getMessage());
            }
        }
    }

    private void validateAndProcessDiscountPercent(RentalAgreementRequest rentalAgreementRequest) {
        boolean abortCheckout = false;
        while (!abortCheckout) {
            int discountPercent;
            printOut.println(ENTER_DISCOUNT_PERCENT);
            try {
                if (scanner.hasNextLine()) {
                    discountPercent = Integer.parseInt(scanner.nextLine());
                    if (discountPercent < 0 || discountPercent > 100) {
                        throw new InvalidDiscountValueException(INVALID_DISCOUNT_PERCENT_MESSAGE);
                    } else {
                        rentalAgreementRequest.setDiscountPercent(discountPercent);
                        validateAndProcessCheckoutDate(rentalAgreementRequest);
                    }
                }
                abortCheckout = true;
            } catch (NumberFormatException | InvalidDiscountValueException e) {
                printOut.println(e.getMessage());
            }
        }
    }

    private void validateAndProcessCheckoutDate(RentalAgreementRequest rentalAgreementRequest) {
        LocalDate checkoutDate;
        boolean abortCheckout = false;
        while (!abortCheckout) {
            printOut.println(ENTER_CHECKOUT_DATE);
            try {
                if (scanner.hasNextLine()) {
                    checkoutDate = DateUtil.getDateFormat().parse(scanner.nextLine()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    rentalAgreementRequest.setCheckoutDate(checkoutDate);
                    RentalAgreementProcessor rentalAgreementProcessor = RentalAgreementProcessor.getRentalAgreementProcessor();
                    RentalAgreementResponse result = rentalAgreementProcessor.processAndGenerateRentalAgreement(rentalAgreementRequest);
                    printOut.println(result.toString());
                }
                abortCheckout = true;
            } catch (ParseException e) {
                printOut.println(INVALID_DATE_ERROR_MESSAGE);
            }
        }
    }
}
