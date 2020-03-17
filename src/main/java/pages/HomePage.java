package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@class='login']")
	WebElement SignIn;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String ValidateSearchPageTitle() {
		return driver.getTitle();
	}

	public void ClickOnSignInButton() {
		Actions act= new Actions(driver);
		act.moveToElement(SignIn).click().build().perform();
		
	}
	
}