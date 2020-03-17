package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import util.TestUtil;;

public class TestBase extends TestUtil {
	public static WebDriver driver;
	public static Properties prop;

	public static void InitProp() throws IOException {
		prop = new Properties();
		FileInputStream fi = new FileInputStream("src/main/java/config/config.properties");
		prop.load(fi);

	}

	
	public void Initialization(String myBrowser) {
		if (System.getProperty("os.name").contains("Window")) {
			System.out.println(System.getProperty("os.name"));
			if (myBrowser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
				driver = new ChromeDriver();
				Reporter.log("Running test in : " +myBrowser);
			} else if (myBrowser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
				driver = new FirefoxDriver();
				Reporter.log("Running test in : " +myBrowser);
			} else if (myBrowser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				Reporter.log("Running test in : " +myBrowser);
			}

		} else if (System.getProperty("os.name").contains("Mac")) {
			System.out.println(System.getProperty("os.name"));
			if (myBrowser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
				driver = new ChromeDriver();
				Reporter.log("Running test in : " +myBrowser);
			} else if (myBrowser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
				driver = new FirefoxDriver();
				Reporter.log("Running test in : " +myBrowser);
			} else if (myBrowser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer");
				driver = new InternetExplorerDriver();
				Reporter.log("Running test in : " +myBrowser);
			}
}
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				driver.get(prop.getProperty("url"));

} 

	public static void ExplicitWait(WebDriver driver, int timeout, WebElement element) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();

	}
	
	public static void failedTestCase(String testMethodName) {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File ("screenshots/"+testMethodName+"_"+".jpg"));
		} catch (IOException e) {
		  e.printStackTrace();
		  e.getMessage();
		}
}
	

	public void CloseBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
