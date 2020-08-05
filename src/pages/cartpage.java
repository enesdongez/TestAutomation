package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cartpage {

	WebDriver driver;
	
	@FindBy(css = "#mainPage > main > div.center > div > div.comments-box.col-md-4 > div > div:nth-child(2) > a")
	WebElement cartpage_button;
	
	public cartpage(WebDriver driver){
		this.driver = driver;
	}
	 
	public void cartpage_button() {
		cartpage_button.click();
	}
	
	public String add_cartpage() {
		
		this.cartpage_button();
		
		return cartpage_button.getAttribute("data-id");
	}

}
