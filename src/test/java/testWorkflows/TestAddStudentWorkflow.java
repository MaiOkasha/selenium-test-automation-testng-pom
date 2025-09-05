package testWorkflows;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.AdmissionFormPage;
import pages.AdmissionLetterPage;
import pages.AdminLoginPage;
import pages.StudentLoginPage;
import pages.AddStudentSection;

public class TestAddStudentWorkflow extends BaseTest {

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
		Reporter.log("Admin is logged In Sucessfully");

	}

	// First Test Case - Add Student Workflow
	@Test(priority = 2, dataProvider = "Student Data")
	public void testAddStudentWorkflow(String studentName, int regNo, String className, String date, int discount) {
		Reporter.log("Admin is in Dashboard Page");
		studentSectionPage.clickMenu();
		Reporter.log("Admin Click Menu ");
		studentSectionPage.clickStudentsSection();
		Reporter.log("Admin Click StudentTab");
		studentSectionPage.clickAddNewStudent();
		Reporter.log("Admin Click Add New ");
		admissionFormPage.fillForm(studentName, regNo, className, date, discount);
		Reporter.log("Admin Enter the required fields on Form");
		admissionLetterPage.captureCredentials();
		String username = admissionLetterPage.getUsername();
		String password = admissionLetterPage.getPassword();
		System.out.println(username);
		System.out.println(password);
		driver.navigate().to(baseUrl);
		Reporter.log("Admin Logedd Out");
		studentLoginPage.login(username, password);
		Reporter.log("Student Logged In Successfully");
	}

	@DataProvider(name = "Student Data")
	public Object[][] getFormData() {
		return new Object[][] { { "Mai Fuad", 30, "09/04/2025", "Grade 10", 20 }, };
	}

	@DataProvider(name = "Admin Login credentials")
	public Object[][] getLoginData() {
		return new Object[][] { { "maiokasha930@gmail.com", "iam123" }, };

	}

}
