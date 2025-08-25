package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectrepository.Locators;
import utils.Base;
import utils.Reporter;

public class OverviewPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	
	public OverviewPage(WebDriver driver,ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest = extTest;
		
	}
	
	public boolean clickFinish() {
		driver.findElement(Locators.finishButton).click();
		Base.sleep();
	
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Checkout: Complete!']"))); //Products xpath
			//pass the test in extent report
			Reporter.generateReport(driver,extTest,Status.PASS,"Overview Success");
			return true;
			}catch(TimeoutException te) {
				//fail the extent report
				Reporter.generateReport(driver,extTest,Status.FAIL,"Overview Failure");
				return false;
			}
	
		
	}

}
