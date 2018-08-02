package b;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface StudentService2 {
	public Employee saveOne(Employee emp);

	public void deleteOne(Employee emp);

	public List<Employee> getAll();

	public Employee getOne(long id);

	public boolean checkLogin(Employee emp);
}
