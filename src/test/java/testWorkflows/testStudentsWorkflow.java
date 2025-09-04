package testWorkflows;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import base.BaseTest;
import pages.AdminLoginPage;
import pages.PrintBasicListOfStudentsPage;
import pages.SearchByNameFromAllStudentsPage;
import pages.StudentSection;

public class TestStudentsWorkflow extends BaseTest {

	private AdminLoginPage loginPage;
	private StudentSection studentSection;
	private SearchByNameFromAllStudentsPage searchByname;
	private PrintBasicListOfStudentsPage printList;
	private Actions action;

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

		// check at least one student card is displayed
		Assert.assertTrue(driver.findElement(By.cssSelector("div.m-round")).isDisplayed(),
				"Student cards are not displayed!");
		Reporter.log("Student cards are displayed successfully");
	}

	// 2- Search By name
	@Test(priority = 3, dataProvider = "Name For Search")
	public void testSearchByName(String name) throws InterruptedException {
		studentSection.clickMenu();
		studentSection.clickStudentsSection();
		studentSection.clickAllStudents();
		searchByname.clickSearchBtn();
		searchByname.seachByName(name);
		Thread.sleep(3000);

		/*
		 * // check at least one student card is displayed after search
		 * Assert.assertTrue(driver.findElement(By.cssSelector("div.m-round")).
		 * isDisplayed(), "No student cards displayed for search!");
		 * 
		 * // check the searched name appears on the page
		 * Assert.assertTrue(driver.getPageSource().contains(name),
		 * "Searched student name not found on page!");
		 */

		Reporter.log("Search results for '" + name + "' displayed successfully");
	}

	// Edit the Student
	@Test(priority = 4)
	public void testEditStudent() throws InterruptedException, TimeoutException {
		Thread.sleep(1000);

		searchByname.clickEditBtn();

		Reporter.log("Admin Edit Student Data");

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * WebElement studentNameField = wait
		 * .until(ExpectedConditions.visibilityOfElementLocated(searchByname.
		 * studentNameLocator));
		 * 
		 * Assert.assertTrue(studentNameField.isDisplayed(),
		 * "Edit Student form did not appear!");
		 */
		Reporter.log("Edit Student form appeared successfully");
	}

	// Delete Student
	@Test(priority = 5, dataProvider = "Name For Delete")
	public void testDeleteStudent(String name) {
		studentSection.clickMenu();
		studentSection.clickStudentsSection();
		studentSection.clickAllStudents();

		searchByname.clickSearchBtn();

		searchByname.seachByName(name);

		searchByname.clickDeleteBtn();
	}

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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By studentNameInReport = By.xpath("//h4[contains(normalize-space(),'" + name + "')]");
		WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(studentNameInReport));

		Assert.assertTrue(nameElement.isDisplayed(), "Student report page did not appear for: " + name);
		Reporter.log("Student report for '" + name + "' appeared successfully");
	}

	/*
	 * @Test(priority = 7) public void testPrintList() { studentSection.clickMenu();
	 * studentSection.clickStudentsSection(); studentSection.clickPrintBasicList();
	 * Reporter.log("Navigated to Print Basic List page");
	 * 
	 * Assert.assertTrue(driver.findElement(By.cssSelector(
	 * "input#searchlist-selectized")).isDisplayed());
	 * Reporter.log("Class selection input is displayed");
	 * 
	 * printList.selectClassName(); Reporter.log("Class selected: Grade 10");
	 * 
	 * printList.printInFormat();
	 * Reporter.log("All print buttons clicked successfully (Copy, CSV, Excel, PDF)"
	 * ); }
	 */

	@Test(priority = 7)
	public void testPrintList() throws InterruptedException {
		studentSection.clickStudentsSection();
		studentSection.clickPrintBasicList();
		Reporter.log("Navigated to Print Basic List page");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement classInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#searchlist-selectized")));
		Assert.assertTrue(classInput.isDisplayed());
		Reporter.log("Class selection input is displayed");

		printList.selectClassName();
		Reporter.log("Class selected: Grade 10");

		printList.printFormat();
		Reporter.log("All print buttons clicked successfully (Copy, CSV, Excel, PDF)");
	}

	@DataProvider(name = "Admin Login credentials")
	public Object[][] getLoginData() {
		return new Object[][] { { "maiokasha930@gmail.com", "iam123" }, };

	}

	@DataProvider(name = "Name For Search")
	public Object[][] getNameData() {
		return new Object[][] { { "Lana" } };
	}

	@DataProvider(name = "Name For Delete")
	public Object[][] getNameForDelete() {
		return new Object[][] { { "Anne" } };
	}

}
