package com.gmail.Library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;

import com.gmail.BaseClass.BaseClass;
import com.gmail.Report.Report;

public class LibraryClass extends Report
{
	
	//--------------------click method---------------------
	public static void clickelement(WebElement element) throws Exception
	{
	   try
	   {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	   }
	   catch(Exception e)
	   {
		   logFailException(e);  
	   }
	}
	
	//---------------------sendkeys method-----------------
	public static void entertext(WebElement element, String value)throws Exception
	{

		   try
		   {
			 wait.until(ExpectedConditions.visibilityOf(element));
			 element.sendKeys(value);
		   }
		   catch(Exception e)
		   {
			   logFailException(e);  
		   }
		
	}
	
	//---------------------sendkeys and enter method-----------------
		public static void sendtextandEnter(WebElement element, String value)throws Exception
		{

			   try
			   {
				 wait.until(ExpectedConditions.visibilityOf(element));
				 element.sendKeys(value,Keys.ENTER);
			   }
			   catch(Exception e)
			   {
				   logFailException(e); 
			   }
			
		}
	//--------------------------------validatefields--------------
	public static void validate(WebElement blankele,WebElement invalidele,WebElement validele,String value,String com) throws Exception
	{
		try
		{
			Thread.sleep(5000);
			if (value.equalsIgnoreCase("blank")&& blankele.isDisplayed())
			{
				logPass(com);;
			}
			else if (value.equalsIgnoreCase("invalid")&& invalidele.isDisplayed())
			{
				logPass(com);
			}
			else if (value.equalsIgnoreCase("valid")&& validele.isDisplayed())
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
			logFailException(ex);	
		}
	   
	 
	}

}
