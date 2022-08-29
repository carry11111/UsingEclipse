package listeners;

import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class ExtentListener implements ITestListener,ISuiteListener{
	
	static Date d= new Date();
	
	static String fileName= "Extent_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
	
	static ExtentReports extent= ExtentManager.createInstance(".//reports//"+fileName);
	
	public static ExtentTest test;
	
	
	public void onTestStart(ITestResult result)
	
	
	{
		
		test=extent.createTest(result.getClass().getName()+"@TEST :"+result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		String methodname= result.getMethod().getMethodName();
		
		String logText= "</b>"+"TEST PASSED:"+methodname;
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		
		test.pass(m);
	}

	public void onTestSkip(ITestResult result)
	{
		String methodname= result.getMethod().getMethodName();
		
		String logText= "</b>"+"TEST SKIPPED:"+methodname;
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
		
		test.log(Status.PASS, m);
	}
	public void onTestFailure(ITestResult result)
	{
		String methodname= result.getMethod().getMethodName();
		
		String logText= "</b>"+"TEST FAILED:"+methodname;
		
		try {
			ExtentManager.captureScrenShot();
		}
		catch(Exception e)
		{
			
		}
		
		//test.fail("Screenshot for failure", MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.fileName).build());
		test.log(Status.FAIL, "Screenshot for failure", MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.fileName).build());
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		
		test.fail(m);
	}
	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
}
