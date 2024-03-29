package tek.sdet.framework.pages;

import tek.sdet.framework.base.BaseSetup;

public class POMFactory extends BaseSetup {

	private RetailHomePage homePage;
	private RetailSignInPage signInPage;
	private RetailAccountPage accountPage;
	private RetailOrderPage orderPage;
	
	public POMFactory() {
		this.homePage = new RetailHomePage();
		this.signInPage = new RetailSignInPage();
		this.accountPage = new RetailAccountPage();
		this.orderPage = new RetailOrderPage();
	}
	
	
	public RetailHomePage homePage() {
		return this.homePage;
	}
	
	public RetailSignInPage signinPage() {
		return this.signInPage;
	}
	
	public RetailAccountPage accountPage() {
		return this.accountPage;
	}
	
	public RetailOrderPage orderPage() {
		return this.orderPage;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
