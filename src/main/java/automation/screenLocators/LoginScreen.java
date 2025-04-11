package automation.screenLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;
import automation.constants.CT_HomeScreen;
import automation.constants.CT_LoginScreen;
import automation.constants.CT_OnBoardScreen;
import automation.ultis.logs.Log;
import io.appium.java_client.android.AndroidDriver;

public class LoginScreen extends CommonBase{
	private AndroidDriver driver;
	public LoginScreen(AndroidDriver _driver) {
		this.driver = _driver;
	}
	
	public void LoginAsAdminSuccessfully() {
		Log.info("Click login btn");
		clickToElement(By.xpath(CT_OnBoardScreen.LOGIN_BTN));
		Log.info("Click username input");
		clickToElement(By.xpath(CT_LoginScreen.USERNAME_INPUT));
		Log.info("Enter username input");
		sendKey(By.xpath(CT_LoginScreen.USERNAME_INPUT), "admin@nexus.com");
		closeKeyBoard();
		Log.info("Click continue");
		clickToElement(By.xpath(CT_LoginScreen.CONTINUE_BTN));
		Log.info("Enter passcode input");
		clickToElement(By.xpath(CT_LoginScreen.PASSCODE_INPUT));
		sendKey(By.xpath(CT_LoginScreen.PASSCODE_INPUT), "123456");
		closeKeyBoard();
		Log.info("Click continue");
		clickToElement(By.xpath(CT_LoginScreen.CONTINUE_BTN));
		pause(5000);
	}
	public void AccessUserList() {
		clickToElementByTouchAction(By.xpath(CT_HomeScreen.USER_LIST_LINK));
		pause(2000);
	}
}
