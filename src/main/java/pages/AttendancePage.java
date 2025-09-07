package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AttendancePage {
	private WebDriver driver;

	private By menu = By.xpath("//*[@id=\"mobile-collapse\"]");
	private By attendanceMenu = By.xpath("//*[@id=\"attandance\"]");
	private By studentAttendanceOption = By.xpath("//*[@id=\"studentsattandance\"]");
	private By employeeAttendanceOption = By.xpath("//*[@id=\"employeesattandance\"]");
	private By classWiseReportOption = By.xpath("//*[@id=\"classwise\"]");
	private By studentReportOption = By.xpath("//*[@id=\"studentattendancereport\"]");
	private By employeeReportOption = By.xpath("//*[@id=\"employeeattendancereport\"]");

	private By datePicker = By.xpath("//*[@name='date']");
	private By classDropdown = By.xpath("//*[@id='searchlist-selectized']");
	private By selectGrade = By.xpath("//div[text()='grade 2']");
	private By submitBtn = By.id("submitBtn");
	private By claasWiseDate = By.xpath("//*[@id='month']");
	private By searchField = By.xpath("//*[@type='search']");
	private By pdfBtn = By.xpath("//span[text()='PDF']");
	private By firstRowDate = By.xpath("//table/tbody/tr[1]/td[1]");
	private By firstRowClass = By.xpath("//table/tbody/tr[1]/td[5]");
	private By firstRowName = By.xpath("//table/tbody/tr[1]/td[4]");
	private By FirstRowType = By.xpath("//table/tbody/tr[1]/td[5]");

	public AttendancePage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToStudentAttendance() {
		driver.findElement(attendanceMenu).click();
		driver.findElement(studentAttendanceOption).click();
	}

	public void goToEmployeeAttendance() {
		driver.findElement(attendanceMenu).click();
		driver.findElement(employeeAttendanceOption).click();
	}

	public void selectDate(String date) {
		WebElement dateField = driver.findElement(datePicker);
		dateField.clear();
		dateField.sendKeys(date); 
	}

	public void selectDatesClassWise(String date) {
		WebElement dateField = driver.findElement(claasWiseDate);
		dateField.clear();
		dateField.sendKeys(date); 
	}

	public void selectClass(String className) {
		WebElement classField = driver.findElement(classDropdown);
		classField.sendKeys(className);
		classField.sendKeys(Keys.ENTER);
		
	}

	public void submitAttendance() {
		driver.findElement(submitBtn).click();
	}

	public void goToClassWiseReport() {
		driver.findElement(attendanceMenu).click();
		driver.findElement(classWiseReportOption).click();
	}

	public void goToStudentReport() {
		driver.findElement(studentReportOption).click();
	}

	public void goToEmployeeReport() {
		driver.findElement(employeeReportOption).click();
	}

	public void downlodeEmployeeReport() {
		driver.findElement(pdfBtn).click();

	}

	public void search(String query) {
		WebElement searchInput = driver.findElement(searchField);
		searchInput.clear();
		searchInput.sendKeys(query);
		searchInput.sendKeys(Keys.ENTER); 
	}

	public String getFirstRowDate() {
		return driver.findElement(firstRowDate).getText();
	}

	public String getFirstRowClass() {
		return driver.findElement(firstRowClass).getText();
	}

	public String getFirstRowName() {
		return driver.findElement(firstRowName).getText();
	}

	public String getFirstRowType() {
		return driver.findElement(FirstRowType).getText();
	}

}
