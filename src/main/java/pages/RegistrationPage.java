package pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.TestBase;
import jxl.read.biff.BiffException;


public class RegistrationPage extends TestBase {
	
	public String HeaderName = "MY ACCOUNT";
	public String WellcomeMsg = "Welcome to your account";
	public String CurrentConMessage = "controller=my-account";
	
	@FindBy(id = "id_gender")
	WebElement GenderMale;
	
	@FindBy(id = "customer_firstname")
	WebElement customerFirstname;
	
	@FindBy(id = "customer_lastname")
	WebElement customerLastname;
	
	@FindBy(id = "passwd")
	WebElement Passwd;

	@FindBy(id = "days")
	WebElement Days;

	@FindBy(id = "months")
	WebElement Months;
	
	@FindBy(id = "years")
	WebElement Years;
	
	@FindBy(id = "company")
	WebElement Company;
	
	@FindBy(id = "address1")
	WebElement Address1;
	
	@FindBy(id = "address2")
	WebElement Address2;
	
	@FindBy(id = "city")
	WebElement City;
	
	@FindBy(id = "id_state")
	WebElement State;
	
	@FindBy(id = "postcode")
	WebElement Postcode;
	
	@FindBy(id = "other")
	WebElement Other;
	
	@FindBy(id = "phone")
	WebElement Phone;
	
	@FindBy(id = "phone_mobile")
	WebElement phoneMobile;
	
	@FindBy(id = "alias")
	WebElement Alias;
	
	@FindBy(id = "submitAccount")
	WebElement SubmitAccount;
	
	@FindBy(css = "h1")
	WebElement Header;
	
	@FindBy(className = "account")
	WebElement Account;
	
	@FindBy(className = "info-account")
	WebElement infoAccount;
	
	@FindBy(className = "logout")
	WebElement Logout;
	
		
	public RegistrationPage() {
		PageFactory.initElements(driver, this);

	}

	public void FillRegistrationForm ( String CustomerName , String CustomerLastName, String Password,
			String SelectDay, String SelectMonth, String SelectYear, String Comp, String Add1,
			String Add2, String city, String state, String PostCode, String other, String phone,
			String MobilePhone, String alias) throws BiffException, IOException {
		
		
		customerFirstname.sendKeys(CustomerName);
		customerLastname.sendKeys(CustomerLastName);
		Passwd.sendKeys(Password);
		Select day = new Select(Days);
		day.selectByValue(SelectDay);
		Select month = new Select(Months);
		month.selectByValue(SelectMonth);
		Select year = new Select(Years);
		year.selectByValue(SelectYear);
		Company.sendKeys(Comp);
		Address1.sendKeys(Add1);
		Address2.sendKeys(Add2);
		City.sendKeys(city);
		Select stat= new Select(State);
		stat.selectByVisibleText(state);
		Postcode.sendKeys(PostCode);
		Other.sendKeys(other);
		Phone.sendKeys(phone);
		phoneMobile.sendKeys(MobilePhone);
		Alias.sendKeys(alias);
		SubmitAccount.click();
		String CurentURL = driver.getCurrentUrl();
		
		
		Assert.assertEquals(Header.getText(), HeaderName);
		Assert.assertEquals(Account.getText(), CustomerName+ " " + CustomerLastName);
		
		assertTrue(infoAccount.getText().contains(WellcomeMsg));
		assertTrue(Logout.isDisplayed());
		assertTrue(CurentURL.contains(CurrentConMessage));
		
	}
	
}