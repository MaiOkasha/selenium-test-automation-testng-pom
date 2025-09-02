package pages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
	 
	 
	 public void login(String user,String pass) throws InterruptedException {

		   driver.findElement(username).sendKeys(user);
		   driver.findElement(password).sendKeys(pass);
		   driver.findElement(loginbtn).click();;
		
		}
	 
	 
	 
	 
//	 employeePage Basic information locators 
	 private By menu = By.xpath("//*[@id=\"mobile-collapse\"]");
	 private By allemployees = By.xpath("//*[text()=\"All Employees\"]");
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
//		   String fatehrn, String genderf, String experiancef, String id, String religionf, String emalif, String educationf, String bloodf, String date_ofB, String homeAddress 
		   
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
	 
	 public void deleteallEmp() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
			driver.findElement(menu).click();
			

		
		 WebElement employeeMenu = driver.findElement(By.xpath("//*[text()=\"Employees\"]"));
		 action.moveToElement(employeeMenu).click().perform();
		 driver.findElement(allemployees).click();
		 List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='employeeTable']//tr"));
		 while (true) {
		        try {
		            // Locate the first employee's delete button
		            WebElement deleteBtn = driver.findElement(By.xpath("//*[@id='pcoded']/div[2]/div[2]/div/div/div/div/div/div/div[3]/div[1]/form/button[3]"));
		            
		            // Click the delete button
		            deleteBtn.click();

		            // Handle confirmation alert
		            wait.until(ExpectedConditions.alertIsPresent());
		            driver.switchTo().alert().accept();

		            // Wait for the row to be removed
//		            Thread.sleep(1000);
		        } catch (org.openqa.selenium.NoSuchElementException e) {
		            System.out.println("All employees deleted!");
		            break;
		        }
		    }
		}
	 public void deleteEmp_Byname(String employeeName) throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
			driver.findElement(menu).click();
			

		
		 WebElement employeeMenu = driver.findElement(By.xpath("//*[text()=\"Employees\"]"));
		 action.moveToElement(employeeMenu).click().perform();
		 driver.findElement(allemployees).click();
		 try {
		        // Locate the row that contains the employee name
		        WebElement employeeRow = driver.findElement(By.xpath(
		            "//*[@id='pcoded']/div[2]/div[2]/div/div/div/div/div/div/div[3]//div[div/form/div[contains(text(),'" + employeeName + "')]]"
		        ));
		        
		        // Locate the delete button inside that row
		        WebElement deleteBtn = employeeRow.findElement(By.xpath(".//form/button[3]"));
		        
		        // Click delete
		        deleteBtn.click();

		        // Handle confirmation alert
		        wait.until(ExpectedConditions.alertIsPresent());
		        driver.switchTo().alert().accept();

		        System.out.println(employeeName + " deleted successfully!");
		        
		    } catch (org.openqa.selenium.NoSuchElementException e) {
		        System.out.println("Employee " + employeeName + " not found!");
		    }
		}
		    
		
		  
}
