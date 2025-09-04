package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrintBasicListOfStudentsPage {

	private WebDriver driver;

	By selectClassLocator = By.xpath("//input[@id='searchlist-selectized']");
	By coopyLocator = By.cssSelector("button.dt-button.buttons-copy");
	By csvLocator = By.xpath("//button[.//span[text()='CSV']]");
	By excelLocator = By.xpath("//button[.//span[text()='Excel']]");
	By pdfLocator = By.cssSelector("button.dt-button.buttons-pdf");


	public PrintBasicListOfStudentsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectClassName() {
		WebElement search = driver.findElement(selectClassLocator);
		search.click();
		search.clear();
		search.sendKeys("Grade 10");
		search.sendKeys(Keys.RETURN);
	}
	
	 public void printInFormat() {
	        // Click Copy
	        driver.findElement(coopyLocator).click();

	        // Click CSV
	        driver.findElement(csvLocator).click();

	        // Click Excel
	        driver.findElement(excelLocator).click();

	        // Scroll to PDF button and click using JavaScript
	        WebElement pdfBtn = driver.findElement(pdfLocator);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pdfBtn);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pdfBtn);
	    }
	
	/*
	 * public void printInFormat() { driver.findElement(coopyLocator).click();
	 * driver.findElement(csvLocator).click();
	 * driver.findElement(excelLocator).click();
	 * driver.findElement(pdfLocator).click(); }
	 */
	 
	 public void printList() {
		 selectClassName();
		 printInFormat();
	 }
	
	
	
	/*
	 * public void printFormat(String format) { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(10)); JavascriptExecutor js =
	 * (JavascriptExecutor) driver;
	 * 
	 * By locator; switch (format.toLowerCase()) { case "copy": locator =
	 * coopyLocator; break; case "csv": locator = csvLocator; break; case "excel":
	 * locator = excelLocator; break; case "pdf": locator = pdfLocator; break;
	 * default: throw new IllegalArgumentException("Invalid format: " + format); }
	 * 
	 * WebElement btn =
	 * wait.until(ExpectedConditions.elementToBeClickable(locator));
	 * js.executeScript("arguments[0].click();", btn); System.out.println(format +
	 * " clicked successfully."); }
	 */
	/*
	 * public void printListOfStudents(String className) { selectClassName();
	 * 
	 * printFormat("copy"); printFormat("csv"); printFormat("excel");
	 * printFormat("pdf"); }
	 */
        

	
	 
	 

	
//Assert all students appear they are from the same grade 

}
