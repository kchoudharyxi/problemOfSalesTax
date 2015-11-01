package com.xebia.main;

import com.xebia.services.TaxCalculator;

public class Main {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        taxCalculator.readInput();
        taxCalculator.view();
    }
}
 