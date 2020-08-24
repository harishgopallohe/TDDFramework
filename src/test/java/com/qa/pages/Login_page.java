package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	//initialization and declaration

	@FindBy (id = "LogonId") private WebElement username;	
	@FindBy (id = "LoginPasscode") private WebElement password;
	@FindBy (xpath = "//button[text()='Login']") private WebElement login;	

	
	public Login_page(WebDriver driver) {
		
			PageFactory.initElements(driver, this);
		
	}	
	
	//utilization
	
	public void serCredentials(String enter_user, String enter_password) {
		
		username.sendKeys(enter_user);
		password.sendKeys(enter_password);
		
	}
	
	
	public void clickLogin() {
		login.click();
	}
	

}
