package testcasePkg;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.ClientsPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;
import utilities.WaitUtilities;

public class ClientsPageTest extends BaseClass {
	ClientsPage cp;
	HomePage hp;
	LoginPage lp;
	WaitUtilities wu = new WaitUtilities();
	ExcelUtilities eu = new ExcelUtilities();

	@Test
	public void verifyCreateAnsSearchClients() throws IOException, InterruptedException {
		cp = new ClientsPage(driver);
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.sendUserName(eu.readStringData(1, 0));
		lp.sendPassword(eu.readStringData(1, 1));
		lp.loginButtonClick();
		hp.clientsClick();
	    hp.createClientsClick();
		cp.branchDropDown();
		cp.invoiceOrderDropDown();
		cp.divisionDropDown();
		cp.sendInvoiceContact();
		cp.invoiceDeliveryMethodDropDown();
		cp.sendClientName();
		cp.sendPhone();
		cp.masterDoccumentDropDown();
		cp.sendClientAddress();
		cp.sendSettilementDays();
		cp.sendEmail();
		cp.vatRateDropDown();
		cp.sendPostcode();
		cp.sendCompanyRegistration();
		cp.createClientCheckBox();
		cp.saveButtonClick();
		//cp.fluentWaitforClientsLeftClick();
		Thread.sleep(1000);
		cp.clientsLeftLinkClick();
		cp.sendSearchClients();
		String expected="CLIENTS";
		  String actual=cp.ClientPageNavCheck();
		  System.out.println(actual);
		  Assert.assertEquals(actual, expected,Constants.hp_verifyOnClickClientsAndCreateClients_ErrorMessage);
	}

}
