package pages.usual_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import pages._pages_mngt.MainPageManager;
import pages.super_pages.MenusPage;

public class MessagesPage extends MenusPage {

	public enum MessagesList {
		ACCOUNT_CREATED{
			public String toString() {
				return "ACCOUNT CREATED!";
			}
		},
		ACCOUNT_DELETED {
			public String toString() {
				return "ACCOUNT DELETED!";
			}
		}
	}
	public MessagesPage(MainPageManager pages) {
		super(pages);
	}

	public MessagesPage ensurePageLoaded() {
		super.ensurePageLoaded();
		waitBig.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Continue"))));
		return this;
	}
	
	public MessagesPage verifyMessageText(MessagesList messageExpected) {
		log.info("Ensure that '" + messageExpected + "' message appears");
		String actualTextRegistration = driver.findElement(By.cssSelector(".title>b")).getText();
		Assert.assertTrue(actualTextRegistration.equals(messageExpected.toString()),
				"Expected value: '" + messageExpected + "', but actual is:'" + actualTextRegistration + "'");
		return this;
	}

	public HomePage clickContinueWithRefresh() {
		log.info("Click 'continue' button");
		su.clickJS(driver.findElement(By.xpath("//a[@data-qa='continue-button']")));
		driver.navigate().refresh();
		su.clickJS(driver.findElement(By.xpath("//a[@data-qa='continue-button']")));
		return pages.homePage.ensurePageLoaded();
	}

	public HomePage clickContinue() {
		log.info("Click 'continue' button");
		su.clickJS(driver.findElement(By.xpath("//a[@data-qa='continue-button']")));
		return pages.homePage.ensurePageLoaded();
	}
}
