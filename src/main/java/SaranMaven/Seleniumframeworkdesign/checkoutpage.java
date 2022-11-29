package SaranMaven.Seleniumframeworkdesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Abstractcomponents;

public class checkoutpage extends Abstractcomponents {
	WebDriver driver;

	public checkoutpage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		super(driver2);
		this.driver=driver2;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath  = "//a[text()='Place Order ']")
	WebElement submit;
	
	
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath = "//button[.=' India']")
	WebElement selectCountry;
	
	public void selectCountry(String countryname)
	{
		Actions a =new Actions(driver);
		a.sendKeys(country,countryname).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));	
		selectCountry.click();
	}
	
	public Confirmationpage submitOrder()
	{
		submit.click();
		return new Confirmationpage(driver);
	}




}


