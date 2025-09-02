package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StudentSectionPage {

	private WebDriver driver;

	By studentsTabLocator = By.xpath("//*[@id=\"students\"]/a/span[2]");
	By addNewStudentLocator = By.xpath("//*[@id=\"addnewstudent\"]/a");

	public StudentSectionPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickStudentsSection() {
		driver.findElement(studentsTabLocator);
	}

	public void clickAddNewStudent() {
		driver.findElement(addNewStudentLocator);
	}

}
