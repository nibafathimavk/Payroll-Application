package elementRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;
import utilities.WaitUtilities;

public class WorkersPage {
	WebDriver driver;
	String workersLastNameValue;
	GeneralUtilites gu=new GeneralUtilites();
	WaitUtilities wu=new WaitUtilities();
	public WorkersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	
	@FindBy(xpath="//a[text()='Create Worker']")
	WebElement createWorkers;
	@FindBy(id="worker-title")
	WebElement workersTitle;
	@FindBy(id="worker-gender")
	WebElement workersGender;
	@FindBy(id="worker-branch_id")
	WebElement workersBranch;
	@FindBy(id="worker-first_name")
	WebElement workersFirstName;
	@FindBy(id="worker-last_name")
	WebElement workersLastName;
	@FindBy(id="worker-division_id")
	WebElement workersDivision;
	@FindBy(id="worker-dob")
	WebElement workersDOB;
	@FindBy(id="worker-employment_type")
	WebElement workersEmploymentType;
	@FindBy(id="worker-address1")
	WebElement workersAddress;
	@FindBy(id="worker-payslip_method")
	WebElement workersPayslipMethod;
	@FindBy(id="worker-phone")
	WebElement workersPhone;
	@FindBy(id="worker-ni_number")
	WebElement workersNiNumber;
	@FindBy(id="worker-email")
	WebElement workersEmail;
	@FindBy(id="worker-postcode")
	WebElement workersPostcode;
   @FindBy(xpath="//button[text()='Next']")
   WebElement workersNextButton;
   @FindBy(id="worker-ac_name")
	WebElement workersAccName;
	@FindBy(id="worker-ac_no")
	WebElement workersAccNumber;
	@FindBy(id="worker-sort_code")
	WebElement workersSortCode;
	@FindBy(xpath="//button[text()='Save']")
	WebElement workersSaveButton;
	@FindBy(xpath="//div[@class='col-lg-2 col-sm-4 left-menu no-padding']//ul//li//a[text()='Workers']")
	WebElement workersLeftLink;
	@FindBy(id="workersearch-first_name")
	WebElement workerSearchWithName;
	@FindBy(xpath="//button[text()='Search']")
	WebElement workersSearchButoton;
	@FindBy(xpath="//a[@aria-label='Update']//span[@class='glyphicon glyphicon-pencil']")
	WebElement workersUpdateIcon;
	@FindBy(xpath="//div[@class='col-sm-6 page-title']//h1")
	WebElement workersCreateUpdateCheck;
	
	public void createWorkersClick() {
		createWorkers.click();	
	}
	public void workersTitleDropDown() {
			gu.selectDropdownUsingValue(workersTitle,"Ms");
		}
	public void workersGenderDropDown() {
		gu.selectDropdownUsingVisibleText(workersGender,"Female");
	}
	public void workersBranchDropDown() {
		gu.selectDropdownUsingValue(workersBranch,"1");
	}
	public void workersFirstNameSend() {
		gu.sendKeyFunction(workersFirstName, "Charlie");
		System.out.println("Name before update is ~Charlie~ ");
	}
	public void workersDivisionDropDown() {
		gu.selectDropdownUsingVisibleText(workersDivision, "NewAlpha");
	}
	public void workersLastNameSend() {
		String workersLastNameValue="John"+gu.generateCurrentDateAndTime();
		this.workersLastNameValue=workersLastNameValue;
		gu.sendKeyFunction(workersLastName, workersLastNameValue);
	}
	public String sendRandomlyCreatedWorkersFirstName() {
		return workersLastNameValue;
	}
	public void workersDateOfBirthSend() {
		gu.sendKeyFunction(workersDOB, "01-02-2024");
	}
	public void wokersEmployementTypeDropDown() {
		gu.selectDropdownUsingValue(workersEmploymentType, "contractor");
	}

	public void wokersAddressSend() {
		gu.sendKeyFunction(workersAddress, "Abcstreet,Bldng121,California");
	}
	public void workersPayslipMethodDropDown() {
		gu.selectDropdownUsingVisibleText(workersPayslipMethod, "Electronic");
	}
	public void workersPhoneSend() {
		gu.sendKeyFunction(workersPhone, "1234567890");
	}
	public void workersNiNumberSend() {
		gu.sendKeyFunction(workersNiNumber, "1111");
	}
	public void workersEmailSend() {
		gu.sendKeyFunction(workersEmail, "abc.xyz.com");
	}
	public void workersPostcode() {
		gu.sendKeyFunction(workersPostcode, "234234");
	}
	public void workersNextButtonClick() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", workersNextButton);
	}
	public void fluentWaitAfterNextButtonClick() {
		wu.fluentWait(driver,workersAccName,"id","worker-ac_name");
	}
	public void workersAccNameSend() {
		gu.sendKeyFunction(workersAccName, "Charlie John");
}
	public void workersAccNumberSend() {
		gu.sendKeyFunction(workersAccNumber, "0987654321");
}
	public void workersSortCodeSend() {
		gu.sendKeyFunction(workersSortCode, "2020");
}
	public void workersSaveButtonClick() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", workersSaveButton);
	}
	
	public void workersLeftLinkClick() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", workersLeftLink);
	}
	public void workersNameSearchSend() {
		gu.sendKeyFunction(workerSearchWithName, "Charlie");
	}
	public void workersSearchButtonClick() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", workersSearchButoton);
	}
	public void workersUpdateIconClick() {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", workersUpdateIcon);
	}
	public void workersFirstNameUpdate() {
	    	workersFirstName.clear();
			gu.sendKeyFunction(workersFirstName, "Chaplin");
			System.out.println("Name after update is ~Chaplin~ ");
	}
public String workersCreateUpdateSuccessCheck() {
	return 	gu.getElementText(workersCreateUpdateCheck);
}
}
