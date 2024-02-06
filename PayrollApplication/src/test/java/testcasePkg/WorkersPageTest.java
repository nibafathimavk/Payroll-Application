package testcasePkg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.ClientsPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.WorkersPage;
import utilities.ExcelUtilities;

public class WorkersPageTest extends BaseClass{
	LoginPage lp;
	HomePage hp;
	ClientsPage cp;
	WorkersPage wp;
	ExcelUtilities eu=new ExcelUtilities();
	@Test
  public void verifyOnWorkerSearchAndUpdate() throws InterruptedException, IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  cp=new ClientsPage(driver);
	  wp=new WorkersPage(driver);
	  lp.sendUserName(eu.readStringData(1,0));
	  lp.sendPassword(eu.readStringData(1, 1));
	  lp.loginButtonClick();
	  hp.workersClick();
	  wp.createWorkersClick();
	  wp.workersTitleDropDown();
	  wp.workersGenderDropDown();
	  wp.workersBranchDropDown();
	  wp.workersFirstNameSend();
	  wp.workersDivisionDropDown();
	  wp.workersLastNameSend();
	  wp.workersDateOfBirthSend();
	  wp.wokersEmployementTypeDropDown();
	  wp.wokersAddressSend();
	  wp.workersPayslipMethodDropDown();
	  wp.workersPhoneSend();
	  wp.workersNiNumberSend();
	  wp.workersEmailSend();
	  wp.workersPostcode();
	  wp.workersNextButtonClick();
	  wp.fluentWaitAfterNextButtonClick();
	  wp.workersAccNameSend();
	  wp.workersAccNumberSend();
	  wp.workersSortCodeSend();
	  wp.workersSaveButtonClick();
	  Thread.sleep(1000);
	  wp.workersLeftLinkClick();
	  wp.workersNameSearchSend();
	  wp.workersSearchButtonClick();
	  Thread.sleep(1000);
	  wp.workersUpdateIconClick();
	  wp.workersFirstNameUpdate();
	  wp.workersNextButtonClick();
	  wp.fluentWaitAfterNextButtonClick();
	  wp.workersSaveButtonClick();
 	  String expected="Jennifer John030224061605";
	  String actual=wp.workersCreateUpdateSuccessCheck();
	  System.out.println(actual);
	  Assert.assertEquals(actual, expected,Constants.hp_verifyOnWorkerSearchAndUpdate_ErrorMessage);
	  //after update search for the name name not found--doubt
  }
 
}
