package org.mindtree.employeemanagement.web.api;
import java.util.Collection;

import org.mindtree.employeemanagement.exception.CustomerNotFoundException;
import org.mindtree.employeemanagement.model.Employee;
import org.mindtree.employeemanagement.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/empMgt")
public class EmployeeController  {

@Autowired
private EmployeeService employeeService;
	
private static final Logger log=LoggerFactory.getLogger(EmployeeController.class);

@RequestMapping(value="/addEmp",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,
consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
{
	log.info("git test");
	log.info("Inside addEmployee Controller method");
	return new ResponseEntity<Employee>(employeeService.addEmployee(employee),HttpStatus.OK);
		}

@RequestMapping(value="/getByEmpId/{empId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Employee> getEmployee(@PathVariable("empId") long empId) throws CustomerNotFoundException  
{
	log.info("Inside getEmpById Controller method");
	if(employeeService.getEmployee(empId)==null)
	{
		throw new CustomerNotFoundException("empId doesnot exists in the DB not able to retrieve the data "+empId);
	}
	return new ResponseEntity<Employee>(employeeService.getEmployee(empId),HttpStatus.OK);
}

@RequestMapping(value="/getAllEmpDetails",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Collection<Employee>> getAllEmployee() throws CustomerNotFoundException 
{
	log.info("Inside getAllEmpDetails Controller method");
	if(employeeService.getAllEmplyeeDetails().isEmpty())
	{
		throw new CustomerNotFoundException("No employees found in the DB");
	}
	return new ResponseEntity<Collection<Employee>>(employeeService.getAllEmplyeeDetails(),HttpStatus.OK);
}
@RequestMapping(value="/deleteEmp/{empId}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Employee> deleteEmployee(@PathVariable("empId")long empID) throws CustomerNotFoundException
{	
	log.info("Inside deleteEmployee Controller method");
	if(employeeService.getEmployee(empID)==null)
	{
		throw new CustomerNotFoundException("empId does not exists in the DB not able to delete");
	}
	employeeService.deleteEmployee(empID);
	return new ResponseEntity<Employee>(HttpStatus.OK);
	}
@RequestMapping(value="/checkLogin",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Employee> validateUser(@RequestBody Employee employee) throws CustomerNotFoundException
{
	log.info("Inside checkLogin Controller method");
	if(employeeService.validateUser(employee.getUserName(),employee.getPassword())==null)
	{
		throw new CustomerNotFoundException("User does not exists in the DB for perticular userName and Password,Check your userName and Password");
	}
	return new ResponseEntity<Employee>(employeeService.validateUser(employee.getUserName(),employee.getPassword()),HttpStatus.OK);	
}
}
