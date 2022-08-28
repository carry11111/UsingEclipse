import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Framehandling {
	
	public static void main(String[] args) throws InterruptedException {
		
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	driver.get("https://www.automationtestinginsider.com/2019/08/textarea-textarea-element-defines-multi.html");

	
	List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
	
	System.out.println(iframes.size());
	
	for(int i=1;i<=iframes.size();i++)
	{
		driver.switchTo().frame(i);
		if(driver.findElements(By.id("searchInput")).size()>0)
			
		{
			System.out.println(i); 
			break;
		}
		
		else
		{
			driver.switchTo().defaultContent();
			System.out.println("switched to main window");
		}
		
		
	}
	
	driver.findElement(By.id("searchInput")).sendKeys("ABCD");
	



}
}
