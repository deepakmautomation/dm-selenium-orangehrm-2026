package com.dvm.qa.selenium.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dvm.qa.selenium.pages.LoginPage;
import com.dvm.qa.selenium.testbase.TestBase;
import com.dvm.qa.selenium.util.ListenerCls;

@Listeners(ListenerCls.class)

public class LoginPageTest {

	WebDriver driver;
	LoginPage loginPage;
	TestBase testBase;

	@BeforeMethod
	public void setup() {
		testBase = new TestBase();
		driver = testBase.launchBrowser("chrome");
		loginPage = new LoginPage(driver);
	}

	@Test
	public void verify_Page_Load() {
		boolean logocheck =  loginPage.checkLogo();
		Assert.assertTrue(logocheck);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}


}
