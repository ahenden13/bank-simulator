//Alana Henden, HW3, CST338, 9/27/24
//Address.java
//This class holds an Address object that takes is used to access
    //compare addresses when necessary


package task1;

public class Address {

    private String street;
    private String zipCode;

    public Address (String str, String zip) {
        this.street = str;
        this.zipCode = zip;
    }

    public String getStreet() {
        return street;
    }

    public boolean equals (Address other) {
        return ((this.street.equals(other.street)) && (this.zipCode.equals(other.zipCode)));
    }
}
