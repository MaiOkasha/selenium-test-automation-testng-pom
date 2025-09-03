package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentCardPage {

	private WebDriver driver;

	private By menuLocator = By.xpath("//*[@id=\"mobile-collapse\"]");
	By studentsTabLocator = By.xpath("//span[text()='Students']");
	By allStudentLocator = By.xpath("//*[@id=\"allstudents\"]/a/span[2]");
	By cardLocator = By.xpath("//input[@name='id' and @value='23']/following-sibling::button[@name='sview']");
	By viewButton = By.xpath("//input[@name='id' and @value='23']/following-sibling::button[@name='sview']");
	By title = By.xpath("//*[@id=\"pcoded\"]/div[2]/div[2]/div/div/div/div/div/div/div[1]/div");

	public StudentCardPage(WebDriver driver) {
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
	}

	public void clickAllStudents() {
		driver.findElement(allStudentLocator).click();
	}

	public void clickStudentCard() {
		driver.findElement(cardLocator).click();

	}

	public void clickViewButton() {
		driver.findElement(viewButton).click();
	}
	
	public void getTitle() {
		driver.findElement(title).getText();
		System.out.println(driver.findElement(title).getText());
	}

}
