package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class RegisterPage extends MenusPage{

	public RegisterPage(MainPageManager pages) {
		super(pages);
	}
	
	public RegisterPage ensurePageLoaded() {
		super.ensurePageLoaded();
		log.info("Ensure the register page was opened...");
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='create-account']"))));
		return this;
	}

	public RegisterPage typePassword(String password) {
		log.info("Type into 'password' textbox value: " + password + "");
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}

	public RegisterPage typeFirstName(String firstName) {
		log.info("Type into 'first name' textbox value: " + firstName + "");
		driver.findElement(By.id("first_name")).sendKeys(firstName);
		return this;
	}

	public RegisterPage typeLastName(String lastName) {
		log.info("Type into 'last name' textbox value: " + lastName + "");
		driver.findElement(By.id("last_name")).sendKeys(lastName);
		return this;
	}

	public RegisterPage typeAddress1(String address1) {
		log.info("Type into 'address' textbox value: " + address1 + "");
		driver.findElement(By.id("address1")).sendKeys(address1);
		return this;
	}

	public RegisterPage typeState(String state) {
		log.info("Type into 'state' textbox value: " + state + "");
		driver.findElement(By.id("state")).sendKeys(state);
		return this;
	}

	public RegisterPage typeCity(String city) {
		log.info("Type into 'city' textbox value: " + city + "");
		driver.findElement(By.id("city")).sendKeys(city);
		return this;
	}

	public RegisterPage typeZipCode(String zipCode) {
		log.info("Type into 'zipCode' textbox value: " + zipCode + "");
		driver.findElement(By.id("zipcode")).sendKeys(zipCode);
		return this;
	}

	public RegisterPage typeMobileNumber(String mobileNumber) {
		log.info("Type into 'mobile number' textbox value: " + mobileNumber + "");
		driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);
		return this;
	}

	public MessagesPage clickCreateAccountButton() {
		log.info("Click 'create account' button");
		su.clickJS(driver.findElement(By.xpath("//button[@data-qa='create-account']")));
		return pages.messagesPage.ensurePageLoaded();
	}
}
