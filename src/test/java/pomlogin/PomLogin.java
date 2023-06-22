package pomlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {

	@FindBy(xpath="//input[@name='username']") WebElement uname;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button") WebElement loginbtn;
	@FindBy(linkText = "Forgot your password?") WebElement forgetpassowrd;

	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
	public void typeusername(String name) {
		uname.sendKeys(name);
	}
	public void typepassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickbtn() {
		loginbtn.click();
	}
	public String verifytitle() {
		return driver.getTitle();
	}
}
