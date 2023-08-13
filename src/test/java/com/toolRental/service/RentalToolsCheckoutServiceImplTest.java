package com.toolRental.service;

import com.toolRental.exception.InvalidDiscountValueException;
import com.toolRental.exception.InvalidRentalDaysException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RentalToolsCheckoutServiceImplTest {
    RentalToolsCheckoutServiceImpl checkoutRentalTools;

    @DisplayName("Provide invalid Discount value and validate the exception")
    @MethodSource("invalidDiscountTestParams")
    @ParameterizedTest
    public void test1(String input) {
        String userInput = String.format(input,
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream byteArrayInputSystem = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputSystem);
        checkoutRentalTools = RentalToolsCheckoutServiceImpl.getRentalToolsCheckoutServiceImpl(byteArrayInputSystem, System.out);
        checkoutRentalTools.validateAndCheckoutProcess();

        assertThrows(InvalidDiscountValueException.class, ()
                -> { throw new InvalidDiscountValueException("Discount Percent must Be Between 0 and 100. Please Re-Enter Discount Percent."); }
        );
    }

    @DisplayName("Provide valid request value and validate the result")
    @MethodSource("validTestParams1")
    @ParameterizedTest
    public void test2(String input, String output) {
        String userInput = String.format(input,
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream byteArrayInputSystem = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputSystem);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        checkoutRentalTools = RentalToolsCheckoutServiceImpl.getRentalToolsCheckoutServiceImpl(byteArrayInputSystem, printStream);
        checkoutRentalTools.validateAndCheckoutProcess();

        List<String> expectedOutputList = Arrays.asList(output.split("\n"));

        String[] lines = baos.toString().split(System.lineSeparator());
        List<String> list = new ArrayList<>(Arrays.asList(lines));
        List<String> actualOutputList = list.stream()
                .filter(toBeRemoved -> !toBeRemoved.startsWith("Enter"))
                        .collect(Collectors.toList());

        Assertions.assertEquals(expectedOutputList,actualOutputList);
    }

    @DisplayName("Provide valid request value and validate the result")
    @MethodSource("validTestParams2")
    @ParameterizedTest
    public void test3(String input, String output) {
        String userInput = String.format(input,
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream byteArrayInputSystem = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputSystem);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        checkoutRentalTools = RentalToolsCheckoutServiceImpl.getRentalToolsCheckoutServiceImpl(byteArrayInputSystem, System.out);
        checkoutRentalTools.validateAndCheckoutProcess();

        List<String> expectedOutputList = Arrays.asList(output.split("\n"));

        String[] lines = baos.toString().split(System.lineSeparator());
        List<String> list = new ArrayList<>(Arrays.asList(lines));
        List<String> actualOutputList = list.stream()
                .filter(toBeRemoved -> !toBeRemoved.startsWith("Enter"))
                .collect(Collectors.toList());

        Assertions.assertEquals(expectedOutputList,actualOutputList);
    }

    @DisplayName("Provide valid request value and validate the result")
    @MethodSource("validTestParams3")
    @ParameterizedTest
    public void test4(String input, String output) {
        String userInput = String.format(input,
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream byteArrayInputSystem = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputSystem);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        checkoutRentalTools = RentalToolsCheckoutServiceImpl.getRentalToolsCheckoutServiceImpl(byteArrayInputSystem, System.out);
        checkoutRentalTools.validateAndCheckoutProcess();

        List<String> expectedOutputList = Arrays.asList(output.split("\n"));

        String[] lines = baos.toString().split(System.lineSeparator());
        List<String> list = new ArrayList<>(Arrays.asList(lines));
        List<String> actualOutputList = list.stream()
                .filter(toBeRemoved -> !toBeRemoved.startsWith("Enter"))
                .collect(Collectors.toList());

        Assertions.assertEquals(expectedOutputList,actualOutputList);
    }

    @DisplayName("Provide valid request value and validate the result")
    @MethodSource("validTestParams4")
    @ParameterizedTest
    public void test5(String input, String output) {
        String userInput = String.format(input,
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream byteArrayInputSystem = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputSystem);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        checkoutRentalTools = RentalToolsCheckoutServiceImpl.getRentalToolsCheckoutServiceImpl(byteArrayInputSystem, System.out);
        checkoutRentalTools.validateAndCheckoutProcess();

        List<String> expectedOutputList = Arrays.asList(output.split("\n"));

        String[] lines = baos.toString().split(System.lineSeparator());
        List<String> list = new ArrayList<>(Arrays.asList(lines));
        List<String> actualOutputList = list.stream()
                .filter(toBeRemoved -> !toBeRemoved.startsWith("Enter"))
                .collect(Collectors.toList());

        Assertions.assertEquals(expectedOutputList,actualOutputList);
    }

    @DisplayName("Provide valid request value and validate the result")
    @MethodSource("validTestParams5")
    @ParameterizedTest
    public void test6(String input, String output) {
        String userInput = String.format(input,
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream byteArrayInputSystem = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputSystem);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        checkoutRentalTools = RentalToolsCheckoutServiceImpl.getRentalToolsCheckoutServiceImpl(byteArrayInputSystem, System.out);
        checkoutRentalTools.validateAndCheckoutProcess();

        List<String> expectedOutputList = Arrays.asList(output.split("\n"));

        String[] lines = baos.toString().split(System.lineSeparator());
        List<String> list = new ArrayList<>(Arrays.asList(lines));
        List<String> actualOutputList = list.stream()
                .filter(toBeRemoved -> !toBeRemoved.startsWith("Enter"))
                .collect(Collectors.toList());

        Assertions.assertEquals(expectedOutputList,actualOutputList);
    }

    @DisplayName("Provide invalid rental days value and validate the exception")
    @MethodSource("invalidRentalTestParams")
    @ParameterizedTest
    public void test7(String input) {
        String userInput = String.format(input,
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream byteArrayInputSystem = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputSystem);
        checkoutRentalTools = RentalToolsCheckoutServiceImpl.getRentalToolsCheckoutServiceImpl(byteArrayInputSystem, System.out);
        checkoutRentalTools.validateAndCheckoutProcess();

        assertThrows(InvalidRentalDaysException.class, ()
                -> { throw new InvalidRentalDaysException("Rental Days Input must be greater than 0. Please Re-Enter."); }
        );
    }

    @DisplayName("Provide invalid number format for rental days value and validate the exception")
    @MethodSource("invalidNumberFormatParams")
    @ParameterizedTest
    public void test8(String input) {
        String userInput = String.format(input,
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream byteArrayInputSystem = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(byteArrayInputSystem);
        checkoutRentalTools = RentalToolsCheckoutServiceImpl.getRentalToolsCheckoutServiceImpl(byteArrayInputSystem, System.out);
        checkoutRentalTools.validateAndCheckoutProcess();

        assertThrows(InvalidRentalDaysException.class, ()
                -> { throw new InvalidRentalDaysException("Rental Days Input must be greater than 0. Please Re-Enter : "); }
        );
    }

    private static Stream<Arguments> invalidDiscountTestParams() {
        return Stream.of(
                Arguments.of("JAKR%s5%s101%s09/03/15")
        );
    }

    private static Stream<Arguments> invalidRentalTestParams() {
        return Stream.of(
                Arguments.of("JAKR%s0%s10%s09/03/15")
        );
    }

    private static Stream<Arguments> invalidNumberFormatParams() {
        return Stream.of(
                Arguments.of("JAKR%sh%s10%s09/03/15")
        );
    }

    private static Stream<Arguments> validTestParams1() {
        return Stream.of(
                Arguments.of("LADW%s3%s10%s07/02/20",
                        "Tool Code: LADW\n" +
                                "Tool Type: Ladder\n" +
                                "Tool Brand: Werner\n" +
                                "Rental Days: 3\n" +
                                "Checkout Date: 07/02/20\n" +
                                "Due Date: 07/05/20\n" +
                                "Daily Rental Charge: $1.99\n" +
                                "Charge Days: 2\n" +
                                "Pre-discount Charge: $3.98\n" +
                                "Discount Percent: 10%\n" +
                                "Discount Amount: $0.40\n" +
                                "Final Charge: $3.58")
        );
    }

    private static Stream<Arguments> validTestParams2() {
        return Stream.of(
                Arguments.of("CHNS%s5%s25%s07/02/15",
                        "Tool Code: CHNS\n" +
                                "Tool Type: Chainsaw\n" +
                                "Tool Brand: Stihl\n" +
                                "Rental Days: 5\n" +
                                "Checkout Date: 07/02/15\n" +
                                "Due Date: 07/07/15\n" +
                                "Daily Rental Charge: $1.49\n" +
                                "Charge Days: 3\n" +
                                "Pre-discount Charge: $4.47\n" +
                                "Discount Percent: 25%\n" +
                                "Discount Amount: $1.12\n" +
                                "Final Charge: $3.35")
        );
    }
    private static Stream<Arguments> validTestParams3() {
        return Stream.of(
                Arguments.of("JAKD%s6%s0%s09/03/15",
                        "Tool Code: JAKD\n" +
                                "Tool Type: Jackhammer\n" +
                                "Tool Brand: DeWalt\n" +
                                "Rental Days: 6\n" +
                                "Checkout Date: 09/03/15\n" +
                                "Due Date: 09/09/15\n" +
                                "Daily Rental Charge: $2.99\n" +
                                "Charge Days: 3\n" +
                                "Pre-discount Charge: $8.97\n" +
                                "Discount Percent: 0%\n" +
                                "Discount Amount: $0.00\n" +
                                "Final Charge: $8.97")
        );
    }
    private static Stream<Arguments> validTestParams4() {
        return Stream.of(
                Arguments.of("JAKR%s9%s0%s07/02/15",
                        "Tool Code: JAKR\n" +
                                "Tool Type: Jackhammer\n" +
                                "Tool Brand: Ridgid\n" +
                                "Rental Days: 9\n" +
                                "Checkout Date: 07/02/15\n" +
                                "Due Date: 07/11/15\n" +
                                "Daily Rental Charge: $2.99\n" +
                                "Charge Days: 5\n" +
                                "Pre-discount Charge: $14.95\n" +
                                "Discount Percent: 0%\n" +
                                "Discount Amount: $0.00\n" +
                                "Final Charge: $14.95")
        );
    }

    private static Stream<Arguments> validTestParams5() {
        return Stream.of(
                Arguments.of("JAKR%s4%s50%s07/02/20",
                        "Tool Code: JAKR\n" +
                                "Tool Type: Jackhammer\n" +
                                "Tool Brand: Ridgid\n" +
                                "Rental Days: 4\n" +
                                "Checkout Date: 07/02/20\n" +
                                "Due Date: 07/06/20\n" +
                                "Daily Rental Charge: $2.99\n" +
                                "Charge Days: 1\n" +
                                "Pre-discount Charge: $2.99\n" +
                                "Discount Percent: 50%\n" +
                                "Discount Amount: $1.50\n" +
                                "Final Charge: $1.50")
        );
    }
}
