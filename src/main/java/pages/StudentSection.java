package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentSection {

	private WebDriver driver;
	private Actions action;

	private By menuLocator = By.xpath("//*[@id=\"mobile-collapse\"]");
	By studentsTabLocator = By.xpath("//span[text()='Students']");
	By allStudentLocator = By.xpath("//*[@id=\"allstudents\"]/a/span[2]");
	By addNewStudentLocator = By.xpath("//*[@id=\"addnewstudent\"]/a/span[2]");
	By addmisionLetterLocator = By.xpath("//*[@id=\"searchadmissionletter\"]/a/span[2]");
	By studentCardIdLocator = By.xpath("//*[@id=\"idcard\"]/a/span[2]");
	By manageLoginLocator = By.xpath("//*[@id=\"slogin\"]/a/span[2]");
	By promoteStudentsLocator = By.xpath("//*[@id=\"promotions\"]/a/span[2]");
	By manageLoginTab = By.xpath("//*[@id=\"promotions\"]/a/span[2]");
	By printBasicListLocator = By.xpath("//span[@class='pcoded-mtext' and text()='Print Basic List']");
	// *[@id="promotions"]/a/span[2]
	// By promoteTabLocator = By.xpath("//*[@id=\"promotions\"]/a/span[2]"); the
	// path for manageLogin

	public StudentSection(WebDriver driver, Actions action) {
		this.driver = driver;
		this.action = action;
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement allStudentsTab = wait.until(ExpectedConditions.elementToBeClickable(allStudentLocator));
		allStudentsTab.click();
	}

	/*
	 * public void clickPrintBasicList() { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(30)); WebElement printBasicListTab =
	 * wait.until(ExpectedConditions.elementToBeClickable(printBasicListLocator));
	 * printBasicListTab.click(); }
	 */

	public void clickPrintBasicList() {

		clickMenu();

		for (int i = 0; i < 3; i++) {
			try {
				WebElement printBtn = driver.findElement(printBasicListLocator);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", printBtn);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", printBtn);
				break;
			} catch (org.openqa.selenium.ElementClickInterceptedException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException ignored) {
				}
			}
		}
	}

	/*
	 * for mouse hover on the tap public void clickAllStudents() { WebDriverWait
	 * wait = new WebDriverWait(driver, Duration.ofSeconds(30)); WebElement
	 * allStudentsTab =
	 * wait.until(ExpectedConditions.elementToBeClickable(allStudentLocator));
	 * Actions actions = new Actions(driver);
	 * actions.moveToElement(allStudentsTab).click().perform(); }
	 */

	public void clickAddNewStudent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement addNewStudentTab = wait.until(ExpectedConditions.elementToBeClickable(addNewStudentLocator));
		action.moveToElement(addNewStudentTab).click().perform();
	}

	public void clickAdmisionLetter() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement admisionLetterTab = wait.until(ExpectedConditions.elementToBeClickable(addmisionLetterLocator));
		action.moveToElement(admisionLetterTab).click().perform();

	}

	// Add for the other if needed

	/*
	 * public void clickAddNewStudent() {
	 * driver.findElement(addNewStudentLocator).click(); }
	 */

	/*
	 * public void clickAllStudents() { WebElement allStudentsTab =
	 * driver.findElement(allStudentLocator); WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(30));
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(allStudentLocator));
	 * driver.findElement(allStudentLocator).click();
	 * 
	 * //Or //WebElement promoteTab = driver.findElement(manageLoginTab);
	 * //action.moveToElement(promoteTab).click().perform();
	 * 
	 * }
	 */

	public void clickPromoteLogin() {
		WebElement promoteTab = driver.findElement(manageLoginTab);
		action.moveToElement(promoteTab).click().perform();
	}

}
