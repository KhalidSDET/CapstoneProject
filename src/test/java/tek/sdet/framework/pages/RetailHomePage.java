
package tek.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup{
	
	public RetailHomePage() {
		// we are implementing pageFactory Class to initialize the UI elements
		// using @FindBy annotation of PageFactory
		PageFactory.initElements(getDriver(), this);
	}
	
	// syntax for storing UI elements using @FindBy annotations    
	// @FindBy(locatorType = "locator Value")    
	// public WebElement nameOfElement    
	
	@FindBy(linkText = "TEKSCHOOL") // this is same as driver.findElement()     
	public WebElement tekschoolLogo;
    @FindBy(id = "searchInput")
    public WebElement searchBarInput;
    @FindBy(id = "searchBtn")
    public WebElement searchButton;
    @FindBy(xpath = "//img[contains(@alt, 'Pokemon')]")
    public WebElement pokemonImage;
    @FindBy(id = "signinLink")
    public WebElement signInOption;
    @FindBy(xpath = "//a[text()= 'Account']")
    public WebElement accountOption;
    @FindBy(id = "logoutBtn")
    public WebElement logoutOption;
    

}
