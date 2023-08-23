package applogic;

import models.User;
import pages.usual_pages.HomePage;
import pages.usual_pages.MessagesPage.MessagesList;

public class LoginHelper1 extends DriverBasedHelper {

	public LoginHelper1(ApplicationManager1 manager) {
		super(manager);
	}

	public HomePage fillRegisterFormWithMandatoryFields(User user) {
		return pages.registerPage
				.typePassword(user.getPassword())
				.typeFirstName(user.getFirstName())
				.typeLastName(user.getLastName())
				.typeAddress1(user.getAddress1())
				.typeState(user.getState())
				.typeCity(user.getCity())
				.typeZipCode(user.getZipCode())
				.typeMobileNumber(user.getMobileNumber()).clickCreateAccountButton()
				.verifyMessageText(MessagesList.ACCOUNT_CREATED)
				.clickContinueWithRefresh();
	}
}
