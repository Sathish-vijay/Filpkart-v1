package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Baseclass {

	public static WebDriver driver;

	public static Actions a;

	static Properties properties;

	public static String readPropertyFile(String key) {

		properties = new Properties();

		try {
			properties.load(new FileInputStream(
					"C:\\Users\\Lenovo\\eclipse-workspace\\filpkart\\src\\resource\\java\\config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return properties.getProperty(key);

	}

	public static WebDriver browserFactory(String key) {

		String browser = readPropertyFile(key);

		if (browser.toUpperCase().equals("CHROME")) {

			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

			driver = new ChromeDriver();
		}

		else if (browser.toUpperCase().equals("IE")) {

			System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");

			driver = new InternetExplorerDriver();

		}

		else {

			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");

			driver = new FirefoxDriver();

		}

		a = new Actions(driver);

		driver.get(readPropertyFile("url"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		return driver;

	}

}
