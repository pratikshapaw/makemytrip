package testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utility.ExcellReader;

public class HomePageTest extends BaseTest{

	@Test(priority=1) 
	public void validateRoundTrip() throws InterruptedException
	{
		home.clickOnRoundTrip();
	}
	
	@Test(priority=2)
	public void validateCity() throws InterruptedException, IOException 
	{
		home.addCity(ExcellReader.readData(0, 0),ExcellReader.readData(0, 1));
	}
	
	@Test(priority=3)
	public void validateDate() throws InterruptedException
	{
		home.addDate();
		if(driver.getPageSource().contains("You are booking for more than 30 days"))
		{
			System.out.println("You are booking for more than 30 days");
		}
	}
	
	@Test(priority=4)
	public void validateTravellers()
	{
		home.addTravellers();
		if(driver.getPageSource().contains("Upto 9 passengers allowed"))
		{
			System.out.println("Upto 9 passengers allowed");
		}
		
	}
	
	@Test(priority=5)
	public void validateReview() throws InterruptedException
	{
		home.validateReviewPage();
		if(driver.getPageSource().contains("You have more fares to select from"))
		{
			System.out.println("You have more fares to select from");
		}
		
		
	}
	
	@Test (priority=6)
	public void validateRevdate() throws InterruptedException
	{
		Assert.assertEquals("Mon, 9 Oct",home.validateReviewDate());
	}
}
