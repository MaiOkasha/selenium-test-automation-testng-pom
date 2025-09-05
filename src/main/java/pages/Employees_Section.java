package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Employees_Section {

	private WebDriver driver;
	private Actions action;
	private WebDriverWait wait;

	public Employees_Section(WebDriver driver, Actions action) {
		this.driver = driver;
		this.action = action;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

//        aِdmin login page locators 
	private By username = By.xpath("//*[@id=\"username\"]");
	private By password = By.xpath("//*[@id=\"password\"]");
	private By loginbtn = By.xpath("//*[@id=\"submit\"]");
	private By totalstudents = By.xpath("//*[text()=\"Total Students\"]");

	public void login(String user, String pass) throws InterruptedException {
		Reporter.log("Opeining browser");
		Reporter.log("Entring username");
		driver.findElement(username).sendKeys(user);
		Reporter.log("Entring password");
		driver.findElement(password).sendKeys(pass);
		Reporter.log("Clicking login");
		driver.findElement(loginbtn).click();
		;

	}

	public boolean login_assert() {
		WebElement students = driver.findElement(totalstudents);

		return students.isDisplayed();

	}

	public void All_EmployeeAlone() {
		driver.findElement(allemployees).click();

	}

	public void add_employee() {
		driver.findElement(addemployee).click();

	}

	public void allemployee_page() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
		driver.findElement(menu).click();
		Reporter.log("Clicking menu");

		WebElement employesselement = driver.findElement(employees);
		wait.until(ExpectedConditions.visibilityOfElementLocated(employees));
		action.moveToElement(employesselement).click().perform();
		Reporter.log("Clicking All Employees");
		driver.findElement(allemployees).click();
		// Wait until menu is clickable
//    wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
//
//    // Wait until employees element is visible
//    WebElement employesselement = wait.until(ExpectedConditions.visibilityOfElementLocated(employees));
//
//    // Now safely click using Actions
//    action.moveToElement(employesselement).click().perform();
//
//    // Finally click All Employees
//    WebElement allEmp = wait.until(ExpectedConditions.elementToBeClickable(allemployees));
//    allEmp.click();
//
//    Reporter.log("Clicked All Employees page");
	}

//	dont delete this line 
//	String name, String phoneNum, String date, String rolef, String salaryf, String picturef,  String fatehrn, String id, String educationf, String genderf,  String religionf, String bloodf, String experiancef, String emalif,  String date_ofB, String homeAddress
	public void edit_emp_info() throws InterruptedException {
		allemployee_page();

		Reporter.log("Clicking edit");
		driver.findElement(AllEmp_edit).click();
		Reporter.log("updating employee form");

		driver.findElement(employeename).clear();
		driver.findElement(employeename).sendKeys("Ahmad Badaha");
		driver.findElement(phone).clear();
		driver.findElement(phone).sendKeys("0595024003");
		WebElement dateInput = driver.findElement(By.name("doa"));
		String dateValue = "2024-12-19";
		((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", dateInput, dateValue);

		Thread.sleep(1000);
//		   driver.findElement(role).clear();
		driver.findElement(role).sendKeys("Teacher");
		driver.findElement(salary).clear();
		driver.findElement(salary).sendKeys("8500");
		String projectPath = System.getProperty("user.dir");
		String filePath = projectPath + "\\assets_emp_photos\\me.jpg";
//
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys(filePath);
//		   driver.findElement(Pictuer).sendKeys("D:\\Programming_learning\\Axsos accademy\\Automation\\Project\\Employees_Photos\\20.jpg");

		driver.findElement(father).clear();
		driver.findElement(father).sendKeys("Ali Badaha");
		driver.findElement(national_id).clear();
		driver.findElement(national_id).sendKeys("108-532-1750");
		driver.findElement(education).clear();
		driver.findElement(education).sendKeys("Associate Degree");
//		   driver.findElement(gender).clear();
		driver.findElement(gender).sendKeys("Male");

		WebElement relgionfield = driver.findElement(religon);
//		 relgionfield.clear();
		relgionfield.sendKeys("Islam");
		relgionfield.sendKeys(Keys.RETURN);
//		 driver.findElement(blood_group).clear();
		driver.findElement(blood_group).sendKeys("A-");
		driver.findElement(experiance).clear();
		driver.findElement(experiance).sendKeys("11");
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys("badaha.22@gmail.com");
//		 driver.findElement(dateofbirth).clear();
		driver.findElement(dateofbirth).sendKeys("9/13/1992");
		driver.findElement(home_Address).clear();
		driver.findElement(home_Address).sendKeys("Apt 1488");
//		 Thread.sleep(1000);
		Reporter.log("Clicking update button");
		WebElement update = driver.findElement(submitbtn);
		action.moveToElement(update);
		driver.findElement(submitbtn).click();
//		 Thread.sleep(2000);
//		 driver.findElement(AllEmp_view).click();
//		 driver.navigate().refresh();

	}

	public boolean checkupdate() {
		WebElement empname = driver.findElement(employeename);
		String employeeName = empname.getAttribute("value");
//		System.out.println(employeeName);
		WebElement empfathername = driver.findElement(father);
		String father = empfathername.getAttribute("value");
//		System.out.println(father);

		return employeeName.contains("Ahmad Badaha") && father.contains("Ali Badaha");

	}

	public void view_employee_info() throws InterruptedException {

		driver.findElement(allemployees).click();

		Reporter.log("Clicking view button ");

		driver.findElement(Emp_view).click();

	}

	public boolean employee_view() {
		WebElement Getpdf = driver.findElement(By.xpath("//*[contains(text(),\" Get PDF\")]"));

		return Getpdf.isDisplayed();
	}

	public void search_for_employye(String name) throws InterruptedException {
//		allemployee_page();
//		Thread.sleep(1000);
		driver.findElement(allemployees).click();
		Reporter.log("Enering invalid name");
		driver.findElement(AllEmp_searchbox).sendKeys(name);
		Actions actions = new Actions(driver);

		// Move to the button, press arrow down, then enter
		Reporter.log("Clicking username from List");
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

	}

	public boolean check_search(String name) {
		WebElement searchresult = driver.findElement(By.xpath("//*[text()=\'" + name + "']"));
		return searchresult.isDisplayed();
	}

	public void allbutton() {
		driver.findElement(All_button).click();

	}

	public boolean check_all_employyes_displayed() {
		WebElement allemployees = driver
				.findElement(By.xpath("//div[contains(@class,'col-12')][contains(.,'- All Employees')]"));
		return allemployees.isDisplayed();
	}

	public void search_for_employye_with_invalid_data2() {
		allemployee_page();
		Reporter.log("Enering invalid name");
		driver.findElement(AllEmp_searchbox).sendKeys("Ahmad Badaha");
		Actions actions = new Actions(driver);

		// Move to the button, press arrow down, then enter
		Reporter.log("Clicking username from List");
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

	}

	public void search_for_employye_with_invalid_data() {
		driver.findElement(allemployees).click();
		Reporter.log("Enering invalid name");
		driver.findElement(AllEmp_searchbox).sendKeys("aSAs");
		Actions actions = new Actions(driver);

		// Move to the button, press arrow down, then enter
		Reporter.log("Clicking username from List");
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

	}

	public boolean check_search_invalid() {
		WebElement allemployees = driver
				.findElement(By.xpath("//div[contains(@class,'col-12')][contains(.,'- All Employees')]"));
		return allemployees.isDisplayed();

	}

	public void delete_Emp(String employeeToDelete) throws InterruptedException {
		Reporter.log("Deleteing Employee");
		WebElement deleteButton = driver.findElement(By
				.xpath("//div[@class='m-round'][.//span[text()='" + employeeToDelete + "']]//button[@name='edelete']"));

		deleteButton.click();
		Reporter.log("Deleteing Confirmation");
		driver.switchTo().alert().accept();

	}

	public boolean isEmployeePresent(String empolyee) {

		List<WebElement> employees = driver
				.findElements(By.xpath("//div[contains(@class,'m-round')]//span[text()='" + empolyee + "']"));
		return !employees.isEmpty();

	}

//	 employeePage Basic information locators 
	private By menu = By.xpath("//*[@id=\"mobile-collapse\"]");
	private By allemployees = By.xpath("//*[text()=\"All Employees\"]");
	private By AllEmp_searchbox = By.xpath("//*[@id=\"tags1\"]");
	private By Emp_view = By.xpath("//*[@name='eview']");
	private By AllEmp_edit = By.xpath("//form/button[2]");
	private By AllEmp_delete = By.xpath("//form/button[3]");
	private By dateofjoin = By.xpath("//input[@type='date' and @name='doa']");
	private By dateofbirth = By.xpath("//input[@type='date' and @name='dob']");
	private By All_button = By.xpath("//*[@class=\"btn b-link\"]");

//	 add new employee page locators
	private By employees = By.xpath("//*[text()=\"Employees\"]");
	private By addemployee = By.xpath("//*[@id=\"addnewteacher\"]");
	private By employeename = By.xpath("//*[@id=\"tname\"]");
	private By phone = By.xpath("//*[@name=\"phone\"]");
	private By role = By.xpath("//*[@name=\"class\"]");
	private By Pictuer = By.xpath("//*[@type=\"file\"]");
	private By calender = By.xpath("//div[2]/input[@type=\"date\"]");
	private By salary = By.xpath("//*[@type=\"number\"]");

	@DataProvider(name = "BasicInfoData")
	public static Object[][] getData() {
		List<Object[]> data = new ArrayList<>();
//		      String csvFilePath = "src/resources/data.csv";

		try (BufferedReader bufferReader = new BufferedReader(new FileReader("Test_Data/Requried_Fields_Valid.csv"))) {
			String line;
			bufferReader.readLine();
			while ((line = bufferReader.readLine()) != null) {
				String[] values = line.split(",");
				String name = values[0].trim();
				String phonenm = values[1].trim();
				String rolef = values[2].trim();
				String picturef = values[3].trim();
				String date = values[4].trim();
				String salaryf = values[5].trim();
				data.add(new Object[] { name, phonenm, rolef, picturef, date, salaryf });
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data.toArray(new Object[0][]);
	}

	@Test(dataProvider = "BasicInfoData")
	public void Basic_Information_Valid(String name, String phoneNum, String rolef, String picturef, String date,
			String salaryf) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
		driver.findElement(menu).click();

		WebElement employesselement = driver.findElement(employees);
		wait.until(ExpectedConditions.visibilityOfElementLocated(employees));
		action.moveToElement(employesselement).click().perform();

		driver.findElement(addemployee).click();
		;
		driver.findElement(employeename).sendKeys(name);
		driver.findElement(phone).sendKeys(phoneNum);
		driver.findElement(role).sendKeys(rolef);
		driver.findElement(Pictuer).sendKeys(picturef);
		driver.findElement(calender).clear();
		driver.findElement(calender).sendKeys(date);
		driver.findElement(salary).sendKeys(salaryf);
		driver.findElement(submitbtn).click();

	}

//	 employeePage Other Information

	private By father = By.xpath("//*[@placeholder=\"Father / Husband Name\"]");
	private By gender = By.xpath("//*[@name=\"gender\"]");
	private By experiance = By.xpath("//*[@placeholder=\"Experience\"]");
	private By national_id = By.xpath("//*[@placeholder=\"National ID\"]");
	private By religon = By.xpath("//*[@id=\"searchlist-selectized\"]");
	private By email = By.xpath("//*[@type=\"email\"]");
	private By education = By.xpath("//*[@placeholder=\"Education\"]");
	private By blood_group = By.xpath("//*[@name=\"blood\"]");
	private By date_of_birth = By.xpath("//*[@name=\"dob\"]");
	private By home_Address = By.xpath("//*[@placeholder=\"Home Address\"]");
//	 buttons
	private By submitbtn = By.xpath("//*[@id=\"submitBtn\"]");
	private By restbtn = By.xpath("//*[@type=\"reset\"]");

	@DataProvider(name = "AllInfoData")
	public static Object[][] getData2() {
		List<Object[]> data = new ArrayList<>();
//	      String csvFilePath = "src/resources/data.csv";

		try (BufferedReader bufferReader = new BufferedReader(new FileReader("Test_Data/Form_Full_Valid.csv"))) {
			String line;
			bufferReader.readLine();
			while ((line = bufferReader.readLine()) != null) {

				String[] values = line.split(",");

				String basePath = System.getProperty("user.dir"); // Project root
				String picturePath = basePath + "/" + values[3].trim(); //

				String name = values[0].trim();
				String phoneNum = values[1].trim();
				String rolef = values[2].trim();
//	              String picturef = values[3].trim();
				String date = values[4].trim();
				String salaryf = values[5].trim();
				String fatehrn = values[6].trim();
				String genderf = values[7].trim();
				String experiancef = values[8].trim();
				String id = values[9].trim();
				String religionf = values[10].trim();
				String emalif = values[11].trim();
				String educationf = values[12].trim();
				String bloodf = values[13].trim();
				String date_ofB = values[14].trim();
				String homeAddress = values[15].trim();
				data.add(new Object[] { name, phoneNum, rolef, picturePath, date, salaryf, fatehrn, genderf,
						experiancef, id, religionf, emalif, educationf, bloodf, date_ofB, homeAddress });

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return data.toArray(new Object[0][]);
	}

	@DataProvider(name = "AllInfoData_Form_Full_invalid")
	public static Object[][] getData3() {
		List<Object[]> data = new ArrayList<>();
//	      String csvFilePath = "src/resources/data.csv";

		try (BufferedReader bufferReader = new BufferedReader(new FileReader("Test_Data/Form_Full_invalid.csv"))) {
			String line;
			bufferReader.readLine();
			while ((line = bufferReader.readLine()) != null) {

				String[] values = line.split(",");

				String basePath = System.getProperty("user.dir"); // Project root
				String picturePath = basePath + "/" + values[3].trim(); //

				String name = values[0].trim();
				String phoneNum = values[1].trim();
				String rolef = values[2].trim();
//	              String picturef = values[3].trim();
				String date = values[4].trim();
				String salaryf = values[5].trim();
				String fatehrn = values[6].trim();
				String genderf = values[7].trim();
				String experiancef = values[8].trim();
				String id = values[9].trim();
				String religionf = values[10].trim();
				String emalif = values[11].trim();
				String educationf = values[12].trim();
				String bloodf = values[13].trim();
				String date_ofB = values[14].trim();
				String homeAddress = values[15].trim();
				data.add(new Object[] { name, phoneNum, rolef, picturePath, date, salaryf, fatehrn, genderf,
						experiancef, id, religionf, emalif, educationf, bloodf, date_ofB, homeAddress });

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return data.toArray(new Object[0][]);
	}

	@DataProvider(name = "AllInfoData_Form_Full_duplicated")
	public static Object[][] getData4() {
		List<Object[]> data = new ArrayList<>();
//	      String csvFilePath = "src/resources/data.csv";

		try (BufferedReader bufferReader = new BufferedReader(
				new FileReader("Test_Data/Form_Full_Valid_duplicated.csv"))) {
			String line;
			bufferReader.readLine();
			while ((line = bufferReader.readLine()) != null) {

				String[] values = line.split(",");

				String basePath = System.getProperty("user.dir"); // Project root
				String picturePath = basePath + "/" + values[3].trim(); //

				String name = values[0].trim();
				String phoneNum = values[1].trim();
				String rolef = values[2].trim();
//	              String picturef = values[3].trim();
				String date = values[4].trim();
				String salaryf = values[5].trim();
				String fatehrn = values[6].trim();
				String genderf = values[7].trim();
				String experiancef = values[8].trim();
				String id = values[9].trim();
				String religionf = values[10].trim();
				String emalif = values[11].trim();
				String educationf = values[12].trim();
				String bloodf = values[13].trim();
				String date_ofB = values[14].trim();
				String homeAddress = values[15].trim();
				data.add(new Object[] { name, phoneNum, rolef, picturePath, date, salaryf, fatehrn, genderf,
						experiancef, id, religionf, emalif, educationf, bloodf, date_ofB, homeAddress });

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return data.toArray(new Object[0][]);
	}

	public void All_Information(String name, String phoneNum, String rolef, String picturef, String date,
			String salaryf, String fatehrn, String genderf, String experiancef, String id, String religionf,
			String emalif, String educationf, String bloodf, String date_ofB, String homeAddress)
			throws InterruptedException {
//		 	Reporter.log("clicking main menu");
//		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		    wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
//			driver.findElement(menu).click();
//			Reporter.log("Selecting Employee Section");
//		   WebElement employesselement=driver.findElement(employees);
//		   wait.until(ExpectedConditions.visibilityOfElementLocated(employees));
//		   action.moveToElement(employesselement).click().perform(); 
//			Reporter.log("Filling form");
		driver.findElement(allemployees).click();
		driver.findElement(addemployee).click();
		driver.findElement(employeename).sendKeys(name);
		driver.findElement(phone).sendKeys(phoneNum);
		driver.findElement(role).sendKeys(rolef);
		driver.findElement(Pictuer).sendKeys(picturef);
		driver.findElement(calender).clear();
		driver.findElement(calender).sendKeys(date);
		driver.findElement(salary).sendKeys(salaryf);

		driver.findElement(father).sendKeys(fatehrn);
		driver.findElement(gender).sendKeys(genderf);
		driver.findElement(experiance).sendKeys(experiancef);
		driver.findElement(national_id).sendKeys(id);
		WebElement relgionfield = driver.findElement(religon);
		relgionfield.sendKeys(religionf);
		relgionfield.sendKeys(Keys.RETURN);

		driver.findElement(email).sendKeys(emalif);
		driver.findElement(education).sendKeys(educationf);
		driver.findElement(blood_group).sendKeys(bloodf);
		driver.findElement(date_of_birth).sendKeys(date_ofB);
		driver.findElement(home_Address).sendKeys(homeAddress);
		Reporter.log("Clicking Submit");

		driver.findElement(submitbtn).click();
//		 driver.findElement(allemployees).click();

//		 Thread.sleep(500);

	}

//	   job letter  page locators 
	private By job_letter = By.xpath("//*[@id=\"jobletter\"]/a/span[2]");
	private By Search_employee = By.xpath("//*[@placeholder=\"Search Employee\"]");
	private By print_button = By.xpath("//*[@id=\"btn\"]");

	public void Job_letter() throws AWTException, InterruptedException {
//		Reporter.log("Clicking main menu");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
//		driver.findElement(menu).click();
//		Reporter.log("Clicking Employee section");
//		WebElement employesselement=driver.findElement(employees);
//		   wait.until(ExpectedConditions.visibilityOfElementLocated(employees));
//		   action.moveToElement(employesselement).click().perform(); 
//		
		Reporter.log("Clicking Job letter section");
		driver.findElement(job_letter).click();
		Reporter.log("Selecting Employee");
		Thread.sleep(1000);
		driver.findElement(Search_employee).sendKeys("Trudy Mullinger");
		Actions actions = new Actions(driver);

		// Move to the button, press arrow down, then enter

		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		WebElement printButton = driver.findElement(By.xpath("//*[@id='btn']"));
		printButton.click();
		Thread.sleep(2000);
		clickAtPosition(1224, 726);
		clickAtPosition(1224, 726);
		Reporter.log("Printing Employee job letter");
//			 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", printButton);
//				((JavascriptExecutor) driver).executeScript("arguments[0].click();", printButton);
		Thread.sleep(2000);
//				String mainWindow = driver.getWindowHandle();

//			// Switch to the new window
//			for (String handle : driver.getWindowHandles()) {
//			    if (!handle.equals(mainWindow)) {
//			        driver.switchTo().window(handle);
//			        break;
//			    }
//			}
//
//			// Close the print window
//			driver.close();
		Reporter.log("Switching window ");

	}

	public boolean check_jobLetter() {
		WebElement printButton = driver.findElement(By.xpath("//*[@id='btn']"));
		return printButton.isDisplayed();
	}

//	 Manage login  page locators 
	private By Manage_login = By.xpath("//*[@id=\"elogin\"]/a/span[2]");
	private By Manage_login_Username = By.xpath("//*[@placeholder=\"Username\"]");
	private By Manage_login_password = By.xpath("//*[@placeholder=\"Password\"]");
	private By Manage_login_save_button = By
			.xpath("//*[@class=\"fa-duotone fa-solid fa-floppy-disk update-btn text-dark\"]");
	private By Manage_login_reoladall = By.xpath("//*[text()=\"or, Reload All\"]");
	private By Manage_login_CSV = By.xpath("//*[text()=\"CSV\"]");
	private By Manage_login_excell = By.xpath("//*[text()=\"Excel\"]");
	private By Manage_login_PDF = By.xpath("//*[text()=\"PDF\"]");
	private By Manage_login_Column_view = By.xpath("//span[text()=\"Column visibility\"]");
	private By Manage_login_Id = By
			.xpath("//*[@class=\"dt-button buttons-columnVisibility active\"]//span[text()=\"ID\"]");
	private By Manage_login_Staff = By
			.xpath("//*[@class=\"dt-button buttons-columnVisibility active\"]//span[text()=\"Staff Name\"]");
	private By Manage_login_Column_Username = By
			.xpath("//*[@class=\"dt-button buttons-columnVisibility active\"]//span[text()=\"Username\"]");

	public void Manage_login() throws InterruptedException, AWTException {
//		 	Reporter.log("Opeining Main Menu");
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		    wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
//			driver.findElement(menu).click();
//			Reporter.log("Opeining clicking employee list");
//			WebElement employesselement=driver.findElement(employees);
//			   wait.until(ExpectedConditions.visibilityOfElementLocated(employees));
//			   action.moveToElement(employesselement).click().perform(); 

		Thread.sleep(2000);
		Reporter.log("Opeining Manage logn section");
		driver.findElement(Manage_login).click();

		Reporter.log("Reload List to view all");
		Thread.sleep(1000);

		Thread.sleep(2000);
		driver.findElement(Manage_login_reoladall).click();
		Reporter.log("Saving Login Inofrmation of Employees ");
		driver.findElement(Manage_login_CSV).click();
		Thread.sleep(1000);
		driver.findElement(Manage_login_excell).click();
		Thread.sleep(1000);
		driver.findElement(Manage_login_PDF).click();
		Reporter.log("Changing view Settings ");
		Thread.sleep(1000);
		driver.findElement(Manage_login_Column_view).click();
		Thread.sleep(500);
		driver.findElement(Manage_login_Id).click();
		Thread.sleep(500);
		driver.findElement(Manage_login_Column_Username).click();
		Thread.sleep(500);
		driver.findElement(Manage_login_Staff).click();
		clickAtPosition(500, 300);

		Reporter.log("Searching for Employee account ");
		driver.findElement(Search_employee).sendKeys("Ahmad Badaha");
		Actions actions = new Actions(driver);

		// Move to the button, press arrow down, then enter

		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		Reporter.log("Changing Username and password of  Employee account ");
		driver.findElement(Manage_login_Username).clear();
		driver.findElement(Manage_login_Username).sendKeys("badaha");
		driver.findElement(Manage_login_password).clear();
		driver.findElement(Manage_login_password).sendKeys("Aa00147235");
		Thread.sleep(1000);
		Reporter.log("Saving changes for Employee account ");
		driver.findElement(Manage_login_save_button).click();
//				 WebElement success=driver.findElement(By.xpath("//*[@class=\"toast-message\"]"));
//				 action.moveToElement(success);
		Thread.sleep(3000);

	}
//	 public boolean Check_username_changed() {
//		 WebElement success=driver.findElement(By.xpath("//*[@class=\"toast-message\"]"));
//			
//			
//			return success.isDisplayed();
//			
//		 
//	 }

	private By instute_name = By.xpath("//*[text()=\"Institute Name\"]");
	private By Logout_button = By.xpath("//*[@href='logout.php' or @class=\"ti-lock\"]/i");
	private By Select_employee = By.xpath("//*[text()=\"Employee\"]");

	public void LogOut() throws AWTException, InterruptedException {
		Actions actions = new Actions(driver);
		Thread.sleep(2000);

		WebElement instute = driver.findElement(instute_name);
		actions.moveToElement(instute).click().perform();
		instute.click();
		Reporter.log("Logging Out");
//		 action.click();
		Thread.sleep(2000);
		WebElement logout = driver.findElement(Logout_button);

		actions.moveToElement(logout).click().perform();

	}

	public void login_As_Employee() throws InterruptedException {
		Reporter.log("Opeining browser");
		driver.findElement(Select_employee).click();
		Reporter.log("Entring username");
		driver.findElement(username).sendKeys("badaha");
		Reporter.log("Entring password");
		driver.findElement(password).sendKeys("Aa00147235");
		Reporter.log("Clicking login");
		driver.findElement(loginbtn).click();
	}

	public boolean login_AsEmployee_assert() {
		WebElement students = driver.findElement(By.xpath("//*[text()=\"Attendance Report \"]"));

		return students.isDisplayed();

	}

//	 Methood to move mouse according to pixel location X,y
	public void clickAtPosition(int x, int y) throws AWTException {
		Robot robot = new Robot();

		// Move mouse to (x, y)
		robot.mouseMove(x, y);

		// Click the mouse
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

	}

	public void safeClick(By locator, WebDriver driver, int timeoutSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		int retries = 3;

		for (int i = 0; i < retries; i++) {
			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
				element.click();
				return; // ✅ success
			} catch (StaleElementReferenceException e) {
				System.out.println("Stale element, retrying... Attempt " + (i + 1));
			}
		}
		throw new RuntimeException("Failed to click element after " + retries + " attempts.");
	}

}