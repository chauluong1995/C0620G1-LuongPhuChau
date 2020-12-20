package com.sprint1backend.DTO;

// Create by: Mai_HTQ
public class EmployeeDTO {
    private Long id;
    private String employeeCode;
    private String fullName;
    private String birthday;
    private String email;
    private String gender;
    private String phoneNumber;
    private String password;
    private String role;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String employeeCode, String fullName, String birthday, String email, String gender,
                       String phoneNumber, String password, String role) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.fullName = fullName;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
