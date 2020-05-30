package com.cbt.pojos;
public class Company {
    private Address address;

    private int companyId;

    private String companyName;

    private String startDate;

    private String title;

    public Company(Address address, int companyId, String companyName, String startDate, String title) {
        this.address = address;
        this.companyId = companyId;
        this.companyName = companyName;
        this.startDate = startDate;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Company{" +
                "address=" + address +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public void setAddress(Address address){
        this.address = address;
    }
    public Address getAddress(){
        return this.address;
    }
    public void setCompanyId(int companyId){
        this.companyId = companyId;
    }
    public int getCompanyId(){
        return this.companyId;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    public String getCompanyName(){
        return this.companyName;
    }
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    public String getStartDate(){
        return this.startDate;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
}

