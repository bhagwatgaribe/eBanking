package com.eBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how = How.XPATH, using= "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement lnkNewCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.XPATH, using = "//tbody/tr[5]/td[2]/input[1]")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinNo;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtTelephoneNo;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmailId;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;

	public void ClickAddNewCustomer() {
		lnkNewCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys("cname");
	}
	
	public void custGender(String cgender) {
		rdGender.click();
	}
	
	public void custDOB(String dd, String mm, String yy) {
		txtdob.sendKeys("dd");
		txtdob.sendKeys("mm");
		txtdob.sendKeys("yy");
	}
	
	public void custAddress(String caddress) {
		txtAddress.sendKeys("caddress");
	}
	
	public void custCity(String ccity) {
		txtCity.sendKeys("ccity");
	}
	
	public void custState(String cstate) {
		txtState.sendKeys("cstate");
	}
	
	public void custPinNo(String cpinno) {
		txtPinNo.sendKeys(cpinno);
	}
	
	public void custTelephone(String ctelephone) {
		txtTelephoneNo.sendKeys("ctelephone");
	}
	
	public void custEmailId(String cemailid) {
		txtEmailId.sendKeys(cemailid);
	}
	
	public void custPassword(String cpassword) {
		txtPassword.sendKeys("cpassword");
	}
	
	public void custSubmit() {
		btnSubmit.click();
	}
	
	
}
