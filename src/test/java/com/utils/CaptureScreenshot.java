package com.utils;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;

public class CaptureScreenshot {
	
	/**
	 * This method captures the screen shot, developed in java and can be used for any automation tool
	 * 
	 * @param scenarioName, errorType
	 * Name of the file, in this case is 'errorType'_stepFailed
	 * 
	 */
public void caputureImage(String scenarioName, String errorName) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");

		String resultFolder = "";
		createFolder(System.getProperty("screenshotPath"));
		resultFolder = System.getProperty("screenshotPath")+ scenarioName;
		createFolder(resultFolder);
		
		File resultScreenShot = new File(resultFolder + "/"+errorName+"_StepFailed.jpg");

		try {			
			Robot robot = new Robot();
			Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit()
					.getScreenSize());
			BufferedImage bufferedImage = robot
					.createScreenCapture(captureSize);
			ImageIO.write(bufferedImage, "jpg", resultScreenShot);

		} catch (AWTException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}

	}

/**
 * This method create directory for error screen shot(if it not exists)
 * 
 * @param directory path
 * 
 */
		public void createFolder(String path)
		{
			File directory = new File(String.valueOf(path));
			 if(!directory.exists()){
			      directory.mkdir();
			}		
		}
}
