package testWorkflows;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TeseBase;
import pages.AdminLoginPage;
import pages.StudentCardPage;
import pages.AddStudentSection;

//Need Fixes 

public class TestCrudOnStudent extends TeseBase {

	private AdminLoginPage adminLoginPage;
	private StudentCardPage studentCardPage;
	private AddStudentSection studentSectionPage;

	@BeforeClass
	public void init() {
		adminLoginPage = new AdminLoginPage(driver);
		studentSectionPage = new AddStudentSection(driver);
		studentCardPage = new StudentCardPage(driver);

	}

	// PreCondition For Test Cases
	@Test(priority = 1, dataProvider = "Admin Login credentials")
	public void testLogin(String email, String password) {
		adminLoginPage.login(email, password);
		System.out.println("Login Done");
	}

	@Test(priority = 2)
	public void testViewStudent() {
		studentSectionPage.clickMenu();
		studentSectionPage.clickStudentsSection();
		studentCardPage.clickAllStudents();
		studentCardPage.clickStudentCard();
		studentCardPage.clickViewButton();
		studentCardPage.getTitle();
		Assert.assertTrue(driver.getTitle().contains("Student Report"));
	}

	@DataProvider(name = "Admin Login credentials")
	public Object[][] getLoginData() {
		return new Object[][] { { "badaha.22@gmail.com", "Aa00147235@@" }, };

	}

}
