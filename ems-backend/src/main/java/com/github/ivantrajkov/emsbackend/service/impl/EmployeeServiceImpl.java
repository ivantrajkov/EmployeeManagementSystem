package com.github.ivantrajkov.emsbackend.service.impl;

import com.github.ivantrajkov.emsbackend.dto.EmployeeDto;
import com.github.ivantrajkov.emsbackend.entity.Employee;
import com.github.ivantrajkov.emsbackend.exception.ResourceNotFoundException;
import com.github.ivantrajkov.emsbackend.mapper.EmployeeMapper;
import com.github.ivantrajkov.emsbackend.repository.EmployeeRepository;
import com.github.ivantrajkov.emsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with the id: " + employeeId + " does not exist"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow((() -> new ResourceNotFoundException("Employee with id: " + employeeId + " does not exist")));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow((() -> new ResourceNotFoundException("Employee with id: " + employeeId + " does not exist")));

        employeeRepository.delete(employee);
    }
}
