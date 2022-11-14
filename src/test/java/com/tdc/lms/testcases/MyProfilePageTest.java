package com.tdc.lms.testcases;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tdc.ims.pages.PageObjects.LoginPageObject;
import com.tdc.ims.pages.PageObjects.ProfilePageObject;
import com.tdc.lms.base.BaseTests;
import com.tdc.lms.pages.LoginPage;
import com.tdc.lms.pages.MyProfilePage;

public class MyProfilePageTest extends BaseTests{
	MyProfilePage myProfile;
	LoginPage loginPage;
	
	
	@BeforeClass
	public void launchMyProfile() {	
		
		System.out.println("User is already logged in.................");
		loginPage = new LoginPageObject(driver.get()).getLoginPage();
		myProfile = new ProfilePageObject(driver.get()).getProfilePage();
		//loginPage.loginLink();
		
		//LoginPage.loginLink();
		/*
		 * try { LoginPage.loginLink();
		 * LoginPage.applicationLogin("gp2008@rediffmail.com","qwerty12345");
		 * LoginPage.closePopUp(); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
	}
	
	@Test(priority=1)
	public void goToMyCourses() throws InterruptedException {		
		myProfile.myCourses();
	}
	
	@Test(priority=2)
	public void goToBookmarkedArticles() throws InterruptedException {
		myProfile.bookmarkedArticles();
	}
	
	@Test(priority=3)
	public void goToBookmarkedBlogs() throws InterruptedException {
		myProfile.bookmarkedBlogs();
	}
	
	@Test(priority=4)
	public void goToMyProfile() throws InterruptedException {
		myProfile.ownProfile();
	}
	
	@Test(priority=5)
	public void goToAccount() throws InterruptedException {
		myProfile.ownAccount();
	}
	
	@Test(priority=6)
	public void goToMyCart() throws InterruptedException {
		myProfile.myCart();
	}
	
	@Test(priority=7, description = "Signing Out the user")
	public void signOut() throws InterruptedException, IOException {		
		//LoginPage LoginPage = new LoginPage(driver);
		loginPage.signOut();
	}
}
