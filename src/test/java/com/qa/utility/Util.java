package com.qa.utility;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.qa.base.TestBase;

import io.qameta.allure.Allure;

public class Util extends TestBase {

	public static void takeScreenShot(String path) throws IOException {

		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(path));
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public static void DisplayOutputinReport(String heading, String actual) throws Exception {
		Allure.addAttachment(heading, actual);
	}

	public static void ScreenshotStep(String screenshotName) throws Exception {
		Thread.sleep(700);
		InputStream screenshot = new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
		Allure.addAttachment(screenshotName, "image/png", screenshot, "png");
	}

}
