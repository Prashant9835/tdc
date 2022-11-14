package com.tdc.lms.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.tdc.lms.pages.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	//public LoginPage LoginPage;
	//public MyProfilePage MyProfile;
	
	
	@BeforeSuite(alwaysRun = true)
	public void initializeDriver() throws IOException  {
		
		//properties class
		Properties prop = new Properties();                              
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tdc\\\\lms\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Prashant\\Downloads\\edgedriver_win64\\msedgedriver.exe\\");
			driver.set(new EdgeDriver());
		}
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get().manage().window().maximize();
		//return driver;
		/*
		 * LoginPage = new LoginPage(driver); LoginPage.goTo(); MyProfile = new
		 * MyProfilePage(driver);
		 */
	}
	  	  	  	 	
	
	/*
	 * @BeforeTest(alwaysRun = true) public void launchApplication() throws
	 * IOException { //driver = initializeDriver(); LoginPage = new
	 * LoginPage(driver); LoginPage.goTo(); MyProfile = new MyProfilePage(driver); }
	 */
	 
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.get().close();
	}	  	 	

}
