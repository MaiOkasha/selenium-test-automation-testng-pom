package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddStudentSection {

	private WebDriver driver;

	private By menuLocator = By.xpath("//*[@id=\"mobile-collapse\"]");
	By studentsTabLocator = By.xpath("//span[text()='Students']");
	
	By addNewStudentLocator = By.xpath("//*[@id=\"addnewstudent\"]/a/span[2]");

	public AddStudentSection(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMenu() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuLocator)).click();
		driver.findElement(menuLocator).click();

	}

	public void clickStudentsSection() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(studentsTabLocator));
		driver.findElement(studentsTabLocator).click();
		;
	}

	public void clickAddNewStudent() {
		driver.findElement(addNewStudentLocator).click();
	}

}
