import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {

public static void main(String[] args) throws InterruptedException {
	
	String downloadPath="C:\\Users\\RAJRASIN\\Pictures";
	
    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("profile.default_content_settings.popups", 0);
    chromePrefs.put("download.default_directory", downloadPath);
    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("prefs", chromePrefs);
    options.addArguments("--test-type");
    options.addArguments("--disable-extensions"); //to disable browser extension popup
    options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
   

		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
	
		driver.get("http://softwaretestingplace.blogspot.com/2015/10/sample-web-page-to-test.html");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[text()='Download Text File']")).click();
		//ele.click();
		
}
}