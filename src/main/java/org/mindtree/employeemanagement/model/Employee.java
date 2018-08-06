package org.mindtree.employeemanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"userName","password"})})
//@Table(name="Employee")
public class Employee implements Serializable{
	@Id
	@Column(name="empId")
	private long empId;
	@Column(name = "userName")
	@NotEmpty(message="userName id should not be null")
	private String userName;
	@Column(name = "password")
	@NotEmpty(message="password  should not be null")
	private String password;
	@Column(name = "fullName")
	private String fullName;
	@Column(name = "emailId")
	private String emailId;
	@Column(name = "dateOfBirth")
	private String dateOfBirth;
	@Column(name = "gender")
	private String gender;
	@Column(name = "securityQuestion")
	private String securityQuestion;
	@Column(name = "securityAnswer")
	private String securityAnswer;

	public Employee()
	{
		
	}
	
	public Employee(long empId,String userName,String password,String fullName,String emailId,
			String dateOfBirth,String gender,String securityQuestion,String securityAnswer)
	{
		this.empId=empId;
		this.userName=userName;
		this.password=password;
		this.fullName=fullName;
		this.emailId=emailId;
		this.dateOfBirth=dateOfBirth;
		this.gender=gender;
		this.securityQuestion=securityQuestion;
		this.securityAnswer=securityAnswer;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public void setGender(String gender) {
		this.gender = gender;
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

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

}
