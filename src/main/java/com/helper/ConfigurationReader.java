package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

	public static Properties p;
	
	public ConfigurationReader() throws Throwable {
		File f=new File(".\\src\\main\\java\\properties\\Configuration.properties");
		FileInputStream fis =new FileInputStream(f);
		p =new Properties();
		p.load(fis);	
	}
	
	public String getBrowser() {
		String Browser=p.getProperty("browser");
		return Browser;
	}
	public String getUrl() {
		String Url=p.getProperty("url");
		return Url;
	}
	
	public String Username() {
		String Username=p.getProperty("db_Username");
		return Username;
	}
	
	public String Password() {
		String Password=p.getProperty("db_Password");
		return Password;
	}
	
	public String Firstname() {
		String fname = p.getProperty("fname");
		return fname;
	}
	
	public String Lastname() {
		String lname = p.getProperty("lname");
		return lname;
	}
	
	public String Address() {
		String address = p.getProperty("address");
		return address;
	}
	
	public String CreditCardNumber() {
		String C_card = p.getProperty("C_card");
		return C_card;
	}
	
	public String CreditCardType() {
		String C_type = p.getProperty("C_type");
		return C_type;
	}
	
	public String ExpiryDate() {
		String expiry_date = p.getProperty("expiry_date");
		return expiry_date;
	}
	
	public String ExpiryYear() {
		String expiry_yr = p.getProperty("expiry_yr");
		return expiry_yr;
	}
	
	public String Cvv() {
		String cvv = p.getProperty("cvv");
		return cvv;
	}
	
}
