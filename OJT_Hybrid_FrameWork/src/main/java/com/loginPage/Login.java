package com.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	WebDriver driver= null;
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button")
	WebElement loginbtn;
	
	public DashBord ValidLogin(String uname , String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbtn.click();
		
		return new DashBord(driver);
	}
	
		
	

}
