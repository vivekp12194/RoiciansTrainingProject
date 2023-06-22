package testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseHRMClass;
import pomlogin.PomLogin;
import testData.Excelsheet;

public class LoginTest extends BaseHRMClass {
	PomLogin login;
	public LoginTest() {
		super();
	}
	@BeforeMethod
	public void callmethod() throws InterruptedException {
		initiate();
		screenshots("Login");
		login = new PomLogin();
	}
	@DataProvider
	public Object[][] details(){
		Object result[][] = Excelsheet.readdata("Sheet1");
		return result; 
	}
	
	@Test (priority=1)
	public void title() {
		String Actual = login.verifytitle();
		Assert.assertEquals(Actual, "OrangeHRM");
		System.out.println(Actual);
	}
	@Test (priority=2,dataProvider="details")
	public void login(String name,String password) {
		login.typeusername(name);
		login.typepassword(password);
		//login.clickbtn();
	}
	@AfterMethod
	public void closebrowser() {
		driver.close();
	}
}
