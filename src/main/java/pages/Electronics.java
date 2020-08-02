package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.Baseclass;

public class Electronics extends Baseclass {

 	WebDriverWait wait;

	@FindBy(xpath = "//span[contains(text(),'Electronics')]")
	WebElement Electronics;

	@FindBy(xpath = "//li[@class='_1KCOnI _3ZgIXy']/a[contains(text(),'Apple') and @title='Apple']")
	WebElement Apple;

	@FindBy(xpath = "//img[@class='_2VeolH _3I5S6S' and @alt='IPHONE-XR-shop now']")
	WebElement shopnow;

	@Test

	public void moveonElectronics() {

		a.moveToElement(Electronics).click().build().perform();

	}

	@Test

	public void selectappleproduct() {

		Apple.click();

	}

	@Test
	public void clickimage() {

		wait = new WebDriverWait(driver, 30);

		// wait.until(ExpectedConditions.invisibilityOf(shopnow));

		wait.until(ExpectedConditions.elementToBeClickable(shopnow)).click();

	}

}
