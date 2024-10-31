//Alana Henden, HW3, CST338, 9/27/24
//Account.java
//This class holds an Account object that takes account information and a customer object. Used to access and
    // set account information and display it when necessary.

package task1;

import java.util.Set;

public class Account {

    private int accountNumber;
    private AccountType accountType;
    private Customer accountHolder;
    private double accountBalance;

    public Account (int accountNumber, AccountType accountType, Customer accountHolder, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountHolder = accountHolder;
        this.accountBalance = accountBalance;
    }

    public void setAccountNumber(int num) {
        this.accountNumber = num;
    }

    public Customer getCustomer() {
        return accountHolder;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    @Override
    public String toString() {
        return String.format("%d (%s) $%.2f - %s: %s", accountNumber, accountType.toString(), accountBalance, accountHolder.getName(), accountHolder.getSSN());
    }
}
