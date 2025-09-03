package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

	private WebDriver driver;

	By menuLocator = By.xpath("//*[@id=\"pcoded\"]/div[2]/nav/div/div[2]/ul[2]/li[7]/a/i");
	// By menuLocator =
	// By.xpath("//*[@id=\"pcoded\"]/div[2]/nav/div/div[2]/ul[2]/li[7]/ul");
	By logoutLocator = By.xpath("//*[@id=\"pcoded\"]/div[2]/nav/div/div[2]/ul[2]/li[7]/ul/li[3]");
	//// a[normalize-space()='Logout' and @href='logout.php']
	/// By logoutLinkLocator = By.cssSelector("a[href='logout.php']");

	public LogoutPage(WebDriver driver) {
		this.driver = driver;

	}

	public void clickMenu() {
		driver.findElement(menuLocator).click();
		;
	}

	public void clickLogout() {
		driver.findElement(logoutLocator).click();
	}

	public void logout() throws InterruptedException {
		clickMenu();
		//Thread.sleep(2000);

		clickLogout();

	}

}
