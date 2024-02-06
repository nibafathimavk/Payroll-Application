package testcasePkg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;

public class LoginPageTest extends BaseClass {
	LoginPage lp; // creating object of login page java class for calling its datas
	HomePage hp;
	ExcelUtilities eu=new ExcelUtilities();
	@DataProvider(name = "login-data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { { "Admin", "Admin" },{ "Niba","Niba123"}};
	}

	@Test(dataProvider = "login-data-provider")
	public void verifyLoginWithIncorrectCredentials(String name, String pass) {
		lp = new LoginPage(driver);
		lp.sendUserName(name);
		lp.sendPassword(pass);
		lp.loginButtonClick();
		String expected="Incorrect username or password.";
		  String actual=lp.wrongCredentialAlert();
		  System.out.println(actual);
		  Assert.assertEquals(actual, expected, "::Alert Message Not As Expected");
	}
	
	 @Test(priority=1)
	 public void verifyLoginWithCorrectCredentials() throws IOException {
		  lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  lp.sendUserName(eu.readStringData(1,0));
		  lp.sendPassword(eu.readStringData(1,1));
		  lp.loginButtonClick();
		  String expected="PAYROLL APPLICATION";
			 String actual=hp.homePageLoginCheck();
			// System.out.println(actual);
			 Assert.assertEquals(actual, expected,Constants.lp_verifyLoginWithCorrectCredentials_ErrorMessage);//error messages are giving using constant files
			 
	 }


}
