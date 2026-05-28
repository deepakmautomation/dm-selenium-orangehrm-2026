package com.dvm.qa.selenium.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dvm.qa.selenium.pages.DashboardPage;
import com.dvm.qa.selenium.pages.LoginPage;
import com.dvm.qa.selenium.testbase.TestBase;
import com.dvm.qa.selenium.util.ListenerCls;

@Listeners(ListenerCls.class)

public class LoginPageTest {

	WebDriver driver;
	LoginPage loginPage;
	TestBase testBase;
	DashboardPage dashboardPage;

	@Parameters({"browser"}) // Browser is testNg level so run it as testNG suite 
	@BeforeMethod
	public void setup(String browser) {
		testBase = new TestBase();
		driver = testBase.launchBrowser(browser);
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
	}

	@Test(priority = 0)
	public void verify_Page_Load() {
		boolean logocheck =  loginPage.checkLogo();
		Assert.assertTrue(logocheck);
	}

	@Test (priority = 1)
	public void Verify_valid_login() {
		dashboardPage  = loginPage.login(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
