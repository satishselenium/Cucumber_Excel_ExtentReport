package driverfactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {
	public static WebDriver driver; 
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String testDataExcelFileName = "Data.xlsx";
	
	
	public void init (String Browser) {
		if (Browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.gecko.driver","/Users/Documents/geckodriver");
			System.setProperty("webdriver.chrome.driver",".\\WebDriver\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        
	        SessionId sessionid = ((ChromeDriver) driver).getSessionId();
	        System.out.println("Session ID fro driver in base test = "+sessionid);
	       
		}else {
			System.out.println(" we dont have other browser setup as of now");
		}
	}
	
	
	public void OpenURL (String URL) {
			//System.setProperty("webdriver.gecko.driver","/Users/Documents/geckodriver");
			 driver.get(URL);
		     driver.manage().window().maximize();
	}
	
	
}
