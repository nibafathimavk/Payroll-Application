package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;

import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	GeneralUtilites gu=new GeneralUtilites();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(id = "loginform-username") // declaring web element with page factory
	WebElement userNameField;
	@FindBy(id = "loginform-password")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Login']")
	WebElement loginButton;
	@FindBy(xpath = "//p[text()='Incorrect username or password.']")
	WebElement wrongCredentialAlertMsg;
	// By username=By.id("loginform-username"); //declaring web element without page factory
	
	public void sendUserName(String username) {
		userNameField.sendKeys(username);
	}
	public void sendPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void loginButtonClick() {
		loginButton.click();
	}
	public String wrongCredentialAlert() {
		//String alertMessage = wrongCredentialAlertMsg.getText();    //basic way
		//return alertMessage;
		return gu.getElementText(wrongCredentialAlertMsg);    //using utility class
		
	}
}
