package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {

public RetailAccountPage() {
		
		PageFactory.initElements(getDriver(), this);
		
	}

@FindBy(xpath = "//img[@alt='profile pic']")
public WebElement accountProfilePicture;

@FindBy(xpath = "//h1[@class='account__personal-title']")
public WebElement accountYourProfileTitle;

@FindBy(xpath = "//input[@name = 'name']")
public WebElement accountNameField;

@FindBy(id = "personalPhoneInput")
public WebElement accountPhoneNumber;

@FindBy(id = "personalUpdateBtn")
public WebElement accountUpdateButton;

@FindBy(xpath = "//div[text() = 'Personal Information Updated Successfully']")
public WebElement personalInformationUpdateMessage;

@FindBy(css = "#previousPasswordInput")
public WebElement previousPasswordInput;

@FindBy(id = "newPasswordInput")
public WebElement newPasswordInput;

@FindBy(xpath = "//input[@id = 'confirmPasswordInput']")
public WebElement confirmPasswordInput;

@FindBy(id = "credentialsSubmitBtn")
public WebElement changePasswordButton;

@FindBy(xpath = "//div[contains(text(), 'Password Updated')]")
public WebElement passwwordUpdateMessage;

@FindBy(xpath = "//p[contains(text(),'Add a payment method')]")
public WebElement addPaymentMethodLink;

@FindBy(id = "cardNumberInput")
public WebElement cardNumberInput;

@FindBy(xpath = "//input[@id= 'nameOnCardInput']")
public WebElement nameOnCardInpu;

@FindBy(css = "#expirationMonthInput")
public WebElement expirationMonthInput;

@FindBy(id = "expirationYearInput")
public WebElement expirationYearInput;

@FindBy(xpath = "//input[@name = 'securityCode']")
public WebElement securityCodeField;

@FindBy(xpath = "(//button[@class= 'account__btn-submit'])[3]")
public WebElement addYourCardButton;

@FindBy(xpath = "//div[contains(text(), 'Payment Method added')]")
public WebElement paymentAddedMessage;

@FindBy(xpath = "//div[@class = 'account__payment-image-wrapper']")
public WebElement selectedCardOfPaymentMethod;

@FindBy(xpath = "//button[contains(text(),'Edit')]")
public WebElement editCardOption;

@FindBy(xpath = "//button[@id= 'paymentSubmitBtn']")
public WebElement updateCardButton;

@FindBy(xpath = "//div[contains(text(), 'Payment Method updated')]")
public WebElement paymentUpdateMessage;

@FindBy(xpath = "//*[@id=\"closeBtn\"]/svg/path[2]")
public WebElement closeButtonOfPaymentUpdate;

@FindBy(xpath = "//button[contains(text(),'remove')]")
public WebElement removeCardOption;

@FindBy(xpath = "//p[contains(text(), 'Add Address')]")
public WebElement addAddressButton;

@FindBy(css = "#countryDropdown")
public WebElement addressCountryDropdown;

@FindBy(xpath = "//input[@id='fullNameInput']")
public WebElement addressFullNameInput;

@FindBy(id = "phoneNumberInput")
public WebElement addressPhoneNumber;

@FindBy(css = "#streetInput")
public WebElement addressStreetInput;

@FindBy(xpath = "//input[@id='apartmentInput']")
public WebElement addressApartmentNumber;

@FindBy(id = "cityInput")
public WebElement addressCityInput;

@FindBy(xpath = "//select[@class = 'account__address-new-dropdown' and @name= 'state']")
public WebElement addressStateDropdown;

@FindBy(css = "#zipCodeInput")
public WebElement addressZipCodeInput;

@FindBy(xpath = "//button[contains(text(), 'Add Your Address')]")
public WebElement addressAddYourAddressButton;

@FindBy(xpath = "//div[contains(text(), 'Address Added Successfully')]")
public WebElement addressAddedMessage;

@FindBy(xpath = "//button[contains(text(),'Remove')]")
public WebElement removeAddressButton;

@FindBy(xpath = "//div[@class = 'account__address-single']")
public WebElement selectedAddress;

@FindBy(xpath = "//a[@id='orderLink']")
public WebElement ordersOption;











}
