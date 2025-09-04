package pages;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchByNameFromAllStudentsPage {

	private WebDriver driver;

	By searchBtn = By.xpath("//*[@id=\"show\"]");
	By searchStudentLocator = By.xpath("//*[@id=\"tags1\"]");
	By studentNamefromDropdown = By.xpath("//*[@id=\"ui-id-13\"]");
	By nameLocator = By.xpath("//*[@id=\"pcoded\"]/div[2]/div[2]/div/div/div/div/div/div/div[3]/div/b");
	By viewBtnLocator = By.xpath("//button[@name='sview']");
	By editBtnLocator = By.xpath("//button[@name='sedit']");
	By deleteBtnLocator = By.cssSelector("button[name='sdelete']");
	public By studentNameLocator = By.xpath("//*[@id=\"studentname\"]");

	public SearchByNameFromAllStudentsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSearchBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.ignoring(StaleElementReferenceException.class, NoSuchElementException.class).until(d -> {
			try {
				WebElement btn = d.findElement(searchBtn);
				if (btn.isDisplayed() && btn.isEnabled()) {
					btn.click();
					return true;
				}
				return false;
			} catch (Exception e) {
				return false;
			}
		});
	}

	public void seachByName(String name) {
		driver.findElement(searchStudentLocator).sendKeys(name);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

	}

	public void getName() {
		driver.findElement(nameLocator).getText();
	}
	
	public void clickEditBtn() throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        // The wait.until() method itself throws TimeoutException,
		// so the try-catch block must wrap this method call.
		WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(editBtnLocator));
		editBtn.click();
		System.out.println("Clicked 'Edit' button successfully.");
    }

	/*
	 * public void clickEditBtn() throws InterruptedException { Thread.sleep(5000);
	 * driver.findElement(editBtnLocator).click(); Thread.sleep(3000);
	 * 
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	 * 
	 * wait.ignoring(StaleElementReferenceException.class).until(driver -> {
	 * driver.findElement(editBtnLocator).click(); return true; });
	 * 
	 * 
	 * 
	 * WebElement studentNameField =
	 * wait.ignoring(StaleElementReferenceException.class) .until(d ->
	 * d.findElement(studentNameLocator));
	 * 
	 * driver.findElement(editBtnLocator).clear(); Thread.sleep(3000);
	 * 
	 * driver.findElement(editBtnLocator).sendKeys(" Lana Mohammed");
	 * Thread.sleep(3000);
	 * 
	 * driver.findElement(editBtnLocator).sendKeys(Keys.RETURN); }
	 */
	public void clickViewBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// StaleElementReferenceException
		wait.ignoring(StaleElementReferenceException.class).until(driver -> {
			WebElement viewBtn = driver.findElement(viewBtnLocator);
			if (viewBtn.isDisplayed() && viewBtn.isEnabled()) {
				((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", viewBtn);
				return true; // clicked successfully
			}
			return false; // retry if not clickable yet
		});

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.view-student-container")));

		System.out.println("Clicked View button successfully.");
	}

	/*
	 * public void clickViewBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(40));
	 * 
	 * // Retry using JS click to avoid hover-only issues
	 * wait.ignoring(StaleElementReferenceException.class) .until(driver -> {
	 * WebElement viewBtn = driver.findElement(viewBtnLocator);
	 * if(viewBtn.isDisplayed() && viewBtn.isEnabled()) {
	 * ((org.openqa.selenium.JavascriptExecutor) driver)
	 * .executeScript("arguments[0].click();", viewBtn); return true; // clicked
	 * successfully } return false; // retry if not clickable });
	 * 
	 * // Wait until the student name is visible after clicking View WebElement
	 * studentNameField = wait.ignoring(StaleElementReferenceException.class)
	 * .until(d -> d.findElement(studentNameLocator));
	 * 
	 * System.out.println("Viewed student: " + studentNameField.getText()); }
	 */

	/*
	 * public void clickViewBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(40));
	 * 
	 * // Retry clicking using Actions until it works
	 * wait.ignoring(StaleElementReferenceException.class) .until(driver -> {
	 * WebElement viewBtn = driver.findElement(viewBtnLocator);
	 * 
	 * if(viewBtn.isDisplayed() && viewBtn.isEnabled()) { // Move mouse to element
	 * and click new Actions(driver).moveToElement(viewBtn).click().perform();
	 * return true; } return false; });
	 * 
	 * // Wait until the student name is visible after clicking View WebElement
	 * studentNameField = wait.ignoring(StaleElementReferenceException.class)
	 * .until(d -> d.findElement(studentNameLocator));
	 * 
	 * System.out.println("Viewed student: " + studentNameField.getText()); }
	 */

	/*
	 * public void clickViewBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(40));
	 * 
	 * // Retry clicking the View button until it succeeds, ignoring stale element
	 * wait.ignoring(StaleElementReferenceException.class) .until(driver -> {
	 * WebElement viewBtn = driver.findElement(viewBtnLocator);
	 * if(viewBtn.isDisplayed() && viewBtn.isEnabled()) { viewBtn.click(); return
	 * true; } return false; });
	 * 
	 * // Wait explicitly until the student name element is visible on the View page
	 * WebElement studentNameField = wait.until(
	 * ExpectedConditions.visibilityOfElementLocated(studentNameLocator) );
	 * 
	 * // Optional: print student name String studentName =
	 * studentNameField.getText(); System.out.println("Viewed student: " +
	 * studentName); }
	 */

	/*
	 * public void clickViewBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(40));
	 * 
	 * // Retry clicking the View button until it succeeds, ignoring stale element
	 * wait.ignoring(StaleElementReferenceException.class) .until(driver -> {
	 * WebElement viewBtn = driver.findElement(viewBtnLocator);
	 * 
	 * // Ensure the button is clickable if(viewBtn.isDisplayed() &&
	 * viewBtn.isEnabled()) { viewBtn.click(); return true; // clicked successfully
	 * } return false; // retry if not clickable yet });
	 * 
	 * // Optional: wait until student details are visible in the view page
	 * WebElement studentNameField =
	 * wait.ignoring(StaleElementReferenceException.class) .until(d ->
	 * d.findElement(studentNameLocator));
	 * 
	 * String studentName = studentNameField.getText();
	 * System.out.println("Viewed student: " + studentName); }
	 * 
	 */
	/*
	 * public void goBackToAllStudentsPage() { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(20));
	 * 
	 * driver.navigate().back();
	 * 
	 * // wait until search box is visible again to make sure we are on the right
	 * page
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(searchStudentLocator
	 * )); }
	 */

	/*
	 * public void clickEditBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(40));
	 * 
	 * // Retry clicking the Edit button
	 * wait.ignoring(StaleElementReferenceException.class) .until(driver -> {
	 * driver.findElement(editBtnLocator).click(); return true; });
	 * 
	 * // Retry finding the student name field WebElement studentNameField =
	 * wait.ignoring(StaleElementReferenceException.class) .until(d ->
	 * d.findElement(studentNameLocator));
	 * 
	 * studentNameField.clear(); studentNameField.sendKeys(" Lana Mohammed");
	 * studentNameField.sendKeys(Keys.RETURN);
	 * 
	 * //After editing, navigate back to All Students page driver.navigate().back();
	 * 
	 * // Optional: wait until the search box is visible again to ensure we are back
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(searchStudentLocator
	 * )); }
	 */

	// True Code
	/*
	 * public void clickEditBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(40));
	 * 
	 * // Retry clicking the Edit button until it succeeds, // ignoring
	 * StaleElementReferenceException
	 * wait.ignoring(StaleElementReferenceException.class) .until(driver -> {
	 * driver.findElement(editBtnLocator).click(); return true; // condition
	 * satisfied after successful click });
	 * 
	 * // Retry finding the student name field until it becomes stable and ready
	 * WebElement studentNameField =
	 * wait.ignoring(StaleElementReferenceException.class) .until(d ->
	 * d.findElement(studentNameLocator));
	 * 
	 * // Clear the field before sending new input studentNameField.clear();
	 * 
	 * // Send the new student name studentNameField.sendKeys(" Lana Mohammed");
	 * 
	 * // Press Enter/Return key to confirm studentNameField.sendKeys(Keys.RETURN);
	 * }
	 */

	/*
	 * public void clickViewBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(40));
	 * 
	 * // Retry clicking the View button until it succeeds, // ignoring
	 * StaleElementReferenceException
	 * wait.ignoring(StaleElementReferenceException.class) .until(driver -> {
	 * driver.findElement(viewBtnLocator).click(); return true; // condition
	 * satisfied after successful click });
	 * 
	 * // Retry finding the student name element (same student we want to view)
	 * WebElement studentNameField =
	 * wait.ignoring(StaleElementReferenceException.class) .until(d ->
	 * d.findElement(studentNameLocator));
	 * 
	 * // Just to ensure it's found, we can print or get its text String studentName
	 * = studentNameField.getText(); System.out.println("Viewed student: " +
	 * studentName); }
	 */

	/*
	 * public void clickEditBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(40));
	 * 
	 * WebElement editBtn =
	 * wait.until(ExpectedConditions.elementToBeClickable(editBtnLocator));
	 * editBtn.click();
	 * 
	 * WebElement studentNameField =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(studentNameLocator))
	 * ;
	 * 
	 * studentNameField.clear();
	 * 
	 * studentNameField.sendKeys(" Lana Mohammed");
	 * studentNameField.sendKeys(Keys.RETURN); }
	 */

	/*
	 * public void clickEditBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(40)); WebElement editBtn =
	 * wait.until(ExpectedConditions.elementToBeClickable(editBtnLocator));
	 * editBtn.click(); driver.findElement(studentNameLocator).click();
	 * driver.findElement(studentNameLocator).sendKeys(" Mohammed");
	 * driver.findElement(studentNameLocator).sendKeys(Keys.RETURN);
	 * 
	 * }
	 */

	public void clickDeleteBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Retry to click the Delete button safely
		wait.ignoring(StaleElementReferenceException.class).until(driver -> {
			try {
				// Find the Delete button after search
				WebElement deleteBtn = driver.findElement(deleteBtnLocator);

				// Click it via JS to avoid hover/overlay issues
				((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteBtn);

				return true; // clicked successfully
			} catch (StaleElementReferenceException | NoSuchElementException e) {
				return false; // retry if element is stale or not yet found
			}
		});

		// Wait for the confirmation alert
		wait.until(ExpectedConditions.alertIsPresent());

		// Accept the alert
		driver.switchTo().alert().accept();

		System.out.println("Deleted student successfully.");
	}

	/*
	 * public void clickDeleteBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(20));
	 * 
	 * WebElement deleteBtn =
	 * wait.until(ExpectedConditions.elementToBeClickable(deleteBtnLocator));
	 * deleteBtn.click();
	 * 
	 * wait.until(ExpectedConditions.alertIsPresent());
	 * 
	 * driver.switchTo().alert().accept(); }
	 */

	/*
	 * public void clickViewBtn() {
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * WebElement viewBtn =
	 * wait.until(ExpectedConditions.elementToBeClickable(viewBtnLocator));
	 * viewBtn.click();
	 * 
	 * // driver.findElement(viewBtnLocator).click(); }
	 */
	/*
	 * public void clickEditBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(40)); WebElement editBtn =
	 * wait.until(ExpectedConditions.presenceOfElementLocated(editBtnLocator));
	 * ((org.openqa.selenium.JavascriptExecutor)
	 * driver).executeScript("arguments[1].click();", editBtn); }
	 */

	/*
	 * public void clickEditBtn() { WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(40)); WebElement editBtn =
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(editBtnLocator));
	 * Actions actions = new Actions(driver);
	 * actions.moveToElement(editBtn).click().perform();
	 * 
	 * }
	 */
	// Error Need to be fixed

}
