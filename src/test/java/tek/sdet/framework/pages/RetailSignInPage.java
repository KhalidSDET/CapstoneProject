package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailSignInPage extends BaseSetup {
	
	public RetailSignInPage() {
		
		PageFactory.initElements(getDriver(), this);
		
	}
	
	@FindBy(id = "email")
	public WebElement emailField;
	@FindBy(css = "#password")
	public WebElement passwordFiled;
	@FindBy (xpath = "//button[text()='Login']")
	public WebElement loginButton;
	@FindBy (id = "newAccountBtn")
	public WebElement createNewAccountButton;
	@FindBy (css = "#nameInput")
	public WebElement createNewAccountNameField;
	@FindBy (id = "emailInput")
	public WebElement createNewAccountEmailField;
	@FindBy (xpath = "//input[@type ='password']")
	public WebElement createNewAccountPasswordField;
	@FindBy (id = "confirmPasswordInput")
	public WebElement createNewAccountConfPasswordField;
	@FindBy(id = "signupBtn")
	public WebElement createNewAccountSignUpButton;
	
}
