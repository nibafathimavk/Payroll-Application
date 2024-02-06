package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;
import utilities.WaitUtilities;

public class ClientsPage {
	WebDriver driver;
	String clientNameValue;
	
	GeneralUtilites gu=new GeneralUtilites();
	WaitUtilities wu=new WaitUtilities();
	public ClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath="//select[@id='client-branch_id']")
	WebElement branch;
	@FindBy(id="client-invoice_order")
	WebElement invoiceOrder;
	@FindBy(id="client-division_id")
	WebElement division;
	@FindBy(id="client-invoice_contact")
	WebElement invoiceContact;
	@FindBy(id="client-invoice_delivery_method")
	WebElement invoiceDeliveryMethod;
	@FindBy(xpath="//input[@id='client-client_name']")
	WebElement clientName;
	@FindBy(id="client-phone")
	WebElement phone;
	@FindBy(id="client-master_document")
	WebElement masterDoccument;
	@FindBy(id="client-client_address")
	WebElement clientAddress;
	@FindBy(id="client-settilement_days")
	WebElement settilementDays;
	@FindBy(id="client-email")
	WebElement email;
	@FindBy(id="client-vat_rate")
	WebElement vatRate;
	@FindBy(id="client-postcode")
	WebElement postcode;
	@FindBy(id="client-company_reg")
	WebElement companyRegistration;
	@FindBy(id="client-require_po")
	WebElement requirePO;
	@FindBy(id="client-direct_client")
	WebElement directClientCheckbox;
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement saveButton;
	@FindBy(id="clientsearch-client_name")
	WebElement clientSearch;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//div[@class='col-sm-6 page-title']//h1")
	WebElement clientsHeading;
	@FindBy(xpath="//div[@class='col-lg-2 col-sm-4 left-menu no-padding']//ul//li//a[text()='Clients']")
	WebElement clientsLeftLink;
	
	public void branchDropDown() {
		//branch.click();
			gu.selectDropdownUsingValue(branch,"1");
		}
		public void invoiceOrderDropDown() {
			gu.selectDropdownUsingValue(invoiceOrder,"Single timesheet per client");
		}
		public void divisionDropDown() {
			gu.selectDropdownUsingValue(division,"1");
		}
		public void sendInvoiceContact() {
		gu.sendKeyFunction(invoiceContact, "ABC123");
	}
		public void invoiceDeliveryMethodDropDown() {
			gu.selectDropdownUsingVisibleText(invoiceDeliveryMethod,"Electronic");
		}
		public void sendClientName() {                                               //explanation to be written
			String clientNameValue="Niba Fathima"+gu.generateCurrentDateAndTime();
			this.clientNameValue=clientNameValue;
			gu.sendKeyFunction(clientName, clientNameValue);
		}
		public String sendRandomlyCreatedClientName() {
			return clientNameValue;
		}
		public void sendPhone() {
			gu.sendKeyFunction(phone, "1234567890");
		}
		public void masterDoccumentDropDown() {
			gu.selectDropdownUsingVisibleText(masterDoccument,"PDF");
		}
		public void sendClientAddress() {
			gu.sendKeyFunction(clientAddress, "Asdfgh12345");
		}
		public void sendSettilementDays() {
			gu.sendKeyFunction(settilementDays, "30");
		}
		public void sendEmail() {
			gu.sendKeyFunction(email, "abc.xyz@gmail.com");	
		}
		public void vatRateDropDown() {
			gu.selectDropdownUsingValue(vatRate,"VAT 15.00%");
		}
		public void sendPostcode() {
			gu.sendKeyFunction(postcode, "332423");
		}
		
		public void sendCompanyRegistration() {
			gu.sendKeyFunction(companyRegistration, "Company12345");
		}
		public void createClientCheckBox() {
			requirePO.click();
			directClientCheckbox.click();
//			ukPublicSectorClient.click();
//			subjectToPayee.click();
		}
		public void saveButtonClick() {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", saveButton);
			//saveButton.click();	
		}
		public void fluentWaitforClientsLeftClick() {
		wu.fluentWaitforClick(driver,clientsLeftLink);
	}
		public void clientsLeftLinkClick() {
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", clientsLeftLink);
		}
	public void sendSearchClients()
	{
		gu.sendKeyFunction(clientSearch, "Niba Fathima");	
		searchButton.click();
	}
	
	public String getTextOfClientTable(int row, int column)   //dynamic table read
{
		String tableElementPath="//table[@class='table table-striped table-bordered']//tbody//tr["+row+"]//td["+column+"]";
        WebElement element=driver.findElement(By.xpath(tableElementPath));
        return element.getText();
        }
	public String ClientPageNavCheck()
	{
	return 	gu.getElementText(clientsHeading);
	}
}
