package testWorkflows;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TeseBase;
import pages.AdmissionFormPage;
import pages.AdmissionLetterPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.StudentSectionPage;

public class TestAddStudentWorkflow extends TeseBase {

	private LoginPage loginPage;
	private StudentSectionPage studentSectionPage;
	private AdmissionFormPage admissionFormPage;
	private AdmissionLetterPage admissionLetterPage;
	private LogoutPage logoutPage;

	@BeforeClass
	public void init() {
		loginPage = new LoginPage(driver);
		studentSectionPage = new StudentSectionPage(driver);
		admissionFormPage = new AdmissionFormPage(driver);
		admissionLetterPage = new AdmissionLetterPage(driver);
		logoutPage = new LogoutPage(driver);
	}

	// PreCondition For Test Cases
	@Test(priority = 1, dataProvider = "Admin Login credentials")
	public void testLogin(String email, String password) {
		loginPage.login(email, password);

	}

	// The First Test Case - TC _ St _ 001 - Add Student Workflow
	@Test(priority = 2, dataProvider = "Student Data")
	public void testAddStudentWorkflow(String studentName, int regNo, String className, String date, int discount) throws InterruptedException {
		studentSectionPage.clickMenu();
		studentSectionPage.clickStudentsSection();
		studentSectionPage.clickAddNewStudent();
		admissionFormPage.fillForm(studentName, regNo, className, date, discount);
		admissionLetterPage.captureCredentials();
		String username = admissionLetterPage.getUsername();
		String password = admissionLetterPage.getPassword();
		System.out.println(username);
		System.out.println(password);
		logoutPage.logout();
		loginPage.login(username, password);
		
	}

	// Assert the message : Student has been added Successfully

	@DataProvider(name = "Student Data")
	public Object[][] getFormData() {
		return new Object[][] { { "Mai Fuad", 26, "09/04/2025", "Grade 10", 20 }, };
	}

	@DataProvider(name = "Admin Login credentials")
	public Object[][] getLoginData() {
		return new Object[][] { { "badaha.22@gmail.com", "Aa00147235@@" }, };

	}

}
