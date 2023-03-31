
package tek.sdet.framework.pages;

import java.util.List;

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
    
	@FindBy(id = "accountLink")
    public WebElement accountOption;
    
	@FindBy(id = "logoutBtn")
    public WebElement logoutOption;
    
	@FindBy(id = "hamburgerBtn")
    public WebElement sidebar;
	
	@FindBy(xpath = "//select[@ id = 'search']" )
	public WebElement allDepartments;
    
	@FindBy(xpath = "//span[contains(text(),'Electronics')]")
    public WebElement electronicsOption;
    
	@FindBy(xpath = "//span[contains(text(),'Computers')]")
    public WebElement computersOption;
    
	@FindBy(xpath = "//span[contains(text(),'Smart Home')]")
    public WebElement smartHomeOption;
    
	@FindBy(xpath = "//span[contains(text(),'Sports')]")
    public WebElement sportOption;
    
	@FindBy(xpath = "//span[contains(text(),'Automative')]")
    public WebElement automativeOption;
	
	@FindBy(xpath = "//img[@alt = 'Kasa Outdoor Smart Plug']" )
	public WebElement itemImage;
	 
	@FindBy(xpath = "//button[@id ='addToCartBtn']")
	public WebElement addToCardBtn;
	
	@FindBy(xpath = "//select[@class = 'product__select']")
	public WebElement cartQuantityIcon;
	
	@FindBy(xpath = "//div[@id = 'cartBtn']")
	public WebElement cartOption;
	
    
    
    
    

}
