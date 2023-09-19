package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//marquee[@class='heading3']")
	WebElement message;
	
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logout;
	
	public void verifyLogin() {
		String expected_message = "Welcome To Manager's Page of Guru99 Bank";
		String actual_message = message.getText();
		Assert.assertEquals(actual_message, expected_message);
	}
	
	public boolean isHomePageExists() {
		try {
			return (message.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		logout.click();
	}

}
