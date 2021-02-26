package seleniumUtil;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports{

	private String reportPath= System.getProperty("user.dir")+PropertyFile.getInstance().getValueOf("reportPath");
	private ExtentTest testLogger;
	private ExtentReports report;
	private ExtentSparkReporter sparkReporter;
	
	public Reports() {
		setUpReports();
	}

	private void setUpReports() {
		sparkReporter = new ExtentSparkReporter(reportPath);
		report = new ExtentReports();
		report.attachReporter(sparkReporter);
		sparkReporter.config().setDocumentTitle("Extent Report Demo");
		sparkReporter.config().setReportName("Test Report");
	}

	public void startReportTest(String testName) {
		testLogger = report.createTest(testName);
		testLogger.log(Status.INFO, "Test execution started");
	}
	
	public void updateLog(Status status, String info) {
		testLogger.log(status,info);
	}
	
	public ExtentTest getTestLogger() {
		return testLogger;
	}

	public void publishExtentReports() {
		report.flush();
	}
	
}
