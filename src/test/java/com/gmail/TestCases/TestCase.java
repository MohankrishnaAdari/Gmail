package com.gmail.TestCases;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gmail.BaseClass.BaseClass;
import com.gmail.pages.GmailHomePage;
import com.gmail.pages.PswdPage;
import com.gmail.pages.UidPage;


public class TestCase extends BaseClass
{
	public Properties pro;
	
	@BeforeMethod
	public void method1() throws Exception
	{
		//Define Properties object and load properties file
		FileInputStream fi=new FileInputStream("D:\\Selenium\\Workspace\\org.mohan.mail\\src\\test\\resources\\properties.properties");
	    pro=new Properties();
		pro.load(fi);
	}	
	@AfterMethod
	public void closeBrowser()
	{
		closesite();	
	}
	
	@Test()
	@Parameters({"browser","title","uid","uidcriteria","comment"})
	public void mailLogintTest1(String bn,String title,String uid,String value,String com) throws Exception
	{
	    openbrowser(bn);
	    UidPage up=new UidPage(driver);
	    PswdPage pp=new PswdPage(driver);
	    GmailHomePage hp=new GmailHomePage(driver);
	    launchsite(pro.getProperty("url"));
	    validatetitle(title);
	   // UidPage up=new UidPage(driver);
	    //PswdPage pp=new PswdPage(driver);
	    up.enteruid(uid);
	    up.clickuidnext();
	    up.validateUserIdCriteria(value,com);
	    
	    
	}
	@Test()
	@Parameters({"browser","title","uid","uidcriteria","comment"})
	public void mailLogintTest2(String bn,String title,String uid,String value,String com) throws Exception
	{
	    openbrowser(bn);
	    UidPage up=new UidPage(driver);
	    PswdPage pp=new PswdPage(driver);
	    GmailHomePage hp=new GmailHomePage(driver);
	    launchsite(pro.getProperty("url"));
	    validatetitle(title);
	   // UidPage up=new UidPage(driver);
	    //PswdPage pp=new PswdPage(driver);
	    up.enteruid(uid);
	    up.clickuidnext();
	    up.validateUserIdCriteria(value,com);
	    
	    
	}
	
	@Test()
	@Parameters({"browser","title","uid","pwd","pwdcriteria","comment"})
	public void mailLogintTest3(String bn,String title,String uid,String pwd,String value,String com) throws Exception
	{
	    openbrowser(bn);
	    UidPage up=new UidPage(driver);
	    PswdPage pp=new PswdPage(driver);
	    GmailHomePage hp=new GmailHomePage(driver);
	    launchsite(pro.getProperty("url"));
	    validatetitle(title);
	   // UidPage up=new UidPage(driver);
	    //PswdPage pp=new PswdPage(driver);
	    up.enteruid(uid);
	    up.clickuidnext();
	    pp.enterpwd(pwd);
	    pp.clickpwdnext();
	    pp.validatePasswordCriteria(value,com);
	    
	    
	}
	@Test()
	@Parameters({"browser","title","uid","pwd","comment"})
	public void deleteUnreadMails(String bn,String title,String uid,String pwd,String com) throws Exception
	{
	    openbrowser(bn);
	    UidPage up=new UidPage(driver);
	    PswdPage pp=new PswdPage(driver);
	    GmailHomePage hp=new GmailHomePage(driver);
	    launchsite(pro.getProperty("url"));
	    validatetitle(title);
	   // UidPage up=new UidPage(driver);
	    //PswdPage pp=new PswdPage(driver);
	    up.enteruid(uid);
	    up.clickuidnext();
	    pp.enterpwd(pwd);
	    pp.clickpwdnext();
	    hp.searchMails();
	    hp.deletemails(com);
	    hp.signout();
	    
	    
	}

}
