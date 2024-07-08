package org.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class ATM implements ATMInterface {
	
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'₹'##,##,##0.00");

    // User Database that Bank Owns consisting of customer ID and PIN
    HashMap<Integer, Integer> data = new HashMap<>();

    public ATM() {
        data.put(12032004, 5260); // Example: Customer ID 12032004 with PIN 5260
        data.put(15051975, 1505); // Example: Customer ID 15051975 with PIN 1505
        //Can have more entries
    }

    @Override
    public void getLogin() throws IOException {
    	
    	

        System.out.println("Welcome to the ATM!!");

        //Inserting the CreditCard
        //Customer Username,Customer Password
        
        int attempts = 0;
        boolean authenticated = false;

        while (attempts < 3 && !authenticated) {
            System.out.println("Enter your customer Number:");
            int cn = input.nextInt();

            System.out.println("Enter your PIN Number:");
            int pn = input.nextInt();

            if (data.containsKey(cn) && data.get(cn) == pn) {
                UserInterface userAccount = new UserAccount();
                getAccountType(userAccount);
                authenticated = true;
            } else {
                System.err.println("\nWrong Customer Number or Pin Number\n");
                attempts++;
            }
        }

        if (!authenticated) {
            System.err.println("Too many failed attempts. Please try again later.");
        }
    }

    public void getAccountType(UserInterface userAccount) {
        System.out.println("Select the Account you want to Access:");
        System.out.println("Type 1 - Current  Account");
        System.out.println("Type 2 - Saving Account");

        int selection = input.nextInt();

        switch (selection) {
            case 1:
                getChecking(userAccount);
                break;
            case 2:
                getSaving(userAccount);
                break;
            default:
                System.err.println("\n" + "Invalid Choice " + "\n");
                getAccountType(userAccount);
        }
    }

    public void getChecking(UserInterface userAccount) {
        System.out.println("Current Account:");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = input.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Current  Account Balance: " + moneyFormat.format(userAccount.getCheckingBalance()));
                getChecking(userAccount);
                break;
            case 2:
                getCheckingWithdrawInput(userAccount);
                getChecking(userAccount);
                break;
            case 3:
                getCheckingDepositInput(userAccount);
                getChecking(userAccount);
                break;
            case 4:
                System.out.println("Thank you for using this ATM!!");
                break;
            default:
                System.err.println("\n" + "Invalid Choice" + "\n");
                getChecking(userAccount);
        }
    }

    public void getSaving(UserInterface userAccount) {
        System.out.println("Saving Account:");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
        System.out.println("Choice: ");

        int selection = input.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(userAccount.getSavingBalance()));
                getSaving(userAccount);
                break;
            case 2:
                getSavingWithdrawInput(userAccount);
                getSaving(userAccount);
                break;
            case 3:
                getSavingDepositInput(userAccount);
                getSaving(userAccount);
                break;
            case 4:
                System.out.println("Thank you for using this ATM!!");
                break;
            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getSaving(userAccount);
        }
    }

    public void getCheckingWithdrawInput(UserInterface userAccount) {
        System.out.println("Current  Account Balance: " + moneyFormat.format(userAccount.getCheckingBalance()));
        System.out.println("Amount you want to withdraw from Current Account:");
        double amount = input.nextDouble();

        if (userAccount.getCheckingBalance() - amount >= 0) {
            userAccount.withdrawFromChecking(amount);
            System.out.println("New Current  Account Balance: " + moneyFormat.format(userAccount.getCheckingBalance()));
        } else {
            System.err.println("Balance cannot be negative" + "\n");
        }
    }

    public void getSavingWithdrawInput(UserInterface userAccount) {
        System.out.println("Saving Account Balance: " + moneyFormat.format(userAccount.getSavingBalance()));
        System.out.println("Amount you want to withdraw from Saving Account:");
        double amount = input.nextDouble();

        if (amount>=0 && userAccount.getSavingBalance() - amount >= 0) {
            userAccount.withdrawFromSaving(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(userAccount.getSavingBalance()));
        } else {
            System.err.println("Balance cannot be negative" + "\n");
        }
    }

    public void getCheckingDepositInput(UserInterface userAccount) {
        System.out.println("Current  Account Balance: " + moneyFormat.format(userAccount.getCheckingBalance()));
        System.out.println("Amount you want to deposit into Current Account:");
        double amount = input.nextDouble();

        if(amount >= 0)
		{
        	 userAccount.depositToChecking(amount);
             System.out.println("New Current  Account Balance: " + moneyFormat.format(userAccount.getCheckingBalance()));
		}
		else
		{
			System.err.println("Amount cannot be negative" + "\n");
		}
        
       
    }

    public void getSavingDepositInput(UserInterface userAccount) {
        System.out.println("Saving Account Balance: " + moneyFormat.format(userAccount.getSavingBalance()));
        System.out.println("Amount you want to deposit into Saving Account:");
        double amount = input.nextDouble();

        if(amount >= 0)
		{
        	userAccount.depositToSaving(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(userAccount.getSavingBalance()));
		}
		else
		{
			System.err.println("Amount cannot be negative" + "\n");
		}
        
        
    }
}
