package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrintBasicListOfStudentsPage {

	private WebDriver driver;

	// driver.navigate

	By classDropdownBtn = By.xpath("//*[@id=\"myform\"]/div/div/div[1]");
	By pdfBtn = By.xpath("//*[@id=\"example_wrapper\"]/div[1]/button[4]");

	public PrintBasicListOfStudentsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void search() {
		WebElement search = driver.findElement(classDropdownBtn);
		search.clear();
		search.sendKeys("Grade 10");
		search.sendKeys(Keys.RETURN);
	}
	
	public void clickpdfBtn() {
		driver.findElement(pdfBtn).click();
	}
//Assert all students appear they are from the same grade 
	
	
	
	
	
	
	

}
