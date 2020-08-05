package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class homepage {

	WebDriver driver;
	Actions action;

    By login_button = By.cssSelector("#pageBody > div.row > header > div > div > div > div:nth-child(1) > div.member-nav.col-md-9 > div:nth-child(5) > a");
    By urunler_dropdown=By.cssSelector("#mainPage > main > div > div.slider-wide.col-md-12 > div.home-categories.pull-left > div > ul > li:nth-child(1) > a");
    By islemci_menu=By.cssSelector("#mainPage > main > div > div.slider-wide.col-md-12 > div.home-categories.pull-left > div > ul > li:nth-child(1) > div > div > ul:nth-child(1) > li:nth-child(3) > a");
    By islemci=By.cssSelector("#allProducts > div:nth-child(2) > div.product-inner > div.product-title.col-md-12 > a");
	By cartpage=By.cssSelector("#basketQuantityTutar");
	
    public homepage(WebDriver driver){
        this.driver = driver;
        action=new Actions(driver);
    }
    
    public void clickLoginPage(){
        driver.findElement(login_button).click();
    }
    
    public void selectDropdownMenu() {
    	 action.moveToElement(driver.findElement(urunler_dropdown));
         action.perform();
    }
    
    public void selectMenu() {
    	driver.findElement(islemci_menu).click();
    }
    
    public void selectItem() {
    	driver.findElement(islemci).click();
    }
    
	
	public void goto_cartpage() {
		driver.findElement(cartpage).click();
	}
	 

}
