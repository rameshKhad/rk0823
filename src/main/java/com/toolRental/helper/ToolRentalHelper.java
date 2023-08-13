package com.toolRental.helper;

import com.toolRental.domain.RentalAgreementRequest;

import java.util.Objects;

public class ToolRentalHelper {
    public static boolean isRentalAgreementRequestValid(RentalAgreementRequest rentalAgreementRequest){
        return (Objects.nonNull(rentalAgreementRequest)
                && (Objects.nonNull(rentalAgreementRequest.getToolCode()) && !rentalAgreementRequest.getToolCode().isEmpty())
                && Objects.nonNull(rentalAgreementRequest.getCheckoutDate()));
    }
}