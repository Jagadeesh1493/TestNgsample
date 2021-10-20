package com.baseClass;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Set;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {

	public static WebDriver driver;
	private static Select select;


	
	public static WebDriver getBrowser(String type) {
		
		if(type.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"//Driver//ChromeDriver.exe");
			driver=new ChromeDriver();
				
	}
		driver.manage().window().maximize();
	return driver;
	}
	
	
	//Get Url Method
	public static void getUrl(String Url) {
		driver.get(Url);
	}
	
	
	//Property class
	public static Properties p;
	public static void properties() throws Throwable {
		FileInputStream fis=new FileInputStream("C:\\Users\\kulas\\eclipse-workspace\\CucumberProjecct\\src\\main\\java\\properties\\Configuration.properties");
		p=new Properties();
		p.load(fis);
	}
	
	
	
	//Read data from Excel
	
	

//	public static String particularData_From_Excel(String path, int row_Index, int cell_Index) throws Throwable {
//
//		File f=new File(path);
//		FileInputStream fis=new FileInputStream(f);
//		Workbook w = new XSSFWorkbook(fis);
//		Sheet sheetAt = w.getSheetAt(0);
//		Row row = sheetAt.getRow(row_Index);
//		Cell cell = row.getCell(cell_Index);
//		CellType type = cell.getCellType();
//					
//			if (type.equals(CellType.STRING)) {
//				value = cell.getStringCellValue();
//			}
//			else if (type.equals(CellType.NUMERIC)) {
//				double numericCellValue = cell.getNumericCellValue();
//				value = Double.toString(numericCellValue);
//				
//			}		
//		return value;
//		
//	}
//	
	
	
	
	//Click Method
	public static void clickOnElement(WebElement element) {
		element.click();
	}
	
	public static void moveToElement(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	//NavigateTo method
	public static void navigateTo(String Url) {
		driver.navigate().to(Url);
	}
	
	//Navigate Back method
	public static void navigateBack() {
		driver.navigate().back();
	}
	
	//Navigate forward method
	public static void navigateForward() {
		driver.navigate().forward();
	}
			
	//Navigate refresh method
	public static void navigateRefresh() {
			driver.navigate().refresh();
	}
	
	//Get method
	public static void Get(String Url) {
		driver.get(Url);
	}
	
	//Alert method
	public static void alert(String type) {
		if (type.equalsIgnoreCase("simple")) {
			Alert simple=driver.switchTo().alert();
			simple.accept();
		}
		else if (type.equalsIgnoreCase("confirmAccept")) {
			Alert confirm=driver.switchTo().alert();
			confirm.accept();
		}
		else if (type.equalsIgnoreCase("confirmDismiss")) {
			Alert confirm=driver.switchTo().alert();
			confirm.dismiss();
		}
	
	}
	
	
	//Sleep
	public static void Sleep(int value) throws Throwable {
		Thread.sleep(value);

	}
	
	
	//Action DragandDrop
	public static void dragandDrop(WebElement src, WebElement dest) {
		Actions action=new Actions(driver);
		action.dragAndDrop(src, dest).perform();
	}
	
	//Action
	public static void action(WebElement element, String type) {
		Actions action=new Actions(driver);
		
		if (type.equalsIgnoreCase("single")) {
			action.click(element).perform();
		}
		else if (type.equalsIgnoreCase("contextclick")) {
			action.contextClick(element).perform();
		}
		else if (type.equalsIgnoreCase("doubleclick")) {
			action.doubleClick(element).perform();
		}
		else if (type.equalsIgnoreCase("movetoelement")) {
			action.moveToElement(element).perform();
		}
	}
	
	//Switch Frame method
	public static void switchframe(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	//Switch default Frame method
	public static void defaultframe() {
		driver.switchTo().defaultContent();
		}
	
	//Switch default Frame method			
	public static void parentframe() {
		driver.switchTo().parentFrame();
				}
		
	//ScreenShort method
	public static void screenshot(String filedir) throws Throwable {
		TakesScreenshot take=(TakesScreenshot) driver;
		File src=take.getScreenshotAs(OutputType.FILE);
		File dest=new File(filedir);
		FileUtils.copyFile(src, dest);
		}
		
	//Get attribute method
	public static void getattribute(WebElement element, String name) {
		String value=element.getAttribute(name);
		System.out.println(value);
	}
	
	//Send Keys method
	public static void inputvalueElement(WebElement webElement, String name) {
		webElement.sendKeys(name);
	}
	
	//Get Text method
	public static void getText(WebElement element) {
		String text=element.getText();
		System.out.println(text);
	}
	
	//Get Title
	public static void getTitle() {
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	//Dropdown method
	public static void dropdown(String type, WebElement element, String value) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		}
		else if (type.equalsIgnoreCase("visible text")) {
			s.selectByVisibleText(value);
		}
		else if (type.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		}
		
	}
	
	//IsMultiple
	public static boolean isMultiple(String xpath) {
		WebElement multiple=driver.findElement(By.xpath(xpath));
		select =new Select(multiple);
		return select.isMultiple();
	}
	
	//GetOption method
	public static List<WebElement> getOptions(String xpath) {
		WebElement option=driver.findElement(By.xpath(xpath));
		select =new Select(option);
		return select.getOptions();
	}
	
	//Get first selected Option method
		public static WebElement getFirstSelectedOption(String xpath) {
			WebElement option=driver.findElement(By.xpath(xpath));
			select =new Select(option);
			return select.getFirstSelectedOption();	
	}
		
	//Get all Selected Option
		public static List<WebElement> getAllSelectedOption(String xpath) {
			WebElement option=driver.findElement(By.xpath(xpath));
			select =new Select(option);
			return select.getAllSelectedOptions();	
	}
		
	//Deselect all
		public static void deselect(String xpath){
				WebElement multiple=driver.findElement(By.xpath(xpath));
				select =new Select(multiple);
				select.deselectAll();	
			}
	//Scroll Up
		public static void scrollUp() {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window scrollby", "0,-450");
		}
		
	//Scroll Down		
		public static void scrollDown() {
			JavascriptExecutor js=(JavascriptExecutor) driver;					
			js.executeScript("window scrollby", "0,450");
		}
		
	//Check box method
		public static void checkBox(WebElement element) {
			element.click();
		}
	
	//isEnabled method
		public static void iseEabled(WebElement element) {
			element.isEnabled();
				}	
		
	//isDisplayed method
		public static void isDisplayed(WebElement element) {
			element.isDisplayed();
				}	
		
	//window Handle
		public static void windowHandle() {
			String parent = driver.getWindowHandle();
			Set<String> child = driver.getWindowHandles();
			for(String id: child)
			{
				if (parent.equals(id)) {
					driver.switchTo().window(id);
				}
			}
		}
		
	//Get Current Url
		public static void GetCurrentUrl() {
			String Url=driver.getCurrentUrl();
			System.out.println(Url);
		}
		
	//Quit method
	public static void quit() {
		driver.quit();
	}
	
	//Close method
	public static void Close() {
		driver.close();
	}
		
	
}
