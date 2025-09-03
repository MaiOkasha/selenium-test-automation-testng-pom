package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PromoteStudentPage {

	private WebDriver driver;

	By searchLocator = By.cssSelector("input.m-field.form-control[placeholder='Search Student']");
	By selectClassLocator = By.xpath("//*[@id=\"myform\"]/div/div/div[1]");
	By choiceLocator = By.xpath("//*[@id=\"ui-id-2\"]/li");
	By checkboxLocator = By.xpath("//*[@id=\"example\"]/tbody/tr/td[4]/input");
	By selectPromotedClassLocator = By.xpath(
			"//*[@id=\"pcoded\"]/div[2]/div[2]/div/div/div/div/div/div/div[3]/div[3]/div/div/div/div[1]/div/div[1]");
	By saveChangesLocator = By.xpath("//*[@id=\"submitBtn\"]");

	public PromoteStudentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchByName(String name) {
		driver.findElement(searchLocator).clear();
		driver.findElement(searchLocator).click();
		driver.findElement(checkboxLocator).sendKeys(name);
		driver.findElement(choiceLocator).click();
	}

	public void clickCheckbox() {
		driver.findElement(checkboxLocator).click();
	}

	public void promoteIn(String className) {
		driver.findElement(selectPromotedClassLocator).sendKeys(className);
		driver.findElement(selectPromotedClassLocator).sendKeys(Keys.ENTER);

	}

	public void clickSaveBtn() {
		driver.findElement(saveChangesLocator).click();
	}

	public void doPromote(String name, String className) {
		searchByName(name);
		clickCheckbox();
		promoteIn(className);
		clickSaveBtn();

	}

}
