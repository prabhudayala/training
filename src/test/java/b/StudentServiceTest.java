package b;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {
	@Mock
	private EmployeeRepository e;
	
	@InjectMocks
	StudentService studentService;
	
	@Test
	public void saveOneTest(){
		Employee mockEMployee = new Employee(1, "username", "password", "fullName", "emailID", "dateOfBirth", "sender",
				"securityQuestion", "securityAnswer");
		Mockito.when(e.saveAndFlush(mockEMployee)).thenReturn(mockEMployee);
		assertEquals(mockEMployee, studentService.saveOne(mockEMployee));
	}
	@Test
	public void deleteOneTest(){
		Employee mockEMployee = new Employee(1, "username", "password", "fullName", "emailID", "dateOfBirth", "sender",
				"securityQuestion", "securityAnswer");
		Mockito.doNothing().when(e).delete(mockEMployee);
		e.delete(mockEMployee);
		//assertEquals(mockEMployee, studentService.saveOne(mockEMployee));
	}
	
}
