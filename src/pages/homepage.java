package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class homepage {

	WebDriver driver;
	Actions action;

	@FindBy(css = "#pageBody > div.row > header > div > div > div > div:nth-child(1) > div.member-nav.col-md-9 > div:nth-child(5) > a")
	WebElement login_button;
	
	@FindBy(css = "#mainPage > main > div > div.slider-wide.col-md-12 > div.home-categories.pull-left > div > ul > li:nth-child(1) > a")
	WebElement urunler_dropdown;
	
	@FindBy(css = "#mainPage > main > div > div.slider-wide.col-md-12 > div.home-categories.pull-left > div > ul > li:nth-child(1) > div > div > ul:nth-child(1) > li:nth-child(3) > a")
	WebElement islemci_menu;
	
	@FindBy(css = "#allProducts > div:nth-child(2) > div.product-inner > div.product-title.col-md-12 > a")
	WebElement islemci;
	
	@FindBy(css = "#basketQuantityTutar")
	WebElement cartpage;
	
    public homepage(WebDriver driver){
        this.driver = driver;
        action=new Actions(driver);
    }
    
    public void clickLoginPage(){
        login_button.click();
    }
    
    public void selectDropdownMenu() {
    	 action.moveToElement(urunler_dropdown);
         action.perform();
    }
    
    public void selectMenu() {
    	islemci_menu.click();
    }
    
    public void selectItem() {
    	islemci.click();
    }
    
	
	public void goto_cartpage() {
		cartpage.click();
	}
	 

}
