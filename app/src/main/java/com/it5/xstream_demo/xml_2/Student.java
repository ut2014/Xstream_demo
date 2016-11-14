package com.it5.xstream_demo.xml_2;

/**
 * Created by IT5 on 2016/11/14.
 */

public class Student {
    private String firstName;
    private String lastName;
    private int className;
    private int rollNo;
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "address=" + address +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", className=" + className +
                ", rollNo=" + rollNo +
                '}';
    }
}
