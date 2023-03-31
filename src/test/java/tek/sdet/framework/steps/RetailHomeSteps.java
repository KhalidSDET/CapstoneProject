package tek.sdet.framework.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.pages.RetailHomePage;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailHomeSteps extends CommonUtility{
	POMFactory factory = new POMFactory();
	
	// ************** Scenario test *****************
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekschoolLogo));
		logger.info("user is on retail website");
	}
	
	@When("User search for {string} item")
	public void userSearchForItem(String value) {
		sendText(factory.homePage().searchBarInput,value);
		logger.info("User searched for "+ value+" item");
		
	}
	
	@Then("Product should be displayed")
	public void productShouldBeDisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().pokemonImage));
		logger.info("Product is displayed");
		
	}
	
	// ************** Scenario 01 *****************
	
	 @When("User click on All section")
	 public void userClickOnAllsection() {
		 click(factory.homePage().sidebar);
		 logger.info("user clicked on all section");
	 }
	 
	 @Then("Below options are present in Shop by Department sidebar")
		public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
			waitTillPresence(factory.homePage().electronicsOption);
			String[] allDepartments = {"Electronics", "Computers", "Smart Home", "Sports", "Automative"};
			for (int i = 0; i < allDepartments.length; i++) {
				WebElement element = getDriver().findElement(By.xpath( "//div[@class = 'sidebar_content-item']//span"));
				assert element.isDisplayed();
			}
			logger.info("all department options are present");
			
		}
		
		
	// ************** Scenario 02 *****************
		
	 @And("User click on {string}")
		public void userClickOnDepartment(String department) {
		    click(getDriver().findElement(By.xpath("//span[text()='" + department +"']")));
			logger.info("User clicked on departments");
		}
		@Then("below options are present in department{string}  {string}")
		public void optionsArePresentInDepartment(String optionOne, String optionTwo) {
			Assert.assertTrue(isElementDisplayed(getDriver().findElement(By.xpath("//span[text()='" + optionOne + "']"))));
			Assert.assertTrue(isElementDisplayed(getDriver().findElement(By.xpath("//span[text()='" + optionTwo + "']"))));
			logger.info("Options are present in Department");
		}
		
	// ************** Scenario 03 *****************
		
		@And("User change the category to {string}")
		public void userChangeTheCategoryToSmartHome(String category) {
			click(factory.homePage().allDepartments);
			selectByVisibleText(factory.homePage().allDepartments, category);
			logger.info("category changed to Smart Home");
		}
		
		@And("User search for an item {string}")
		public void userSearchForAnItem(String itemName) {
			sendText(factory.homePage().searchBarInput, itemName);
			logger.info("user searched for the item");
		}
		
		@And("User click on Search icon")
		public void userClickOnSearchIcon() {
			click(factory.homePage().searchButton);
			logger.info("user clicked on search icon");
		}
		
		@And("User click on item")
		public void userClickOnItem(){
			click(factory.orderPage().product);
			logger.info("user clicked on item");
		}
		
		@And("User select quantity {string}")
		public void userSelectQuantity(String quantity) {
			click(factory.orderPage().quantityDropDown);
			selectByVisibleText(factory.orderPage().quantityDropDown, quantity);
			logger.info("user selected quantity to 4");
		}
		
		@And("User click add to Cart button")
		public void userClicAddToCartButton() {
			click(factory.homePage().addToCardBtn);
			logger.info("user clicked add to cart button");
		}
		
		@Then("the cart icon quantity should change to {string}")
		public void cartIconQuantityShouldChange(String qty) {
			waitTillPresence(factory.homePage().cartQuantityIcon);
			Assert.assertTrue(isElementDisplayed(getDriver().findElement(By.xpath("//span[@id = 'cartQuantity' and text()='" + qty +"']"))));
			logger.info("cart icon quantity is changed to 4");
		}
		
		// ************** Scenario 04 *****************
		
		@And("User click on Cart option")
		public void userClickOnCartOption() {
			waitTillPresence(factory.homePage().cartOption);
			click(factory.homePage().cartOption);
			logger.info("user clicked on cart option");
		}
		
		@And("User click on Proceed to Checkout button")
		public void userClickOnProceedToCheckoutBtn() {
			waitTillPresence(factory.orderPage().proceedCheckOutBtn);
			click(factory.orderPage().proceedCheckOutBtn);
			logger.info("user clicked on proceed to checkout Btn");
		}
		
		@And("User click Add a new address link for shipping address")
		public void userClickAddANewAddLinkForShpngAdd() {
			click(factory.accountPage().addAddressButton);
			logger.info("user clicked add a new address link");
		}
		
		@And("User fill new address form with below information")
		public void userFillNewAddFormInfo(DataTable dataTable) {
			List<Map<String, String >> addressData = dataTable.asMaps(String.class, String.class);
			selectByVisibleText(factory.accountPage().addressCountryDropdown, addressData.get(0).get("country"));
			sendText(factory.accountPage().accountNameField, addressData.get(0).get("fullName"));
			sendText(factory.accountPage().accountPhoneNumber, addressData.get(0).get("phoneNumber"));
			sendText(factory.accountPage().addressStreetInput, addressData.get(0).get("streetAddress"));
			sendText(factory.accountPage().addressApartmentNumber, addressData.get(0).get("apt"));
			sendText(factory.accountPage().addressCityInput, addressData.get(0).get("city"));
			selectByVisibleText(factory.accountPage().addressStateDropdown, addressData.get(0).get("state"));
			sendText(factory.accountPage().addressZipCodeInput, addressData.get(0).get("zipCode"));
			logger.info("user filled out the new address form");
		}
		
		@And("User click Add Your Address button")
		public void userClickAddYourAddBtn() {
		click(factory.accountPage().addAddressButton);
			logger.info("user clicked on add your address button");
		}
		
		@And("User click Add a credit card or Debit Card for Payment method")
		public void userClickAddCreditDebitCardforPaymentMethod() {
			click(factory.accountPage().addPaymentMethodLink);
			logger.info("user clicked on Add a credit or debit card button");
		}
		
		@And("User fill Debit or credit card information")
		public void userFillDebitOrCreditCardInfo(DataTable dataTable) {
			List<Map<String, String>> paymentData = dataTable.asMaps(String.class, String.class);
			sendText(factory.accountPage().cardNumberInput, paymentData.get(0).get("cardNumber"));
			sendText(factory.accountPage().nameOnCardInpu, paymentData.get(0).get("nameOnCard"));
			sendText(factory.accountPage().expirationMonthInput, paymentData.get(0).get("expirationMonth"));
			sendText(factory.accountPage().expirationYearInput, paymentData.get(0).get("expirationYear"));
			sendText(factory.accountPage().securityCodeField, paymentData.get(0).get("securityCode"));
		}
		
		@And("User click on Add your card button")
		public void userClickOnAddYourCardButton() {
			click(factory.accountPage().addYourCardButton);
			logger.info("user clicked on add your card button");
		}
		
		@And("User click on Place Your Order")
		public void userClickOnPlaceYourOrder(){
			click(factory.orderPage().placeOrderButton);
			logger.info("user clicked on place you order");
		}
		
		@Then("a message should be displayed {string}")
		public void orderPlacedMessageShouldBeDisplayed(String message){
			waitTillPresence(factory.orderPage().placingConfirmationMessage);
			String expectedMessage = "Order Placed, Thanks";
			WebElement actualMessage = factory.orderPage().placingConfirmationMessage;
			Assert.assertEquals(expectedMessage, actualMessage.getText());
			logger.info("Order Placed, Thanks message is displayed");
		}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
