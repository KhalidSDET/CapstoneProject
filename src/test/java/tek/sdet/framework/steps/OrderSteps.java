package tek.sdet.framework.steps;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class OrderSteps extends CommonUtility {
	POMFactory factory = new POMFactory();
	
	
	
	//**************Scenario 01 *****************

	@And("User click on Orders section")
	public void userClickOnOrdersSection() {
	click(factory.accountPage().ordersOption);
	logger.info("user clicked on orders option");
	}
	
	@And("User click on first order in list")
	public void userClickOnFirstOrderInList() {
	click(factory.orderPage().firstOrderSelection)	;
	logger.info("user clicked on first order in the list");
	}
	
	@And("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
	click(factory.orderPage().cancelOption);
	logger.info("user clicked on cancel button");
	}
	
	@And("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String reason) {
	click(factory.orderPage().cancelationReason);
	selectByVisibleText(factory.orderPage().cancelationReason, reason);
	logger.info("user selected the cancelation Reason 'Bought wrong item'");
	}
	
	@And("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
	click(factory.orderPage().orderCancelButton);
	logger.info("user clicked on cancel order button");
	}
	
	@Then("a cancelation message should be displayed 'Your Order Has Been Cancelled'")
	public void orderCancelationMessage() {
	String expectedMessage = "Your Order Has Been Cancelled";
	WebElement actualMessage = waitTillPresence(factory.orderPage().orderCancelationMessageConfirmation);
	Assert.assertEquals(expectedMessage, actualMessage.getText());
	logger.info("cancelation message is displayed: "+actualMessage.getText());
	}
	
	//**************Scenario 02 *****************
	
	@And("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
	click(factory.orderPage().orderReturnOption);
	logger.info("user clicked on return button");
	}
	
    @And("User select the Return Reason {string}")
    public void userSelectTheReturnReason(String reason) {
    click(factory.orderPage().orderReturnReason);	
    selectByVisibleText(factory.orderPage().orderReturnReason, reason);
    logger.info("user selected the return reason 'Item damaged'");
    }
    
    @And("User select the drop off service {string}")
    public void userSelectTheDropOffService(String reason) {
    click(factory.orderPage().dropOffSelection);
    selectByVisibleText(factory.orderPage().dropOffSelection, reason);
    logger.info("user selected the drop off service 'Fedex'");
    }
    
    @And("User click on Return Order button")
    public void userClickOnReturnOrderBtton() {
    click(factory.orderPage().orderReturnButton);
    logger.info("user clicked on return order");	
    }
    
    @Then("a return message should be displayed 'Return was successfull'")
    public void returnMessage() {
    waitTillPresence(factory.orderPage().orderReturnMessageConfirmation);
    String expectedMessage = "Return was successfull";
    WebElement actualMessage = factory.orderPage().orderReturnMessageConfirmation;
    Assert.assertEquals(expectedMessage, actualMessage.getText());
    logger.info("a return message is displayed successfully"+ actualMessage.getText());
    }
	
    //**************Scenario 03 *****************
	
    @And("User click on Review button")
    public void userClickOnReviewButton() {
    click(factory.orderPage().orderReviewButton);
    logger.info("user clicked on review button");
    }
    
    @And("User write Review headline {string} and Review text {string}")
    public void userWriteReviewHeadline(String headlineReview, String textReview) {
    sendText(factory.orderPage().headlineReviewInput, headlineReview);
    sendText(factory.orderPage().textReviewInput, textReview);
    logger.info("user write review headline: "+headlineReview+ "and Review text"+textReview);
    }
    
    @And("User click Add your Review button")
    public void userClickAddYourReviewButton() {
    click(factory.orderPage().addReviewButton);
    logger.info("user clicked on add your review button");
    }
    
    @Then("a review message should be displayed 'Your review was added successfully'")
	public void reviewMessageShouldBeDisplayed() {
    waitTillPresence(factory.orderPage().reviewAddedMessage);
    String expectedMessage = "Your review was added successfully";
    WebElement actualMessage = factory.orderPage().reviewAddedMessage;
    Assert.assertEquals(expectedMessage, actualMessage.getText());
    logger.info("a review message is displayed "+actualMessage.getText());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

