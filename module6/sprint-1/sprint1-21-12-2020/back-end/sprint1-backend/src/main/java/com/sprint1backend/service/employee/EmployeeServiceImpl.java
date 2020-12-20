package com.sprint1backend.service.employee;

import com.sprint1backend.entity.AppAccount;
import com.sprint1backend.entity.AppRole;
import com.sprint1backend.entity.Employee;
import com.sprint1backend.repository.AppAccountRepository;
import com.sprint1backend.repository.AppRoleRepository;
import com.sprint1backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AppAccountRepository appAccountRepository;

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Override
    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void editEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        System.out.println("delete by id");
        this.employeeRepository.deleteById(id);
    }


    // ------------------------------- Validate ton tai -------------------------------------
    @Override
    public List<Employee> findEmployeeByCode(String code) {
        return this.employeeRepository.findEmployeeByEmployeeCode(code);
    }

    @Override
    public List<Employee> findEmployeeByEmail(String email) {
        return this.employeeRepository.findEmployeeByEmail(email);
    }


    // ------------------------------- Account - Role --------------------------------------------
    @Override
    public void saveAccount(AppAccount appAccount) {
        this.appAccountRepository.save(appAccount);
    }

    @Override
    public AppAccount findByNameAppAccount(String appAccount) {
        return appAccountRepository.findByUsername(appAccount);
    }

    @Override
    public AppRole findByNameAppRole(String appRole) {
        return appRoleRepository.findByName(appRole);
    }

    @Override
    public List<AppRole> findAllByRole() {
        try {
            return appRoleRepository.findAll();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }


    // ----------------------------- Search ---------------------------------
    @Override
    public List<Employee> findEmployeeByFullNameContaining(String fullName) {
        return this.employeeRepository.findEmployeeByFullNameContaining(fullName);
    }

    @Override
    public List<Employee> findEmployeeByEmailContaining(String email) {
        return this.employeeRepository.findEmployeeByEmailContaining(email);
    }

    @Override
    public List<Employee> findEmployeeByPhoneNumberContaining(String phoneNumber) {
        return this.employeeRepository.findEmployeeByPhoneNumberContaining(phoneNumber);
    }
}
