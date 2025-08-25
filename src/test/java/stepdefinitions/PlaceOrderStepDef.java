package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.CustomerInformationPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.OverviewPage;
import pages.SelectProductPage;
import pages.ValidationPage;
import utils.ExcelReader;

public class PlaceOrderStepDef {
	WebDriver driver = Hooks.driver;
	ExtentTest extTest = Hooks.extTest;
	LoginPage loginPage;
	SelectProductPage selectProductPage;
	AddToCartPage addToCartPage;
	CheckoutPage checkoutPage;
	CustomerInformationPage customerInformationPage;
	OverviewPage overviewPage;
	LogoutPage logoutPage;
	ValidationPage validationPage;
	
	 static String[][] excelData;
	  
	
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		String expResult = "https://www.saucedemo.com/";
		String actResult = driver.getCurrentUrl();
		Assert.assertEquals(expResult, actResult);
		
		if (excelData == null) {
            excelData = ExcelReader.readData(); // load Excel data once
        }
	  
	}
	@When("the user enters username as {string} and password as {string} and click login button")
	public void the_user_enters_username_as_and_password_as_and_click_login_button(String userName, String password) {
		loginPage = new LoginPage(driver,extTest);
		int row = Hooks.currentRow;
		 userName = excelData[row][0];  
		 password = excelData[row][1];
		 
		boolean actResult = loginPage.validateLogin(userName,password);
		
		Assert.assertTrue(actResult);
		
	   
	}
	@When("the user select the product")
	public void the_user_select_the_product() {
		selectProductPage = new SelectProductPage(driver,extTest);
		boolean actResult = selectProductPage.selectProduct();
	   
	}
	@When("the user clicks on Add to Cart button")
	public void the_user_clicks_on_add_to_cart_button() {
		addToCartPage = new AddToCartPage(driver,extTest);
		boolean actResult = addToCartPage.addToCart();
		
	    
	}
	@When("the user clicks on the Cart icon")
	public void the_user_clicks_on_the_cart_icon() {
		boolean actResult = addToCartPage.cartIcon();
	   
	}
	@When("the user clicks on Checkout button")
	public void the_user_clicks_on_checkout_button() {
		checkoutPage = new CheckoutPage(driver,extTest);
		boolean actResult = checkoutPage.clickCheckout();
	    
	}
	@When("the user enters customer information firstname as {string} and lastname as {string} and {string} and click Continue button")
	public void the_user_enters_customer_information_firstname_as_and_lastname_as_and_and_click_continue_button(String firstName, String lastName, String postCode) {
		customerInformationPage = new CustomerInformationPage(driver,extTest);
		int row = Hooks.currentRow;
		firstName = excelData[row][2]; 
		lastName = excelData[row][3].toString(); 
		postCode =excelData[row][4]; 
		boolean actResult = customerInformationPage.addCustomerDetails(firstName,lastName,postCode);
	}
	@When("the user verifies the product and click Finish button click")
	public void the_user_verifies_the_product_and_click_finish_button_click() {
		overviewPage = new OverviewPage(driver,extTest);
		boolean actResult = overviewPage.clickFinish();
	    
	}
	@When("the user clicks on the Logout button")
	public void the_user_clicks_on_the_logout_button() {
		logoutPage = new LogoutPage(driver,extTest);
		boolean actResult = logoutPage.logout();
	    
	}
	@Then("the user validates the Login button in the login page")
	public void the_user_validates_the_login_button_in_the_login_page() {
		validationPage = new ValidationPage(driver, extTest);
		boolean actResult = validationPage.logoutverfication();
		
	    
	}

}
