package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {

	private WebDriver driver;

	By AdminRoleLocator = By.xpath("//*[@id=\"signin-form\"]/div[1]/div/label[1]/i");
	By emailLocator = By.xpath("//input[@id=\"username\"]");
	By passwordLocator = By.xpath("//input[@id=\"password\"]");
	By loginBtn = By.xpath("//button[@id=\"submit\"]");

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnAdminRole() {
		driver.findElement(AdminRoleLocator).click();
	}

	public void enterEmail(String email) {
		driver.findElement(emailLocator).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}

	public void login(String email, String password) {
		clickOnAdminRole();
		enterEmail(email);
		enterPassword(password);
		clickLogin();
	}

}
