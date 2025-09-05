package pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class ClassesPage {

	private WebDriver driver;
	private Actions action;
	private WebDriverWait wait;

//    constructor
	public ClassesPage(WebDriver driver) {
		this.driver = driver;
//         PageFactory.initElements(driver, this);
	}

//        aِdmin login page locators 
	private By username = By.xpath("//*[@id=\"username\"]");
	private By password = By.xpath("//*[@id=\"password\"]");
	private By loginbtn = By.xpath("//*[@id=\"submit\"]");

//	 login page method
	public void login(String user, String pass) throws InterruptedException {

		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginbtn).click();
		;

	}

//	 All Classes page  locators 
	private By menu = By.xpath("//*[@id=\"mobile-collapse\"]");
	private By classes = By.xpath("//*[text()=\"Classes\"]");
	private By allclasses = By.xpath("//*[text()=\"All Classes\"]");
	private By adde_button_in_allclasses = By.xpath("//*[@class=\"ti-plus\"]");

//	 Edit class section
	private By edit_class_name = By.xpath("//*[@placeholder=\"Class Name\"]");
	private By edit_class_fees = By.xpath("//*[@placeholder=\"Monthly Fees\"]");
	private By edit_class_teacher = By.xpath("//*[@id=\"searchlist\"]");
	private By update_button = By.xpath("//*[@id=\"submitBtn\"]");

//	 This method to click edit on class you want 
	public void Edit_class() throws InterruptedException {
//		 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement editIcon = driver
				.findElement(By.xpath("//h6[contains(text(),'Grade 4')]/a/i[contains(@class,'ti-pencil')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editIcon);
		driver.findElement(edit_class_name).clear();
		driver.findElement(edit_class_name).sendKeys("Grad 13");
		driver.findElement(edit_class_fees).clear();
		driver.findElement(edit_class_fees).sendKeys("242");
//		    driver.findElement(class_teacher_dropdown).sendKeys("");;
//		    driver.findElement(class_teacher_dropdown).sendKeys(Keys.RETURN);
		driver.findElement(update_button).click();
		// Assert that the updated class "Grad 13" exists on the page
		WebElement editedClass = driver.findElement(By.xpath("//h6[contains(text(),'Grad 13')]"));
		Assert.assertNotNull(editedClass, "Class name was not updated to 'Grad 6'.");
		System.out.println(editedClass);
	}

//	 This method delete any class you want  
	public void delete_class() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement deleteIcon = driver
				.findElement(By.xpath("//h6[contains(text(),'Grade 1')]//i[contains(@class,'ti-trash')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteIcon);
		WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[contains(@class,'modal-footer')]//button[contains(text(),'Yes') or contains(text(),'Delete')]")));
		confirmButton.click();
		// Assert that the delete class "Grad 13" exists on the page
		WebElement deletedClass = driver.findElement(By.xpath("//h6[contains(text(),'Grad 13')]"));
		Assert.assertNotNull(deletedClass, "Class name was not updated to 'Grad 6'.");
		System.out.println(deletedClass);
	}

//   Add New Class page Locators
	private By class_name = By.xpath("//*[@id=\"classname\"]");
	private By fees = By.xpath("//*[@name=\"fees\"]");
//	 private By class_teacher = By.xpath("//*[@name=\"teacher\"]");
	private By class_teacher_dropdown = By.xpath("//*[@placeholder=\"Select*\"]");
	private By create_button = By.xpath("//*[@id=\"submitBtn\"]");

//	 data provider to fill in class form 
	@DataProvider(name = "class_Data")
	public static Object[][] loginData() {
		return new Object[][] { { "Grade 1", "300", "Arlinda Deshon" }, { "Grade 2", "500", "Alysa Aimeric" },
				{ "Grade 3", "700", "Dehlia Chapman" }, { "Grade 4", "900", "Erroll Scamerden" },
				{ "Grade 5", "300", "Nappie Bradnam" }, { "Grade 6", "500", "Penny Loudon" },
				{ "Grade 7", "200", "Arlinda Deshon" }, { "Grade 8", "100", "Alysa Aimeric" },
				{ "Grade 9", "500", "Dehlia Chapman" }, { "Grade 10", "900", "Erroll Scamerden" },
				{ "Grade 11", "300", "Nappie Bradnam" }, { "Grade 12", "500", "Penny Loudon" },

		};
	}

//	 this method to navigate to all classes 
	public void allclasses() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
		driver.findElement(menu).click();
		driver.findElement(classes).click();
//		    driver.findElement(classes).click();

		driver.findElement(allclasses).click();

	}

	public void addnew_Class(String classname, String feesf, String teacher) {

		driver.findElement(adde_button_in_allclasses).click();
		driver.findElement(class_name).sendKeys(classname);
		driver.findElement(fees).sendKeys(feesf);
		driver.findElement(class_teacher_dropdown).sendKeys(teacher);
		;
		driver.findElement(class_teacher_dropdown).sendKeys(Keys.RETURN);
		driver.findElement(create_button).click();
//		    wait.until(ExpectedConditions.visibilityOfElementLocated(adde_button_in_allclasses));

	}
}