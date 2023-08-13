package com.toolRental;

import com.toolRental.service.RentalToolsCheckoutServiceImpl;

public class ToolRentalMain {

    public static void main(String[] args) {
        RentalToolsCheckoutServiceImpl
                .getRentalToolsCheckoutServiceImpl(System.in, System.out)
                .checkout();
    }
}