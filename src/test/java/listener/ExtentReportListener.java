package listener;



	import java.io.File;
	import java.io.IOException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Date;

import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;

import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

import driverfactory.BaseTest;

	public class ExtentReportListener extends BaseTest{

		//public static final String scenarioName = null;
		public static ExtentHtmlReporter report = null;
		public static String scenarioName = null;
		public static String Feature_Name = null;
		public static String Feature_Name_old = "Satish";
		
		//public static ExtentReports extent = null;
		//public static ExtentTest test = null;

		public static ExtentReports setUp() {
			String reportLocation = "C:/Report/Extent_Report.html";
			report = new ExtentHtmlReporter(reportLocation);		
			report.config().setDocumentTitle("Automation Test Report");
			report.config().setReportName("Automation Test Report");
			report.config().setTheme(Theme.STANDARD);		
			System.out.println("Extent Report location initialized . . .");
			report.start();
			
			extent = new ExtentReports();
			extent.attachReporter(report);		
			extent.setSystemInfo("Application", "Change it to your application");
			extent.setSystemInfo("Operating System", System.getProperty("os.name"));
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			System.out.println("System Info. set in Extent Report");		
			return extent;
		}

		public static void testStepHandle(String teststatus,WebDriver driver,ExtentTest extenttest,Throwable throwable) {
			switch (teststatus) {
			case "FAIL":		
				extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));			
				extenttest.error(throwable.fillInStackTrace());
		        

				try {
					extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
				} catch (IOException e) {
					e.printStackTrace();
				}
				driver.quit();
				
				//extenttest.createNode("new test", "new scenario");
				
			break;
			
			case "PASS":			
				extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
				break;
				
			default:
				break;
			}	
			
		}
		
		public static void testStepHandle(String teststatus,ExtentTest extenttest,Throwable throwable) {
			switch (teststatus) {
			case "FAIL":		
				extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));			
				extenttest.error(throwable.fillInStackTrace());
				
				
					try {
					extenttest.addScreenCaptureFromPath(captureScreenShot(driver));
					} catch (IOException e) {
					e.printStackTrace();
					}
					driver.quit();
			break;
			
			case "PASS":			
				extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
				break;
				
			default:
				break;
			}	
			
		}
		public static String captureScreenShot(WebDriver driver) throws IOException {
			TakesScreenshot screen = (TakesScreenshot) driver;
			File src = screen.getScreenshotAs(OutputType.FILE);
			String dest = "C:\\Cucumber screenshot\\" + getcurrentdateandtime() + ".png";
			File target = new File(dest);
			FileUtils.copyFile(src, target);
			return dest;
		}
		
		private static String getcurrentdateandtime() {
			String str = null;
			try {
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
				Date date = new Date();
				str = dateFormat.format(date);
				str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
			} catch (Exception e) {
			}
			return str;
		}
	}
