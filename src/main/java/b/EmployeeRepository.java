package b;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Cacheable()
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query(value = "SELECT * FROM Employee e WHERE e.username = ?1 and e.password= ?2", nativeQuery = true)
	public List<Employee> findByTitle(String userName, String password);
	
}
