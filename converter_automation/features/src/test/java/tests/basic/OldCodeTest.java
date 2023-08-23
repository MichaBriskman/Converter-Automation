package tests.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import tests.supers.TestBase;
import util.GenUtils;

public class OldCodeTest extends TestBase {
	
	String timestamp, email, password, username, firstName, lastName, address, state, city, zipCode, mobileNumber;

	final static String REGISTRATION_MSG = "ENTER ACCOUNT INFORMATION";
	final static String ACCOUNT_CREATED_MSG = "ACCOUNT CREATED!";
	final static String ACCOUNT_DELETED_MSG = "ACCOUNT DELETED!";
	@Test
	public void test() {
		try {

			initParameter();
			
			WebDriver driver = app.getDriver();
			driver.get("https://www.automationexercise.com/");

			log.info("Ensure the Main site page was opened...");
			driver.findElement(By.className("features_items"));

			log.info("Click 'signup / Login' link");
			driver.findElement(By.linkText("Signup / Login")).click();
			
			GenUtils.sleepMillis(500);

			log.info("Ensure the login/signup page was opened...");
			driver.findElement(By.className("signup-form"));

			log.info("Type into 'Name' textbox value: " + username + "");
			driver.findElement(By.name("name")).sendKeys(username);

			log.info("Type into 'email' textbox value: " + email + "");
			driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys(email);

			log.info("Click 'signup' button");
			driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

			GenUtils.sleepMillis(500);

			log.info("Ensure the signup page was opened...");
			String actualTextRegistration = driver.findElement(By.cssSelector(".login-form h2 b")).getText();
			Assert.assertTrue(actualTextRegistration.equals(REGISTRATION_MSG),
					"Expected value: '" + REGISTRATION_MSG + "', but actual is:'" + actualTextRegistration + "'");
			
			log.info("Type into 'password' textbox value: " + password + "");
			driver.findElement(By.id("password")).sendKeys(password);

			log.info("Type into 'first name' textbox value: " + firstName + "");
			driver.findElement(By.id("first_name")).sendKeys(firstName);

			log.info("Type into 'last name' textbox value: " + lastName + "");
			driver.findElement(By.id("last_name")).sendKeys(lastName);

			log.info("Type into 'address' textbox value: " + address + "");
			driver.findElement(By.id("address1")).sendKeys(address);

			log.info("Type into 'state' textbox value: " + state + "");
			driver.findElement(By.id("state")).sendKeys(state);
			
			log.info("Type into 'city' textbox value: " + city + "");
			driver.findElement(By.id("city")).sendKeys(city);

			log.info("Type into 'zipCode' textbox value: " + zipCode + "");
			driver.findElement(By.id("zipcode")).sendKeys(zipCode);
			
			log.info("Type into 'mobile number' textbox value: " + mobileNumber + "");
			driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);

			GenUtils.sleepMillis(2000);

			log.info("Click 'create account' button");
			su.clickJS(driver.findElement(By.xpath("//button[@data-qa='create-account']")));

			GenUtils.sleepMillis(500);

			log.info("Ensure the 'account created' page was opened...");
			String actualTextAccountCreated = driver.findElement(By.cssSelector(".col-sm-9 h2 b")).getText();
			Assert.assertTrue(actualTextAccountCreated.equals(ACCOUNT_CREATED_MSG),
					"Expected value: '" + ACCOUNT_CREATED_MSG + "', but actual is:' " + actualTextAccountCreated + "'");

			log.info("Click 'continue' button");
			su.clickJS(driver.findElement(By.xpath("//a[@data-qa='continue-button']")));
			driver.navigate().refresh();
			su.clickJS(driver.findElement(By.xpath("//a[@data-qa='continue-button']")));

			log.info("Ensure the Main site page was opened...");
			driver.findElement(By.className("features_items"));
			// -------------------------------------
			log.info("step 16: Ensure the 'logout' link appears above");
			driver.findElement(By.xpath("//a[@href='/logout']"));

			log.info("Click 'delete account' button");
			driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

			GenUtils.sleepMillis(500);

			log.info("Ensure the 'account deleted' page was opened...");
			String actualTextAccountDeleted = driver.findElement(By.cssSelector(".col-sm-9 h2 b")).getText();
			Assert.assertTrue(actualTextAccountDeleted.equals(ACCOUNT_DELETED_MSG),
					"Expected value: '" + ACCOUNT_DELETED_MSG + "', but actual is:'" + actualTextAccountDeleted + "'");

			log.info("Click 'continue' button");
			driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

			GenUtils.sleepMillis(500);

			log.info("Ensure the Main site page was opened...");
			driver.findElement(By.className("features_items"));

			log.info("step 19: Ensure the 'login' link appears above");
			driver.findElement(By.xpath("//a[@href='/login']"));

			GenUtils.sleepMillis(500);
			endTestSuccess();

		} catch (Throwable t) {
			onTestFailure(t);
		}
	}
	
	private void initParameter() {
		timestamp = GenUtils.getCurrentTimestamp(GenUtils.TIME_FORMAT_ddMMyyHHmmSSS);
		email = "randomEmail" + timestamp + "@gmail.com";
		password = "123456";
		username = "randomUesrname" + timestamp;
		firstName = "micha";
		lastName = "briskman";
		address = "kajskdj 2123";
		state = "Florida";
		city = "Miami";
		zipCode = "55555";
		mobileNumber = "123";
	}
}
