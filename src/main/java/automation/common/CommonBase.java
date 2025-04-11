package automation.common;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class CommonBase {
	public static AndroidDriver driver;
	
	public AndroidDriver openApp() {
		DesiredCapabilities ca = new DesiredCapabilities();
		ca.setCapability("appium:appPackage", "com.example.babylon_nexus");
		ca.setCapability("appium:appActivity", "com.example.babylon_nexus.MainActivity");
		ca.setCapability("appium:udid", "2b2935095b3f7ece");
		ca.setCapability("appium:automationName", "UiAutomator2");
		ca.setCapability("platformName", "Android");
		ca.setCapability("appium:deviceName", "Android Device");
		ca.setCapability("appium:noReset", "true");
		
		try {
			URL url = new URL("http://127.0.0.1:4723/");
			driver = new AndroidDriver(url, ca);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	public WebElement getElementVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
	
	public List<WebElement> getAllElementVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return driver.findElements(locator);
	}
	
	public WebElement getElementPresentInDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}
	public void clickToElement(By locator) {
		WebElement element =getElementVisibility(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	
	public void clickToElementByJSExecutor(By locator) {
		WebElement element = getElementPresentInDOM(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	public void clickToElementByTouchAction(By locator) {
	    WebElement element = driver.findElement(locator);
	    TouchAction touch = new TouchAction(driver);
	    touch
	        .tap(ElementOption.element(element))
	        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))) // Optional wait after tap
	        .perform();
	}
	public void sendKey(By locator, String key) {
		WebElement element =getElementVisibility(locator);
		element.clear();
		element.sendKeys(key);
	}
	public void pause(long milisecond) {
		try {
			Thread.sleep(milisecond);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void closeKeyBoard() {
		driver.hideKeyboard();
	}
	public boolean isElementDisplay(By locator) {
		WebElement element = getElementVisibility(locator);
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e1) {
			// TODO: handle exception
			return false;
		} catch (TimeoutException e2) {
			return false;
		}
	}
	public static AndroidDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
	public void verifyText(By locator, String result) {
		WebElement element =  getElementVisibility(locator);
		assertEquals(element.getText(), result);
	}
	public boolean verifyIsDisplay(By locator) {
		WebElement element =  getElementVisibility(locator);
		if(element.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
}
