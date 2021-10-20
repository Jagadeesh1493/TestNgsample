package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bookconfirmation {

	WebDriver driver;
	
	public Bookconfirmation(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="logout")
	private WebElement logout;

	public WebElement getLogut() {
		return logout;
	}
	
	@FindBy(id="my_itinerary")
	private WebElement litinerary;

	public WebElement getLitinerary() {
		return litinerary;
	}
}
