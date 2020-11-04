package com.codegym.entity.employee;

public class Employee {
    private Integer id;
    private String name;
    private String birthday;
    private String idCard;
    private String salary;
    private String phoneNumber;
    private String email;
    private String address;
    private String idPosition;
    private String idEducationDegree;
    private String idDivision;
    private String userName;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthday;
    }

    public void setBirthDay(String birthDay) {
        this.birthday = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String phone) {
        this.phoneNumber = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(String idPosition) {
        this.idPosition = idPosition;
    }

    public String getIdEducationDegree() {
        return idEducationDegree;
    }

    public void setIdEducationDegree(String idEducationDegree) {
        this.idEducationDegree = idEducationDegree;
    }

    public String getIdDivision() {
        return idDivision;
    }

    public void setIdDivision(String idDivision) {
        this.idDivision = idDivision;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
