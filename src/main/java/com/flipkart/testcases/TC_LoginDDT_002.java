package com.flipkart.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.filpkart.pages.Loginpage;
import com.flipkart.utilities.XLData;

public class TC_LoginDDT_002 extends Baseclass {

	@Test(dataProvider = "Logindata")

	public void Datareceiver(String username, String password) {

		Loginpage login = new Loginpage(driver);

		login.sendusernametobox(username);
		login.sendpasswordtobox(password);
		login.Clickloginbutton();

		// driver.quit();

	}

	@DataProvider(name = "Logindata")

	@Test

	public String[][] getexcelData() throws Exception {

		int rowcount = XLData.getrowcount();

		int cellcount = XLData.getcellcount();

		String[][] logindata = new String[rowcount][cellcount];

		for (int i = 1; i < rowcount; i++) {

			for (int j = 0; j <cellcount; j++) {

				logindata[i-1][j] = XLData.getCellData(i, j);

			}

		}

		return logindata;

	}

}
