package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constants.CT_LoginScreen;
import automation.constants.CT_OnBoardScreen;
import automation.constants.CT_SignUpScreen;
import automation.screenLocators.SignupScreen;
import automation.ultis.helpers.CaptureHelper;
import automation.ultis.logs.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;

public class TestSignUp extends CommonBase{
	private AndroidDriver driver;
	private String baseName = "Jimmy";
	private String baseEmail = "dung.pham6+";
	private String baseDomain = "@sotatek.com";
	private int baseNumber = 7020;
	private String stringNumber;
	
	private String email;
	
	
	@BeforeMethod
	public void initApp() {
		driver = openApp();
		baseNumber++;
		stringNumber = String.valueOf(baseNumber);
		email = baseEmail + stringNumber + baseDomain; 
	}
	
	@Test (priority = 1)
	public void signUp_emtyFullName() {
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Leave empty Full Name");
		signup.SignUpFullName("");
		Log.info("Empty full name error message is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.EMPTY_EERROR));
		pause(2000);
	}
	@Test (priority = 2)
	public void signUp_emtyFullNameBySpace() {
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Leave empty Full Name");
		signup.SignUpFullName("     ");
		Log.info("Empty full name error message is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.EMPTY_EERROR));
		pause(2000);
	}


	@Test (priority = 3)
	public void signUpSuccessfully() {
		System.out.println(email);
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Enter Full Name");
		signup.SignUpFullName(baseName);
		Log.info("Enter Email");
		signup.SignUpEmail(email);
		Log.info("Choose electrician occupation");
		signup.SignUpElectricianOccupation();
		Log.info("Successfully created account screen is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.SUCCESSFULLY_CREATE_ACCCOUNT));
		pause(2000);
	}
	@Test (priority = 4)
	public void signUpSuccessfullySpecialCharacterFullName_1() {
		System.out.println(email);
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Enter Full Name");
		signup.SignUpFullName("José Álvarez");
		Log.info("Enter Email");
		signup.SignUpEmail(email);
		Log.info("Choose electrician occupation");
		signup.SignUpElectricianOccupation();
		Log.info("Successfully created account screen is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.SUCCESSFULLY_CREATE_ACCCOUNT));
		pause(2000);
	}
	@Test (priority = 5)
	public void signUpSuccessfullySpecialCharacterFullName_2() {
		System.out.println(email);
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Enter Full Name");
		signup.SignUpFullName("Mary-Jane");
		Log.info("Enter Email");
		signup.SignUpEmail(email);
		Log.info("Choose electrician occupation");
		signup.SignUpElectricianOccupation();
		Log.info("Successfully created account screen is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.SUCCESSFULLY_CREATE_ACCCOUNT));
		pause(2000);
	}
	@Test (priority = 6)
	public void signUp_emtyEmail() {
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Enter Full Name");
		signup.SignUpFullName(baseName);
		Log.info("Leave empt Email");
		signup.SignUpEmail("");
		Log.info("Empty email error message is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.EMPTY_EERROR));
		pause(2000);
	}
	@Test (priority = 7)
	public void signUp_emtyEmailBySpace() {
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Enter Full Name");
		signup.SignUpFullName(baseName);
		Log.info("Enter Email");
		signup.SignUpEmail("");
		Log.info("Empty email error message is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.EMPTY_EERROR));
		pause(2000);
	}
	@Test (priority = 8)
	public void signUp_InvalidEmail_1() {
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Enter Full Name");
		signup.SignUpFullName(baseName);
		Log.info("Enter Email Missing \"@\"");
		signup.SignUpEmail("dungpham.gmail.com");
		Log.info("Invalid email error message is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.INVALID_EMAIL_ERROR));
		pause(2000);
	}
	@Test (priority = 9)
	public void signUp_InvalidEmail_2() {
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Enter Full Name");
		signup.SignUpFullName(baseName);
		Log.info("Enter Email Missing domain");
		signup.SignUpEmail("dung.pham@");
		Log.info("Invalid email error message is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.INVALID_EMAIL_ERROR));
		pause(2000);
	}
	@Test (priority = 10)
	public void signUp_InvalidEmail_3() {
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Enter Full Name");
		signup.SignUpFullName(baseName);
		Log.info("Enter Email Missing extension");
		signup.SignUpEmail("dung.pham@gmail");
		Log.info("Invalid email error message is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.INVALID_EMAIL_ERROR));
		pause(2000);
	}
	@Test (priority = 11)
	public void signUp_InvalidEmail_4() {
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Enter Full Name");
		signup.SignUpFullName(baseName);
		Log.info("Enter Email Multiple \"@@\"");
		signup.SignUpEmail("dung.pham@@gmail.com");
		Log.info("Invalid email error message is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.INVALID_EMAIL_ERROR));
		pause(2000);
	}
	@Test (priority = 12)
	public void signUp_InvalidEmail_5() {
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Enter Full Name");
		signup.SignUpFullName(baseName);
		Log.info("Enter Email Special characters");
		signup.SignUpEmail("dung.pham!@gmail.com");
		Log.info("Invalid email error message is display");
		verifyIsDisplay(By.xpath(CT_SignUpScreen.INVALID_EMAIL_ERROR));
		pause(2000);
	}
	@Test (priority = 13)
	public void loginAfterSigningUp() {
		System.out.println(email);
		SignupScreen signup = new SignupScreen(driver);
		Log.info("Enter Full Name");
		signup.SignUpFullName(baseName);
		Log.info("Enter Email");
		signup.SignUpEmail(email);
		Log.info("Choose electrician occupation");
		signup.SignUpElectricianOccupation();
		Log.info("Click Login btn on successfull created account screen");
		signup.ClickLoginAfterSigningUP();
		Log.info("New user on On Board screen is display");
		verifyIsDisplay(By.xpath(CT_LoginScreen.USERNAME_LABEL));
		pause(2000);
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		baseNumber = Integer.parseInt(stringNumber);	
		System.out.println(baseNumber);
//		if(ITestResult.FAILURE == result.getStatus() || ITestResult.SKIP == result.getStatus()) {
//			CaptureHelper capture = new CaptureHelper();
//			capture.takeScreenShot(driver, result.getName());
//		}
		driver.terminateApp("com.example.babylon_nexus");   
	}
	
}
