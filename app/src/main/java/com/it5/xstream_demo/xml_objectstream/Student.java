package com.it5.xstream_demo.xml_objectstream;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by IT5 on 2016/11/14.
 */
@XStreamAlias("student")
public class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
