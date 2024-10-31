//Alana Henden, HW3, CST338, 9/27/24
//Customer.java
//This class holds a Customer object that takes personal customer information and an address object.
// Used to access and set print customer information and compare customers when necessary.


package task1;

public class Customer {

    private String customerName;
    private String ssn;
    private Address customerAddress;

    public Customer(String customerName, String ssn, Address customerAddress) {
        this.customerName = customerName;
        this.ssn = ssn;
        this.customerAddress = customerAddress;
    }

    public String getSSN() {
        String temp = this.ssn;
        return temp;
    }

    public String getName() {
        return customerName;
    }

    public Address getAddress() {
        return customerAddress;
    }

    public void printCustomer() {
        System.out.println("" + customerName + " on " + customerAddress.getStreet() + " has the following:");
    }

    public boolean equals (Customer temp) {
        return ((this.customerName.equals(temp.customerName)) && (this.ssn.equals(temp.ssn)) && (this.customerAddress.equals(temp.customerAddress)));
    }

}
