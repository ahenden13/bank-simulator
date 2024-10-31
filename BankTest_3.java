//Alana Henden, HW3, CST338, 9/27/24
//BankTest_3.java

package task1;

import java.util.LinkedHashSet;
import java.util.Set;

public class BankTest_3 {
    public static void main(String[] args) {
        Bank testBank3 = new Bank("Alana's Bank", new Address("123 Main Street", "12345"));
        Set<Integer> myNums = new LinkedHashSet<>(5);
        myNums.add(1110);
        myNums.add(2222);
        myNums.add(3330);
        myNums.add(4444);
        myNums.add(5550);
        testBank3.setAccountNumbers(myNums);
        Address addr = new Address("123 Circle Drive", "11111");

        testBank3.openAccount("Alana1", addr, "123-456-7890", AccountType.CHECKING, 100.0);
        testBank3.openAccount("Alana2", addr, "223-456-7890", AccountType.CHECKING, 100.0);
        testBank3.openAccount("Alana3", addr, "323-456-7890", AccountType.SAVINGS, 100.0);
        testBank3.openAccount("Alana4", addr, "423-456-7890", AccountType.SAVINGS, 100.0);
        testBank3.openAccount("Alana5", addr, "523-456-7890", AccountType.CHECKING, 100.0);

        //testing to ensure my getTotalBalance() method is functioning correctly
        System.out.println("output balance: " + testBank3.getTotalBalance());
        System.out.println("expected balance:$500.00");
    }
}

