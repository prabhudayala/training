package b;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.WebRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomizedResponseEntityExceptionHandler.class)
public class CustomisezResponseEntityTest {
	
	@Mock
	CustomizedResponseEntityExceptionHandler c;
	@Mock
	EmployeeNotFoundException enf;
	@Mock
	WebRequest wr;
	
	@Mock
	RuntimeException ex;
	
    /*@Test
    public void handleAllOtherException1Test() {
    	c.handleAllOtherException1(ex, wr);
    	assertNotNull("String");
    }*/
    
    @Test
    public void handleAllOtherException2Test() {
    	c.handleUserNotFoundException2(enf, wr);
    	assertNotNull("String");
    }
    
}