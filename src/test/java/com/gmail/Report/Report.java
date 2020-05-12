package com.gmail.Report;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.gmail.BaseClass.BaseClass;

public class Report extends BaseClass
{
	public static String screenshot() throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		String fn=sf.format(dt)+".png";
		File src=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(fn);
		FileHandler.copy(src,dest);
		return(dest.getAbsolutePath());
	}
//===========================================================================================================	
public static void logPass(String com) throws Exception
	{
		String fp=screenshot();
		Reporter.log("Test passed for "+com);
		Reporter.log(
			"<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");     
	
	}
	
public static void logFail(String com) throws Exception
{
	String fp=screenshot();
	Reporter.log("Test failed for "+com);
	Reporter.log(
		"<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");     
	Assert.fail();
}

public static void logFailException(Exception com) throws Exception
{
	String fp=screenshot();
	Reporter.log("Test failed for "+com);
	Reporter.log(
		"<a href=\""+fp+"\"><img src=\""+fp+"\" height=\"100\" width=\"100\"/></a>");     
	Assert.fail();
}
//=========================================================================================================================
public static String createResultFolder()
{		
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YY");
	
	String path="";
	
	File f=new File(System.getProperty("user.dir")+"\\Results\\"+sdf.format(new Date()).replace("/", "_")+"\\TestSummaryReport.html");
			
	if(!f.exists())
	{			
		f.mkdirs();
		path=System.getProperty("user.dir")+"\\Results\\"+sdf.format(new Date()).replace("/", "")+"\\TestSummaryReport.html";
	}else
		 {
			path=System.getProperty("user.dir")+"\\Results\\"+sdf.format(new Date()).replace("/", "")+"\\TestSummaryReport.html";
		}		
	return path;
}
}
