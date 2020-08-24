package com.qa.base;
import com.qa.utility.Util;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop;
	public static Logger log;
	


	static {
		
		try {
			log = Logger.getLogger(TestBase.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			fis = new FileInputStream(
					"C:\\Data\\Selenium Workspace\\SeleniumTraining\\src\\com\\qa\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicit")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		log.info("***Driver is maximized***");
		driver.get(prop.getProperty("URL"));
		log.info("***URL is fetched***");

	}

	@AfterMethod
	public void afterMethod(ITestResult it) throws IOException {
		if (it.getStatus() == 1 || it.getStatus() == 2) {
			Util.takeScreenShot(prop.getProperty("path") + it.getName() + ".png");
		}
		
		log.debug("***Screenshot is taken***");

		driver.quit();
		
		log.debug("***Browser is closed***");

	}

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		log.warn("***driver is initialised***");

	}

	@BeforeSuite
	public void beforeSuite() {

		log.info("***Execution is started***");
		Reporter.log("This is my train application", true);
	}

	@AfterSuite
	public void report() {
		Reporter.log("This is my report", true);
		log.info("***Execution is complete***");
	}

}
