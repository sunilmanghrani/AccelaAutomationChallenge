package com.stepDefinations;

import java.text.SimpleDateFormat;
import java.util.Date;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.pageObjects.BasePage;
import com.utils.DriverFactory;

public class StepContext {
	public static WebDriver driver;
	DriverFactory driverFactory = new DriverFactory();
	//setting system properties
	static{
		
		System.getProperty("user.dir");
		System.out.println(System.getProperty("user.dir"));
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("logFilePath", System.getProperty("user.dir")+"/system_logs/log_"+ dateFormat.format(new Date()));
        System.setProperty("screenshotPath", System.getProperty("user.dir")+"/error_screenshot/"+ dateFormat.format(new Date())+"/");
        }
	final static Logger logger = Logger.getLogger(StepContext.class);
	
	@Before
	public void SetUp(Scenario scenario)
	{	
		logger.info("Initializing driver" );
		driver = driverFactory.CreateDriver("chrome");
		logger.info("***Started execution of Scenario ==> " + scenario.getName());
		System.setProperty("scenarioName", scenario.getName());
        
	}
	
	@After
	public void TearDown(Scenario scenario)
	{
		logger.info("***Ended execution of Scenario ==> "+ scenario );
		driver.quit();
		logger.info("Quit driver" );
		logger.info("*****************************************************************" );
		logger.info("*****************************************************************" );
	}
	
	

}
