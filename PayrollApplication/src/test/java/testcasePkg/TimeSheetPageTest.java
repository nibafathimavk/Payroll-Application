package testcasePkg;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.ClientsPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.TimeSheetPage;
import utilities.ExcelUtilities;
import utilities.GeneralUtilites;

public class TimeSheetPageTest extends BaseClass{
	TimeSheetPage tsp;
	ClientsPage cp;
	HomePage hp;
	LoginPage lp;
	ExcelUtilities eu = new ExcelUtilities();

 @Test
 public void verifyTimeSheetPageAlertsCheck() throws IOException, InterruptedException {
	    tsp=new TimeSheetPage(driver);
		cp = new ClientsPage(driver);
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.sendUserName(eu.readStringData(1, 0));
		lp.sendPassword(eu.readStringData(1, 1));
		lp.loginButtonClick();
		hp.timeSheetMenuClick();
		tsp.generatePlaySlipButtonClick();
		tsp.generatePlaySlipButtonClickAlert();
		tsp.generateInvoiceButtonClick();
		tsp.generateInvoiceButtonClickAlert();
		String expected="TIMESHEETS";
		String actual=tsp.timeSheetPageCheck();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, Constants.tsp_verifyTimeSheetPageAlertsCheck_ErrorMessage);
}
 @Test
 public void verifyTimeSheetPageCreateTimeSheets() throws InterruptedException, IOException, AWTException {
	  tsp=new TimeSheetPage(driver);
			cp = new ClientsPage(driver);
			lp = new LoginPage(driver);
			hp = new HomePage(driver);
			lp.sendUserName(eu.readStringData(1, 0));
			lp.sendPassword(eu.readStringData(1, 1));
			lp.loginButtonClick();
			hp.timeSheetMenuClick();
			tsp.createTimeSheetClick();
			tsp.timeSheetFileUpload();
			
 }
}
