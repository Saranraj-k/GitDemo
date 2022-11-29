package SaranMaven.Seleniumframeworkdesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Abstractcomponents;

public class Confirmationpage extends Abstractcomponents {
	
	   WebDriver driver;

		public Confirmationpage(WebDriver driver2) {
			// TODO Auto-generated constructor stub
			super(driver2);
			this.driver=driver2;
			PageFactory.initElements(driver, this);
		}
		
		
		
		//String message=	driver.findElement(By.cssSelector("h1[class='hero-primary']")).getText();
		
		
		@FindBy (css = "h1[class='hero-primary']")
		WebElement confirmationMessage;
		
		public String getConfirmationMessage()
		{
			return confirmationMessage.getText();
		} 

}
