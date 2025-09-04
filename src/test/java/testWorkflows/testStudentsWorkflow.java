package testWorkflows;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import base.TeseBase;
import pages.AdminLoginPage;
import pages.PrintBasicListOfStudentsPage;
import pages.SearchByNameFromAllStudentsPage;
import pages.StudentSection;

public class TestStudentsWorkflow extends TeseBase {

	private AdminLoginPage loginPage;
	private StudentSection studentSection;
	private SearchByNameFromAllStudentsPage searchByname;
	private PrintBasicListOfStudentsPage printList;
	private Actions action;
	// private AddStudentSection studentSectionPage;
	// private AdmissionFormPage admissionFormPage;

	@BeforeClass
	public void init() {
		loginPage = new AdminLoginPage(driver);
		searchByname = new SearchByNameFromAllStudentsPage(driver);
		printList = new PrintBasicListOfStudentsPage(driver);
		studentSection = new StudentSection(driver, action);

	}

	// PreCondition For Test Cases
	@Test(priority = 1, dataProvider = "Admin Login credentials")
	public void testLogin(String email, String password) {
		loginPage.login(email, password);
		Reporter.log("Admin Logged in Successfully !");

	}

	// 1- View All Student
	@Test(priority = 2)
	public void testViewAllStudents() {
		studentSection.clickMenu();
		studentSection.clickStudentsSection();
		studentSection.clickAllStudents();
		Reporter.log("Admin View All Student ");
	}

	// 2- Search By name
	@Test(priority = 3, dataProvider = "Name For Search")
	public void testSearchByName(String name) {
		studentSection.clickMenu();
		studentSection.clickStudentsSection();
		studentSection.clickAllStudents();
		searchByname.clickSearchBtn();
		searchByname.seachByName(name);
		// searchByname.clickViewBtn();
	}

	// 3- View Student Report //Have An error

	/*
	 * @Test(priority = 4) public void testViewStudentReport() {
	 * searchByname.clickViewBtn(); Reporter.log("Admin View Student Report"); }
	 */
	// need to fix

	// Edit the Student
	@Test(priority = 4)
	public void testEditStudent() {
		searchByname.clickEditBtn();
		Reporter.log("Admin Edit Student Data");
	}
	/*
	 * @Test(priority = 4) public void testEditStudent() { //
	 * driver.navigate().back(); searchByname.clickEditBtn();
	 * Reporter.log("Admin Edit Student Data"); }
	 */

	// View Student Report
	@Test(priority = 6, dataProvider = "Name For Search")
	public void testViewStudentReport(String name) {
		studentSection.clickMenu();
		studentSection.clickStudentsSection();
		studentSection.clickAllStudents();
		searchByname.clickSearchBtn();
		searchByname.seachByName(name);
		searchByname.clickSearchBtn();
		searchByname.seachByName(name);
		searchByname.clickViewBtn();
		Reporter.log("Admin View Student Report");
	}
	/*
	 * @Test(priority = 5, dataProvider = "Name For Search") public void
	 * testViewStudentReport(String name) { searchByname.clickSearchBtn();
	 * searchByname.seachByName(name); searchByname.clickViewBtn();
	 * Reporter.log("Admin View Student Report"); }
	 */
	/*
	 * @Test(priority = 5, dataProvider = "Name For Search") public void
	 * testViewStudentReport(String name) { searchByname.clickSearchBtn();
	 * searchByname.seachByName(name); searchByname.clickViewBtn(); }
	 */

	@Test(priority = 5, dataProvider = "Name For Delete")
	public void testDeleteStudent(String name) {
		studentSection.clickMenu();
		studentSection.clickStudentsSection();
		studentSection.clickAllStudents();

		searchByname.clickSearchBtn();

		searchByname.seachByName(name);

		searchByname.clickDeleteBtn();
	}

