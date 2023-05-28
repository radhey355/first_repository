 package com.base;

import org.apache.log4j.Logger;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utility.PropertyUtils;

public class BaseClass {
	
	public static WebDriver driver = null;
	public static ExtentReports report= null;
	public static ExtentSparkReporter spakr = null;
	public static ExtentTest test= null;
	
	Logger log = Logger.getLogger(BaseClass.class);
	
	     //TO INETILIZE THE BROWSER
	public void initialization() throws Exception {
		
		System.out.println("Reading property file for browser");
		log.info("Reading property file for browser");
		
		String browserName= PropertyUtils.readProperty("browser");
		
		     //IF THERE IS CHROME
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("WebDriver.chrome.driver", "C:/chromedriver.exe");
		   driver= new ChromeDriver();
		}
		     //IF THERE IS FIREFOX
		if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("WebDriver.gecko.driver", "C:/geckodriver.exe");
		   driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(PropertyUtils.readProperty("url"));
		
		
	}
	public void reportInit() {  
		report =  new ExtentReports();
		spakr  =  new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReports.html");
		report.attachReporter(spakr);
	}
}
