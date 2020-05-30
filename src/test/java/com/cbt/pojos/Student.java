package com.cbt.pojos;

public class Student {
    private String admissionNo;

    private int batch;

    private String birthDate;

    private Company company;

    private Contact contact;

    private String firstName;

    private String gender;

    private String joinDate;

    private String lastName;

    private String major;

    private String password;

    private String section;

    private int studentId;

    private String subject;

    public Student(String admissionNo, int batch, String birthDate, Company company, Contact contact, String firstName, String gender, String joinDate, String lastName, String major, String password, String section, int studentId, String subject) {
        this.admissionNo = admissionNo;
        this.batch = batch;
        this.birthDate = birthDate;
        this.company = company;
        this.contact = contact;
        this.firstName = firstName;
        this.gender = gender;
        this.joinDate = joinDate;
        this.lastName = lastName;
        this.major = major;
        this.password = password;
        this.section = section;
        this.studentId = studentId;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "admissionNo='" + admissionNo + '\'' +
                ", batch=" + batch +
                ", birthDate='" + birthDate + '\'' +
                ", company=" + company +
                ", contact=" + contact +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", joinDate='" + joinDate + '\'' +
                ", lastName='" + lastName + '\'' +
                ", major='" + major + '\'' +
                ", password='" + password + '\'' +
                ", section='" + section + '\'' +
                ", studentId=" + studentId +
                ", subject='" + subject + '\'' +
                '}';
    }

    public void setAdmissionNo(String admissionNo) {
        this.admissionNo = admissionNo;
    }

    public String getAdmissionNo() {
        return this.admissionNo;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public int getBatch() {
        return this.batch;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getJoinDate() {
        return this.joinDate;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return this.major;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSection() {
        return this.section;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }
}
