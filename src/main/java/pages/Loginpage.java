package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import utilities.Baseclass;

public class Loginpage extends Baseclass {

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement loginbutton;

	@FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']")
	WebElement usernamebox;

	@FindBy(xpath = "//input[@class='_2zrpKA _3v41xv _1dBPDZ' and @type='password']")
	WebElement passwordbox;

	@FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement login;

	@Test

	public void loginbuttonclick() {

		loginbutton.sendKeys(Keys.ENTER);

	}

	@Test

	public void entersuserid_and_password() {

		usernamebox.sendKeys(readPropertyFile("username"));

		passwordbox.sendKeys(readPropertyFile("password"));

	}

	@Test
	public void login() {

		login.click();
	}

}
