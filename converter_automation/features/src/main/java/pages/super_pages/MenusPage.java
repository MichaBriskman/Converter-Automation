package pages.super_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.usual_pages.LoginOrSignupPage;
import pages.usual_pages.MessagesPage;

public class MenusPage extends AnyPage{

	public MenusPage(MainPageManager pages) {
		super(pages);
	}

	
	public MenusPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		return this;
	}
	
	public LoginOrSignupPage clickLoginOrSignup() {
		log.info("Click 'signup / Login' link");
		driver.findElement(By.linkText("Signup / Login")).click();
		return pages.loginOrSignupPage.ensurePageLoaded();
	}
	
	public MessagesPage clickDeleteAccountLink() {
		log.info("Click 'delete account' button");
		driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
		return pages.messagesPage.ensurePageLoaded();
	}

	public MenusPage verifySignupLoginLink() {
		log.info("step 19: Ensure the 'login' link appears above");
		driver.findElement(By.xpath("//a[@href='/login']"));
		return this;
	}

	public MenusPage verifyLogoutLink() {
		log.info("step 16: Ensure the 'logout' link appears above");
		driver.findElement(By.xpath("//a[@href='/logout']"));
		return this;
	}

}
