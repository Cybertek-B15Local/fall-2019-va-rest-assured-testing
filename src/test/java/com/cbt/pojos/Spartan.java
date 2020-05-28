package com.cbt.pojos;

public class Spartan {

    private int id;
    private String name;
    private String gender;
    private String phone;

    @Override
    public String toString() {
        return "Spartan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                '}';
    }
}
