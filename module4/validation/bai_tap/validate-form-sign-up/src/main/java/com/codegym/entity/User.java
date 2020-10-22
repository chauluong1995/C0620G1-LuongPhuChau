package com.codegym.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity(name = "user")
public class User {
    @Id
    @NotBlank(message = "Please enter your email !")
    @Email
    private String email;

    @Column(name = "first_name")
    @NotBlank(message = "Please enter your first name !")
    @Size(min = 5, max = 45, message = "Length of first name : min 5 and max 45 !")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Please enter your last name !")
    @Size(min = 5, max = 45, message = "Length of last name : min 5 and max 45 !")
    private String lastName;

    @Column(name = "phone_number")
    @Pattern(regexp = "\\d{10}", message = "Invalid phone number !")
    private String phoneNumber;

    @NotNull(message = "Please enter your age !")
    @Min(value = 18, message = "Age must be greater than or equal to 18 !")

    private Integer age;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
