package com.inetbanking.testCases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass

{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pass) throws InterruptedException
	{
		  LoginPage lp = new LoginPage(driver);
		  lp.sendUserName(user);
			logger.info("UsernameSended");
		  lp.sendpassword(pass);
			logger.info("PasswordSended");
		  lp.loginButton();
			Thread.sleep(3000);
		  if(isAlertPresent()== true)
		  {
			  driver.switchTo().alert().accept();
			  driver.switchTo().defaultContent();
			  Assert.assertTrue(false);
			  logger.warn("login failed");
		  }
		  
			else
			{
				Assert.assertTrue(true);
				logger.info("Login passed");
				lp.logOut();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
				
			}

	}
	
	@DataProvider(name="LoginData")
	String[][]getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/TestData.xlsx";
		
		int rowNum = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String [rowNum][colCount];
		
		for(int i=1;i<rowNum;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}

		}

		  return loginData;
		
	}
	
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e)
		{
		return false;
		}
	}

}
