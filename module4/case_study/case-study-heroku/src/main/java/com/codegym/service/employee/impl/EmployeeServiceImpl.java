package com.codegym.service.employee.impl;

import com.codegym.entity.employee.*;
import com.codegym.repository.employee.*;
import com.codegym.service.employee.EmployeeService;
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
    private PositionRepository positionRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public List<Position> allPosition() {
        return this.positionRepository.findAll();
    }

    @Override
    public List<Division> allDivision() {
        return this.divisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> allEducationDegree() {
        return this.educationDegreeRepository.findAll();
    }

    @Override
    public List<AppUser> allUser() {
        return this.userRepository.findAll();
    }
}
