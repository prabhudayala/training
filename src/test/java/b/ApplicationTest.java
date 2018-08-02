package b;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ApplicationTest {
	

	@Test
	public void applicationContextTest() {
		Application.main(new String[] {});
		assertNotNull("String");
	}
	
}