package com.codegym.service.employee.impl;

import com.codegym.entity.employee.Employee;
import com.codegym.repository.EmployeeRepository;
import com.codegym.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findByNameContaining(Pageable pageable, String name) {
        return this.employeeRepository.findByNameContaining(pageable, name);
    }

    @Override
    public void deleteEmployee(Integer id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        this.employeeRepository.save(employee);
    }
}
