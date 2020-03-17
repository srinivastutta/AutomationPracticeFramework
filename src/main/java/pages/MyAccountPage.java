package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;

public class MyAccountPage extends TestBase {
	public String CurrentConMessage = "controller=order-confirmation";
	public String OrderStatusMessage = "Your order on My Store is complete.";

	@FindBy(css = "h1")
	WebElement Header;

	@FindBy(className = "account")
	WebElement Account;

	@FindBy(className = "info-account")
	WebElement infoAccount;

	@FindBy(className = "logout")
	WebElement Logout;

	@FindBy(linkText = "Women")
	WebElement women;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
	WebElement FadedShortSleeveTshirts;

	@FindBy(xpath = "//button[@name='Submit']")
	WebElement AddToCart;

	@FindBy(xpath = "//*[@class='btn btn-default button button-medium']")
	WebElement ProceedToCheckOut1;

	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement ProceedToCheckOut2;

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement ProceedToCheckOut3;

	@FindBy(xpath = "//*[@id='cgv']")
	WebElement TermsOfService;

	@FindBy(xpath = "//*[@class='button btn btn-default standard-checkout button-medium']")
	WebElement ProceedToCheckOut4;

	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement PayByBankWire;

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement ConfirmMyOrder;

	@FindBy(xpath = "//*[@class='cheque-indent']/strong")
	WebElement OrderStatus;

	@FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
	WebElement FinalStep;

	public MyAccountPage() {
		PageFactory.initElements(driver, this);

	}

	public void CheckOut() {

		ExplicitWait(driver, 5, women);
		ExplicitWait(driver, 5, FadedShortSleeveTshirts);
		ExplicitWait(driver, 5, AddToCart);
		ExplicitWait(driver, 5, ProceedToCheckOut1);
		ExplicitWait(driver, 5, ProceedToCheckOut2);
		ExplicitWait(driver, 5, ProceedToCheckOut3);

		TermsOfService.click();
		ProceedToCheckOut4.click();
		PayByBankWire.click();
		ConfirmMyOrder.click();
			
		String CurentURL = driver.getCurrentUrl();

		assertTrue(CurentURL.contains(CurrentConMessage));
		OrderStatus.getText().contains(OrderStatusMessage);
		assertTrue(FinalStep.isDisplayed());
		ExplicitWait(driver, 5, Logout);
	}

}
