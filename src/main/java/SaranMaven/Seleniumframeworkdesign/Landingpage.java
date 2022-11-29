package SaranMaven.Seleniumframeworkdesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Abstractcomponents;

public class Landingpage extends Abstractcomponents {
	
	WebDriver driver;

	public Landingpage(WebDriver driver2) { // this is constructor. driver 2 is coming from standAlonetest class. If
											// this
		// Landingpage is going to execute, It will execute the constructors
		// first eventhough it has lot of methods....

		super(driver2);
		this.driver = driver2;// this will pass the value of driver 2 to driver.
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement emailID;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	public Productcatalogue loginApplication(String email,String Pswd)
	{
		emailID.sendKeys(email);
		password.sendKeys(Pswd);
		submit.click();
		Productcatalogue productcatalogue=new Productcatalogue(driver);
		return productcatalogue;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}
