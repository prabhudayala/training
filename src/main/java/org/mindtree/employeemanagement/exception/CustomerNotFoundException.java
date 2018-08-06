package org.mindtree.employeemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="BadRequest")
public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

public CustomerNotFoundException(String msg)
{
	super(msg);
}
}
