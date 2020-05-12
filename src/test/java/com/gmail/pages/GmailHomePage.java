package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gmail.Library.LibraryClass;

public class GmailHomePage extends LibraryClass 
{
	
//------------------------Gmail Page-----------------
	@FindBy (xpath="//*[@aria-label='Main menu']/following-sibling::div[3]/descendant::a")
	public static WebElement pagetitle;
//------------------------SearchBar-----------------
	@FindBy (xpath="//input[@name='q']")
	public static WebElement searchbar;
	
	//------------------------CheckBox-----------------
	@FindBy (xpath="(//span[@role='checkbox'])[2]")
	public static WebElement checkbox;
	//------------------------DeleteButton-----------------
	@FindBy (xpath="//*[@gh='mtb']/descendant::div[@aria-label='Delete']")
	public static WebElement deleteBtn;
	//------------------------signout-----------------
	@FindBy (xpath="//*[starts-with(@aria-label,'Google Account')]/child::span")
	public static WebElement gmailProfile;
	
	@FindBy (xpath="//a[text()='Sign out']")
	public static WebElement signoutBtn;
	
	@FindBy (xpath="//*[@class='bBf']")
	public static WebElement delmailmsg;
	
	@FindBy (xpath="//*[contains(text(),'Some messages in Trash')]")
	public static WebElement nomsgs;
	
	public WebDriver driver;
	public String unread="label:unread";
	public GmailHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//========================Page methods========================================
	
	public void searchMails()throws Exception
	{
	  sendtextandEnter(searchbar, unread);	
	}
	 public void deletemails(String com)throws Exception
	 {
		try
		{
	      while(2>1)
	      {
	       Thread.sleep(5000); 
	       clickelement(checkbox);
	       Thread.sleep(5000);
	       if(deleteBtn.isDisplayed())
	        {
	    	  wait.until(ExpectedConditions.visibilityOf(deleteBtn));
		      clickelement(deleteBtn);
	        }
	       else
	        {
	    	 validateDeletemsg(com);
	    	  	 break;
	        }
	       }
		 }
		catch(Exception e)
		{
			validateDeletemsg(com);
			
		}
	 }
	public void validateDeletemsg(String com)
	{
		try
		{
		  wait.until(ExpectedConditions.visibilityOf(nomsgs));
		  if(nomsgs.isDisplayed())
		  {
			  logPass(com);
		  }
		  else
		  {
			  logFail(com);
		  }
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void signout() throws Exception
	{
	  
	  clickelement(gmailProfile);
	  wait.until(ExpectedConditions.elementToBeClickable(signoutBtn));
	  clickelement(signoutBtn);
	  Thread.sleep(5000);
	}
	
}
