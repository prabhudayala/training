package org.mindtree.employeemanagement.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice()
public class CustomerExceptionHandler extends ResponseEntityExceptionHandler
{    
        @ExceptionHandler(RuntimeException.class)
        public final ResponseEntity<Object> handleAllSqlExceptions(RuntimeException ex, WebRequest request) {
        List<String> details = new ArrayList<String>();
        details.add("Duplicate keys are not allowed for username and password");
        ErrorResponse error = new ErrorResponse("Unique key Constarint violation", details);
        return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
      
    @ExceptionHandler(CustomerNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(CustomerNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<String>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Record Not Found", details);
        return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
    }
  
}