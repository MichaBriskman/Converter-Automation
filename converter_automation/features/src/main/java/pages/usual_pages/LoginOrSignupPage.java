package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class LoginOrSignupPage extends MenusPage {

	public LoginOrSignupPage(MainPageManager pages) {
		super(pages);
	}

	public LoginOrSignupPage ensurePageLoaded() {
		super.ensurePageLoaded();
		log.info("Ensure the login/signup page was opened...");
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("signup-form"))));
		return this;
	}
	
	public LoginOrSignupPage typeName(String name) {
		log.info("Type into 'Name' textbox value: " + name + "");
		driver.findElement(By.name("name")).sendKeys(name);
		return this;
	}

	public LoginOrSignupPage typeSignupEmail(String email) {
		log.info("Type into 'email' textbox value: " + email + "");
		driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
		return this;
	}

	public RegisterPage clickSignupBtn() {
		log.info("Click 'signup' button");
		driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
		return pages.registerPage.ensurePageLoaded();
	}
}
