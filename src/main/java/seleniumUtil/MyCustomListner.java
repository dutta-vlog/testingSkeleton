package seleniumUtil;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class MyCustomListner implements ITestListener {
	
	ScriptController scriptController ;
	
	public MyCustomListner() {
		scriptController = new TestConfiguration().getScriptController();
	}
	

	public void onTestStart(ITestResult result) {
		scriptController.getLog4j().getLog4jLogger().info(result.getName()+" test is being executed.");
	}

	public void onTestSuccess(ITestResult result) {
		scriptController.getLog4j().getLog4jLogger().info(result.getName()+" Passed.");
		scriptController.getReport().getTestLogger().log(Status.PASS, result.getName() + " - PASSED",
				MediaEntityBuilder
						.createScreenCaptureFromPath(scriptController.getScreenshotInstance().takeScreenshot())
						.build());
	}

	public void onTestFailure(ITestResult result) {
		scriptController.getLog4j().getLog4jLogger().error(result.getName()+" Failed."+ result.getThrowable());
		String scrrenShotName= scriptController.getScreenshotInstance().takeScreenshot();
		scriptController.getReport().getTestLogger().fail( scrrenShotName + " - FAILED");
			scriptController.getReport().getTestLogger().fail("<b><font color=red>"
					+ " Click the below link Or check the above screenshot at folder to get the Screenshot of failure "
					+ "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(scrrenShotName).build());
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// not implemented
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		scriptController.getLog4j().getLog4jLogger().info(context.getCurrentXmlTest()+ " started executing.");
		scriptController.getReport().startReportTest(context.getName());
	}

	public void onFinish(ITestContext context) {
		scriptController.getLog4j().getLog4jLogger().info(context.getCurrentXmlTest()+ " finished executing.");
		scriptController.getReport().publishExtentReports();

	}
}
