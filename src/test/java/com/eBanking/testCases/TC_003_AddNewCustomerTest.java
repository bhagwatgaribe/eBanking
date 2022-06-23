package com.eBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBanking.Base.BaseClass;
import com.eBanking.pageObjects.AddCustomerPage;
import com.eBanking.pageObjects.LoginPage;
import com.eBanking.utilities.RandomCharUtils;
import com.eBanking.utilities.Screenshot;

public class TC_003_AddNewCustomerTest extends BaseClass {

	@Test
	public void AddNewCustomer() throws IOException, InterruptedException {
		
		Screenshot ss = new Screenshot();
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("User Name Provided");
		lp.setPassword(password);	
		logger.info("Password Provided");
		lp.clickSubmit();
		logger.info("Logged in successfully");
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.ClickAddNewCustomer();
		logger.info("Providing Customer Details...");
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		addcust.custName("Ramesh");
		addcust.custGender("male");
		addcust.custDOB("07", "12", "1990");
		addcust.custAddress("Magarpatt, Hadapsar");
		addcust.custCity("Pune");
		addcust.custState("Maharashtra");
		addcust.custPinNo("411028");
		addcust.custTelephone("8888888888");
		
		RandomCharUtils rcu = new RandomCharUtils();
		String emailString = rcu.RandomString() + "@gmail.com";
		addcust.custEmailId("emailString");
		
		addcust.custPassword("Abcd@123");
		addcust.custSubmit();
		
		boolean result =  driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (result == true) {
			Assert.assertTrue(true);
			logger.info("Test case passed");
		}
		else {
			ss.CaptureScreen(driver, "AddNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case failed");
		}
	}
	
	
	
	
}