package com.TestNGProjecct;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.baseClass.Base_Class;
import com.helper.FileReaderManager;
import com.sdp.PageObjectManager;

public class TestCase1 extends Base_Class{
	
	public static WebDriver driver= getBrowser("chrome");
	public static PageObjectManager pom=new PageObjectManager(driver);
	ExtentReports report;
	ExtentTest test;
	ExtentSparkReporter reporter;
	
	@BeforeTest
	private void configuration() {
		reporter=new ExtentSparkReporter(".//Rep//report//index.html");
		report=new ExtentReports();
		report.attachReporter(reporter); 
		test =report.createTest("config");
	}
	
	@Test(priority=-1)
	private void Url() throws Throwable {
		String Url= FileReaderManager.getInstance().getInstanceCR().getUrl();
		getUrl(Url);
		test =report.createTest("Url");
	}
	
	@Test(priority=0)
	private void Sign_In() throws Throwable {
		GetCurrentUrl();
		String username=FileReaderManager.getInstance().getInstanceCR().Username();
		inputvalueElement(pom.getInstanceSp().getUsername(), username);
		String password=FileReaderManager.getInstance().getInstanceCR().Password();
		inputvalueElement(pom.getInstanceSp().getPassword(), password);
		clickOnElement(pom.getInstanceSp().getLogin());
		test =report.createTest("Sign_In");
	}
	
	@Test(priority=2)
	private void searchRoom() {
		dropdown("value", pom.getInstanceSr().getLocation(), "Los Angeles");
		dropdown("value", pom.getInstanceSr().getHotels(), "Hotel Sunshine");
		dropdown("value", pom.getInstanceSr().getRoom_type(), "Super Deluxe");
		dropdown("value", pom.getInstanceSr().getRoom_nos(), "2");
		pom.getInstanceSr().getDatepick_in().clear();
		inputvalueElement(pom.getInstanceSr().getDatepick_in(), "28/09/2021");
		pom.getInstanceSr().getDatepick_out().clear();
		inputvalueElement(pom.getInstanceSr().getDatepick_out(), "02/10/2021");
		dropdown("value", pom.getInstanceSr().getAdult_room(), "2");
		dropdown("value", pom.getInstanceSr().getChild_room(), "1");
		clickOnElement(pom.getInstanceSr().getSubmit());	
		test =report.createTest("SearchRoom");
	}
	
	@Test(priority=3)
	private void hotel() {
		clickOnElement(pom.getInstanceSh().getRadiobutton_0());
		clickOnElement(pom.getInstanceSh().getSubmit());
		test =report.createTest("Hotel");
	}
	
	@Test(priority=4)
	private void bookHotel() throws Throwable {
		String firstname = FileReaderManager.getInstance().getInstanceCR().Firstname();
		inputvalueElement(pom.getInstanceBh().getFirst_name(), firstname);
		String lastname = FileReaderManager.getInstance().getInstanceCR().Lastname();
		inputvalueElement(pom.getInstanceBh().getLast_name(), lastname);
		String address = FileReaderManager.getInstance().getInstanceCR().Address();
		inputvalueElement(pom.getInstanceBh().getAddress(), address);
		String CrediCardNumber = FileReaderManager.getInstance().getInstanceCR().CreditCardNumber();
		inputvalueElement(pom.getInstanceBh().getCc_num(), CrediCardNumber);
		String creditCardType = FileReaderManager.getInstance().getInstanceCR().CreditCardType();
		dropdown("value", pom.getInstanceBh().getCc_type(), creditCardType);
		String expiryDate = FileReaderManager.getInstance().getInstanceCR().ExpiryDate();
		dropdown("value", pom.getInstanceBh().getCc_exp_month(), expiryDate);
		String expiryyear = FileReaderManager.getInstance().getInstanceCR().ExpiryYear();
		dropdown("value", pom.getInstanceBh().getCc_exp_year(), expiryyear);
		String Cvv = FileReaderManager.getInstance().getInstanceCR().Cvv();
		inputvalueElement(pom.getInstanceBh().getCc_cvv(), Cvv);
		clickOnElement(pom.getInstanceBh().getBook_now());	
		Sleep(5000);
		test =report.createTest("BookHotel");
	}
	
	@Test(priority=5)
	public void logout() throws Throwable{
		
		moveToElement(pom.getInstanceBc().getLitinerary());
		screenshot("C:\\Users\\kulas\\eclipse-workspace\\CucumberProjecct\\Screenshot\\001.png");
		clickOnElement(pom.getInstanceBc().getLitinerary());
		screenshot("C:\\Users\\kulas\\eclipse-workspace\\CucumberProjecct\\Screenshot\\002.png");
		clickOnElement(pom.getInstanceBc().getLogut());
		quit();
	}
  
}
