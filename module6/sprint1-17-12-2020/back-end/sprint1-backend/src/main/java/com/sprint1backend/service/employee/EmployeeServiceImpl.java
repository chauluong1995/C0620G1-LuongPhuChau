package com.sprint1backend.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1backend.entity.Employee;
import com.sprint1backend.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findEmployeeByID(Long id) {
        return this.employeeRepository.findById(id).orElse(null);
    }
}
