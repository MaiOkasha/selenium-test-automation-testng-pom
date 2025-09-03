package testWorkflows;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.TeseBase;
import pages.AdminLoginPage;
import pages.PromoteStudentPage;
import pages.StudentSection;

public class TestPromoteStudents extends TeseBase {

	private AdminLoginPage adminLoginPage;
	private StudentSection studentSection;
	private PromoteStudentPage promoteStudentPage;

	@BeforeClass
	public void init() {
	    super.setUp(); 
	    adminLoginPage = new AdminLoginPage(driver);
	    studentSection = new StudentSection(driver);
	    promoteStudentPage = new PromoteStudentPage(driver);
	}


	// PreCondition For Test Cases
	@Test(priority = 1, dataProvider = "Admin Login credentials")
	public void testLogin(String email, String password) {
		adminLoginPage.login(email, password);
		System.out.println("Login Done");
	}

	/*
	 * @Test(priority = 2) public void testPromoteStudents(String studentName,
	 * String className) { studentSection.clickMenu();
	 * studentSection.clickStudentsSection(); studentSection.clickPromoteLogin();
	 * promoteStudentPage.doPromote(studentName, className); }
	 */

	/*
	 * @DataProvider(name = "Promote Data") public Object[][] getData() { return new
	 * Object[][] { { "mohammed", "Grade 12" } }; }
	 */
	@DataProvider(name = "Admin Login credentials")
	public Object[][] getLoginData() {
		return new Object[][] { { "badaha.22@gmail.com", "Aa00147235@@" }, };
	}

}
