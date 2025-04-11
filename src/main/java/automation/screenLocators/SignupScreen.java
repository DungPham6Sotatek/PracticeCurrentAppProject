package automation.screenLocators;

import org.openqa.selenium.By;
import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import automation.common.CommonBase;
import automation.constants.CT_OnBoardScreen;
import automation.constants.CT_SignUpScreen;
import io.appium.java_client.android.AndroidDriver;

public class SignupScreen extends CommonBase{
	private AndroidDriver driver;
	public SignupScreen (AndroidDriver _driver) {
		this.driver = _driver;
	}
	
	public void SignUpFullName(String fullName) {
		clickToElement(By.xpath(CT_OnBoardScreen.SIGNUP_BTN));
		clickToElement(By.xpath(CT_SignUpScreen.FULLNAME_INPUT));	
		sendKey(By.xpath(CT_SignUpScreen.FULLNAME_INPUT), fullName);
		closeKeyBoard();
		clickToElement(By.xpath(CT_SignUpScreen.CONTINUE_BTN));
		pause(2000);
	}
	
	public void SignUpEmail(String email) {
		clickToElement(By.xpath(CT_SignUpScreen.EMAIL_INPUT));
		sendKey(By.xpath(CT_SignUpScreen.EMAIL_INPUT), email);
		closeKeyBoard();
		clickToElement(By.xpath(CT_SignUpScreen.CONTINUE_BTN));
		pause(2000);
	}
	
	public void SignUpElectricianOccupation() {
		clickToElement(By.xpath(CT_SignUpScreen.ELECTRICIAN_RBTN));
		clickToElement(By.xpath(CT_SignUpScreen.SIGNUP_BTN));
		pause(2000);
	}
	public void ClickLoginAfterSigningUP() {
		clickToElement(By.xpath(CT_SignUpScreen.LOGIN_BTN));
		pause(2000);
	}
	
}
