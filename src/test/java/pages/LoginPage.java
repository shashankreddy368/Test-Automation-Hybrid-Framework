package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(name="uid")
	WebElement UserId;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="btnLogin")
	WebElement LoginBtn;
	
	
	
	public void setUserId(String userid) {
		UserId.sendKeys(userid);
	}
	
	public void setPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		LoginBtn.click();
	}
	

}
