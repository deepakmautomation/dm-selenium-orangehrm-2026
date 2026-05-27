package com.dvm.qa.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	By logo = By.xpath("//div[@class='orangehrm-login-branding']/img");
	By username = By.name("username");
	By password = By.name("password");
	By loginbutton = By.xpath("//div[contains(@class,'orangehrm-login-action')]/button");

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	public boolean checkLogo() {
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
		return driver.findElement(logo).isDisplayed();
	}
	
	public DashboardPage login(String uname, String pwd) {
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbutton).click();
		return new DashboardPage(driver);
	}
}
