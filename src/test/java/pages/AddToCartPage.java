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

public class AddToCartPage {
	WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	ExtentReports extReports;
	
	public AddToCartPage(WebDriver driver,ExtentTest extTest) {
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest = extTest;
		
	}
	
	public boolean addToCart() {
		driver.findElement(Locators.addtocartButton).click();
		Base.sleep();
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("remove"))); //Products xpath
			//pass the test in extent report
			Reporter.generateReport(driver,extTest,Status.PASS,"Add To Cart Success");
			}catch(TimeoutException te) {
				//fail the extent report
				Reporter.generateReport(driver,extTest,Status.FAIL,"Add To Cart Failure");
			}
		return true;
		
	}
	public boolean cartIcon() {
		driver.findElement(Locators.cartIconButton).click();
		Base.sleep();
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your Cart']"))); //Products xpath
			//pass the test in extent report
			Reporter.generateReport(driver,extTest,Status.PASS,"Checkout Page Success");
			return true;
			}catch(TimeoutException te) {
				//fail the extent report
				Reporter.generateReport(driver,extTest,Status.FAIL,"Checkout Page Failure");
				return false;
			}
		
	}

}
