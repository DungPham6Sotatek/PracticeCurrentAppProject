package automation.screenLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.common.CommonBase;
import automation.constants.CT_HomeScreen;
import io.appium.java_client.android.AndroidDriver;


public class HomeScreen extends CommonBase{
	private  AndroidDriver driver;
	public HomeScreen(AndroidDriver _driver) {
		this.driver = _driver;
	}
	
	public void AccessUserList() {
		clickToElement(By.xpath(CT_HomeScreen.USER_LIST_LINK));
		pause(2000);
	}
	public void AccessNotify() {
		clickToElement(By.xpath(CT_HomeScreen.NOTIFY_LINK));
		pause(2000);
	}
	public void LogOutSuccessfully() {
		clickToElement(By.xpath(CT_HomeScreen.LOGOUT_LINK));
		clickToElement(By.xpath(CT_HomeScreen.LOGOUT_BTN));
		pause(2000);
	}

}
