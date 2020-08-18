package com.filpkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.flipkart.testcases.Baseclass;

public class Electronics {

	public WebDriver ldriver;

	public Electronics(WebDriver rdriver) {

		this.ldriver = rdriver;

		PageFactory.initElements(ldriver, this);

	}

	@FindBy(xpath = "//span[text()='Electronics']")
	WebElement Electronics;

	@FindBy(xpath = "//li/a[@title='Apple' and contains(text(),'Apple')]")

	WebElement apple;

	public void moveonElectronics() {

		Baseclass.Act().moveToElement(Electronics).perform();

		System.out.println("Mouse over is DONE");

	}

	public void verifyappletext() {

		String text = apple.getText();

		Assert.assertEquals(text, "Apple");

	}

	public void clickonapple() {

		apple.click();

		System.out.println("Click on apple is Done");
	}

}
