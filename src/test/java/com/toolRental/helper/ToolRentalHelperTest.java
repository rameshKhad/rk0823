package com.toolRental.helper;

import com.toolRental.domain.RentalAgreementRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

public class ToolRentalHelperTest {

    @MethodSource("validRentalAgreementRequest")
    @ParameterizedTest
    public void isRentalAgreementRequestValidTrue(RentalAgreementRequest rentalAgreementRequest){
        Assertions.assertTrue(ToolRentalHelper.isRentalAgreementRequestValid(rentalAgreementRequest));
    }

    @MethodSource("invalidRentalAgreementRequest")
    @ParameterizedTest
    public void isRentalAgreementRequestValidFalse(RentalAgreementRequest rentalAgreementRequest){
        Assertions.assertFalse(ToolRentalHelper.isRentalAgreementRequestValid(rentalAgreementRequest));
    }

    private static Stream<Arguments> validRentalAgreementRequest() {
        RentalAgreementRequest validRequest = new RentalAgreementRequest();
        validRequest.setCheckoutDate(LocalDate.of(2023,4,4));
        validRequest.setToolCode("JAKR");
        validRequest.setDiscountPercent(10);
        validRequest.setRentalDayCount(3);

        RentalAgreementRequest invalidRequest = new RentalAgreementRequest();
        invalidRequest.setDiscountPercent(10);
        invalidRequest.setRentalDayCount(3);

        return Stream.of(
                Arguments.of(validRequest)
        );
    }

    private static Stream<Arguments> invalidRentalAgreementRequest() {
        RentalAgreementRequest invalidRequest = new RentalAgreementRequest();
        invalidRequest.setDiscountPercent(10);
        invalidRequest.setRentalDayCount(3);

        return Stream.of(
                Arguments.of(invalidRequest)
        );
    }

}
