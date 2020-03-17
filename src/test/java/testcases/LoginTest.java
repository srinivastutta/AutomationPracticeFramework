package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestBase;
import listener.CustomListener;
import pages.HomePage;
import pages.SignInPage;

@Listeners(CustomListener.class)
public class LoginTest extends TestBase{
	HomePage homePage;
	SignInPage signInPage;
	
	@BeforeMethod
	@Parameters("myBrowser")
	public void Setup(String myBrowser) throws IOException {
		InitProp();
		Initialization(myBrowser);
		homePage = new HomePage();
		signInPage = new SignInPage();
	}

	@Test
	public void Login_Test()  {
		homePage.ClickOnSignInButton();
		signInPage.Login(prop.getProperty("userid"), prop.getProperty("password"));
		signInPage.SignOut();
	}

	@AfterMethod
	public void TearDown() {
	CloseBrowser();

	}
}
