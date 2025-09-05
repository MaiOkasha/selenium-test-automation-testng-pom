package pages;

import org.testng.Reporter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrintBasicListOfStudentsPage {

	private WebDriver driver;
	By coopyLocator = By.cssSelector("button.dt-button.buttons-copy");
	By selectClassLocator = By.xpath("//input[@id='searchlist-selectized']");
	private By csvLocator = By.xpath("//*[text()=\"CSV\"]");
	private By excelLocator = By.xpath("//*[text()=\"Excel\"]");
	private By pdfLocator = By.xpath("//*[text()=\"PDF\"]");

	public PrintBasicListOfStudentsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectClassName() {
		WebElement search = driver.findElement(selectClassLocator);
		search.click();
		search.clear();
		search.sendKeys("Grade 2");
		search.sendKeys(Keys.RETURN);
	}

	public void printFormat() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(coopyLocator).click();
		Thread.sleep(1000);
		driver.findElement(csvLocator).click();
		Thread.sleep(1000);
		driver.findElement(excelLocator).click();
		Thread.sleep(1000);
		driver.findElement(pdfLocator).click();
		Thread.sleep(1000);
	}

	public void printList() throws InterruptedException {
		selectClassName();
		printFormat();
	}

}
