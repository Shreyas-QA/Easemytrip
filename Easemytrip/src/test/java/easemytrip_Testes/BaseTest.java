package easemytrip_Testes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.collections.Lists;



public class BaseTest {

	
	public WebDriver driver;

	@Parameters({ "browser" }) // chrome
	@BeforeClass
	public void initialize(String browserName) throws Exception {

		System.out.println(browserName);
		// Check if parameter passed from TestNG is 'firefox'
		if (browserName.equalsIgnoreCase("firefox")) {
			// create firefox instance
			System.setProperty("webdriver.gecko.driver", "/opt/homebrew/bin/geckodriver");
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");
			// create chrome instance
			driver = new ChromeDriver(options);

		}
		// Check if parameter passed as 'Edge'
		else if (browserName.equalsIgnoreCase("Edge")) {
			// set path to Edge.exe
			System.setProperty("webdriver.edge.driver", ".\\MicrosoftWebDriver.exe");
			// create Edge instance
			driver = new EdgeDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.easemytrip.com/flights.html");

	}

	@AfterSuite
	// Test cleanup
	public void TeardownTest() {
		
		driver.quit();
	}

	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("/Users/shreyassambare/eclipse-workspace/Easemytrip/TestNg.xml");// path to
																											// xml..

		testng.setTestSuites(suites);
		testng.run();
	}
}
