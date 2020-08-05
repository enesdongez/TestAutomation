package pages;

import org.openqa.selenium.*;

public class login {

    WebDriver driver;

    By eposta = By.id("email");
    By sifre = By.id("password");
    By login = By.cssSelector("#mainPage > main > div.center > form > div > div.col-md-4 > input");

    public login(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String strUserName){
        driver.findElement(eposta).sendKeys(strUserName);
    }
    
    public void setPassword(String strPassword){
         driver.findElement(sifre).sendKeys(strPassword);
    }

    public void clickLogin(){
         driver.findElement(login).click();
    }

    public void loginwebsite(String strUserName,String strPasword){

        this.setUserName(strUserName);

        this.setPassword(strPasword);
     
        this.clickLogin();

    }

}