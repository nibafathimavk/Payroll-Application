package testcasePkg;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotCapture;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
//base class is used to launch and exit  the url
public class BaseClass {
 WebDriver driver;  //driver created as an instance variable
 ScreenShotCapture sc;
 public static Properties pro;
 public static void testBasic() throws IOException {   //for using property file(config.properties) add testbasic() method before beforeMethod

		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\config1.properties");
		pro.load(fp);
	}
  @BeforeMethod(alwaysRun = true)
  @Parameters("Browser")
  public void beforeMethod(String browserName) throws IOException {
	  if(browserName.equals("Chrome")) {
		  testBasic();                 //and call the testBasic() here for loading property file.
	  System.setProperty(pro.getProperty("ChromeDriver"), System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chrome\\chromedriver.exe");
		 // WebDriverManager.chromedriver().setup(); works as per the chrome version without downloading driver again
		  driver = new ChromeDriver();
  }
	  else if(browserName.equals("Firefox")) {
		  testBasic();
		  WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
	  }
			driver.get(pro.getProperty("BaseURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
  }

  @AfterMethod(alwaysRun = true)
	public void afterMethode(ITestResult iTestResult) throws IOException {  //ITestResult is a listener class which check for the tc status and takes screenshot when it fails
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		//driver.quit();
	}

}
