package execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.Electronics;
import pages.Loginpage;
import utilities.Baseclass;

public class Executioncentre {

	@Test

	public void execute() {

		WebDriver driver = Baseclass.browserFactory("browser");

		Loginpage loginPage = PageFactory.initElements(driver, Loginpage.class);

		loginPage.loginbuttonclick();

		loginPage.entersuserid_and_password();

		loginPage.login();

		Electronics electronics = PageFactory.initElements(driver, Electronics.class);

		electronics.moveonElectronics();

		electronics.selectappleproduct();
		
		electronics.clickimage();
		

	}

}
