package testCases;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testCaseBase.BaseClass;

public class LoginTest2 extends BaseClass {
	
	@Test(groups={"Master"})
	public void testLogin() {
		logger.debug("application logs...........");
		logger.info("**** starting Logintest ****");
		LoginPage lp = new LoginPage(driver);
		lp.setUserId(rb.getString("userId"));	// reading userId value from config.properties file
		logger.info("userId entered");
//		lp.setPassword(rb.getString("password"));	// reading password value from config.properties file
		logger.info("password entered");
		lp.clickLogin();
		logger.info("clicked on Login button");
		
		HomePage hp = new HomePage(driver);
		logger.info("Validating Login");
		hp.verifyLogin();
		hp.clickLogout();
		logger.info("LoginTest is completed");
	}
	
	

}
