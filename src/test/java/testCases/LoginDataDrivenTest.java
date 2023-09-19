package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testCaseBase.BaseClass;
import utilities.DataProviders;

public class LoginDataDrivenTest extends BaseClass {
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void loginDataDrivenTest(String userId, String password, String result) {
		
		try {
		LoginPage lp = new LoginPage(driver);
		lp.setUserId(userId);
		lp.setPassword(password);
		lp.clickLogin();
		Thread.sleep(3000);
		
		HomePage hp = new HomePage(driver);
		boolean status = hp.isHomePageExists();
		
		if(result.equals("pass")) {
			if(status==true) {
				hp.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(result.equals("fail")) {
			if(status==true) {
				HomePage hp1 = new HomePage(driver);
				hp1.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		logger.info("LoginDatadrivenTest is completed");
		}
		catch (Exception e) {
			Assert.fail();
			e.getMessage();
		}
	}
	

}
