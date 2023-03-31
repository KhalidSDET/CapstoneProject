package tek.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.pages.RetailSignInPage;
import tek.sdet.framework.utilities.CommonUtility;

public class SignInSteps extends CommonUtility {
	POMFactory factory = new POMFactory();
	
	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.homePage().signInOption);
		logger.info("user clicked on sign in option");
	}
	
	@And("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String emailValue, String passValue) {
		sendText(factory.signinPage().emailField, emailValue);
		sendText(factory.signinPage().passwordFiled, passValue);
		logger.info("user entered email and password");	
	}	
	@And("User click on login button")
	public void userClickOnLoginButton() {
	 click(factory.signinPage().loginButton);
	 logger.info("user clicked on login button");
	}
	
	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
	Assert.assertTrue(isElementDisplayed(factory.homePage().accountOption));
	logger.info("user is logged in into Account");
	}

	@And("User click on Logout option")
	public void userClickOnLogoutOption() {
		click(factory.homePage().logoutOption);
		Assert.assertTrue(isElementDisplayed(factory.homePage().signInOption));
		logger.info("user logged out");
	}
	
	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
	    click(factory.signinPage().createNewAccountButton);
	    logger.info("user clicked on Create New Account button");
	    
	}
	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
	   List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
	   sendText(factory.signinPage().createNewAccountNameField, data.get(0).get("name"));
	   sendText(factory.signinPage().createNewAccountEmailField, data.get(0).get("email"));
	   sendText(factory.signinPage().createNewAccountPasswordField, data.get(0).get("password"));
	   sendText(factory.signinPage().createNewAccountConfPasswordField, data.get(0).get("confirmPassword"));
	   logger.info("user filled the signup information form");
	    
//	   @When("User fill the signUp information with below data")
//		public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
//		List<Map<String, String>> data = dataTable.asMaps(String.class,String.class);
//		sendText(factory.signInPage().createNewAccountNameField,data.get(0).get("name"));
//		sendText(factory.signInPage().createNewAccountEmailField,data.get(0).get("email"));
//		sendText(factory.signInPage().createNewAccountNameField,DataGenerator.getData(data.get(0).get("name")));
//
//		sendText(factory.signInPage().createNewAccountEmailField,DataGenerator.getData(data.get(0).get("email")));
//		sendText(factory.signInPage().createNewAccountPasswordField,data.get(0).get("password"));
//		sendText(factory.signInPage().createNewAccountConfPassField, data.get(0).get("confirmPassword"));
//		logger.info("user filled the signUp information form");
	}
	@When("Use click on SignUp button")
	public void useClickOnSignUpButton() {
	    click(factory.signinPage().createNewAccountSignUpButton);
	    logger.info("user clicked on Sign Up button");
	}
	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		waitTillPresence(factory.accountPage().accountProfilePicture);
	    Assert.assertTrue(isElementDisplayed(factory.accountPage().accountProfilePicture));
	    logger.info("user is logged into account page");
	    
	}

}
