package testWorkflows;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddStudentSection;
import pages.AdminLoginPage;
import pages.AdmissionFormPage;
import pages.AdmissionLetterPage;
import pages.StudentLoginPage;

//Test Case to test Add Student with missed RequiredFeild
public class InvalidAddStudentTest extends BaseTest {
	private AdminLoginPage loginPage;
	private AddStudentSection studentSectionPage;
	private AdmissionFormPage admissionFormPage;
	private AdmissionLetterPage admissionLetterPage;
	private StudentLoginPage studentLoginPage;

	@BeforeClass
	public void init() {
		loginPage = new AdminLoginPage(driver);
		studentSectionPage = new AddStudentSection(driver);
		admissionFormPage = new AdmissionFormPage(driver);
		admissionLetterPage = new AdmissionLetterPage(driver);
	}

	// PreCondition For Test Cases
	@Test(priority = 1, dataProvider = "Admin Login credentials")
	public void testLogin(String email, String password) {
		loginPage.login(email, password);
	}

	@Test(priority = 2, dataProvider = "Student Data")
	public void testAddStudentWorkflow(String studentName, int regNo, String className, String date, Integer discount) {
		studentSectionPage.clickMenu();
		studentSectionPage.clickStudentsSection();
		studentSectionPage.clickAddNewStudent();
		admissionFormPage.fillForm(studentName, regNo, className, date, discount);

		if (discount == null) {
			String pageText = driver.findElement(By.tagName("body")).getText();
			Assert.assertTrue(pageText.contains("Discount is required"),
					"Discount error message not displayed on page!");
		} else {
			admissionLetterPage.captureCredentials();
			String username = admissionLetterPage.getUsername();
			String password = admissionLetterPage.getPassword();
			System.out.println(username);
			System.out.println(password);
			driver.navigate().to(baseUrl);
			studentLoginPage.login(username, password);
		}
	}

	@DataProvider(name = "Student Data")
	public Object[][] getFormData() {
		return new Object[][] { { "Mai Fuad", 26, "09/04/2025", "Grade 10", null }, };
	}

	@DataProvider(name = "Admin Login credentials")
	public Object[][] getLoginData() {
		return new Object[][] { { "maiokasha930@gmail.com", "iam123" }, };

	}
}