	/*
	 * @Test(priority = 7) public void testPrintList() { // Open the Students menu
	 * and navigate to Print Basic List page studentSection.clickMenu();
	 * studentSection.clickStudentsSection(); studentSection.clickPrintBasicList();
	 * Reporter.log("Navigated to Print Basic List page");
	 * 
	 * // Ensure the class selection input is displayed
	 * Assert.assertTrue(driver.findElement(By.cssSelector(
	 * "input#searchlist-selectized")).isDisplayed());
	 * Reporter.log("Class selection input is displayed");
	 * 
	 * // Select the class printList.selectClassName();
	 * Reporter.log("Class selected: Grade 10");
	 * 
	 * // Check if all print buttons are displayed
	 * Assert.assertTrue(driver.findElement(By.cssSelector(
	 * "button.dt-button.buttons-copy")).isDisplayed());
	 * Reporter.log("Copy button is displayed");
	 * 
	 * Assert.assertTrue(driver.findElement(By.xpath(
	 * "//button[.//span[text()='CSV']]")).isDisplayed());
	 * Reporter.log("CSV button is displayed");
	 * 
	 * Assert.assertTrue(driver.findElement(By.xpath(
	 * "//button[.//span[text()='Excel']]")).isDisplayed());
	 * Reporter.log("Excel button is displayed");
	 * 
	 * Assert.assertTrue(driver.findElement(By.cssSelector(
	 * "button.dt-button.buttons-pdf")).isDisplayed());
	 * Reporter.log("PDF button is displayed");
	 * 
	 * // Click all buttons (Copy, CSV, Excel, PDF) printList.printInFormat();
	 * Reporter.log("All print buttons clicked successfully");
	 * 
	 * 
	 * }
	 */
	
	
	@Test(priority = 7)
	public void testPrintList() {
	    // Open the Students menu and navigate to Print Basic List page
	    studentSection.clickMenu();
	    studentSection.clickStudentsSection();
	    studentSection.clickPrintBasicList();
	    Reporter.log("Navigated to Print Basic List page");

	    // Ensure the class selection input is displayed
	    Assert.assertTrue(driver.findElement(By.cssSelector("input#searchlist-selectized")).isDisplayed());
	    Reporter.log("Class selection input is displayed");

	    // Select the class
	    printList.selectClassName();
	    Reporter.log("Class selected: Grade 10");

	    // Ensure all print buttons are visible and clickable
	    Assert.assertTrue(driver.findElement(By.cssSelector("button.dt-button.buttons-copy")).isDisplayed());
	    Reporter.log("Copy button is displayed");

	    Assert.assertTrue(driver.findElement(By.xpath("//button[.//span[text()='CSV']]")).isDisplayed());
	    Reporter.log("CSV button is displayed");

	    Assert.assertTrue(driver.findElement(By.xpath("//button[.//span[text()='Excel']]")).isDisplayed());
	    Reporter.log("Excel button is displayed");

	    Assert.assertTrue(driver.findElement(By.cssSelector("button.dt-button.buttons-pdf")).isDisplayed());
	    Reporter.log("PDF button is displayed");

	    // Click all buttons using the Page method
	    printList.printInFormat();
	    Reporter.log("All print buttons clicked successfully (Copy, CSV, Excel, PDF)");
	}


	/*
	 * @Test(priority = 7) public void testPrintList() { studentSection.clickMenu();
	 * studentSection.clickStudentsSection(); studentSection.clickPrintBasicList();
	 * printList.printList();
	 * 
	 * }
	 */

	// Change username form manageLogin

	/*
	 * @Test(priority = 5, dataProvider = "Name For Delete") public void
	 * testDeleteStudent(String name) { // ensure the page is fully loaded
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(searchStudentLocator
	 * );
	 * 
	 * searchByname.clickSearchBtn(); searchByname.seachByName(name);
	 * searchByname.clickDeleteBtn(); }
	 */

	/*
	 * @Test(priority = 5, dataProvider = "Name For Delete") public void
	 * testDeleteStudent(String name) { searchByname.clickSearchBtn();
	 * searchByname.seachByName(name); searchByname.clickDeleteBtn();
	 * 
	 * }
	 */

	// delete student

	// add new

	// print basic list

	// change password via manageLogin

	// promote student

	@DataProvider(name = "Admin Login credentials")
	public Object[][] getLoginData() {
		return new Object[][] { { "badaha.22@gmail.com", "Aa00147235@@" }, };

	}

	@DataProvider(name = "Name For Search")
	public Object[][] getNameData() {
		return new Object[][] { { "Lana" } };
	}

	@DataProvider(name = "Name For Delete")
	public Object[][] getNameForDelete() {
		return new Object[][] { { "Anne" } };
	}

	/*
	 * @DataProvider(name = "Student Data") public Object[][] getStudentData() {
	 * return new Object[][] { { "Anne", 26, "Grade 12", "09/01/2025", 10 } }; }
	 */
}

/*
 * package testWorkflows;
 * 
 * import org.testng.annotations.BeforeClass; import
 * org.testng.annotations.DataProvider; import org.testng.annotations.Test;
 * import base.TeseBase;
 * 
 * import pages.AddStudentSection; import pages.AdminLoginPage; import
 * pages.AdmissionFormPage; import pages.AdmissionLetterPage; import
 * pages.StudentLoginPage;
 * 
 * public class testStudentsWorkflow extends TestBase{
 * 
 * private AdminLoginPage loginPage; private AddStudentSection
 * studentSectionPage; private AdmissionFormPage admissionFormPage; private
 * AdmissionLetterPage admissionLetterPage; private StudentLoginPage
 * studentLoginPage;
 * 
 * @BeforeClass public void init() { loginPage = new AdminLoginPage(driver);
 * studentSectionPage = new AddStudentSection(driver); admissionFormPage = new
 * AdmissionFormPage(driver); admissionLetterPage = new
 * AdmissionLetterPage(driver); studentLoginPage = new StudentLoginPage(driver);
 * }
 * 
 * // PreCondition For Test Cases
 * 
 * @Test(priority = 1, dataProvider = "Admin Login credentials") public void
 * testLogin(String email, String password) { loginPage.login(email, password);
 * }
 * 
 * @DataProvider(name = "Admin Login credentials") public Object[][]
 * getLoginData() { return new Object[][] { { "badaha.22@gmail.com",
 * "Aa00147235@@" }, };
 * 
 * }
 * 
 * //1- View All Students
 * 
 * 
 * 
 * 
 * 
 * }
 */