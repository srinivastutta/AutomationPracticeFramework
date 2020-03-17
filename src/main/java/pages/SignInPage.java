package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.github.javafaker.Faker;

import base.TestBase;

public class SignInPage extends TestBase {
	public String HeaderName = "MY ACCOUNT";
	public String WellcomeMsg = "Welcome to your account";
	public String CurrentConMessage = "controller=my-account";

	@FindBy(id = "email_create")
	WebElement emailCreate;
	
	@FindBy(id = "SubmitCreate")
	WebElement submitCreate;
	
	@FindBy(id = "email")
	WebElement emailAddress;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitLogin;
		
	@FindBy(css = "h1")
	WebElement Header;
	
	@FindBy(className = "account")
	WebElement Account;
	
	@FindBy(className = "info-account")
	WebElement infoAccount;
	
	@FindBy(className = "logout")
	WebElement Logout;


	public SignInPage() {
		PageFactory.initElements(driver, this);

	}

	public String ValidateSearchPageTitle() {
		return driver.getTitle();
	}

	
	public void EnterEmailToCreateAccount() {
		Faker faker = new Faker();
		String RandomEmail= faker.internet().emailAddress();
		emailCreate.sendKeys(RandomEmail);
		submitCreate.click();
	}
	
	public void SignOut() {
		ExplicitWait(driver, 5, Logout);
	}
	
	public void Login(String email, String Passwd) {
		
		emailAddress.sendKeys(email);
		password.sendKeys(Passwd);
		submitLogin.click();
		
		
		String CurentURL = driver.getCurrentUrl();
		
		Assert.assertEquals(Header.getText(), HeaderName);
		Assert.assertEquals(Account.getText(), prop.getProperty("username"));
		
		assertTrue(infoAccount.getText().contains(WellcomeMsg));
		assertTrue(Logout.isDisplayed());
		assertTrue(CurentURL.contains(CurrentConMessage));
		

	}
	
}