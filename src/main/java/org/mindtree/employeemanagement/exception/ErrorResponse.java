package org.mindtree.employeemanagement.exception;

import java.util.List;

public class ErrorResponse {

	private String message;
	private List<String> details;
	public String getMessage() {
		return message;
	}

	public List<String> getDetails() {
		return details;
	}
		public ErrorResponse(String message,List<String> details)
	{
		this.message=message;
		this.details=details;
	}
}
