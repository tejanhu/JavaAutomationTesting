import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.*;
public class DroppableTest {
	
	ChromeDriver myDriver;
	
	@Before
	public void setUp() {
		myDriver = new ChromeDriver();
	}
	
	@Test
	public void testSomething() {
		 DemoQAPage page = PageFactory.initElements(myDriver, DemoQAPage.class);     
		 page.
	}
	
	
}
