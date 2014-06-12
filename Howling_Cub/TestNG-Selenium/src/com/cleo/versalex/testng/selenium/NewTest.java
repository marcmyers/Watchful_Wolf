package com.cleo.versalex.testng.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.net.URL;  

import org.openqa.selenium.By;  
import org.openqa.selenium.Platform;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;  
import org.openqa.selenium.remote.RemoteWebDriver;  
import org.testng.Assert;  
import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeClass;  
import org.testng.annotations.Test;  

public class NewTest {
	private WebDriver driver;

  @Test(invocationCount=5, threadPoolSize=5)
  public void testSimple() throws Exception {  
      driver.get("http://testingbot.com/");  
      String searchHeader = driver.findElement(By.cssSelector("H1"))  
              .getText().toLowerCase();  

      Assert.assertTrue(searchHeader.contains("online browser testing"));  
  }
  
  @BeforeClass
  public void setUp() throws Exception {  
//      DesiredCapabilities capabillities = DesiredCapabilities.firefox();  
//      capabillities.setCapability("version", "12");  
//      capabillities.setCapability("platform", Platform.WINDOWS);  
//      capabillities.setCapability("name", "Testing Selenium 2");  

      driver = new FirefoxDriver();
  }  

  @AfterClass
  public void tearDown() throws Exception {  
      driver.quit();  
  } 

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
