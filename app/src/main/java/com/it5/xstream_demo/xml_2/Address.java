package com.it5.xstream_demo.xml_2;

/**
 * Created by IT5 on 2016/11/14.
 */

public class Address
{
    private String area;
    private String city;
    private String state;
    private String country;
    private int pincode;

    public void setArea(String area) {
        this.area = area;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
    public void setState(String state) {
        this.state = state;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nAddress [ ");
        stringBuilder.append("\narea: ");
        stringBuilder.append(area);
        stringBuilder.append("\ncity: ");
        stringBuilder.append(city);
        stringBuilder.append("\nstate: ");
        stringBuilder.append(state);
        stringBuilder.append("\ncountry: ");
        stringBuilder.append(country);
        stringBuilder.append("\npincode: ");
        stringBuilder.append(pincode);
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
