package com.dvm.qa.selenium.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static Properties prop;
	public WebDriver driver;

	public TestBase()  {

		try {
			prop = new Properties();
			
			File f = new File(System.getProperty("user.dir")+"/src/main/java/com/dvm/qa/selenium/config/config.properties");
			
			FileInputStream fis = new FileInputStream(f);
			
			prop.load(fis);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	public WebDriver launchBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}
}
