//Alana Henden, HW3, CST338, 9/27/24
//Bank.java
//This class holds a Bank object that has an arraylist of account numbers available and a set of accounts in the bank.
    //We can open and close accounts, get bank information, and display it to the user. Checks for possible fraud and monitors
    //account types.

package task1;

import java.util.ArrayList;
import java.util.Set;

public class Bank {

    private String bankName;
    private Set<Integer> accountNumbers;
    private ArrayList<Account> accounts;
    private Address bankAddress;

    public Bank(String bankName, Address bankAddress) {
        this.bankName = bankName;
        this.bankAddress = bankAddress;
        accounts = new ArrayList<>(0);
    }

    public boolean openAccount(String customerName, Address customerAddress, String ssn, AccountType accountType, double balance) {
        //if there are already 5 accounts in the bank
        if (accounts.size() == 5) {
            System.out.println("Sorry, this bank is not accepting new clients at this time.");
            return false;
        }

        Customer temp = new Customer(customerName, ssn, customerAddress);

        for (Account a: accounts) {
            //if same customer and same type
            if (a.getCustomer().equals(temp) && (a.getAccountType() == accountType)) {
                System.out.println("Customer " + a.getCustomer().getName() + " already has a " + accountType + " account");
                return false;
            //if ssn matches another account but name does not match
            } else if (a.getCustomer().getSSN().equals(ssn) && (!(a.getCustomer().getName().equals(customerName)))) {
                System.out.println("POTENTIAL IDENTITY FRAUD. ACCOUNT NOT CREATED.");
                return false;
            }
        }

        Account temp2 = new Account (0, accountType, temp, balance);

        int accNum = allocateAccountNumber(temp2);
        if (accNum == -1) {
            System.out.println("ANNA (Account Number Not Allowed)");
            return false;
        } else {
            temp2.setAccountNumber(accNum);
        }

        accounts.add(temp2);
        System.out.println(temp2);
        return true;
    }

    private int allocateAccountNumber(Account account) {
        Integer accountNumber;
        accountNumber = accountNumbers.iterator().next();
        if (account.getAccountType() == AccountType.MONEY_MARKET) {
            if (accountNumber%2 == 1) {
                accountNumbers.remove(accountNumber);
                return accountNumber;
            }
            return -1; //returns -1 if no odd accounts for m_m
        } else {
            accountNumbers.remove(accountNumber);
            return accountNumber;
        }
    }

    public boolean closeAccount(String ssn, AccountType accountType) {
        for (Account a: accounts) {
            if (a.getCustomer().getSSN().equals(ssn) && a.getAccountType() == accountType) {
                int accNum = a.getAccountNumber();
                accountNumbers.add(accNum);
                accounts.remove(a);
                return true;
            }
        }
        return false;
    }

    public boolean customerAccounts(String ssn) {
        boolean found = false;
        for (Account a: accounts) {
            if (a.getCustomer().getSSN().equals(ssn)) {
                a.getCustomer().printCustomer();
                found = true;
            }
        }
        for (Account a: accounts) {
            if (a.getCustomer().getSSN().equals(ssn)) {
                System.out.printf("%s: $%.2f", a.getAccountType().toString(), a.getAccountBalance());
            }
        }
        if (!found) {
            System.out.println("\nNo customer with this SSN.");
        }
        return found;
    }

    public void setAccountNumbers(Set<Integer> accountNumbers) {
        this.accountNumbers = accountNumbers;
    }

    public double getTotalBalance() {
        double sum = 0;
        for (Account a: accounts) {
            sum += a.getAccountBalance();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder bank = new StringBuilder("" + bankName + " at " + bankAddress.getStreet());
        bank.append("\nNumber of Accounts: ");
        bank.append(accounts.size());
        for (Account a: accounts) {
            bank.append("\n\t");
            bank.append(a.toString());
        }
        bank.append("\n");
        bank.append("Bank total balance: $");
        bank.append(getTotalBalance());
        return bank.toString();
    }
}
