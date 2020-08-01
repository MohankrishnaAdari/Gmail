package com.gmail.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.Library.LibraryClass;

public class UidPage extends LibraryClass
{
	//-------------------UserField ----------------------
 @FindBy(xpath="//input[@id='Email']")
 public static WebElement uid;
//-------------------Next Btn ----------------------
 
 @FindBy (xpath="//input[@id='next']")
 public static WebElement nxtbtn;
//-------------------Error Msg for Uid ----------------------
 @FindBy(xpath ="//div[contains(text(),'Enter an email')]")
  public static WebElement blankuiderr;
                  
 @FindBy(xpath ="//div[contains(text(),'find your Google Account') or contains(text(),'Enter a valid email')]")
   public static WebElement invaliduiderr;
  
  public WebDriver driver;
  public UidPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
  
  //====================Page methods================================
  
  public void enteruid(String uidvalue)throws Exception
  {
	entertext(uid,uidvalue);  
  }
  
  public void clickuidnext()throws Exception
  {
	  clickelement(nxtbtn);
  }
  
  public void validateUserIdCriteria(String value,String com)throws Exception
  {
	 validate(blankuiderr, invaliduiderr, PswdPage.pwd, value, com);  
  }
}

