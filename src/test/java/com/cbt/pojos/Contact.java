package com.cbt.pojos;
public class Contact {
    private int contactId;

    private String emailAddress;

    private String phone;

    private String premanentAddress;

    public Contact(int contactId, String emailAddress, String phone, String premanentAddress) {
        this.contactId = contactId;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.premanentAddress = premanentAddress;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", emailAddress='" + emailAddress + '\'' +
                ", phone='" + phone + '\'' +
                ", premanentAddress='" + premanentAddress + '\'' +
                '}';
    }

    public void setContactId(int contactId){
        this.contactId = contactId;
    }
    public int getContactId(){
        return this.contactId;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress(){
        return this.emailAddress;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPremanentAddress(String premanentAddress){
        this.premanentAddress = premanentAddress;
    }
    public String getPremanentAddress(){
        return this.premanentAddress;
    }
}

