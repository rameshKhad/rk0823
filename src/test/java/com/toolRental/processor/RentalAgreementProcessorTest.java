package com.toolRental.processor;

import com.toolRental.domain.RentalAgreementRequest;
import com.toolRental.domain.RentalAgreementResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class RentalAgreementProcessorTest {
    private RentalAgreementRequest rentalAgreementRequest;
    private RentalAgreementProcessor rentalAgreementProcessor;

    @BeforeEach
    void setUp() {
        rentalAgreementProcessor = RentalAgreementProcessor.getRentalAgreementProcessor();
    }

    @Test
    @DisplayName("Provide valid rentalAgreement Request for Jackhammer tool around Independence  : ")
    public void processAndGenerateRentalAgreement(){
        rentalAgreementRequest = new RentalAgreementRequest();
        rentalAgreementRequest.setToolCode("JAKR");
        rentalAgreementRequest.setDiscountPercent(50);
        rentalAgreementRequest.setRentalDayCount(4);
        rentalAgreementRequest.setCheckoutDate(LocalDate.of(2020,07,02));
        RentalAgreementResponse rentalAgreementResponse =  rentalAgreementProcessor.processAndGenerateRentalAgreement(rentalAgreementRequest);

        Assertions.assertNotNull(rentalAgreementResponse);
        Assertions.assertEquals("JAKR", rentalAgreementResponse.getToolCode());
        Assertions.assertEquals("Jackhammer", rentalAgreementResponse.getToolType());
        Assertions.assertEquals("Ridgid", rentalAgreementResponse.getToolBrand());
        Assertions.assertEquals(4, rentalAgreementResponse.getRentalDays());
        Assertions.assertEquals(LocalDate.of(2020,7,2), rentalAgreementResponse.getCheckoutDate());
        Assertions.assertEquals(LocalDate.of(2020,7,6), rentalAgreementResponse.getDueDate());
        Assertions.assertEquals(2.99, rentalAgreementResponse.getDailyRentalCharge());
        Assertions.assertEquals(1, rentalAgreementResponse.getChargeDays());
        Assertions.assertEquals(2.99, rentalAgreementResponse.getPreDiscountCharge());
        Assertions.assertEquals(0.5, rentalAgreementResponse.getDiscountPercent());
        Assertions.assertEquals(1.495, rentalAgreementResponse.getDiscountAmount());
        Assertions.assertEquals(1.495, rentalAgreementResponse.getFinalCharge());
    }

    @Test
    @DisplayName("Provide valid rentalAgreement Request for Chainsaw tool around Labor Day : ")
    public void processAndGenerateRentalAgreement2(){
        rentalAgreementRequest = new RentalAgreementRequest();
        rentalAgreementRequest.setToolCode("CHNS");
        rentalAgreementRequest.setDiscountPercent(0);
        rentalAgreementRequest.setRentalDayCount(6);
        rentalAgreementRequest.setCheckoutDate(LocalDate.of(2015,9,3));
        RentalAgreementResponse rentalAgreementResponse =  rentalAgreementProcessor.processAndGenerateRentalAgreement(rentalAgreementRequest);

        Assertions.assertNotNull(rentalAgreementResponse);
        Assertions.assertEquals("CHNS", rentalAgreementResponse.getToolCode());
        Assertions.assertEquals("Chainsaw", rentalAgreementResponse.getToolType());
        Assertions.assertEquals("Stihl", rentalAgreementResponse.getToolBrand());
        Assertions.assertEquals(6, rentalAgreementResponse.getRentalDays());
        Assertions.assertEquals(LocalDate.of(2015,9,3), rentalAgreementResponse.getCheckoutDate());
        Assertions.assertEquals(LocalDate.of(2015,9,9), rentalAgreementResponse.getDueDate());
        Assertions.assertEquals(1.49, rentalAgreementResponse.getDailyRentalCharge());
        Assertions.assertEquals(4, rentalAgreementResponse.getChargeDays());
        Assertions.assertEquals(5.96, rentalAgreementResponse.getPreDiscountCharge());
        Assertions.assertEquals(0, rentalAgreementResponse.getDiscountPercent());
        Assertions.assertEquals(0, rentalAgreementResponse.getDiscountAmount());
        Assertions.assertEquals(5.96, rentalAgreementResponse.getFinalCharge());
    }
}
