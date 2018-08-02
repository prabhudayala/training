package b;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class, secure = false)
public class StudentControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private StudentService2 studentService;

	@Test
	public void getAllTest() throws Exception {
		Employee mockEMployee = new Employee(1, "username", "password", "fullName", "emailID", "dateOfBirth", "sender",
				"securityQuestion", "securityAnswer");
		List<Employee> myList = new ArrayList<>();
		myList.add(mockEMployee);
		System.out.println("awfefew" + studentService);
		Mockito.when(studentService.getAll()).thenReturn(myList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/EmpMgt/getAllEmpDetails")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		String expected = "{\"ststusCode\":\"200\",\"status\":\"Success\",\"message\":\"[]\",\"data\":[{\"id\":1,\"username\":\"username\",\"password\":\"password\",\"fullName\":\"fullName\",\"emailID\":\"emailID\",\"dateOfBirth\":\"dateOfBirth\",\"gender\":\"sender\",\"securityQuestion\":\"securityQuestion\",\"securityAnswer\":\"securityAnswer\"}],\"singleData\":null}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void checkLoginPositiveTest() throws Exception {

		String exampleCourseJson = "{\"username\":\"username\",\"password\":\"password\"}";
		Employee mockEMployee = new Employee();
		mockEMployee.setUsername("username");
		mockEMployee.setPassword("password");
		// List<Employee> myList = new ArrayList<>();

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(studentService.checkLogin(Mockito.any(Employee.class))).thenReturn(true);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/EmpMgt/checkLogin")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	@Test
	public void checkLoginNegativeTest() throws Exception {

		String exampleCourseJson = "{\"username\":\"username\",\"password\":\"password\"}";
		Employee mockEMployee = new Employee();
		mockEMployee.setUsername("username");
		mockEMployee.setPassword("password");
		// List<Employee> myList = new ArrayList<>();

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(studentService.checkLogin(Mockito.any(Employee.class))).thenReturn(false);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/EmpMgt/checkLogin")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());

	}

	@Test
	public void saveOneTest() throws Exception {

		String exampleCourseJson = "{\"username\":\"username\",\"password\":\"password\",\"fullName\":\"fullName\",\"emailID\":\"emailID\",\"dateOfBirth\":\"dateOfBirth\",\"gender\":\"sender\",\"securityQuestion\":\"securityQuestion\",\"securityAnswer\":\"securityAnswer\"}";
		Employee mockEMployee = new Employee(1, "username", "password", "fullName", "emailID", "dateOfBirth", "sender",
				"securityQuestion", "securityAnswer");
		Mockito.when(studentService.saveOne(Mockito.any(Employee.class))).thenReturn(mockEMployee);

		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/EmpMgt/putEmp").accept(MediaType.APPLICATION_JSON)
				.content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

}
