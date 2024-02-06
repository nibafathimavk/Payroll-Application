package elementRepository;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;

	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import utilities.GeneralUtilites;
import utilities.WaitUtilities;

	public class HomePage {
		WebDriver driver;
		GeneralUtilites gu=new GeneralUtilites();
		WaitUtilities wu=new WaitUtilities();
		public HomePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);// with page factory
		}
		@FindBy(xpath="//div[@class='col-sm-6 page-title']//h1")
		WebElement payrollApplication;
		//clients elements
		@FindBy(xpath="//a[text()='Clients']")
		WebElement clientsMenu;
		@FindBy(xpath="//a[text()='Create Client']")
		WebElement createClients;
		@FindBy(xpath="//a[text()='Workers']")
		WebElement workersMenu;
		@FindBy(xpath="//a[text()='TimeSheet']")
		WebElement timeSheetMenu;
		

		public String homePageLoginCheck()
		{
		return 	gu.getElementText(payrollApplication);
		}
		public void clientsClick() {
			//clients.click();
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", clientsMenu);
		}

		public void createClientsClick() {
			createClients.click();	
		}
		public void workersClick() {
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", workersMenu);
		}
		public void timeSheetMenuClick() {
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", timeSheetMenu);
		}
		
		
	}

