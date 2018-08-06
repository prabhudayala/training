package org.mindtree.employeemanagement.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindtree.employeemanagement.ApplicationStart;
import org.mindtree.employeemanagement.model.Employee;
import org.mindtree.employeemanagement.repository.EmployeeRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationStart.class)
@SpringBootTest
public class EmployeeServiceTest {
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceBean employeeServiceBean;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllEmployee()
	{		
		Collection<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(6, "Manoj", "Manoj123", "Manojp", "manoj@mindtree.com", "08jun2002", "male", "your name", "manoj"));
		employeeList.add(new Employee(7, "Manoj", "Manoj123", "Manojp", "manoj@mindtree.com", "08jun2002", "male", "your name", "manoj"));
		employeeList.add(new Employee(8, "Manoj", "Manoj123", "Manojp", "manoj@mindtree.com", "08jun2002", "male", "your name", "manoj"));
		when(employeeRepository.findAll()).thenReturn((List<Employee>) employeeList);		
		Collection<Employee> result = employeeServiceBean.getAllEmplyeeDetails();
		assertEquals(3, result.size());
	}	
	@Test
	public void getEmployeeById(){
		Employee employee=new Employee(6, "Manoj", "Manoj123", "Manojp", "manoj@mindtree.com", "08jun2002", "male", "your name", "manoj");
		when(employeeRepository.findOne(6L)).thenReturn(employee);
		Employee result = employeeServiceBean.getEmployee(6);
		//assertEquals(6, result.getEmpId());
		assertEquals("Manoj", result.getUserName());
		assertEquals("Manoj123", result.getPassword());
		assertEquals("Manojp", result.getFullName());
		assertEquals("manoj@mindtree.com", result.getEmailId());
		assertEquals("08jun2002", result.getDateOfBirth());
		assertEquals("male", result.getGender());		
		assertEquals("your name", result.getSecurityQuestion());
		assertEquals("manoj", result.getSecurityAnswer());
	}		
	@Test
	public void addEmployee(){
		Employee employee=new Employee(6, "Manoj", "Manoj123", "Manojp", "manoj@mindtree.com", "08jun2002", "male", "your name", "manoj");
		when(employeeRepository.save(employee)).thenReturn(employee);
		Employee result = employeeServiceBean.addEmployee(employee);
		//assertEquals(6, result.getEmpId());
				assertEquals("Manoj", result.getUserName());
				assertEquals("Manoj123", result.getPassword());
				assertEquals("Manojp", result.getFullName());
				assertEquals("manoj@mindtree.com", result.getEmailId());
				assertEquals("08jun2002", result.getDateOfBirth());
				assertEquals("male", result.getGender());		
				assertEquals("your name", result.getSecurityQuestion());
				assertEquals("manoj", result.getSecurityAnswer());
	}
	
	@Test
	public void deleteEmployee(){
		Employee employee=new Employee(6, "Manoj", "Manoj123", "Manojp", "manoj@mindtree.com", "08jun2002", "male", "your name", "manoj");
		employeeServiceBean.deleteEmployee(employee.getEmpId());
        verify(employeeRepository, times(1)).delete(employee.getEmpId());        
	}
	
	@Test
	public void validateUserPassword()
	{
		Employee employee=new Employee(6, "Manoj", "Manoj123", "Manojp", "manoj@mindtree.com", "08jun2002", "male", "your name", "manoj");
		when(employeeRepository.findEmployeeByUserNameAndPassword(employee.getUserName(), employee.getPassword())).thenReturn(employee);
		Employee result = employeeServiceBean.validateUser(employee.getUserName(),employee.getPassword());
		assertEquals("Manoj", result.getUserName());
		assertEquals("Manoj123", result.getPassword());
	}
}
