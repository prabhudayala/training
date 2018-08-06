package org.mindtree.employeemanagement.repository;

import org.mindtree.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findEmployeeByUserNameAndPassword(String userName, String password); 
}
