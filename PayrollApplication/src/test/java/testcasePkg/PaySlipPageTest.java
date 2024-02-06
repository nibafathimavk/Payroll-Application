package testcasePkg;

import java.io.IOException;

import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.PaySlipPage;
import utilities.ExcelUtilities;

public class PaySlipPageTest extends BaseClass {
	PaySlipPage pp;
	HomePage hp;
	LoginPage lp;
	ExcelUtilities eu = new ExcelUtilities();
  @Test
  public void verifyOnPaySlipTableContentRead() throws IOException {
	    pp=new PaySlipPage(driver);
	    lp = new LoginPage(driver);
	  	hp = new HomePage(driver);
		lp.sendUserName(eu.readStringData(1, 0));
		lp.sendPassword(eu.readStringData(1, 1));
		lp.loginButtonClick();
		pp.paySlipMenuClick();
		pp.paySlipTableRead();
  }
}
