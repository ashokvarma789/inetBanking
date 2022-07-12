package com.inetbanking.testCases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.Assert;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
        
	@Test
	  public void loginTest() throws InterruptedException, IOException
	  {
		  logger.info("URL is Opened");
		  LoginPage lp = new LoginPage(driver);
		  lp.sendUserName(username);
		  logger.info("Entered Username");
		  lp.sendpassword(password);
		  logger.info("Entered Password");
		  lp.loginButton();
		  logger.info("Clicked Login Button");

		    if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		    {
		    	Assert.assertTrue(true);
				logger.info("Login Test Passed");

		    }
		    
		    else 
		    {   
		    	captureScreen(driver, "loginTest");
		    	Assert.assertTrue(false);
				logger.info("Login Test Failed");


		    }
	  }
}
