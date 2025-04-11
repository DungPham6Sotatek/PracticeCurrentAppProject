package automation.screenLocators;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.common.CommonBase;
import automation.constants.CT_HomeScreen;
import automation.constants.CT_UserListScreen;
import io.appium.java_client.android.AndroidDriver;

public class UserListScreen extends CommonBase{
	private AndroidDriver driver;
	public UserListScreen(AndroidDriver _driver) {
		this.driver = _driver;
	}
	
	public void Filter_ChoseOccupation(String nameOccupation) {
		clickToElement(By.xpath(CT_UserListScreen.FILTER_BTN));
		clickToElement(By.xpath(CT_UserListScreen.OCCUPATION_DROPDOWN));
		String xpath = String.format(CT_UserListScreen.OCCUPATION_OPTION, nameOccupation);
		clickToElement(By.xpath(xpath));
		pause(2000);
	}
	public void Filter_ChoseStatus(String nameStataus) {
		clickToElement(By.xpath(CT_UserListScreen.FILTER_BTN));
		clickToElement(By.xpath(CT_UserListScreen.STATUS_DROPDOWN));
		String xpath = String.format(CT_UserListScreen.STATUS_OPTION, nameStataus);
		clickToElement(By.xpath(xpath));
		pause(2000);
	}
	public void ShowResults() {
		clickToElement(By.xpath(CT_UserListScreen.SHOW_RESULTS));
		pause(2000);
	}
	public void verifyOnlyThisOccupationShow(String nameStataus) {
		String xpath = String.format(CT_UserListScreen.OCCUPATION_ALL, nameStataus);
		List<WebElement> allElement = getAllElementVisibility(By.xpath(xpath));
		for (WebElement element : allElement) {
			String content =  element.getAttribute("content-desc");
			if (content.contains(nameStataus)) {
				System.out.println("All " + nameStataus + ":\n"  
									+ content);
				System.out.println("-----------------------");
			}else {
				System.out.println("All non-" + nameStataus + ":\n" 
									+ content);
			}
			
			assertTrue(content.contains(nameStataus));
		}
		System.out.println(allElement.size());
		pause(2000);
		
	}
	public void verifyOnlyThisStatusShow(String nameOccupation) {
		String xpath = String.format(CT_UserListScreen.OCCUPATION_ALL, nameOccupation);
		List<WebElement> allElement = getAllElementVisibility(By.xpath(xpath));
		for (WebElement element : allElement) {
			String content =  element.getAttribute("content-desc");
			if (content.contains(nameOccupation)) {
				System.out.println("All " + nameOccupation + ":\n"  
									+ content);
				System.out.println("-----------------------");
			}else {
				System.out.println("All non-" + nameOccupation + ":\n" 
									+ content);
			}
			assertTrue(content.contains(nameOccupation));
		}
		pause(2000);
		
	}
}
