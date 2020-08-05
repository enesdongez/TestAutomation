package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class login {

    WebDriver driver;
    
    @FindBy(id = "email")
    WebElement eposta;

    @FindBy(id = "password")
    WebElement sifre;
    
    @FindBy(css = "#mainPage > main > div.center > form > div > div.col-md-4 > input")
    WebElement login;

    public login(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String strUserName){
    	eposta.sendKeys(strUserName);
    }
    
    public void setPassword(String strPassword){
         sifre.sendKeys(strPassword);
    }

    public void clickLogin(){
         login.click();
    }

    public void loginwebsite(String strUserName,String strPasword){

        this.setUserName(strUserName);

        this.setPassword(strPasword);
     
        this.clickLogin();

    }

}