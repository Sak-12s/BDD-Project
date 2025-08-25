package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.CustomerInformationPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.OverviewPage;
import pages.SelectProductPage;
import utils.Base;
import utils.ExcelReader;

public class PlaceOrderTest extends Base {
	LoginPage loginPage;
	SelectProductPage selectProductPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	CustomerInformationPage customerInformationPage;
	OverviewPage overviewPage;
	LogoutPage logoutPage;
	
	ExtentSparkReporter spark;
	ExtentReports extReports;
	ExtentTest extTest;
	 @BeforeClass
	  public void beforeClass() {
		 spark = new ExtentSparkReporter("reports\\ExtendReport.html");
		 extReports = new ExtentReports();
		 extReports.attachReporter(spark);
	  }

	  @AfterClass
	  public void writeReports() {
		  extReports.flush();
	  }
	  
	  @BeforeMethod
	  public void setUp() {
		  launchBrowser();
	  }

	
  @Test(dataProvider = "getData")
  public void testPlaceOrder(String u_name,String pass_word,String firstName,String lastName,String postCode) {
	  //1.Login
	 extTest = extReports.createTest("Place Order Test");
	 loginPage = new LoginPage(driver,extTest);
	 loginPage.validateLogin(u_name,pass_word);
	  //2.Select Product
	 //extTest = extReports.createTest("Select Product Test");
	 selectProductPage = new SelectProductPage(driver,extTest);
	 selectProductPage.selectProduct();
	 
	  //3.Add to Cart
	 addToCartPage = new AddToCartPage(driver,extTest);
	 addToCartPage.addToCart();
	 addToCartPage.cartIcon();
	 
	  //4.Checkout
	 checkoutPage = new CheckoutPage(driver,extTest);
	 checkoutPage.clickCheckout();
	 
	  //5.Customer Info
	 customerInformationPage = new CustomerInformationPage(driver,extTest);
	 customerInformationPage.addCustomerDetails(firstName,lastName,postCode);
	 
	  //6.Overview
	 overviewPage = new OverviewPage(driver,extTest);
	 overviewPage.clickFinish();
	 
	  //7.Logout
	 logoutPage = new LogoutPage(driver,extTest);
	 logoutPage.logout();
  }
 
  @DataProvider
  public Object[][] getData() {
    Object[][] data = ExcelReader.readData();
	return data;
  }
  @AfterMethod
  public void tearDown() {
	  Base.sleep();
	  driver.quit();
  }
 

}
