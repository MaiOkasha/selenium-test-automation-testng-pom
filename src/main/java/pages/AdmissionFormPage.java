package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdmissionFormPage {

	private WebDriver driver;

	By studentNameLocator = By.xpath("//input[@id=\"studentname\"]");
	By regestrationNoLocator = By.xpath("//input[@id=\"reg\"]");
	By dateOfAdmissionLocator = By.xpath("//input[@name='doa']");
	By classNameLocator = By.cssSelector("#searchlist-selectized");
	By discountInFeeLocator = By.xpath("//input[@id=\"searchlist-selectized\"]");
	By submitBtn = By.xpath("//button[@id=\"submitBtn\"]");

	public AdmissionFormPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterStudentName(String studentName) {
		driver.findElement(studentNameLocator).sendKeys(studentName);
	}

	public void enterRegestrationNo(int regNo) {
		driver.findElement(regestrationNoLocator).sendKeys(String.valueOf(regNo));
	}

	public void selectDateOfAdmission(String date) {
		driver.findElement(dateOfAdmissionLocator).clear();
		driver.findElement(dateOfAdmissionLocator).sendKeys(date);
	}

	public void selectClassNameJS(String className) {
		WebElement input = driver.findElement(classNameLocator);
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].value='" + className + "';" + "arguments[0].dispatchEvent(new Event('input'));"
						+ "arguments[0].dispatchEvent(new Event('change'));",
				input);
	}

}
