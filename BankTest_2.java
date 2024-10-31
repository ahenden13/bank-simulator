//Alana Henden, HW3, CST338, 9/27/24
//BankTest_2.java

package task1;

import java.util.LinkedHashSet;
import java.util.Set;

public class BankTest_2 {
    public static void main(String[] args) {
        Bank testBank2 = new Bank("Alana's Bank", new Address("123 Main Street", "12345"));
        Set<Integer> myNums = new LinkedHashSet<>(5);
        myNums.add(1110);
        myNums.add(2222);
        myNums.add(3330);
        myNums.add(4444);
        myNums.add(5550);
        testBank2.setAccountNumbers(myNums);
        Address addr = new Address("123 Circle Drive", "11111");

        //tests to make sure money_market account can not be open w/ even account numbers
        testBank2.openAccount("Alana", addr, "123-456-7890", AccountType.MONEY_MARKET, 100.0);
    }

}
