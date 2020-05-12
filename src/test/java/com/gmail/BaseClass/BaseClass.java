package com.gmail.BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmail.pages.UidPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
  public static WebDriver driver;
  public static WebDriverWait wait;
  
  //------------------------openbrowser--------------------------
  public WebDriver openbrowser(String bn)
  {
	  if (bn.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
	  }
	  else if (bn.equalsIgnoreCase("firefox"))
	  {
		  WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();
	  }
	  else if (bn.equalsIgnoreCase("opera"))
	  {
		  WebDriverManager.operadriver().setup();
		  driver=new OperaDriver();		  
	  }
	  else
	  {
		 System.out.println("Given browser is out of scope");
	  }
	  return driver ;
	  
  }
  
  //---------------launch site--------------------
  public void launchsite(String url)
  {
	  driver.get(url);
	  driver.manage().window().maximize();
	  wait=new WebDriverWait(driver,20);
	  wait.until(ExpectedConditions.visibilityOf(UidPage.uid));
  }
//------------------Close site----------------
  public void closesite()
  {
	  driver.close();
  }
//------------------validate title----------------
  public void validatetitle(String expval)
  {
	  String actval=driver.getTitle();
	  if(actval.equalsIgnoreCase(expval))
	  {
		  System.out.println("title test pass");
	  }
	  else
	  {
		  System.out.println("title test failed");
	  }
  }
}
