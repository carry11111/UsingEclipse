package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.Log;

/**
 * @author Hitendra: BaseClass is used to load the config file and Initialize 
 * WebDriver
 *  
 */
public class BaseClass {
	public static Properties prop;

	// Declare ThreadLocal Driver
	//public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	//public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	//public Logger log= Logger.getLogger(BaseClass.class);
	//loadConfig method is to load the configuration
	/* @BeforeSuite(groups = { "Smoke", "Sanity", "Regression" }) */
	@BeforeSuite
	public void loadConfig() {
		
		PropertyConfigurator.configure("C:\\Users\\RAJRASIN\\eclipse-workspace\\POMPractiseFrameWork\\src\\test\\resources\\config\\log4j.properties");
		Log.info("property file loaded");
		
	
	}
	

		/*try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	
	public void launchApp(String browserName) {
		 String browserName1 = prop.getProperty("browser");
		if (browserName1.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName1.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName1.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		//Maximize the screen
		getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//Launching the URL
		getDriver().get(prop.getProperty("url"));
	}

	
}
