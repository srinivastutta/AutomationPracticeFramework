package testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import jxl.read.biff.BiffException;
import listener.CustomListener;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SignInPage;
import util.TestUtil;

@Listeners(CustomListener.class)
public class SignInTest extends TestBase {
	HomePage homePage;
	SignInPage signInPage;
	RegistrationPage registrationPage;

	@BeforeMethod
	@Parameters("myBrowser")
	public void Setup(String myBrowser) throws IOException {
		InitProp();
		Initialization(myBrowser);
		homePage = new HomePage();
		signInPage = new SignInPage();
		registrationPage = new RegistrationPage();
	}

	@DataProvider
	public Iterator<Object[]> GetTestData() throws BiffException, IOException {
		ArrayList<Object[]> testdata = TestUtil.getDataFromExcel();
		return testdata.iterator();
	}

	@Test(dataProvider = "GetTestData")
	public void SignIn_Test(String CustomerName, String CustomerLastName, String Password, String SelectDay,
			String SelectMonth, String SelectYear, String Comp, String Add1, String Add2, String city, String state,
			String PostCode, String other, String phone, String MobilePhone, String alias)
			throws BiffException, IOException {

		homePage.ClickOnSignInButton();
		signInPage.EnterEmailToCreateAccount();
		registrationPage.FillRegistrationForm(CustomerName, CustomerLastName, Password, SelectDay, SelectMonth,
		SelectYear, Comp, Add1, Add2, city, state, PostCode, other, phone, MobilePhone, alias);

	}

	@AfterMethod
	public void TearDown() {
		CloseBrowser();

	}
}
