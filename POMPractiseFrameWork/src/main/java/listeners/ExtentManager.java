package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extent;
	public static String fileName;
	
	public static WebDriver driver;
	
	public static  ExtentReports createInstance(String filename)
	{
		
		ExtentSparkReporter sr= new ExtentSparkReporter(filename);
		sr.config().setDocumentTitle(filename);
		sr.config().setReportName(filename);
		sr.config().setEncoding("utf-8");
		sr.config().setTheme(Theme.STANDARD);
		
		extent= new ExtentReports();
		
		extent.attachReporter(sr);
		extent.setSystemInfo("Tester", "Rajeev");
		extent.setSystemInfo("Build", "PS-1234");
		extent.setSystemInfo("Organisation", "Oracle");
		
		return extent;
		
	}
	
	
	public static void captureScrenShot() throws IOException
	{
		Date d= new Date();
		
		fileName= d.toString().replace(":", "_").replace("", "_")+".jpg";
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File(".//reports//"+fileName));
		
		
	}
		

}
