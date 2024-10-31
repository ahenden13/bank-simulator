//Alana Henden, HW3, CST338, 9/27/24
//BankTest_1.java

package task1;//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashSet;
import java.util.Set;

public class BankTest_1 {

    public static void main(String[] args) {
        Bank testBank = new Bank("Alana's Bank", new Address("123 Main Street", "12345"));
        Set<Integer> myNums = new LinkedHashSet<>(5);
        myNums.add(1111);
        myNums.add(2222);
        myNums.add(3333);
        myNums.add(4444);
        myNums.add(5555);
        testBank.setAccountNumbers(myNums);
        Address addr = new Address("123 Circle Drive", "11111");
        //checks to make sure openAccount method is working properly and returns appropriate boolean value
        if (testBank.openAccount("Alana", addr, "123-456-7890", AccountType.CHECKING, 100.0)) {
            System.out.println("Account was opened successfully.");
        }


    }

}
