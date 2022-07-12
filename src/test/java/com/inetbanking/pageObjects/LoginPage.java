package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

     WebDriver ldriver;
     
     public LoginPage(WebDriver rdriver)
     {
    	 ldriver = rdriver;
    	 PageFactory.initElements(rdriver, this);
     }
     
     
     @FindBy(name="uid")
     @CacheLookup
     WebElement username;
     
     @FindBy(name="password")
     @CacheLookup
     WebElement password;
     
     @FindBy(name="btnLogin")
     @CacheLookup
     WebElement loginButton;
     
     @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
     @CacheLookup
     WebElement logout;
     
     public void sendUserName(String uname)
     {
    	 username.sendKeys(uname);
     }
     
     public void sendpassword(String pwd)
     {
    	 password.sendKeys(pwd);
     }
     
     public void loginButton()
     {
    	 loginButton.click();
     }
     
     public void logOut()
     {
    	 logout.click();
     }


}
