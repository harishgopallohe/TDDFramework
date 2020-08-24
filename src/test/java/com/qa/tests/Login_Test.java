package com.qa.tests;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.qa.base.TestBase;
import com.qa.pages.Login_page;
import com.qa.utility.ExcelReader;
import com.qa.utility.Util;

public class Login_Test extends TestBase {

	public static Login_page lp;
	public static ExcelReader reader;

	@Test(groups = "sanity")
	public void Login_test() throws Exception {

		lp = new Login_page(driver);
		reader = new ExcelReader();

		lp.serCredentials(reader.getUsername(), reader.getPassword());
		log.info("***Username and password is enterened***");
		log.debug("***User is logging in***");
		lp.clickLogin();
		log.info("***User logged in***");

		Util.ScreenshotStep("Login_Test");

		Reporter.log("My test case is passed", true);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(driver.getTitle(), "DashBoard");

		Util.DisplayOutputinReport("Login", "Login Successful");
		
		log.info("***Message is displayed in the report***");

		sa.assertAll();

	}

}
