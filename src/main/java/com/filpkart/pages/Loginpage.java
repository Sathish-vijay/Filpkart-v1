package com.filpkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Loginpage {

	WebDriver ldriver;

	public Loginpage(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(ldriver, this);

	}

	@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
	WebElement usernamebox;

	@FindBy(xpath = "//input[@class='_2zrpKA _3v41xv _1dBPDZ' and @type='password']")
	WebElement passwordbox;

	@FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c' and @type='submit']")
	WebElement login;

	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
	WebElement close;

	public void sendusernametobox(String username) {

		usernamebox.sendKeys(username);
	}

	public void sendpasswordtobox(String password) {

		passwordbox.sendKeys(password);
	}

	public void Clickloginbutton() {

		login.click();

		// Assert.assertTrue(false);
	}

}
