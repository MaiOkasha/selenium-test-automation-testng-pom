package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.*;

public class TestBase {

	    protected WebDriver driver;
	    protected Actions action;
	    protected String baseUrl = "https://www.eskooly.com/bb/signin.php"; // website URL

	    @BeforeClass
	    public void setup() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        action = new Actions(driver);
	        
	        driver.manage().window().maximize();

	        // Open website at the start
	        driver.get(baseUrl);
	    }

	    @AfterClass
	    public void tearDown() throws InterruptedException {
	        if (driver != null) {
	        	Thread.sleep(3000);
	            driver.quit();
	        }
	    }
	}

  

