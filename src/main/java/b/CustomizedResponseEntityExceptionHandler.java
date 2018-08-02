package b;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * @ExceptionHandler(Exception.class) public final
	 * ResponseEntity<ResponseDetails> handleAllOtherException(Exception ex,
	 * WebRequest request) { Employee emp = new Employee(); ResponseDetails
	 * errorDetails = new ResponseDetails("400", "Failure",
	 * "Some error occured.", emp); return new ResponseEntity<>(errorDetails,
	 * HttpStatus.NOT_FOUND); }
	 */
	/*@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<ResponseDetails> handleAllOtherException1(RuntimeException ex, WebRequest request) {
		Employee emp = new Employee();
		ResponseDetails errorDetails = new ResponseDetails("400", "Failure", "Some all error occured.", emp);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}*/

	// MySQLIntegrityConstraintViolationException
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ResponseDetails> handleUserNotFoundException2(EmployeeNotFoundException ex,
			WebRequest request) {
		Employee emp = new Employee();
		ResponseDetails errorDetails = new ResponseDetails("400", "Failure", "Employee not found.", emp);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
