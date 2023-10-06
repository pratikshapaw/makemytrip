package pages;





import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	static WebDriver driver;
	
	@FindBy(xpath="//*[text()='Round Trip']")WebElement roundtrip;
	@FindBy(xpath="//*[@id='webklipper-publisher-widget-container-notification-close-div']")WebElement popup;
	@FindBy(xpath="//*[text()='From']")WebElement fromcity;
	@FindBy(xpath="//*[@class='font14 appendBottom5 blackText']")List<WebElement> ccity;
	//@FindBy(xpath="(//*[text()='New Delhi, India'])[1]")WebElement currentcity;
	@FindBy(xpath="//*[text()='To']")WebElement tocity;
	@FindBy(xpath="//*[@class='react-autosuggest__input react-autosuggest__input--open']")WebElement tocity1;
	@FindBy(xpath="//*[@class='react-autosuggest__section-container react-autosuggest__section-container--first']//li")List<WebElement> destination;
	@FindBy(xpath="//*[text()='Departure']")WebElement dep;
	@FindBy(xpath="//*[@aria-label='Mon Oct 09 2023']")WebElement departuredate;
	@FindBy(xpath="//*[@aria-label='Fri Nov 24 2023']")WebElement returndate;
	@FindBy(xpath="//*[@class='lbl_input appendBottom5']")WebElement travellers;
	@FindBy(xpath="//*[@data-cy='adults-9']")WebElement adults;
	@FindBy(xpath="//*[@data-cy='children-3']")WebElement children;
	@FindBy(xpath="//*[@data-cy='adults-2']")WebElement adults1;
	@FindBy(xpath="//*[@data-cy='children-2']")WebElement children2;
	@FindBy(xpath="//*[text()='APPLY']")WebElement apply;
	@FindBy(xpath="//*[text()='Search']")WebElement search;
	@FindBy(xpath="//*[@class='button buttonSecondry buttonBig fontSize12 relative']")WebElement op;
	@FindBy(xpath="//*[@class='makeFlex hrtlCenter pushRight']//*[text()='Book Now']")WebElement booknow;
	static @FindBy(xpath="//*[@id=\"listing-id\"]/div[2]/div[2]/div[1]/div/div[1]/p[3]")WebElement reviewdate;
static	@FindBy(xpath="//*[@class='multifareCross']")WebElement cancelbutton;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	}
	
	public void clickOnRoundTrip() throws InterruptedException
	{
		Thread.sleep(4000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", roundtrip);
		
	}
	
	
	public void addCity(String from,String to) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", fromcity);
		/*WebElement optedvalue1=null;
		WebElement optedvalue2=null;
		Thread.sleep(4000);
		for(WebElement op:ccity)
		{
			String currentci = op.getText();
			System.out.println(currentci);
			if(currentci.contains(ExcellReader.re))
			{
				optedvalue1=op;
			}
		}
		optedvalue1.click();
		
		
		js.executeScript("arguments[0].click();", tocity);
		Thread.sleep(3000);
		for(WebElement op1:destination)
		{
			String desti = op1.getText();
			System.out.println(desti);
			if(desti.contains("Mumbai, India"))
			{
				optedvalue2=op1;
			}
		}
		optedvalue2.click();
		*/
		fromcity.sendKeys(from);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", tocity);
		tocity1.sendKeys(to);
	}

	public void addDate() throws InterruptedException
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", dep);
		js.executeScript("arguments[0].click();", departuredate);
		String dpdate = departuredate.getText();
		System.out.println(dpdate);

		String rdate = returndate.getText();
		System.out.println(rdate);
		js.executeScript("arguments[0].click();", returndate);
	
		
		
	}
	
	public void addTravellers()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();",travellers);

		js.executeScript("arguments[0].click();", adults);

		js.executeScript("arguments[0].click();", children);
	}
	
	public  void validateReviewPage() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].click();",travellers);

		js.executeScript("arguments[0].click();", adults1);

		js.executeScript("arguments[0].click();", children2);
		
		js.executeScript("arguments[0].click();", apply);
		
		js.executeScript("arguments[0].click();", search);
		Thread.sleep(7000);
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(op));
		js.executeScript("arguments[0].click();", op);
		
		
		wait.until(ExpectedConditions.visibilityOf(booknow));
		js.executeScript("arguments[0].click();", booknow);
		
	}
	
	public static String validateReviewDate() throws InterruptedException
	{
		Thread.sleep(3000);
		String revdate = reviewdate.getText();
		System.out.println(revdate);
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", cancelbutton);
		return revdate;
	}
}
