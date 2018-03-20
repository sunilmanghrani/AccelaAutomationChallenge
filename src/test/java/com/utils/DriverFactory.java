package com.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	public WebDriver driver = null;
	
	/**
	 * This method is for driver creation and invoke
	 * 
	 * @param browser name
	 * @returnType  It returns WebDriver
	 * 
	 */
		public WebDriver CreateDriver(String selectedBrowser)
	{
                switch (selectedBrowser.toLowerCase())
                {
                    case "firefox":
                        driver = new FirefoxDriver();
                        return driver;

                    case "ie":
                        driver = new InternetExplorerDriver();
                        return driver;

                    case "chrome":
                    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +  "\\drivers"+"\\chromedriver.exe");
                		ChromeOptions options = new ChromeOptions();
                		options.addArguments("--disable-extensions");	
                    	driver = new ChromeDriver(options);
                    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    	driver.manage().window().maximize();
                        return driver;

                    default:
                        System.out.println("selected browser is not valid");
                        return driver;
                }
	}

}
