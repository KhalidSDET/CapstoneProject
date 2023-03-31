package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailOrderPage extends BaseSetup {
	
	public RetailOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "(//p[@class='order__header-btn'])[1]")
	public WebElement firstOrderSelection;
	
	@FindBy(css = "#cancelBtn")
	public WebElement cancelOption;
	
	@FindBy(xpath = "//select[@id='reasonInput']")
	public WebElement cancelationReason;
	
	@FindBy(css = "#orderSubmitBtn")
	public WebElement orderCancelButton;
	
	@FindBy(xpath = "//p[contains(text(),'Your Order Has Been Cancelled')]")
	public WebElement orderCancelationMessageConfirmation;
	
	@FindBy(xpath = "//button[@id='returnBtn']")
	public WebElement orderReturnOption;
	
	@FindBy(id = "reasonInput")
	public WebElement orderReturnReason;
	
	@FindBy(xpath = "//select[@id='dropOffInput']")
	public WebElement dropOffSelection;
	
	@FindBy(css = "#orderSubmitBtn")
	public WebElement orderReturnButton;
	
	@FindBy(xpath = "//p[contains(text(),'Return was successfull')]")
	public WebElement orderReturnMessageConfirmation;
	
	@FindBy(id = "reviewBtn")
	public WebElement orderReviewButton;
	
	@FindBy(xpath = "//input[@id='headlineInput']")
	public WebElement headlineReviewInput;
	
	@FindBy(id = "descriptionInput")
	public WebElement textReviewInput;
	
	@FindBy(xpath = "//button[@id='reviewSubmitBtn']")
	public WebElement addReviewButton;
	
	@FindBy(xpath = "//div[contains(text(), 'Your review was added successfully')]")
	public WebElement reviewAddedMessage;
	
	@FindBy(xpath = "//button[@id = 'proceedBtn']")
	public WebElement proceedCheckOutBtn;
	
	@FindBy(xpath = "//button[@id = 'placeOrderBtn']")
	public WebElement placeOrderButton;
	
	@FindBy(xpath = "//p[text() = 'Order Placed, Thanks']")
	public WebElement placingConfirmationMessage;
	
	@FindBy(className = "products__layout")
	public WebElement smartPlug;
	
	@FindBy(className = "product__select")
	public WebElement quantityDropDown;
	
	@FindBy(className = "products__layout")
	public WebElement product;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
