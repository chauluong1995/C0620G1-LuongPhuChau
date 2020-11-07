package com.codegym.entity.customer;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

@Entity
public class Customer implements Validator {
    @Id
    @NotBlank(message = "Please enter ID !")
    @Pattern(regexp = "^(KH-)\\d{4}$", message = "Invalid ID ! Format ID is KH-XXXX with X is number from 0 to 9 !")
    private String id;

    @NotBlank(message = "Please enter name !")
    private String name;

    private String birthday;
    private String gender;

    @NotBlank(message = "Please enter ID card !")
    @Pattern(regexp = "^(\\d{9})|(\\d{12})$", message = "Invalid ID card ! Format ID Card is " +
            "XXXXXXXXX or XXXXXXXXXXXX with X is number from 0 to 9 !")
    private String idCard;

    @NotBlank(message = "Please enter phone number !")
    @Pattern(regexp = "^(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})$", message = "Invalid phone number ! Format phone " +
            "number is 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or " +
            "(84)+91xxxxxxx with x is number from 0 to 9 !")
    private String phoneNumber;

    @NotBlank(message = "Please enter email !")
    @Email(message = "Invalid email ! Format email is abc@abc.abc !")
    private String email;

    @NotBlank(message = "Please enter address !")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
