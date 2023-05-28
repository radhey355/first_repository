package com.login;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.loginPage.DashBord;
import com.loginPage.Login;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPage {
	WebDriver driver = null;
	Login lp= null;
    DashBord dp = null;
    
	@BeforeSuite
	public void setup() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("file:///C:/Users/HP/Downloads/JARS/selenium/javabykiran-Selenium-Softwares/Offline%20Website/index.html");
		
	}
@Test
public void test01() {
	
	 lp = new Login(driver);
	dp=lp.ValidLogin();
	System.out.println(driver.getTitle());
	Assert.assertEquals(driver.getTitle(),"JavaByKiran | Dashboard" );
}


@Test
public void test02() {
	ArrayList<String> expectedCourses = new ArrayList<String>();
	expectedCourses.add("Selenium");
	expectedCourses.add("Java / J2EE");
	expectedCourses.add("Paython");
	expectedCourses.add("Php");
	
	dp.VerifyCourses();
}
}
	

