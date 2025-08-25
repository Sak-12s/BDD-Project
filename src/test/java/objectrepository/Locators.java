package objectrepository;

import org.openqa.selenium.By;

public class Locators {
	
	//below are the login page locators
	public static By userName = By.id("user-name");
	public static By password = By.id("password");
	public static By loginButton = By.id("login-button");
	
	//below are the selectProductpage page locators
	public static By productName = By.xpath("//*[@id=\"item_4_title_link\"]/div");
	
	//below are the addtoCartpage page locators
	public static By addtocartButton = By.id("add-to-cart");
	public static By cartIconButton = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
	
	//below are the checkoutPage page locators
	public static By checkoutButton = By.id("checkout");
	
	//below are the customerInformation page locators
	public static By firstName = By.id("first-name");
	public static By lastName = By.id("last-name");
	public static By postalCode = By.id("postal-code");
	public static By continueButton = By.id("continue");
	
	//below are the overView page locators
	public static By finishButton = By.id("finish");
	
	//below are the Logout page locators
	public static By backtohomeButton = By.id("back-to-products");
	public static By openmenuButton = By.id("react-burger-menu-btn");
	public static By logoutButton = By.id("logout_sidebar_link");
	
	

}
