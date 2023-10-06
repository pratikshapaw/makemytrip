package testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import pages.HomePage;

public class BaseTest {
	WebDriver driver;
	HomePage home;
	
	 
	 
	 @BeforeSuite
		public void init() 
		{

			driver = new ChromeDriver();
			driver.get("https://www.makemytrip.com/");
		}
	
	
	@BeforeClass
	public void createObject() throws InterruptedException
	{
		home=new HomePage(driver);
		
	}

}
