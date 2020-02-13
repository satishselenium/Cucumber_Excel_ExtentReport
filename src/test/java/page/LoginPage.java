package page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import com.aventstack.extentreports.ExtentTest;


import driverfactory.BasePage;

public class LoginPage extends BasePage {


	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
    public WebElement ClickToLogin;
	
	@FindBy(xpath="//*[@id='email']")
    public WebElement userName;
	
	@FindBy(xpath="//*[@id='passwd']")
	public WebElement passWord;
	
	@FindBy(xpath="//*[@id='SubmitLogin']/span")
	public WebElement Submit;
	
	@FindBy(xpath="//a[@class='logout']")
	public WebElement Logout;
	
	@FindBy(xpath="//p[contains(text(),'There is 1 error')]")
	public WebElement Error;
	
	@FindBys(@FindBy(xpath="//p[contains(text(),'There is 1 error')]"))
	public List<WebElement> ErrorList;
	
	ExtentTest logInfo;
	
	public LoginPage(WebDriver driver,ExtentTest logInfo) {
		super(driver,logInfo);
		this.logInfo = logInfo;
		// TODO Auto-generated constructor stub
	}
	
	
	public void NavigateToLogin() {
		//driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
		ClickToLogin.click();
		logInfo.info("40 line added");
	}
	
	
	public void login(String UserName, String Password) throws IOException {
		userName.sendKeys(UserName);
		passWord.sendKeys(Password);
		logInfo.log(logInfo.getStatus(), "46 line");
		logInfo.info("44 came");
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		Submit.click();
		logInfo.pass("Submit button clicked");
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		if (isElementExist(ErrorList)) {
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			logInfo.fail("login not successful---error");
		}else {
			logInfo.pass("login successful");
		}
	}
	
	
	public void LogOutAutomationPractice() throws IOException {
		Logout.click();
		logInfo.info("Logged Out application");
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	}

	
}
