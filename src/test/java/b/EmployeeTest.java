package b;



import org.junit.Test;

import junit.framework.Assert;



public class EmployeeTest {
	
	@Test
	public void testAll(){
		Employee mockEMployee = new Employee(1, "username", "password", "fullName", "emailID", "dateOfBirth", "sender",
				"securityQuestion", "securityAnswer");
		mockEMployee.getDateOfBirth();
		mockEMployee.getEmailID();
		mockEMployee.getFullName();
		mockEMployee.getGender();
		mockEMployee.getId();
		mockEMployee.getPassword();
		mockEMployee.getSecurityAnswer();
		mockEMployee.getSecurityQuestion();
		mockEMployee.getUsername();
		Assert.assertEquals(mockEMployee.getDateOfBirth(), "dateOfBirth");
		mockEMployee.setDateOfBirth("username");
		mockEMployee.setEmailID("username");
		mockEMployee.setFullName("username");
		mockEMployee.setGender("username");
		mockEMployee.setId(1);
		mockEMployee.setPassword("username");
		mockEMployee.setSecurityAnswer("username");
		mockEMployee.setSecurityQuestion("username");
		
	}
	
	
}
