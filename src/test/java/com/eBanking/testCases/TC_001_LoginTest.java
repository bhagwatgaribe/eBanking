package com.eBanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanking.Base.BaseClass;
import com.eBanking.pageObjects.LoginPage;
import com.eBanking.utilities.Screenshot;

public class TC_001_LoginTest extends BaseClass {
	
	@Test
	public void LoginTest() throws IOException {
		driver.get(baseURL);
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		Screenshot ss = new Screenshot();
		lp.setUserName(username);
		logger.info("User name is entered");
		
		lp.setPassword(password);
		logger.info("Password is entered");
		
		lp.clickSubmit();
		logger.info("Clicked on submit button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			ss.CaptureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}
}
