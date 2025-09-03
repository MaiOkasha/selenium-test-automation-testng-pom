package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdmissionFormPage {

	private WebDriver driver;

	By studentNameLocator = By.xpath("//input[@placeholder='Name of Student']");
	By regestrationNoLocator = By.xpath("//input[@id=\"reg\"]");
	By dateOfAdmissionLocator = By.xpath("//input[@name='doa']");
	By classNameLocator = By.cssSelector("#searchlist-selectized");
	By discountInFeeLocator = By.xpath("//input[@name='discount' and @placeholder='In %']");
	//By submitBtn = By.xpath("//button[contains(@style,'border-radius:20px') and contains(@style,'width:170px')]");

	public AdmissionFormPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterStudentName(String studentName) {
		driver.findElement(studentNameLocator).sendKeys(studentName);
		System.out.println("Name is entered ");

	}

	public void enterRegestrationNo(int regNo) {
		driver.findElement(regestrationNoLocator).sendKeys(String.valueOf(regNo));
		System.out.println("RegNo is entered ");
	}

	public void selectClassNameJS(String className) {
		WebElement classNameInput = driver.findElement(classNameLocator);
		classNameInput.clear();
		classNameInput.sendKeys(className);
		classNameInput.sendKeys(Keys.RETURN);
		System.out.println("Class Name is entered ");

	}

	public void selectDateOfAdmission(String date) {
		WebElement dateInput = driver.findElement(dateOfAdmissionLocator);
		dateInput.clear();
		dateInput.sendKeys(date);
		dateInput.sendKeys(Keys.RETURN);
		System.out.println("Date is entered ");
	}

	public void enterDiscount(int discount) {
		WebElement discountNo = driver.findElement(discountInFeeLocator);
		discountNo.clear();
		discountNo.sendKeys(String.valueOf(discount));
		discountNo.sendKeys(Keys.RETURN);
		System.out.println("Discount Number is entered ");
	}

	

	public void fillForm(String studentName, int regNo, String date, String className, int discount) {
		enterStudentName(studentName);
		enterRegestrationNo(regNo);
		selectClassNameJS(className);
		selectDateOfAdmission(date);
		enterDiscount(discount);
		
	}

}
