package org.mindtree.employeemanagement.service;

import java.util.Collection;

import org.mindtree.employeemanagement.model.Employee;

public interface EmployeeService {
Employee addEmployee(Employee employee);
Employee getEmployee(long id);
Collection<Employee> getAllEmplyeeDetails();
void deleteEmployee(long id);
Employee validateUser(String userName,String password);
}
