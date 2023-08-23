package tests.basic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.usual_pages.MessagesPage.MessagesList;
import tests.supers.TestBase;
import util.GenUtils;


public class PageObjectCode extends TestBase {
	
	String timestamp, email, password, username, firstName, lastName, address, state, city, zipCode, mobileNumber;
	
	
	@Test
	public void test() {
		try {

			initParameter();
			
			WebDriver driver = app.getDriver();
			driver.get("https://www.automationexercise.com/");

			app.pages().homePage.ensurePageLoaded().clickLoginOrSignup().ensurePageLoaded().typeName(username)
					.typeSignupEmail(email).clickSignupBtn().ensurePageLoaded().typePassword(password)
					.typeFirstName(firstName).typeLastName(lastName).typeAddress1(address).typeState(state)
					.typeCity(city).typeZipCode(zipCode).typeMobileNumber(mobileNumber).clickCreateAccountButton()
					.verifyMessageText(MessagesList.ACCOUNT_CREATED).clickContinueWithRefresh().verifyLogoutLink()
					.clickDeleteAccountLink().verifyMessageText(MessagesList.ACCOUNT_DELETED).clickContinue()
					.verifySignupLoginLink();
			
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



