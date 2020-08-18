package com.flipkart.testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.utilities.Readconfig;

public class Baseclass {

	Readconfig readconfig = new Readconfig();

	public static WebDriver driver;

	public String url = readconfig.geturl();

	public String username = readconfig.getusername();

	public String password = readconfig.getpassword();
 
	// public String browser = readconfig.getbrowsertype();

	@Parameters("browser")

	@BeforeClass

	public void Setup(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", readconfig.chromepath());

			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("mozila")) {

			System.setProperty("webdriver.gecko.driver", readconfig.mozilapath());

			driver = new FirefoxDriver();

		}

		driver.get(url);

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
    	@Test
	public static Actions Act() {
		
		Actions a =new Actions(driver);
	
		return a;
	}

	@AfterMethod
	public void captureScreen(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {

			Date date = java.util.Calendar.getInstance().getTime();
			System.out.println(date);

			String testname = result.getName();

			System.out.println(testname);

			TakesScreenshot tks = (TakesScreenshot) driver;

			File temp = tks.getScreenshotAs(OutputType.FILE);

			File sc = new File("./Screenshot/" + testname + System.currentTimeMillis() + ".png");

			FileUtils.copyFile(temp, sc);

			System.out.println("Screenshot taken");

		}

	}

	@AfterClass

	public void close() {

	//	driver.quit();

	}

}
