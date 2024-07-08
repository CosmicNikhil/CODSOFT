package org.atm;

import java.text.DecimalFormat;

public class UserAccount implements UserInterface {
    private double checkingBalance = 0;
    private double savingBalance = 0;
    
    DecimalFormat moneyFormat = new DecimalFormat("'₹'##,##,##0.00");

    @Override
    public void checkBalance() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void withdrawFromChecking(double amount) {
        checkingBalance -= amount;
    }

    public void withdrawFromSaving(double amount) {
        savingBalance -= amount;
    }

    public void depositToChecking(double amount) {
        checkingBalance += amount;
    }

    public void depositToSaving(double amount) {
        savingBalance += amount;
    }
}
