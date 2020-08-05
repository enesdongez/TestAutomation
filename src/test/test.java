package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import db.db_connect;
import pages.cartpage;
import pages.homepage;
import pages.login;

public class test {

	static WebDriver driver;

    static login objLogin=null;
    
    static homepage objHomePage=null;
    
    static cartpage objCartPage=null;
    
    static db_connect objDB_Connect=null;
    
	static Connection con = null;

    public static void main(String[] args) throws InterruptedException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

    	System.setProperty("webdriver.chrome.driver","..\\TestAutomations\\driver\\chromedriver.exe");
    	driver=new ChromeDriver();

    	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        driver.get("https://www.itopya.com/");
        
        driver.manage().window().maximize();
      
        objLogin=new login(driver);
        objHomePage=new homepage(driver);
        objCartPage=new cartpage(driver);
        objDB_Connect=new db_connect();
        
        con=objDB_Connect.getconnect();
        
        if(driver.getCurrentUrl().equals("https://www.itopya.com/")) {
        	objDB_Connect.write_db("Website Baglantisi", "Basarili", java.time.LocalDateTime.now().toString());
        }else {
        	objDB_Connect.write_db("Website Baglantisi", "Basarisiz", java.time.LocalDateTime.now().toString());
        	return;
        }
        
        objHomePage.clickLoginPage();    
        objLogin.loginwebsite("enesdongez@gmail.com","ileriweb123");
        Thread.sleep(1000);
        
        if(driver.getCurrentUrl().equals("https://www.itopya.com/")) {
        	objDB_Connect.write_db("Giris Ilemi", "Basarili", java.time.LocalDateTime.now().toString());
        }else {
        	objDB_Connect.write_db("Giris Ilemi", "Basarisiz", java.time.LocalDateTime.now().toString());
        	return;
        }
        
        
        objHomePage.selectDropdownMenu();
        Thread.sleep(1000);
        objHomePage.selectMenu();
        Thread.sleep(1000);
        objHomePage.selectItem();
        
        objCartPage.cartpage_button();
        String urun=objCartPage.add_cartpage();
        
        if(urun.equals("16958")) {
        	objDB_Connect.write_db("Sepete Urun Ekleme", "Basarili", java.time.LocalDateTime.now().toString());
        }else {
        	objDB_Connect.write_db("Sepete Urun Ekleme", "Basarisiz", java.time.LocalDateTime.now().toString());
        	return;
        }
        
        Thread.sleep(1000);
        
        objHomePage.goto_cartpage();
        
        

        Thread.sleep(3000);
        driver.quit();
        
    }

    
}