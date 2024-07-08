package org.atm;

import java.io.IOException;

public interface ATMInterface {
    void getLogin() throws IOException;
    void getAccountType(UserInterface userAccount);
    void getChecking(UserInterface userAccount);
    void getSaving(UserInterface userAccount);
    void getCheckingWithdrawInput(UserInterface userAccount);
    void getSavingWithdrawInput(UserInterface userAccount);
    void getCheckingDepositInput(UserInterface userAccount);
    void getSavingDepositInput(UserInterface userAccount);
}
