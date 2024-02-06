package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;

public class TimeSheetPage {
	WebDriver driver;
	GeneralUtilites gu = new GeneralUtilites();

	public TimeSheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	// Alerts
	@FindBy(xpath = "//button[@value='playslip']")
	WebElement generatePlaySlip;
	@FindBy(xpath = "//button[@value='invoice']")
	WebElement generateInvoice;
	@FindBy(xpath = "//div[@class='col-sm-6 page-title']//h1")
	WebElement timeSheetHeading;
	// Timesheet creation
	@FindBy(xpath = "//a[text()='Create Timesheet']")
	WebElement createTimesheet;
	@FindBy(id = "file-logo")
	WebElement browseFile;
	@FindBy(xpath = "//span[text()='Upload']")
	WebElement browseFileUpload;

	@FindBy(id = "trigger")
	WebElement browseFileView;

	public void generatePlaySlipButtonClick() {
		generatePlaySlip.click();
	}

	public void generatePlaySlipButtonClickAlert() throws InterruptedException {
		String generatePlaySlipAlertText = driver.switchTo().alert().getText();
		System.out.println(generatePlaySlipAlertText);
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
	}

	public void generateInvoiceButtonClick() {
		generateInvoice.click();
	}

	public void generateInvoiceButtonClickAlert() throws InterruptedException {
		String generateInvoiceFirstAlertText = driver.switchTo().alert().getText();
		System.out.println(generateInvoiceFirstAlertText);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(7000);
		String generateInvoiceSecondAlertText = driver.switchTo().alert().getText();
		System.out.println(generateInvoiceSecondAlertText);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	public String timeSheetPageCheck() {
		return gu.getElementText(timeSheetHeading);
	}

	public void createTimeSheetClick() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", createTimesheet);
		Thread.sleep(2000);
	}

	public void timeSheetFileUpload() throws AWTException, InterruptedException {
		// JavascriptExecutor executor=(JavascriptExecutor)driver;
		// executor.executeScript("arguments[0].click();", browseFile);
		// browseFile.sendKeys("//C:\\Users\\ASUS\\eclipse-workspace\\PayrollApplication\\src\\main\\resources\\uploads\\testing");
		Actions obj = new Actions(driver);
		obj.moveToElement(browseFile).click().perform();

		StringSelection s1 = new StringSelection(
				"C:\\Users\\ASUS\\eclipse-workspace\\PayrollApplication\\src\\main\\resources\\uploads\\testing");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);
		Robot robot = new Robot(); // second way
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.delay(500);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		browseFileUpload.click();
        
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", browseFileView);
	}
}
