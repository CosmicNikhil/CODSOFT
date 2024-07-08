### ATM Project

#### Description
This ATM project is a simulation of a basic ATM (Automated Teller Machine) system written in Java.
It allows users to perform common banking operations such as withdrawing funds, depositing funds, and checking account balances.
The project is structured into several classes to handle different aspects of the ATM's functionality, including user authentication, account management, and transaction processing.

#### Project Flow

**TransactionMain Class (TransactionMain.java)**
- **Description:** The entry point of the project. It extends `ATM` and starts the application.
- **Flow:** The `main` method creates an instance of `ATM` and calls the `getLogin()` method to start the user authentication process.

**ATM Class (ATM.java)**
- **Description:** Handles the main menu options and user interactions after successful login. It also implements the `ATMInterface`.
- **Flow:**
  - The `getLogin()` method handles user authentication by verifying customer number and PIN against a predefined user database.
  - Once authenticated, the `getAccountType()` method is called to display account options (Checking or Saving).
  - Based on user selection, methods like `getChecking()`, `getSaving()`, `getCheckingWithdrawInput()`, `getSavingWithdrawInput()`, `getCheckingDepositInput()`, and `getSavingDepositInput()` are called to perform the respective operations.

**ATMInterface Interface (ATMInterface.java)**
- **Description:** Defines the methods to be implemented in the `ATM` class.
- **Flow:** Ensures that the `ATM` class implements all necessary methods for the ATM operations.

**UserInterface Interface (UserInterface.java)**
- **Description:** Defines the methods to be implemented in the `UserAccount` class.

**UserAccount Class (UserAccount.java)**
- **Description:** Represents a user's bank account with checking and saving balances.
- **Flow:** Instances of this class are used in `ATM` to manage individual user accounts during transactions.

**User Credentials:**
- **User Number:** 12032004, **Password:** 5260
- **User Number:** 15051975, **Password:** 1505
