package SaranMaven.Seleniumframeworkdesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String item = "IPHONE 13 PRO";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Landingpage landingpage = new Landingpage(driver);// create a class to pass the webdriver driver to constructor
		landingpage.goTo();
		Productcatalogue productcatalogue = landingpage.loginApplication("saranraj@gmail.com", "Saranrajk26119@");
		

		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProdToCart(item);
		Cartpage cartpage = productcatalogue.goToCartPage();

		boolean match = cartpage.verifyProduct(item);
		Assert.assertTrue(match);
		checkoutpage Checkoutpage = cartpage.goTocheckout();
		Checkoutpage.selectCountry("India");
		Confirmationpage confirmationpage = Checkoutpage.submitOrder();

		String message = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.close();
	}

}
