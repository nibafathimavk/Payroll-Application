package testcasePkg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import elementRepository.ClientsPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;

public class HomePageTest extends BaseClass {
	HomePage hp;
	LoginPage lp;
	ClientsPage cp;
	ExcelUtilities eu=new ExcelUtilities();
	@Test(groups={"Smoketest","Regressiontest"})  //this tc will works when the corresponding suite file is called
	public void verifyOnClickClientsAndCreateClients() throws IOException {
		lp=new LoginPage(driver);
		  hp=new HomePage(driver);
		  cp=new ClientsPage(driver);
		  lp.sendUserName(eu.readStringData(1,0));
		  lp.sendPassword(eu.readStringData(1,1));
		  lp.loginButtonClick();
		  hp.clientsClick();
		  String expected="CLIENTS";
		  String actual=cp.ClientPageNavCheck();
		  System.out.println(actual);
		  Assert.assertEquals(actual, expected,Constants.hp_verifyOnClickClientsAndCreateClients_ErrorMessage);
	}


 }
