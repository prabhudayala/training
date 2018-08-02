package b;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentService2 {
	// Employee x = new Employee();
	@Autowired
	EmployeeRepository e;

	@Override
//	@Cacheable()
	public Employee saveOne(Employee emp) {
		return e.saveAndFlush(emp);
	}

	@Override
	//@Cacheable()
	public void deleteOne(Employee emp) {
		e.delete(emp);

	}

	@Override
	@Cacheable(value="employee")
	public List<Employee> getAll() {
		return e.findAll();
	}

	@Override
	//@Cacheable()
	public Employee getOne(long id) throws EmployeeNotFoundException {
		Optional<Employee> emp = e.findById(id);
		if (!emp.isPresent()) {
			throw new EmployeeNotFoundException("i dont know what happened");
		}
		return emp.get();

	}

	@Override
	//@Cacheable()
	public boolean checkLogin(Employee emp) {
		List<Employee> myList = new ArrayList<>();
		String userName = emp.getUsername();
		String password = emp.getPassword();
		myList = e.findByTitle(userName, password);
		if (myList.size() <= 0) {
			return false;
		}
		return true;

	}

}
