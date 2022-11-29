package SaranMaven.Seleniumframeworkdesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Abstractcomponents;

public class Productcatalogue extends Abstractcomponents {

	WebDriver driver;

	public Productcatalogue(WebDriver driver2) {
		super(driver2);

		this.driver = driver2;// this will pass the value of driver 2 to driver.
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	By actionby = By.cssSelector(".mb-3");

	public List<WebElement> getProductList() {

		// waitForElementToAppear(By.cssSelector(".mb-3"));
		waitForElementToAppear(actionby);// above can be decalred in other way
		return products;
	}

	public WebElement getProductByName(String item) {
		WebElement product = getProductList().stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().contains(item)).findFirst().orElse(null);

		return product;
	}

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	public void addProdToCart(String item1) {
		// product.findElement(By.cssSelector(".card-body
		// button:last-of-type")).click();
		WebElement product1 = getProductByName(item1);
		product1.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForElementToAppear(By.cssSelector("#toast-container"));
		waitForElementToDisappear(spinner);

	}

}
