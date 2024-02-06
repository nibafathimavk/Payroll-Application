package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilites;

public class PaySlipPage {
	WebDriver driver;
	//GeneralUtilites gu = new GeneralUtilites();

	public PaySlipPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}
	@FindBy(xpath="//a[text()='Payslip']")
	WebElement paySlipMenu;
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//thead//tr//th")
	WebElement payslipTableHeader;
	
	public void paySlipMenuClick() {
		//gu.javaScriptExecutorFunction(paySlipMenu);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", paySlipMenu);
	}
	public void paySlipTableRead() {
		List<WebElement>tableHeader=driver.findElements(By.xpath("//table[@class='table table-striped table-bordered']//thead//tr//th"));
		for(int i=0;i<tableHeader.size();i++)
		{
			String header=tableHeader.get(i).getText();
			System.out.print(header+" ");
		}
		System.out.println();
		List<WebElement>tableRowsColumnsName=driver.findElements(By.xpath("//table[@class='table table-striped table-bordered']//tbody"));
		for(int j=0;j<tableRowsColumnsName.size();j++)
			{
			for(int k=0;k<tableRowsColumnsName.size();k++)
			{
				String rows=tableRowsColumnsName.get(j).getText();
				String columns=tableRowsColumnsName.get(k).getText();
				System.out.print(rows+" ");
				System.out.println(columns+" ");
				System.out.println();				
			}
			}

	}
}
