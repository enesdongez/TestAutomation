package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartpage {

	WebDriver driver;
	
	By cartpage_button = By.cssSelector("#mainPage > main > div.center > div > div.comments-box.col-md-4 > div > div:nth-child(2) > a");
	
	public cartpage(WebDriver driver){
		this.driver = driver;
	}
	 
	public void cartpage_button() {
		driver.findElement(cartpage_button).click();
	}
	
	public String add_cartpage() {
		
		this.cartpage_button();
		
		return driver.findElement(cartpage_button).getAttribute("data-id");
	}

}
