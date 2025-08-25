Feature: Placeorder
Scenario: Placing the order successfully
Given user is on the login page
When the user enters username as "<Username>" and password as "<Password>" and click login button
And the user select the product
And the user clicks on Add to Cart button
And the user clicks on the Cart icon
And the user clicks on Checkout button
And the user enters customer information firstname as "<Firstname>" and lastname as "<Lastname>" and "<Pincode>" and click Continue button
And the user verifies the product and click Finish button click
And the user clicks on the Logout button
Then the user validates the Login button in the login page

