package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//program for adding external report for emailing ,testNg report(test output) is not mailable.
//Create extend report utility and call this utility in the test suite file inside listeners tag.
public class ExtenetReport implements ITestListener {  
	ExtentSparkReporter sparkReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_hhmmss");
		String strDate = formatter.format(date);

		File reportPath = new File(System.getProperty("user.dir") + "//ExtentReport");

		if (!reportPath.exists()) {
			reportPath.mkdir();
		}
		sparkReporter = new ExtentSparkReporter(             //extent report calling
				System.getProperty("user.dir") + "//ExtentReport//" + "ExtentReport_" + strDate + ".html");  //setting path
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);        //attaching the report

		reports.setSystemInfo("Project", "Parcel Web");
		reports.setSystemInfo("PC Name", "Niba's PC");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Test Done By", "Niba fathima");		
		sparkReporter.config().setDocumentTitle("Payroll Application Report ");
		sparkReporter.config().setReportName("Report Summary");
		sparkReporter.config().setTheme(Theme.STANDARD);
	}

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {      //if test is success then create this report  
		test = reports.createTest(result.getName());   //getName is our testcase name
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {        //if test is failed then create this report  
		test = reports.createTest(result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));
	}

	public void onTestSkipped(ITestResult result) {       // //if test is skipped then create this report 
		test = reports.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {  //when onStart is called this function works
		configureReport();
		// Delete the test output folder before the suite starts
        File testOutputFolder = new File("target/testoutput");
        if (testOutputFolder.exists()) {
            deleteFolder(testOutputFolder);
        }
	}
	private void deleteFolder(File folder) {     //code to delete test output automatically when this is called
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }

	public void onFinish(ITestContext context) {
		reports.flush();   //to generate the report, without this report will not be generated
	}

}
