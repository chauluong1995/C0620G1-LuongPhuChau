package com.sprint1backend.controller;

import com.sprint1backend.DTO.EmployeeDTO;
import com.sprint1backend.entity.AppAccount;
import com.sprint1backend.entity.AppRole;
import com.sprint1backend.entity.Employee;
import com.sprint1backend.service.employee.EmployeeService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    // Create by: Mai_HTQ _ Get List Employee
    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getListEmployee() {
        List<Employee> listEmployee = this.employeeService.findAllEmployee();
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }

    // Create by: Mai_HTQ _ Get List Role
    @GetMapping("/listRole")
    public ResponseEntity<List<String>> getListRole() {
        List<AppRole> listRole = this.employeeService.findAllByRole();
        List<String> listRoleDTO = new ArrayList<>();
        for (AppRole appRole : listRole) {
            listRoleDTO.add(appRole.getName());
        }
        return new ResponseEntity<>(listRoleDTO, HttpStatus.OK);
    }

    // Create by: Mai_HTQ _ Find Employee By ID
    @GetMapping("/findEmployeeById/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = this.employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    // Create by: Mai_HTQ _ Delete Employee By ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Long id) {
        Employee employee = this.employeeService.findEmployeeById(id);
        employee.getAppAccount().setAppRole(null);
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
}

    // Create by: Mai_HTQ _ Create Employee
    @PostMapping("/createNew")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO employeeDTO) {

        AppAccount appAccount = new AppAccount();
        appAccount.setUsername(employeeDTO.getEmail());
        appAccount.setPassword(employeeDTO.getPassword());
//        newAccount.setPassword(bcryptEncoder.encode(account.getPassword()));


        AppRole role = this.employeeService.findByNameAppRole(employeeDTO.getRole());
        appAccount.setAppRole(role);
        this.employeeService.saveAccount(appAccount);

        Employee employee = new Employee();
        employee.setEmployeeCode(employeeDTO.getEmployeeCode());
        employee.setFullName(employeeDTO.getFullName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(employeeDTO.getBirthday(), formatter);
        employee.setBirthday(localDate);

        if (employeeDTO.getGender().equals("1")) {
            employee.setGender(true);
        } else {
            employee.setGender(false);
        }
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());

        AppAccount appAccount1 = employeeService.findByNameAppAccount(employeeDTO.getEmail());
        employee.setAppAccount(appAccount1);

//        String randomCode = RandomString.make(64);
//        newAccount.setVerificationCode(randomCode);
//        appAccountRepository.save(newAccount);
//        sendVerificationEmail(newAccount, siteURL);

        this.employeeService.saveEmployee(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Create by: Mai_HTQ _ Edit Employee
    @PutMapping("/editEmployee/{id}")
    public ResponseEntity<Void> editEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable long id) {
        Employee employee1 = employeeService.findEmployeeById(id);
        if (employee1 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            AppAccount appAccount = employeeService.findByNameAppAccount(employee1.getAppAccount().getUsername());
//            appAccount.getUsername(employeeDTO.getEmail());
            AppRole role = employeeService.findByNameAppRole(employeeDTO.getRole());
            appAccount.setAppRole(role);
            this.employeeService.saveAccount(appAccount);

            employee1.setEmployeeCode(employeeDTO.getEmployeeCode());
            employee1.setFullName(employeeDTO.getFullName());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate localDate = LocalDate.parse(employeeDTO.getBirthday(), formatter);
            employee1.setBirthday(localDate);
            if (employeeDTO.getGender().equals("1")) {
                employee1.setGender(true);
            } else {
                employee1.setGender(false);
            }
            employee1.setEmail(employeeDTO.getEmail());
            employee1.setPhoneNumber(employeeDTO.getPhoneNumber());
            employeeService.editEmployee(employee1);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    // -------------------------------- Validate ton tai ----------------------------------
    // Create by: Mai_HTQ _ Find Employee By employeeCode
    @GetMapping("/findEmployeeByCode")
    public ResponseEntity<List<Employee>> getEmployeeByCode(@RequestParam String employeeCode) {
        List<Employee> employeeList = this.employeeService.findEmployeeByCode(employeeCode);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    // Create by: Mai_HTQ _ Find Employee By email
    @GetMapping("/findEmployeeByEmail")
    public ResponseEntity<List<Employee>> getEmployeeByEmail(@RequestParam String email) {
        List<Employee> employeeList = this.employeeService.findEmployeeByEmail(email);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    //------------------------------ Search Employee ----------------------------------
    // Create by: Mai_HTQ _ Search Employee by full name
    @GetMapping("/searchFullName/{fullName}")
    public ResponseEntity<List<Employee>> searchFullNameEmployee(@PathVariable String fullName) {
        List<Employee> listEmployee = this.employeeService.findEmployeeByFullNameContaining(fullName);
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }

    // Create by: Mai_HTQ _ Search Employee by phone number
    @GetMapping("/searchPhoneNumber/{phoneNumber}")
    public ResponseEntity<List<Employee>> searchPhoneNumberEmployee(@PathVariable String phoneNumber) {
        List<Employee> listEmployee = this.employeeService.findEmployeeByPhoneNumberContaining(phoneNumber);
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }

    // Create by: Mai_HTQ _ Search Employee by email
    @GetMapping("/searchEmail/{email}")
    public ResponseEntity<List<Employee>> searchEmailEmployee(@PathVariable String email) {
        List<Employee> listEmployee = this.employeeService.findEmployeeByEmailContaining(email);
        return new ResponseEntity<>(listEmployee, HttpStatus.OK);
    }
}
