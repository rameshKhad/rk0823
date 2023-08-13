package com.toolRental.domain;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RentalAgreementResponse {
    public RentalAgreementResponse(String toolCode, String toolType, String toolBrand, int rentalDays, LocalDate checkoutDate, LocalDate dueDate, double dailyRentalCharge, int chargeDays, double preDiscountCharge, double discountPercent, double discountAmount, double finalCharge) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.toolBrand = toolBrand;
        this.rentalDays = rentalDays;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.dailyRentalCharge = dailyRentalCharge;
        this.chargeDays = chargeDays;
        this.preDiscountCharge = preDiscountCharge;
        this.discountPercent = discountPercent;
        this.discountAmount = discountAmount;
        this.finalCharge = finalCharge;
    }

    public RentalAgreementResponse() {}

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode;
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getToolBrand() {
        return toolBrand;
    }

    public void setToolBrand(String toolBrand) {
        this.toolBrand = toolBrand;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getDailyRentalCharge() {
        return dailyRentalCharge;
    }

    public void setDailyRentalCharge(double dailyRentalCharge) {
        this.dailyRentalCharge = dailyRentalCharge;
    }

    public int getChargeDays() {
        return chargeDays;
    }

    public void setChargeDays(int chargeDays) {
        this.chargeDays = chargeDays;
    }

    public double getPreDiscountCharge() {
        return preDiscountCharge;
    }

    public void setPreDiscountCharge(double preDiscountCharge) {
        this.preDiscountCharge = preDiscountCharge;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getFinalCharge() {
        return finalCharge;
    }

    public void setFinalCharge(double finalCharge) {
        this.finalCharge = finalCharge;
    }

    private String toolCode;
    private String toolType;
    private String toolBrand;
    private int rentalDays;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private double dailyRentalCharge;
    private int chargeDays;
    private double preDiscountCharge;
    private double discountPercent;
    private double discountAmount;
    private double finalCharge;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yy");
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
    NumberFormat percentFormatter = NumberFormat.getPercentInstance();

    @Override
    public String toString() {
        return "Tool Code: " + toolCode + '\n' +
                "Tool Type: " + toolType + '\n' +
                "Tool Brand: " + toolBrand + '\n' +
                "Rental Days: " + rentalDays + '\n' +
                "Checkout Date: " + checkoutDate.format(dateTimeFormatter) + '\n' +
                "Due Date: " + dueDate.format(dateTimeFormatter) + '\n' +
                "Daily Rental Charge: " + currencyFormatter.format(dailyRentalCharge) + '\n' +
                "Charge Days: " + chargeDays + '\n' +
                "Pre-discount Charge: " + currencyFormatter.format(preDiscountCharge) + '\n' +
                "Discount Percent: " + percentFormatter.format(discountPercent) + '\n' +
                "Discount Amount: " + currencyFormatter.format(discountAmount) + '\n' +
                "Final Charge: " + currencyFormatter.format(finalCharge);
    }

}
