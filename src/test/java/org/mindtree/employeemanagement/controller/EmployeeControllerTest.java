package org.mindtree.employeemanagement.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindtree.employeemanagement.ApplicationStart;
import org.mindtree.employeemanagement.service.EmployeeService;
import org.mindtree.employeemanagement.web.api.EmployeeController;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationStart.class)
@SpringBootTest
public class EmployeeControllerTest {
	private MockMvc mockmvc;
	
	@Mock
	EmployeeService mockEmpService;
	
	@InjectMocks
	EmployeeController mockEmpController;	
	
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		this.mockmvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void verifyaddEmployee() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.post("/empMgt/addEmp").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(
						"{\"empId\": \"8\", \"userName\" : \"Manoj\",\"password\":\"Naresh1234\", \"fullName\": \"NareshP\",\"emailId\": \"naresh.p@mindtree.com\",\"dateOfBirth\": \"08jun2018\",\"gender\": \"male\",\"securityQuestion\": \"Your Name\",\"securityAnswer\": \"Naresh\"}")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.empId").exists()).andExpect(jsonPath("$.userName").exists())
		.andExpect(jsonPath("$.password").exists()).andExpect(jsonPath("$.fullName").exists())
		.andExpect(jsonPath("$.emailId").exists()).andExpect(jsonPath("$.dateOfBirth").exists())
		.andExpect(jsonPath("$.gender").exists()).andExpect(jsonPath("$.securityQuestion").exists()).andExpect(jsonPath("$.securityAnswer").exists())
        .andExpect(jsonPath("$.empId").value(8)).andExpect(jsonPath("$.userName").value("Manoj"))
		.andExpect(jsonPath("$.password").value("Naresh1234")).andExpect(jsonPath("$.fullName").value("NareshP"))
		.andExpect(jsonPath("$.emailId").value("naresh.p@mindtree.com")).andExpect(jsonPath("$.dateOfBirth").value("08jun2018"))
		.andExpect(jsonPath("$.gender").value("male")).andExpect(jsonPath("$.securityQuestion").value("Your Name")).andExpect(jsonPath("$.securityAnswer").value("Naresh")).andDo(print());
	}
	
	 @Test
	public void getAllEmployee() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/empMgt/getAllEmpDetails").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}
	
   @Test
	public void getEmployeeById() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/empMgt/getByEmpId/8").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.empId").exists()).andExpect(jsonPath("$.userName").exists())
		.andExpect(jsonPath("$.password").exists()).andExpect(jsonPath("$.fullName").exists())
		.andExpect(jsonPath("$.emailId").exists()).andExpect(jsonPath("$.dateOfBirth").exists())
		.andExpect(jsonPath("$.gender").exists()).andExpect(jsonPath("$.securityQuestion").exists()).andExpect(jsonPath("$.securityAnswer").exists())
        .andExpect(jsonPath("$.empId").value(8)).andExpect(jsonPath("$.userName").value("Manoj"))
		.andExpect(jsonPath("$.password").value("Naresh1234")).andExpect(jsonPath("$.fullName").value("NareshP"))
		.andExpect(jsonPath("$.emailId").value("naresh.p@mindtree.com")).andExpect(jsonPath("$.dateOfBirth").value("08jun2018"))
		.andExpect(jsonPath("$.gender").value("male")).andExpect(jsonPath("$.securityQuestion").value("Your Name")).andExpect(jsonPath("$.securityAnswer").value("Naresh")).andDo(print());
	}
	
	@Test
	public void deleteEmployeeById() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.delete("/empMgt/deleteEmp/8").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(
						"{\"empId\": \"8\", \"userName\" : \"Manoj\",\"password\":\"Naresh1234\", \"fullName\": \"NareshP\",\"emailId\": \"naresh.p@mindtree.com\",\"dateOfBirth\": \"08jun2018\",\"gender\": \"male\",\"securityQuestion\": \"Your Name\",\"securityAnswer\": \"Naresh\"}")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.id").doesNotExist()).andDo(print());
		}
	
	@Test
	public void verifyUserPassword() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.post("/empMgt/checkLogin").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(
						"{\"empId\": \"8\", \"userName\" : \"Manoj\",\"password\":\"Naresh1234\", \"fullName\": \"NareshP\",\"emailId\": \"naresh.p@mindtree.com\",\"dateOfBirth\": \"08jun2018\",\"gender\": \"male\",\"securityQuestion\": \"Your Name\",\"securityAnswer\": \"Naresh\"}")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.userName").exists())
		.andExpect(jsonPath("$.password").exists()).andExpect(jsonPath("$.userName").value("Manoj")).andExpect(jsonPath("$.password").value("Naresh1234"))
		.andDo(print());
	}
	
//Boundary condition
	@Test
	public void verifyInvalidGetId() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/empMgt/getByEmpId/9").accept(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(jsonPath("$.message").value("Record Not Found"))
			.andDo(print());
		}	
	@Test
	public void verifyInvalidDeleteId() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.delete("/empMgt/deleteEmp/5").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(
						"{\"empId\": \"5\", \"userName\" : \"Manoj\",\"password\":\"Naresh1234\", \"fullName\": \"NareshP\",\"emailId\": \"naresh.p@mindtree.com\",\"dateOfBirth\": \"08jun2018\",\"gender\": \"male\",\"securityQuestion\": \"Your Name\",\"securityAnswer\": \"Naresh\"}")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.id").doesNotExist()).andDo(print());
		}	
	@Test
	public void verifyNoUserExit() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.post("/empMgt/checkLogin").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(
						"{\"userName\" : \"Manoj1\",\"password\":\"Naresh1234\"}")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.message").value("Record Not Found"))
		.andDo(print());
			}
	
	@Test
	public void verifyDuplicateEmployee() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.post("/empMgt/addEmp").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(
						"{\"empId\": \"9\", \"userName\" : \"Manoj\",\"password\":\"Naresh1234\", \"fullName\": \"NareshP\",\"emailId\": \"naresh.p@mindtree.com\",\"dateOfBirth\": \"08jun2018\",\"gender\": \"male\",\"securityQuestion\": \"Your Name\",\"securityAnswer\": \"Naresh\"}")
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$.message").value("Unique key Constarint violation"))
		.andDo(print());
			}
}
