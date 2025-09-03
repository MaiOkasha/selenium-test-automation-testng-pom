package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentSection {

	private WebDriver driver;
	

	private By menuLocator = By.xpath("//*[@id=\"mobile-collapse\"]");
	By studentsTabLocator = By.xpath("//span[text()='Students']");
	
	By manageLoginTab = By.xpath("//*[@id=\"promotions\"]/a/span[2]");
	//*[@id="promotions"]/a/span[2]
	//By promoteTabLocator = By.xpath("//*[@id=\"promotions\"]/a/span[2]"); the path for manageLogin

	public StudentSection(WebDriver driver) {
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

	public void clickPromoteLogin() {
		WebElement promoteTab = driver.findElement(manageLoginTab);
		Actions actions = new Actions(driver);
		actions.moveToElement(promoteTab).click().perform();
	}

}
