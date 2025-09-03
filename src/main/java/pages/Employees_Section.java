package pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    }
   
//        aِdmin login page locators 
	 private By username = By.xpath("//*[@id=\"username\"]");
	 private By password = By.xpath("//*[@id=\"password\"]");
	 private By loginbtn = By.xpath("//*[@id=\"submit\"]");
	 private By totalstudents = By.xpath("//*[text()=\"Total Students\"]");
	 
	 public void login(String user,String pass) throws InterruptedException {
		 	Reporter.log("Opeining browser");
		 	Reporter.log("Entring username");
		    driver.findElement(username).sendKeys(user);
		    Reporter.log("Entring password");
		    driver.findElement(password).sendKeys(pass);
		    Reporter.log("Clicking login");
		    driver.findElement(loginbtn).click();;
		
		}
	public boolean login_assert() {
		WebElement students=driver.findElement(totalstudents);
		
		
		return students.isDisplayed();
		
	}
	
	
public void allemployee_page() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
		 driver.findElement(menu).click();
		    Reporter.log("Clicking menu");

		 WebElement employesselement=driver.findElement(employees);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(employees));
		 action.moveToElement(employesselement).click().perform(); 
		 Reporter.log("Clicking All Employees");
		 driver.findElement(allemployees).click();
		
	}
	
	
//	dont delete this line 
//	String name, String phoneNum, String date, String rolef, String salaryf, String picturef,  String fatehrn, String id, String educationf, String genderf,  String religionf, String bloodf, String experiancef, String emalif,  String date_ofB, String homeAddress
	public void edit_emp_info() throws InterruptedException {
		allemployee_page();
		
		 Reporter.log("Clicking edit");
		 driver.findElement(AllEmp_edit).click();
		 Reporter.log("updating employee form");
		 	driver.findElement(employeename).clear();
		   driver.findElement(employeename).sendKeys("Patricio Kidstone");
		   driver.findElement(phone).clear();
		   driver.findElement(phone).sendKeys("367-665-4054");
		   WebElement dateInput = driver.findElement(By.name("doa"));
		   String dateValue = "2024-12-19"; 
		   ((JavascriptExecutor) driver).executeScript("arguments[0].value = arguments[1];", dateInput, dateValue);


		   Thread.sleep(1000);
//		   driver.findElement(role).clear();
		   driver.findElement(role).sendKeys("Teacher");
		   driver.findElement(salary).clear();
		   driver.findElement(salary).sendKeys("66550");
//		   driver.findElement(Pictuer).clear();
		   driver.findElement(Pictuer).sendKeys("D:\\Programming_learning\\Axsos accademy\\Automation\\Project\\Employees_Photos\\7.jpg");
		   
		   driver.findElement(father).clear();
		   driver.findElement(father).sendKeys("Darcee Rosencrantz");
		   driver.findElement(national_id).clear();
		   driver.findElement(national_id).sendKeys("108-532-1750");
		   driver.findElement(education).clear();
		   driver.findElement(education).sendKeys("Associate Degree");
//		   driver.findElement(gender).clear();
		   driver.findElement(gender).sendKeys("Male");
		 
		 
		 WebElement relgionfield =driver.findElement(religon);
//		 relgionfield.clear();
		 relgionfield.sendKeys("Islam");
		 relgionfield.sendKeys(Keys.RETURN);
//		 driver.findElement(blood_group).clear();
		 driver.findElement(blood_group).sendKeys("A-");
		 driver.findElement(experiance).clear();
		 driver.findElement(experiance).sendKeys("11");
		 driver.findElement(email).clear();
		 driver.findElement(email).sendKeys("rjaulmes5@typepad.com");
//		 driver.findElement(dateofbirth).clear();
		 driver.findElement(dateofbirth).sendKeys("9/13/1992");
		 driver.findElement(home_Address).clear();
		 driver.findElement(home_Address).sendKeys("Apt 1488");
		 Thread.sleep(1000);
		 Reporter.log("Clicking update button");
		 driver.findElement(submitbtn).click();
		

	}
	
	
	public boolean checkupdate() {
		WebElement empname =driver.findElement(employeename);
		String employeeName = empname.getAttribute("value");
		System.out.println(employeeName);
		WebElement empfathername =driver.findElement(father);
		String father = empfathername.getAttribute("value");
		System.out.println(father);
		

		
		
		return employeeName.contains("Patricio Kidstone")&&father.contains("Darcee Rosencrantz");
		
	}

	public void view_employee_info() {
		allemployee_page();
		 Reporter.log("Clicking view button ");
		 driver.findElement(AllEmp_view).click();
		
	}
	public boolean employee_view() {
		 WebElement Getpdf=driver.findElement(By.xpath("//*[contains(text(),\" Get PDF\")]"));

		return Getpdf.isDisplayed();
	}
	
	
	public void search_for_employye(String name) {
		allemployee_page();	
		 Reporter.log("Enering employye name");
		 driver.findElement(AllEmp_searchbox).sendKeys(name);
		 Actions actions = new Actions(driver);
		 
		// Move to the button, press arrow down, then enter
		
		 actions.sendKeys(Keys.ARROW_DOWN)
		 .sendKeys(Keys.ARROW_DOWN) 
		 .sendKeys(Keys.ENTER)        
		 .build()
		 .perform(); 

		
	}
	
	public boolean check_search(String name) {
		 WebElement searchresult=driver.findElement(By.xpath("//*[text()=\'"+name+"']"));
		return searchresult.isDisplayed();
	}
	
	public void allbutton() {
		driver.findElement(All_button).click();
		
		
	}
	
	public boolean check_all_employyes_displayed() {
		WebElement allemployees=driver.findElement(By.xpath("//div[contains(@class,'col-12')][contains(.,'- All Employees')]"));
		return allemployees.isDisplayed();
	}
	
	public void search_for_employye_with_invalid_data() {
		allemployee_page();	
		 Reporter.log("Enering invalid name");
		 driver.findElement(AllEmp_searchbox).sendKeys("efedefw2323");
		 Actions actions = new Actions(driver);
		 
		// Move to the button, press arrow down, then enter
		
		 actions.sendKeys(Keys.ARROW_DOWN)
		 .sendKeys(Keys.ARROW_DOWN) 
		 .sendKeys(Keys.ENTER)        
		 .build()
		 .perform(); 

		
	}
	public boolean check_search_invalid() {
		WebElement allemployees=driver.findElement(By.xpath("//div[contains(@class,'col-12')][contains(.,'- All Employees')]"));
		return allemployees.isDisplayed();
		
	}
	
	
 public void delete_Emp(String employeeToDelete ) throws InterruptedException {
		
		WebElement deleteButton = driver.findElement(By.xpath(
		    "//div[@class='m-round'][.//span[text()='" + employeeToDelete + "']]//button[@name='edelete']"
		));

		
		deleteButton.click();
		
		driver.switchTo().alert().accept();
		       
		   }
 	public boolean isEmployeePresent(String Delete_empolyee) {
 		 
 		  List<WebElement> employees = driver.findElements(By.xpath("//div[contains(@class,'m-round')]//span[text()='" + Delete_empolyee +"']"));
 		    return !employees.isEmpty(); 
 		
 		
 		
 	}
		
 	
	
	
	
	

	 
	 
	 
