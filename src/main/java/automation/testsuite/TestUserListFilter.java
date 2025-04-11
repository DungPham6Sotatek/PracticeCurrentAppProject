package automation.testsuite;

import org.testng.annotations.*;


import automation.common.CommonBase;
import automation.screenLocators.HomeScreen;
import automation.screenLocators.LoginScreen;
import automation.screenLocators.UserListScreen;
import automation.ultis.logs.Log;

public class TestUserListFilter extends CommonBase{
	@BeforeMethod
	public void openUserList() {
		driver = openApp();
		LoginScreen login = new LoginScreen(driver);
		Log.info("Login as Admin");
		login.LoginAsAdminSuccessfully();
		Log.info("Access user list");
		HomeScreen home = new HomeScreen(driver);	
		home.AccessUserList();
	}
	
	@Test (priority = 1)
	public void filterOccupation_Builder() {	
		UserListScreen userList = new UserListScreen(driver);
		Log.info("Access filter choose Builder");
		userList.Filter_ChoseOccupation("Builder");
		Log.info("Click show results");
		userList.ShowResults();
		pause(10000);
		Log.info("Verify all builder shown");
		userList.verifyOnlyThisOccupationShow("Builder");
	}
	@Test (priority = 2)
	public void filterOccupation_Electrician() {
		UserListScreen userList = new UserListScreen(driver);
		Log.info("Access filter choose Electrician");
		userList.Filter_ChoseOccupation("Electrician");
		Log.info("Click show results");
		userList.ShowResults();
		pause(10000);
		Log.info("Verify all Electrician shown");
		userList.verifyOnlyThisOccupationShow("Electrician");
	}
	@Test (priority = 3)
	public void filterOccupation_Construction() {
		UserListScreen userList = new UserListScreen(driver);
		Log.info("Access filter choose Construction");
		userList.Filter_ChoseOccupation("Construction");
		Log.info("Click show results");
		userList.ShowResults();
		pause(10000);
		Log.info("Verify all Construction shown");
		userList.verifyOnlyThisOccupationShow("Construction");
	}
	@Test (priority = 4)
	public void filterOccupation_Contractor() {
		UserListScreen userList = new UserListScreen(driver);
		Log.info("Access filter choose Contractor");
		userList.Filter_ChoseOccupation("Contractor");
		Log.info("Click show results");
		userList.ShowResults();
		pause(10000);
		Log.info("Verify all Contractor shown");
		userList.verifyOnlyThisOccupationShow("Contractor");
	}
	@Test (priority = 5)
	public void filterOccupation_Banker() {
		UserListScreen userList = new UserListScreen(driver);
		Log.info("Access filter choose Banker");
		userList.Filter_ChoseOccupation("Banker");
		Log.info("Click show results");
		userList.ShowResults();
		pause(10000);
		Log.info("Verify all Banker shown");
		userList.verifyOnlyThisOccupationShow("Banker");
	}
	@Test (priority = 6)
	public void filterStatus_Signup() {
		UserListScreen userList = new UserListScreen(driver);
		Log.info("Access filter choose status - Signup");
		userList.Filter_ChoseStatus("Signup");
		Log.info("Click show results");
		userList.ShowResults();
		pause(10000);
		Log.info("Verify all signup-user shown");
		userList.verifyOnlyThisStatusShow("Signup");
	}
	@Test (priority = 7)
	public void filterStatus_Registered() {
		UserListScreen userList = new UserListScreen(driver);
		Log.info("Access filter choose status - Registered");
		userList.Filter_ChoseStatus("Registered");
		Log.info("Click show results");
		userList.ShowResults();
		pause(10000);
		Log.info("Verify all Registered-user shown");
		userList.verifyOnlyThisStatusShow("Registered");
	}
	@Test (priority = 8)
	public void filterStatus_Deleted() {
		UserListScreen userList = new UserListScreen(driver);
		Log.info("Access filter choose status - Deleted");
		userList.Filter_ChoseStatus("Deleted");
		Log.info("Click show results");
		userList.ShowResults();
		pause(10000);
		Log.info("Verify all Deleted-user shown");
		userList.verifyOnlyThisStatusShow("Deleted");
	}
	
	@AfterMethod
	public void tearDown() {
		HomeScreen home = new HomeScreen(driver);
		home.LogOutSuccessfully();
		driver.terminateApp("com.example.babylon_nexus");  
	}
}
