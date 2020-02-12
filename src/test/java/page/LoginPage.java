package page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

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
		logInfo.pass("47 came");
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	}
	
	
	public void LogOutAutomationPractice() throws IOException {
		Logout.click();
		logInfo.info("Logged Out application");
		logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
	}

	
}
