package testWorkflows;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TeseBase;
import pages.AdmissionFormPage;
import pages.AdmissionLetterPage;
import pages.AdminLoginPage;
import pages.StudentLoginPage;
import pages.AddStudentSection;

public class TestAddStudentWorkflow extends TeseBase {

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
		studentLoginPage = new StudentLoginPage(driver);
	}

	// PreCondition For Test Cases
	@Test(priority = 1, dataProvider = "Admin Login credentials")
	public void testLogin(String email, String password) {
		loginPage.login(email, password);
	}

	// The First Test Case - TC _ St _ 001 - Add Student Workflow
	@Test(priority = 2, dataProvider = "Student Data")
	public void testAddStudentWorkflow(String studentName, int regNo, String className, String date, int discount) {
		studentSectionPage.clickMenu();
		studentSectionPage.clickStudentsSection();
		studentSectionPage.clickAddNewStudent();
		admissionFormPage.fillForm(studentName, regNo, className, date, discount);
		admissionLetterPage.captureCredentials();
		String username = admissionLetterPage.getUsername();
		String password = admissionLetterPage.getPassword();
		System.out.println(username);
		System.out.println(password);
		driver.navigate().to(baseUrl);
		studentLoginPage.login(username, password);
	}

	@DataProvider(name = "Student Data")
	public Object[][] getFormData() {
		return new Object[][] { { "Mai Fuad", 26, "09/04/2025", "Grade 10", 20 }, };
	}

	@DataProvider(name = "Admin Login credentials")
	public Object[][] getLoginData() {
		return new Object[][] { { "badaha.22@gmail.com", "Aa00147235@@" }, };

	}

}
