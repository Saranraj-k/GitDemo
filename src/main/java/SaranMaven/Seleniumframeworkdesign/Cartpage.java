package SaranMaven.Seleniumframeworkdesign;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Abstractcomponents;

public class Cartpage  extends Abstractcomponents{
	
	@FindBy(css=".totalRow button")
	WebElement checkoutele;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	
	WebDriver driver;
	public Cartpage(WebDriver driver2)
	{
		super(driver2);
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyProduct(String item)
	{
		Boolean match=cartProducts.stream().anyMatch(s->s.getText().contains(item));
		return match;
	}
	
	public checkoutpage goTocheckout()
	{
		checkoutele.click();
		return new checkoutpage(driver);
	}
	
	

}
