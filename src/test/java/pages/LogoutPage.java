package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import objectrepository.Locators;
import utils.Base;

public class LogoutPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	
	public LogoutPage(WebDriver driver,ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest = extTest;
		
	}
	
	public boolean logout() {
		
		driver.findElement(Locators.openmenuButton).click();
		Base.sleep();
		driver.findElement(Locators.logoutButton).click();
		Base.sleep();
		return true;
		
		
		
	
		
		
		
	}

}
