package tests.basic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import models.User;
import pages.usual_pages.MessagesPage.MessagesList;
import tests.supers.TestBase;
import util.GenUtils;

public class PageObjectCodeWithHelpers extends TestBase {
	String timestamp;
	User user;

	@Test
	public void test() {
		try {

			initParameter();

			WebDriver driver = app.getDriver();
			driver.get("https://www.automationexercise.com/");

			app.pages().homePage.ensurePageLoaded().clickLoginOrSignup().ensurePageLoaded().typeName(user.getUsername())
					.typeSignupEmail(user.getEmail()).clickSignupBtn().ensurePageLoaded();
					

			app.getLoginHelper().fillRegisterFormWithMandatoryFields(user)
					

					.verifyLogoutLink()
					.clickDeleteAccountLink().verifyMessageText(MessagesList.ACCOUNT_DELETED).clickContinue()
					.verifySignupLoginLink();

			endTestSuccess();
		} catch (Throwable t) {
			onTestFailure(t);
		}
	}

	private void initParameter() {
		timestamp = GenUtils.getCurrentTimestamp(GenUtils.TIME_FORMAT_ddMMyyHHmmSSS);
		String email = "randomEmail" + timestamp + "@gmail.com";
		String password = "123456";
		String username = "randomUesrname" + timestamp;
		String firstName = "micha";
		String lastName = "briskman";
		String address = "kajskdj 2123";
		String state = "Florida";
		String city = "Miami";
		String zipCode = "55555";
		String mobileNumber = "123";
		user = new User(username, firstName, lastName, password, email, address, state, city, zipCode, mobileNumber);
	}

}
