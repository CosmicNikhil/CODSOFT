package org.atm;

import java.io.IOException;

public class TransactionMain extends ATM {
    public static void main(String[] args) throws IOException {
        ATMInterface atm = new ATM();
        atm.getLogin();
    }
}
