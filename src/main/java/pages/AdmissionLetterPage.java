package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdmissionLetterPage {

	private WebDriver driver;
	private String username;
	private String password;

	By tableLocator = By.cssSelector(".table-striped.f-12.m-round");
	By usernameLocator = By.xpath("//tr[td[text()='Username']]/td[2]/b");
	By passwordLocator = By.xpath("//tr[td[text()='Password']]/td[2]/b");

	public AdmissionLetterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void captureCredentials() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tableLocator));


		this.username = driver.findElement(usernameLocator).getText();
		this.password = driver.findElement(passwordLocator).getText();
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}