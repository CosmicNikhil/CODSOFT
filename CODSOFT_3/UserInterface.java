package org.atm;

public interface UserInterface {
    void checkBalance();
    public double getCheckingBalance();
    public double getSavingBalance();
    public void withdrawFromChecking(double amount);
    public void withdrawFromSaving(double amount);
    public void depositToChecking(double amount);
    public void depositToSaving(double amount);
}
