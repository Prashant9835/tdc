package com.tdc.ims.pages.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tdc.lms.pages.LoginPage;
import com.tdc.lms.pages.MyProfilePage;

public class ProfilePageObject {
	private MyProfilePage profilePage = null;
	
	public ProfilePageObject(WebDriver driver) {

		profilePage = PageFactory.initElements(driver, MyProfilePage.class);
	}

	public MyProfilePage getProfilePage() {
		return this.profilePage;
	}
	
	/*
	 * public MyProfilePage getMenuPage() { return this.profilePage; }
	 * 
	 * public MyProfilePage getUserMenuPage() { return this.profilePage; }
	 */
}
