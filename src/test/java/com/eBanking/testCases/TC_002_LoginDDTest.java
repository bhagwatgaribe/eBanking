package com.eBanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBanking.Base.BaseClass;
import com.eBanking.pageObjects.LoginPage;
import com.eBanking.utilities.Screenshot;
import com.eBanking.utilities.XLUtils;

public class TC_002_LoginDDTest extends BaseClass{
	
	@Test(dataProvider = "eBankingLoginData")
	public void LoginDDTest(String uname, String pwd) throws IOException, InterruptedException {
		
		LoginPage loginpage = new LoginPage(driver);
		Screenshot ss = new Screenshot();
		
		loginpage.setUserName(uname);
		logger.info("User name provided");
		loginpage.setPassword(pwd);
		logger.info("Password provided");
		loginpage.clickSubmit();
		Thread.sleep(3000);
		
		if (isAlertPresent()== true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			ss.CaptureScreen(driver,"LoginDDTest");
			logger.warn("Login Failed");
			assertTrue(true);
		}
		else {
			assertTrue(false);
			logger.info("LoginPassed");
			loginpage.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	@DataProvider(name = "eBankingLoginData")
	String[][] getData() throws IOException{
		String filePath = System.getProperty("user.dir") + "/src/test/java/com/eBanking/testData/eBankingLoginData.xlsx";
		int rowNum = XLUtils.getRowCount(filePath, "LoginData");
		int colCount = XLUtils.getCellCount(filePath, "LoginData", 1);
		String logindata [][] = new String[rowNum][colCount];
		
		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				logindata[i-1][j] = XLUtils.getCellData(filePath, "LoginData", i, j);
			}
		}
		return logindata;
	}
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
		return false;
		}
	}
}
