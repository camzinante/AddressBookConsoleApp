package addressBookApp;

import java.util.Objects;

public class Entry {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public Entry(){}

    public Entry(String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "*******************" +
                "\nFirst Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nPhone Number: " + phoneNumber +
                "\nEmail Address: " + emailAddress +
                "\n*******************";
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this = o) returns true;
//        if (o = null || getClass() != o.getClass() returns false;
//        Entry address = (entry) = o;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry address = (Entry) o;
        return emailAddress.equals(address.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }
}