//	 employeePage Basic information locators 
	 private By menu = By.xpath("//*[@id=\"mobile-collapse\"]");
	 private By allemployees = By.xpath("//*[text()=\"All Employees\"]");
	 private By AllEmp_searchbox = By.xpath("//*[@id=\"tags1\"]");
	 private By AllEmp_view = By.xpath("//button[@type='submit' and @name='eview']");
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
	 
	 
		@DataProvider(name="BasicInfoData")
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
		              data.add(new Object[]{name, phonenm, rolef, picturef, date, salaryf});
		          }
		      } catch (IOException e) {
		          e.printStackTrace();
		      }

		      return data.toArray(new Object[0][]);
		  }
		
		
	 @Test(dataProvider="BasicInfoData")
	 public  void Basic_Information_Valid(String name, String phoneNum, String rolef, String picturef, String date, String salaryf) { 
			
		   
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
			driver.findElement(menu).click();

		   WebElement employesselement=driver.findElement(employees);
		   wait.until(ExpectedConditions.visibilityOfElementLocated(employees));
		   action.moveToElement(employesselement).click().perform(); 
		
		   driver.findElement(addemployee).click();;
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
	 
	 
	 
	 @DataProvider(name="AllInfoData")
	  public static Object[][] getData2() {
	      List<Object[]> data = new ArrayList<>();
//	      String csvFilePath = "src/resources/data.csv";
	     
	      try (BufferedReader bufferReader = new BufferedReader(new FileReader("Test_Data/Form_Full_Valid.csv"))) {
	          String line;
	          bufferReader.readLine();
	          while ((line = bufferReader.readLine()) != null) {
	              String[] values = line.split(",");
	              String name = values[0].trim();
	              String phoneNum = values[1].trim();
	              String rolef = values[2].trim();
	              String picturef = values[3].trim();
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
	              data.add(new Object[]{name,  phoneNum,  rolef,  picturef,  date,  salaryf, fatehrn,  genderf,  experiancef,  id,  religionf,  emalif,  educationf,  bloodf, date_ofB,homeAddress});
	          }
	      } catch (IOException e) {
	          e.printStackTrace();
	      }

	      return data.toArray(new Object[0][]);
	  }
	
	 
	 
	 public void All_Information(String name, String phoneNum, String rolef, String picturef, String date, String salaryf, String fatehrn, String genderf, String experiancef, String id, String religionf, String emalif, String educationf, String bloodf, String date_ofB, String homeAddress ) {
		 
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
			driver.findElement(menu).click();

		   WebElement employesselement=driver.findElement(employees);
		   wait.until(ExpectedConditions.visibilityOfElementLocated(employees));
		   action.moveToElement(employesselement).click().perform(); 
		
		   driver.findElement(addemployee).click();;
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
		 WebElement relgionfield =driver.findElement(religon);
		 relgionfield.sendKeys(religionf);
		 relgionfield.sendKeys(Keys.RETURN);

		 driver.findElement(email).sendKeys(emalif);
		 driver.findElement(education).sendKeys(educationf);
		 driver.findElement(blood_group).sendKeys(bloodf);
		 driver.findElement(date_of_birth).sendKeys(date_ofB);
		 driver.findElement(home_Address).sendKeys(homeAddress);
		 driver.findElement(submitbtn).click();
		 
		 
	 }
		 
		 
	
	 public void fillform(String name, String phoneNum, String rolef, String picturef, String date, String salaryf, String fatehrn, String genderf, String experiancef, String id, String religionf, String emalif, String educationf, String bloodf, String date_ofB, String homeAddress) {
		 All_Information(name,  phoneNum,  rolef,  picturef,  date,  salaryf, fatehrn,  genderf,  experiancef,  id,  religionf,  emalif,  educationf,  bloodf,date_ofB,homeAddress);
		 
	 }
	 
	
	 
		    
	
		
		  
}
