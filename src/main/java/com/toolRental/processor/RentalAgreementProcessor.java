package com.toolRental.processor;

import com.toolRental.domain.RentalAgreementRequest;
import com.toolRental.domain.RentalAgreementResponse;
import com.toolRental.domain.Tool;
import com.toolRental.helper.ToolRentalHelper;
import com.toolRental.repository.ToolsRepository;
import com.toolRental.util.DateUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class RentalAgreementProcessor {
    private static RentalAgreementProcessor instance;
    private RentalAgreementProcessor() {}
    public static RentalAgreementProcessor getRentalAgreementProcessor() {
        if (instance == null) {
            instance = new RentalAgreementProcessor();
        }
        return instance;
    }
    public RentalAgreementResponse processAndGenerateRentalAgreement(RentalAgreementRequest rentalAgreementRequest) {
        RentalAgreementResponse rentalAgreementResponse = new RentalAgreementResponse();
        if (ToolRentalHelper.isRentalAgreementRequestValid(rentalAgreementRequest)) {
            Map<String,Tool> tools = ToolsRepository.getToolsRepository().getTools();
            Tool foundTool = tools.get(rentalAgreementRequest.getToolCode());
            if (Objects.nonNull(foundTool)) {
                rentalAgreementResponse.setToolCode(rentalAgreementRequest.getToolCode());
                rentalAgreementResponse.setToolType(foundTool.getToolType());
                rentalAgreementResponse.setToolBrand(foundTool.getBrand());
                rentalAgreementResponse.setRentalDays(rentalAgreementRequest.getRentalDayCount());
                rentalAgreementResponse.setCheckoutDate(rentalAgreementRequest.getCheckoutDate());
                //Calculate Due date
                rentalAgreementResponse.setDueDate(rentalAgreementRequest.getCheckoutDate().plusDays(rentalAgreementRequest.getRentalDayCount()));
                //calculate Daily Rental Charge
                rentalAgreementResponse.setDailyRentalCharge(foundTool.getDailyCharge());
                //calculate chargeable days
                rentalAgreementResponse.setChargeDays(calculateChargeableDays(rentalAgreementResponse.getRentalDays(), rentalAgreementResponse.getCheckoutDate(), foundTool));
                //calculate pre-discount charge
                rentalAgreementResponse.setPreDiscountCharge(foundTool.getDailyCharge() * rentalAgreementResponse.getChargeDays());
                //calculate Discount Percent
                rentalAgreementResponse.setDiscountPercent((double) rentalAgreementRequest.getDiscountPercent() / 100);
                //Calculate Discount Amount
                rentalAgreementResponse.setDiscountAmount(rentalAgreementResponse.getDiscountPercent() * rentalAgreementResponse.getPreDiscountCharge());
                //calculate final charge
                rentalAgreementResponse.setFinalCharge(rentalAgreementResponse.getPreDiscountCharge() - rentalAgreementResponse.getDiscountAmount());
            }
        }
        return rentalAgreementResponse;
    }
    public int calculateChargeableDays(int rentalDayCount, LocalDate checkoutDate, Tool foundTool) {
        int chargeDaysCount = 0;
        for (int i = 1; i <= rentalDayCount; i++) {
            LocalDate date = checkoutDate.plusDays(i);
            DayOfWeek dayOfWeek = date.getDayOfWeek();

            if (DateUtil.isHoliday(date)) {
                if (foundTool.isHolidayCharge()) {
                    chargeDaysCount ++;;
                }
            } else if (DateUtil.isWeekend(dayOfWeek)){
                if(foundTool.isWeekendCharge())
                  chargeDaysCount++;
            } else if (foundTool.isWeekdayCharge()) {
                chargeDaysCount++;
            }
        }
        return chargeDaysCount;
    }
}
