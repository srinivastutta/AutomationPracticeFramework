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
import pages.MyAccountPage;
import pages.SignInPage;

@Listeners(CustomListener.class)
public class CheckOutTest extends TestBase{
	HomePage homePage;
	SignInPage signInPage;
	MyAccountPage myAccountPage;
	
	
	@BeforeMethod
	@Parameters("myBrowser")
	public void Setup(String myBrowser) throws IOException {
		InitProp();
		Initialization(myBrowser);
		homePage = new HomePage();
		signInPage = new SignInPage();
		myAccountPage = new MyAccountPage();
	}

	@Test
	public void Check_Out_Test()  {
		homePage.ClickOnSignInButton();
		signInPage.Login(prop.getProperty("userid"), prop.getProperty("password"));
		myAccountPage.CheckOut();
		
	}

	@AfterMethod
	public void TearDown() {
	CloseBrowser();

	}
}
