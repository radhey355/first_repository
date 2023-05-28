package com.test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.loginPage.Login;

public class LoginTest extends BaseClass {
    
	Login lp= null;
	
	@BeforeSuite
	public void setup() throws Exception {
		initialization();
		reportInit();
		lp=new Login(driver);
	}
	
	@Test
	public void Test01() {
		lp.ValidLogin("kiran@gmail.com", "123456");
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
		//from dashboard page
	}
	
	@Test
	public void Test02() {
		//  TO FAIL THE TEST CASE
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard111");
}
	
	@Test
	public void test03() {
	  throw new SkipException("skiping test case");
	  //to skip the test case
	}

}
