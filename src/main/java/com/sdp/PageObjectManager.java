package com.sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pom.BookHotel;
import com.pom.Bookconfirmation;
import com.pom.SearchPage;
import com.pom.SelectHotel;
import com.pom.Sign_In;

public class PageObjectManager {
	
	public WebDriver driver;
	private Sign_In sp;
	private SearchPage sr;
	private SelectHotel sh;
	private BookHotel bh;
	private Bookconfirmation bc;
	
	public PageObjectManager(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}


	public Sign_In getInstanceSp() {
		sp=new Sign_In(driver);
		return sp;
	}
	
	public SearchPage getInstanceSr() {
		sr=new SearchPage(driver);
		return sr;
	}

	public SelectHotel getInstanceSh() {
		sh=new SelectHotel(driver);
		return sh;
	}

	public BookHotel getInstanceBh() {
		bh=new BookHotel(driver);
		return bh;
	}
	
	public Bookconfirmation getInstanceBc() {
		bc=new Bookconfirmation(driver);
		return bc;
	}


	
	
}
