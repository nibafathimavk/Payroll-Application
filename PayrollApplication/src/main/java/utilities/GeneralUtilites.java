package utilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilites {
	WebDriver driver;
	public String getElementText(WebElement element)
	{
		return element.getText();
	}
public void selectDropdownUsingIndex(WebElement element,int index) {
	Select object=new Select(element);
	object.selectByIndex(index);
}
public void selectDropdownUsingValue(WebElement element,String value) {
	Select object=new Select(element);
	object.selectByValue(value);
}
public void selectDropdownUsingVisibleText(WebElement element,String value) {
	Select object=new Select(element);
	object.selectByVisibleText(value);
}
public void sendKeyFunction(WebElement element,String inputValue)
{
	element.sendKeys(inputValue);
}
public String generateCurrentDateAndTime() {     //for generating current date and time/
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
	return formatter.format(date);
}
public int randon(int limit) {
	Random random = new Random();
	// int limit = 1000;
	int randomNumber = random.nextInt(limit);
	return randomNumber;
}
//public void actionObjectForClick() {
//	Actions actionObj = new Actions(driver);
//	actionObj.click().perform();
//}
//public void javaScriptExecutorFunction(WebElement element)
//{
//	JavascriptExecutor executor = (JavascriptExecutor)driver;
//	executor.executeScript("arguments[0].click();", element);
//}

}
