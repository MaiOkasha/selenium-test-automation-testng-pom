package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StudentLoginPage {

	private WebDriver driver;

	By studentRole = By.xpath("//*[@id=\"signin-form\"]/div[1]/div/label[3]");
	By emailLocator = By.xpath("//input[@id=\"username\"]");
	By passwordLocator = By.xpath("//input[@id=\"password\"]");
	By loginBtn = By.xpath("//button[@id=\"submit\"]");

	public StudentLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String email, String password) {
		driver.findElement(studentRole).click();
		driver.findElement(emailLocator).sendKeys(email);;
		driver.findElement(passwordLocator).sendKeys(password);;
		driver.findElement(loginBtn).click();

	}

}
