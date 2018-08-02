package b;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	@NotEmpty(message = "not empty")
	@NotNull(message = "not null")
	private String username;
	private String password;
	private String fullName;
	private String emailID;
	private String dateOfBirth;
	private String gender;
	private String securityQuestion;
	private String securityAnswer;

	public Employee() {
		super();
	}

	public Employee(long id, String username, String password, String fullName, String emailID, String dateOfBirth,
			String sender, String securityQuestion, String securityAnswer) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.emailID = emailID;
		this.dateOfBirth = dateOfBirth;
		this.gender = sender;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String sender) {
		this.gender = sender;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

}
