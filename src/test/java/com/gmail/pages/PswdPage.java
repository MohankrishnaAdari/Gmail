package com.gmail.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.Library.LibraryClass;

public class PswdPage extends LibraryClass
{
	//-------------------UserField ----------------------
 @FindBy(xpath="//input[@name='password']")
 public static WebElement pwd;
//-------------------Next Btn ----------------------
 
 @FindBy (xpath=""//input[@id='passwordNext']")
 public static WebElement nxtbtn;
//-------------------Error Msg for Uid ----------------------
 @FindBy(xpath ="//*[text()='Enter a password']")
  public WebElement blankpwderr;
	
  @FindBy(xpath ="//*[contains(text(),'Wrong password') or contains(text(),'Your password was changed')]")
   public WebElement invalidpwderr;
  
  public WebDriver driver;
  public PswdPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
  
  //====================Page methods================================
  
  public void enterpwd(String uidvalue)throws Exception
  {
	entertext(pwd,uidvalue);  
  }
  
  public void clickpwdnext()throws Exception
  {
	  clickelement(nxtbtn);
  }
  
  public void validatePasswordCriteria(String value,String com)throws Exception
  {
	 validate(blankpwderr, invalidpwderr, GmailHomePage.pagetitle, value,com);  
  }
}

