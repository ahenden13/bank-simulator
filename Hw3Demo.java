//Alana Henden, HW3, CST338, 9/27/24
//Hw3Demo.java
//This is the demo file for my bank simulation project. This project has Address, Customer, Account, and Bank objects
    // that all interact to allow users to open and close accounts, have different kinds of accounts, and access bank and
    // account information. We will generate random numbers to assign account numbers and can hold only 5 accounts total.


package task1;

import java.util.Random;
import java.util.Set;
import java.util.LinkedHashSet;

public class Hw3Demo {
    public static void main(String[] args) {
        Bank csumbBank = new Bank("CSUMB", new Address("123 University Center", "93955"));
        csumbBank.setAccountNumbers(generateAccountNumbers());
        System.out.println("\n========== Bank Accounts ==========");
        Address tomAddr = new Address("123 University Center", "93955");
        csumbBank.openAccount("Tom Smith", tomAddr,
                "556-000-9678", AccountType.CHECKING, 10.0 );
        csumbBank.openAccount("Tom Smith", tomAddr,
                "556-000-9678",  AccountType.MONEY_MARKET, 100_050.0);
        csumbBank.openAccount("Alice Smith", new Address("123 University Center", "93955"),
                "543-000-1234",AccountType.SAVINGS,  50.25 );
        csumbBank.openAccount("Joe Otter", new Address("2440 Ocean Avenue", "93900"),
                "542-000-3421", AccountType.MONEY_MARKET, 350.70 );
        csumbBank.openAccount("Johnny Berlin", new Address("99 Carmichael St", "93933"),
                "543-000-1234", AccountType.SAVINGS,  200.23 );
        csumbBank.openAccount("Frankie Hernandez", new Address("23 Plant Place", "90210"),
                "542-000-5439", AccountType.MONEY_MARKET, 350.70 );
        csumbBank.openAccount("Frankie Hernandez", new Address("23 Plant Place", "90210"),
                "542-000-5439", AccountType.SAVINGS, 99.00 );
        csumbBank.openAccount("Giovanna Moreaux", new Address("1 Park Place", "90210"),
                "542-000-1111", AccountType.MONEY_MARKET, 350_0000_000.00 );

        System.out.println("\n========== Bank Info ==========");
        System.out.println(csumbBank);

        System.out.println("\n========== Close Account ==========");
        System.out.println(csumbBank.closeAccount("542-000-5439", AccountType.SAVINGS));
        System.out.println(csumbBank.closeAccount("542-000-1111", AccountType.MONEY_MARKET));

        System.out.println("\n========== Open New Accounts ==========");

        csumbBank.openAccount("Tom Smith", tomAddr,
                "556-000-9678", AccountType.CHECKING, 750.0 );

        //how does this print?
        csumbBank.openAccount("Kieran Mackenzie", new Address("22 Romie Lane", "90010"),
                "556-000-5454", AccountType.CHECKING, 750.0 );

        System.out.println("\n========== Customer Info ==========");
        csumbBank.customerAccounts("556-000-9678");
        csumbBank.customerAccounts("542-000-1111");

        System.out.println("\n========== Bank Info ==========");
        System.out.println(csumbBank);
    }

    public static Set<Integer> generateAccountNumbers() {
        Random random = new Random();
        // uncomment the next line to match the example
        //random.setSeed(123456L);
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        while (uniqueNumbers.size() < 5) {
            int randomNumber = random.nextInt(51) + 7500;
            uniqueNumbers.add(randomNumber);
        }
        System.out.println(uniqueNumbers);
        return uniqueNumbers;
    }
}