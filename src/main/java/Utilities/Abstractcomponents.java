package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SaranMaven.Seleniumframeworkdesign.Cartpage;

public class Abstractcomponents {
	 WebDriver driver;

		public Abstractcomponents(WebDriver driver2) {
			// TODO Auto-generated constructor stub
			
			this.driver=driver2;
			PageFactory.initElements(driver, this);
		}

		public void waitForElementToAppear(By findBy)
		{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		}
		public void waitForElementToDisappear(WebElement invisible)
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
			
			wait.until(ExpectedConditions.invisibilityOf(invisible));// this is notstarted with By it start with By so use diff in method
			
		}
		
		@FindBy(css = "button[routerlink='/dashboard/cart']")
		WebElement cartClick;
		
		public Cartpage goToCartPage()
		{
			cartClick.click();
			Cartpage cartpage=new Cartpage(driver);
			return cartpage;
		}
		
		
		

}
