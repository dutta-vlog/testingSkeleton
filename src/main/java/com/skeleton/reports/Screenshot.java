package com.skeleton.reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screenshot {

	private WebDriver webdriver;

	public Screenshot(WebDriver webdriver) {
		this.webdriver=webdriver;
	}
	
	public String takeScreenshot(){
			String targetPathWithName = getTargetFilePathWithName();
			File screenshotInputFile = captureScreenshotToFile();
			File screenshotoutputFile =new File(targetPathWithName);
			storeScreenshotAt(screenshotInputFile,screenshotoutputFile);
			return targetPathWithName;
	}
	
	private void storeScreenshotAt(File sourceFile, File targetFilr) {
		try {
			FileUtils.copyFile(sourceFile, targetFilr);
		} catch (IOException e) {
			System.out.println("Screenshot Destination Path is not accessable or does not exist");
			e.printStackTrace();
		}
	}

	private String getTargetFilePathWithName() {
		String targetFileName = System.getProperty("user.dir")+ "/test-output/screenshot/"+getTimeStamp()+".png";
		return targetFileName;
	}

	private File captureScreenshotToFile() {
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		return scrShot.getScreenshotAs(OutputType.FILE);
	}

	public static String getTimeStamp() {
		LocalDateTime timestamp = LocalDateTime.now();
		return timestamp.format(DateTimeFormatter.ofPattern("yyMMdd_HHmmss"));
	}
	
}
