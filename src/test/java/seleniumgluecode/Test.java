package seleniumgluecode;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import listener.ExtentReportListener;
import page.LoginPage;
import utility.ExcelHandler;

public class Test extends ExtentReportListener {  //public class Test extends BaseTest
	//PropertiesFileReader obj= new PropertiesFileReader();
	//public static ExtentReports extent;
	//TestHooks TH = new TestHooks();
	public Map<String,String> data=new HashMap<String,String>();

	@Given("CollectDataFromExcel refer {string}")
	public void collectdatafromexcel_refer(String TestCase) throws Exception {
		System.out.println("Feature name = "+Feature_Name);
		System.out.println("TestCase Name = "+TestCase);
		ExtentTest logInfo=null;
		try {
			test = extent.createTest(Feature.class, Feature_Name);		//FEATURE NAME					
			test=test.createNode(Scenario.class,scenarioName);			//SCENARIO NAME	
			logInfo=test.createNode(new GherkinKeyword("Given"), "collectdatafromexcel_refer"); //GIVEN STEP NAME
			data.clear();
			data = ExcelHandler.getTestDataInMap(Feature_Name, TestCase);
			//logInfo.info("Screenshot added");
		} catch (AssertionError | Exception e) {
			System.out.println(e);
			testStepHandle("FAIL",driver,logInfo,e);			
		}	
	}
	@Given("^user is on homepage$")
	public void user_is_on_homepage() throws Throwable {
		
		ExtentTest logInfo=null;
		try {			
			logInfo=test.createNode(new GherkinKeyword("Given"), "user_is_on_homepage"); //GIVEN STEP NAME
			init("chrome");
			OpenURL("http://automationpractice.com/index.php");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			logInfo.info("78 line");
		} catch (AssertionError | Exception e) {
			System.out.println(e);
			testStepHandle("FAIL",driver,logInfo,e);			
		}
	}

	@When("user enters username and Password")
	public void user_enters_username_and_Password() {
		
		String username = data.get("UserName1");
		String password = data.get("Password1");
		
		
		ExtentTest logInfo=null;
		try {		
			logInfo=test.createNode(new GherkinKeyword("When"), "user_enters_username_and_Password"); //GIVEN STEP NAME
			LoginPage loginPage = new LoginPage(driver,logInfo) ;
			PageFactory.initElements(driver,loginPage);
			loginPage.login(username, password);
		} catch (AssertionError | Exception e) {
			System.out.println(e);
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		
		ExtentTest logInfo=null;
		try {		
			logInfo=test.createNode(new GherkinKeyword("When"), "user_navigates_to_Login_Page"); //GIVEN STEP NAME
			LoginPage loginPage = new LoginPage(driver,logInfo);
			PageFactory.initElements(driver,loginPage);
			loginPage.NavigateToLogin();
			logInfo.pass("user navigates to Login Page");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			logInfo.info("97 line added");
			
		} catch (AssertionError | Exception e) {
			System.out.println(e);
			testStepHandle("FAIL",driver,logInfo,e);			
		}	
	}

	@When("^user enters username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_username_as_and_Password_as(String username, String password) throws Throwable {
		ExtentTest logInfo=null;
		try {		
			logInfo=test.createNode(new GherkinKeyword("When"), "user_enters_username_as_and_Password_as"); //GIVEN STEP NAME
			LoginPage loginPage = new LoginPage(driver,logInfo) ;
			PageFactory.initElements(driver,loginPage);
			loginPage.login(username, password);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			logInfo.info("114 came");
		} catch (AssertionError | Exception e) {
			System.out.println(e);
			testStepHandle("FAIL",driver,logInfo,e);			
		}
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
		ExtentTest logInfo=null;
		try {		
			logInfo=test.createNode(new GherkinKeyword("Then"), "success_message_is_displayed"); //GIVEN STEP NAME
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			Assert.assertEquals(" Logout exists---so Login successful ", true, driver.findElement(By.xpath("//a[@class='logout']")).isDisplayed());
		    System.out.println("Login successful");
			logInfo.info("Screenshot added");
		} catch (AssertionError | Exception e) {
			System.out.println(e);
			testStepHandle("FAIL",driver,logInfo,e);
		}
	}
	
	@When("^Click on My WishLists$")
	public void Click_on_My_WishLists() throws Throwable {
		
		
		ExtentTest logInfo=null;
		try {		
			logInfo=test.createNode(new GherkinKeyword("When"), "Click_on_My_WishLists"); //GIVEN STEP NAME
			driver.findElement(By.xpath("//span[contains(text(),'My wishlists')]")).click();
			System.out.println("My wishlist clicked");
			
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			logInfo.info("Screenshot added");
			
		} catch (AssertionError | Exception e) {
			System.out.println(e);
			testStepHandle("FAIL",driver,logInfo,e);			
		}
	}
	
	@When("^Click on My Addresses$")
	public void Click_on_My_addresses() throws Throwable {
		
		ExtentTest logInfo=null;
		try {	
			logInfo=test.createNode(new GherkinKeyword("When"), "Click_on_My_addresses"); //GIVEN STEP NAME
			driver.findElement(By.xpath("//span[contains(text(),'My addresses')]")).click();
			System.out.println("My addresses clicked");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			logInfo.info("Screenshot added");
			
		} catch (AssertionError | Exception e) {
			System.out.println(e);
			testStepHandle("FAIL",driver,logInfo,e);			
		}
	}
	
	@Then("^LogoutApplication$")
	public void LogoutApplication() throws Throwable {
		
		ExtentTest logInfo=null;
		try {		
			logInfo=test.createNode(new GherkinKeyword("Then"), "LogoutApplication"); //GIVEN STEP NAME
			//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			//logInfo.info("Screenshot added");
			//driver.close();
			LoginPage loginPage = new LoginPage(driver,logInfo) ;
			PageFactory.initElements(driver,loginPage);
			loginPage.LogOutAutomationPractice();
			System.out.println("Application logged out");
			
		} catch (AssertionError | Exception e) {
			System.out.println(e);
			testStepHandle("FAIL",driver,logInfo,e);			
		}
		
		

	}
}
