package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.base.TestBase;


public class ExcelReader extends TestBase {
	public static FileInputStream fis;
	public static Workbook wk;
	public String username = null;
	public String password = null;

	public ExcelReader() throws EncryptedDocumentException, IOException {
		try {
			fis = new FileInputStream("./data/Demo.xlsx");
			wk = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUsername() {

		username = wk.getSheet("validcredentials").getRow(1).getCell(0).toString();
		return username;

	}

	public String getPassword() {

		password = wk.getSheet("validcredentials").getRow(1).getCell(1).toString();
		return password;

	}

}
