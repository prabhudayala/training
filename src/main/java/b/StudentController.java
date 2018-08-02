package b;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/EmpMgt")

@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
class StudentController {
	@Autowired
	StudentService2 s;
	
	@ApiOperation(value = "View a list of available products",response = Iterable.class)

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@RequestMapping(value = "/getAllEmpDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDetails> getAll() {
		List<Employee> e = s.getAll();
		ResponseDetails responseDetails = new ResponseDetails("200", "Success", "[]", e);
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
		// return new ResponseEntity<List<Employee>>(s.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "getByEmpId/{empId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDetails> getOne(@PathVariable("empId") long id) {
		Employee emp = s.getOne(id);
		emp.toString();
		
		 RestTemplate restTemplate = new RestTemplate(); Quote quote =
		 restTemplate.getForObject(
		 "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		 ResponseDetails responseDetails = new ResponseDetails("200",
		 quote.getValue().getQuote(), "[]", emp);
		
		//ResponseDetails responseDetails = new ResponseDetails("200", "Success", "[]", emp);
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);

	}

	@RequestMapping(value = "/putEmp", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDetails> saveOne(@RequestBody Employee emp) {
		System.out.println("$$$$$$$$$$$$#################&*********************");
		s.saveOne(emp);
		ResponseDetails responseDetails = new ResponseDetails("200", "Success", "Employee data inserted successfully.",
				emp);
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteEmp/empId", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDetails> deleteOne(@RequestBody Employee emp) {
		s.deleteOne(emp);
		ResponseDetails responseDetails = new ResponseDetails("200", "Success", "Employee data deleted successfully.",
				emp);
		return new ResponseEntity<ResponseDetails>(responseDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> error() {
		return new ResponseEntity<String>("vwefbwjbefjwe", HttpStatus.OK);

	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDetails> checkLogin(@RequestBody Employee emp) {
		System.out.println("#######################################asdandjkanqw%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		Employee e = new Employee();
		ResponseDetails responseDetailsPass = new ResponseDetails("200", "Success",
				"Employee has authenticated successfully.", e);
		ResponseDetails responseDetailsFail = new ResponseDetails("200", "Success", "Invalid Username and Password.",
				e);
		System.out.println("acjn,dn,jabsj,dn,jasj,d"+s.checkLogin(emp));
		if (s.checkLogin(emp) == true) {
			return new ResponseEntity<ResponseDetails>(responseDetailsPass, HttpStatus.OK);
		}
		return new ResponseEntity<ResponseDetails>(responseDetailsFail, HttpStatus.BAD_REQUEST);
	}

}
