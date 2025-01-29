package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        if (employee.getEmpid() == 0) {
            employeeRepository.save(employee);
        } else {
            Employee employeeUpdate = employeeRepository.findById(employee.getEmpid()).orElse(null);
            if (employeeUpdate != null) {
                employeeUpdate.setEmpName(employee.getEmpName());
                employeeUpdate.setEmpSal(employee.getEmpSal());
                employeeUpdate.setEmpRole(employee.getEmpRole());
                employeeRepository.save(employeeUpdate);
            }
        }
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
