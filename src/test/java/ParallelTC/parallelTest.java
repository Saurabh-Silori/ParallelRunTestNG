package ParallelTC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parallelTest {

	static WebDriver driver;
	String driverResourcePath = "C://Selenium Drivers";
			
	@BeforeMethod()
	@Parameters("browsername")
	public void beforesetup(String browsername) {
		
		System.out.println("In beforesetup method:"+Thread.currentThread().getId());
		
		if(browsername.contentEquals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C://Selenium Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
	}
	
	@Test
	@Parameters("browsername")
	public void test1(String browsername) throws InterruptedException {
		System.out.println("In test1 method:"+Thread.currentThread().getId()+ browsername);
		driver.get("https://facebook.com");
		Thread.sleep(2000);
	}
	
	@Test
	@Parameters("browsername")
	public void test2(String browsername) throws InterruptedException {
		
		System.out.println("In test2 method:"+Thread.currentThread().getId()+browsername);
		driver.get("https://www.tutorialspoint.com");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
