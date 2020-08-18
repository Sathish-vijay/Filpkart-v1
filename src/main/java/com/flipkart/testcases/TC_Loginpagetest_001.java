package com.flipkart.testcases;

import org.testng.annotations.Test;

import com.filpkart.pages.Electronics;
import com.filpkart.pages.Loginpage;

public class TC_Loginpagetest_001 extends Baseclass {

	@Test
	public void LoginTest() {

		Loginpage login = new Loginpage(driver);

		login.sendusernametobox(username);
		login.sendpasswordtobox(password);
		login.Clickloginbutton();

		Electronics ele = new Electronics(driver);

		ele.moveonElectronics();

		ele.verifyappletext();

		ele.clickonapple();

	}

}
