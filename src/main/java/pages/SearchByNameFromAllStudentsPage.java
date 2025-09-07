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

		WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(editBtnLocator));
		editBtn.click();
		driver.findElement(studentNameLocator).clear();
		driver.findElement(studentNameLocator).sendKeys("Lana Mohammed");
		System.out.println("Clicked 'Edit' button successfully.");
	}

	public void clickViewBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.ignoring(StaleElementReferenceException.class).until(driver -> {
			WebElement viewBtn = driver.findElement(viewBtnLocator);
			if (viewBtn.isDisplayed() && viewBtn.isEnabled()) {
				((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", viewBtn);
				return true; 
			}
			return false; 
		});

		System.out.println("Clicked View button successfully.");
	}

	public void clickDeleteBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.ignoring(StaleElementReferenceException.class).until(driver -> {
			try {
				WebElement deleteBtn = driver.findElement(deleteBtnLocator);

				((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteBtn);

				return true; 
			} catch (StaleElementReferenceException | NoSuchElementException e) {
				return false;
			}
		});

		wait.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert().accept();

		System.out.println("Deleted student successfully.");
	}

	
}
