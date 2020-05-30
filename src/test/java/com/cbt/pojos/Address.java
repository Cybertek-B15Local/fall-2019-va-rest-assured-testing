
package com.cbt.pojos;

public class Address {
    private int addressId;

    private String city;

    private String state;

    private String street;

    private int zipCode;

    public Address(int addressId, String city, String state, String street, int zipCode) {
        this.addressId = addressId;
        this.city = city;
        this.state = state;
        this.street = street;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getAddressId() {
        return this.addressId;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getZipCode() {
        return this.zipCode;
    }
}



