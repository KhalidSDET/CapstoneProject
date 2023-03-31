package tek.sdet.framework.steps;

import java.sql.DriverAction;
import java.util.List;
import java.util.Map;

import javax.security.auth.RefreshFailedException;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import org.apache.hc.client5.http.ssl.DefaultHostnameVerifier;
import org.bouncycastle.asn1.dvcs.Data;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v102.page.model.NavigatedWithinDocument;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class AccountSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

	String nameValue;
	String phoneValue;
	String cardNumber;

	public AccountSteps() {
		super();
		this.nameValue = "";
		this.phoneValue = "";
		this.cardNumber = "";
	}

	public AccountSteps(String nameValue, String phoneValue, String cardNumber) {
		super();
		this.nameValue = nameValue;
		this.phoneValue = phoneValue;
		this.cardNumber = cardNumber;
	}

	// **************Scenario 01 *****************
	
	@When("User click on account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().accountOption);
		logger.info("User clicked on Account option");
	}

	@And("User update Name {string} and Phone {string}")
	public void updateNameAndPhone(String nameValue, String phoneValue) {
		clearTextUsingSendKeys(factory.accountPage().accountNameField);
		sendText(factory.accountPage().accountNameField, nameValue);
		clearTextUsingSendKeys(factory.accountPage().accountPhoneNumber);
		sendText(factory.accountPage().accountPhoneNumber, phoneValue);
		logger.info("User entred new Name and Phone Number");
	}

	@And("User click on Update button")
	public void userClickOnUpdateButton() {
		click(factory.accountPage().accountUpdateButton);
		logger.info("User clicked on Update button");
	}

	@Then("User Profile information should be updated")
	public void userProfileShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInformationUpdateMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInformationUpdateMessage));
		Assert.assertEquals(nameValue, factory.accountPage().accountNameField.getText());
		logger.info("User Infromation Updated");
	}

	// **************Scenario 02 *****************
	
	@And("User enter below information")
	public void userEnterBelowInformation(DataTable dataTable) {
		List<Map<String, String>> passwordData = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().previousPasswordInput, passwordData.get(0).get("previousPassword"));
		sendText(factory.accountPage().newPasswordInput, passwordData.get(0).get("newPassword"));
		sendText(factory.accountPage().confirmPasswordInput, passwordData.get(0).get("confirmPassword"));
		logger.info("User entred new Password and confirm it");
	}

	@And("User click on Change Password button")
	public void userClickOnChangePasswordButton() {
		click(factory.accountPage().changePasswordButton);
		logger.info("User changed Password");
	}

	@Then("a message should be displayed 'Password Updated Successfully'")
	public void userPasswordShouldBeUpdated() {
		waitTillPresence(factory.accountPage().passwwordUpdateMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().passwwordUpdateMessage));
		logger.info("password Updated Successfully");
	}

	// **************Scenario 03 *****************

	@And("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.accountPage().addPaymentMethodLink);
	}

	@And("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<Map<String, String>> paymentData = dataTable.asMaps(String.class, String.class);
		sendText(factory.accountPage().cardNumberInput, paymentData.get(0).get("cardNumber"));
		sendText(factory.accountPage().nameOnCardInpu, paymentData.get(0).get("nameOnCard"));
		selectByValue(factory.accountPage().expirationMonthInput, paymentData.get(0).get("expirationMonth"));
		selectByValue(factory.accountPage().expirationYearInput, paymentData.get(0).get("expirationYear"));
		sendText(factory.accountPage().securityCodeField, paymentData.get(0).get("securityCode"));
		logger.info("User Filled Out The Payment Method");
	}

	@And("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountPage().addYourCardButton);
		logger.info("User Clicked on Add your card button");
	}

	@Then("a message should be displayed 'Payment Method added successfully'")
	public void paymentMethodAddedMessage() {
		waitTillPresence(factory.accountPage().paymentAddedMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().paymentAddedMessage));
		logger.info("Payment Successfully Added");
	}

	// **************Scenario 04 *****************

	@And("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		// scrollPageDownWithJS();
		click(factory.accountPage().selectedCardOfPaymentMethod);
		click(factory.accountPage().editCardOption);
		logger.info("user clicked on Edit option of card section");
	}

	@And("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> cardData = dataTable.asMaps(String.class, String.class);
		clearText(factory.accountPage().cardNumberInput);
		sendText(factory.accountPage().cardNumberInput, cardData.get(0).get("cardNumber"));
		clearText(factory.accountPage().nameOnCardInpu);
		sendText(factory.accountPage().nameOnCardInpu, cardData.get(0).get("nameOnCard"));
		selectByValue(factory.accountPage().expirationMonthInput, cardData.get(0).get("expirationMonth"));
		selectByValue(factory.accountPage().expirationYearInput, cardData.get(0).get("expirationYear"));
		clearText(factory.accountPage().securityCodeField);
		sendText(factory.accountPage().securityCodeField, cardData.get(0).get("securityCode"));
		logger.info("User Edited the card information");
	}

	@And("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(factory.accountPage().updateCardButton);
		logger.info("user clicked on update card button");

	}

	@Then("a message should be displayed 'Payment Method updated Successfully'")
	public void paymentMethodUpdatedMessage() {
		waitTillPresence(factory.accountPage().paymentUpdateMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().paymentUpdateMessage));
		logger.info(" paymemt method successfully updated");
	}

	// **************Scenario 05 *****************
	
	@And("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.accountPage().selectedCardOfPaymentMethod);
		click(factory.accountPage().removeCardOption);
		logger.info("user clicked on remove option of card section");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertFalse(factory.accountPage().selectedCardOfPaymentMethod.isDisplayed());
		logger.info("payment details was deleted");
	}

	// **************Scenario 06 *****************
	
	@And("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddressButton);
		logger.info("user clicked on add address button");	
	}
   
	@And("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressData = dataTable.asMaps(String.class, String.class);
		selectByValue(factory.accountPage().addressCountryDropdown, addressData.get(0).get("country"));
		sendText(factory.accountPage().addressFullNameInput, addressData.get(0).get("fullName"));
		sendText(factory.accountPage().addressPhoneNumber, addressData.get(0).get("phoneNumber"));
		sendText(factory.accountPage().addressStreetInput, addressData.get(0).get("streetAddress"));
		sendText(factory.accountPage().addressApartmentNumber, addressData.get(0).get("apt"));
		sendText(factory.accountPage().addressCityInput, addressData.get(0).get("city"));
		selectByValue(factory.accountPage().addressStateDropdown, addressData.get(0).get("state"));
		sendText(factory.accountPage().addressZipCodeInput, addressData.get(0).get("zipCode"));
		logger.info("user filled out a new address form");
	}
    
	@And("User click Add Your Address button")
    public void userClickAddYouAddressButton() {
		click(factory.accountPage().addressAddYourAddressButton);
		logger.info("user clicked on add your address button");	
	}
   
	@Then("a message should be displayed 'Address Added Successfully'")
	public void addressAddedMessageConfirmation() {
		waitTillPresence(factory.accountPage().addressAddedMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().addressAddedMessage));
		logger.info("user added new address successfully");	
	}
	
	// **************Scenario 07 *****************
	
	@And("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		click(factory.accountPage().removeAddressButton);
		logger.info("user clicked on remove option of Address section");
	}
    @Then("Address details should be removed") 
    public void addressDetailsShouldBeRemoved()throws InterruptedException {
		wait(500);
    	Assert.assertFalse(isElementDisplayed(factory.accountPage().selectedAddress));
    	logger.info("Address details removed from account");
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
