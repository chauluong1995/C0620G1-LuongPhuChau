package com.codegym.entity.employee;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Employee implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Please enter name !")
    private String name;

    private String birthday;

    @NotBlank(message = "Please enter ID card !")
    @Pattern(regexp = "^(\\d{9})|(\\d{12})$", message = "Invalid ID card ! Format ID Card is " +
            "XXXXXXXXX or XXXXXXXXXXXX with X is number from 0 to 9 !")
    private String idCard;

    private Double salary;

    @NotBlank(message = "Please enter phone number !")
    @Pattern(regexp = "^(090|091|\\(84\\)(\\+90|\\+91))(\\d{7})$", message = "Invalid phone number ! Format phone " +
            "number is 090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or " +
            "(84)+91xxxxxxx with x is number from 0 to 9 !")
    private String phoneNumber;

    @NotBlank(message = "Please enter email !")
    @Email(message = "Invalid email ! Format email is abc@abc.abc !")
    private String email;

    //    @NotBlank(message = "Please enter address !")
    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//    private AppUser appUser;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        if (employee.salary == null) {
            errors.rejectValue("salary", "salary.empty");
        } else if (employee.salary <= 0) {
            errors.rejectValue("salary", "salary.format");
        }

        if (employee.address.equals("")) {
            errors.rejectValue("address", "address.empty");
        }
    }
}
