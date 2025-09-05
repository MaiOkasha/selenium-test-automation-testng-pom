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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Subjects_Page {
	
	
	private WebDriver driver;
    private Actions action;
    private WebDriverWait wait;
    
//    constructor
    public Subjects_Page(WebDriver driver) {
    	 this.driver = driver;
//         PageFactory.initElements(driver, this);
    }
   
//        aِdmin login page locators 
	 private By username = By.xpath("//*[@id=\"username\"]");
	 private By password = By.xpath("//*[@id=\"password\"]");
	 private By loginbtn = By.xpath("//*[@id=\"submit\"]");
	 
//	 login page method
	 public void login(String user,String pass) throws InterruptedException {

		   driver.findElement(username).sendKeys(user);
		   driver.findElement(password).sendKeys(pass);
		   driver.findElement(loginbtn).click();;
		
		}
	 
	 
	 
	 
//	 All Subjects page  locators 
	 private By menu = By.xpath("//*[@id=\"mobile-collapse\"]");
	 private By subjects = By.xpath("//*[@id=\"subjects\"]/a/span[2]");
	 private By classes_With_Subjects = By.xpath("//*[text()=\"Classes With Subjects\"]");
	 private By assign_subject_button = By.xpath("//*[@class=\"ti-plus\"]");
	 private By edit_subject = By.xpath("//h6[contains(text(),'Grade 4')]/a/i[contains(@class,'ti-pencil')]");
	 
//	 Create Subject section
	 private By select_class_List = By.xpath("//*[@placeholder=\"Select*\"]");
	 private By Subject_name = By.xpath("//*[@placeholder=\"Name Of Subject\"]");
	 private By marks = By.xpath("//*[@name=\"marks1\"]");
	 private By add_morebtn = By.xpath("//*[@id=\"add\"]");
	 private By remove_btn = By.xpath("//*[@id=\"Remove\"]");
	 private By assign_subjects_btn = By.xpath("//*[@class=\"btn bg-c-yellow\"]");
	 
	 
//	 update Subject section
	 private By select_class_update = By.xpath("//*[@id=\"searchlist\"]");
	 private By Subject_name_update = By.xpath("//*[@placeholder=\"Name Of Subject\"]");
	 private By marks_update = By.xpath("//*[@name=\"marks1\"]");
	 private By add_morebtn_update = By.xpath("//*[@id=\"add\"]");
	 private By remove_btn_update = By.xpath("//*[@id=\"Remove\"]");
	 private By assign_subjects_btn_update = By.xpath("//*[@class=\"btn bg-c-yellow\"]");

	 
	 
//	 This method to click edit on class you want 
	 public void Edit_subject() throws InterruptedException {


		    WebElement editIcon = driver.findElement(By.xpath("//h6[contains(text(),'Grade 1')]/a/i[contains(@class,'ti-pencil')]"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editIcon);
		    driver.findElement(Subject_name_update).clear();
		    driver.findElement(Subject_name_update).sendKeys("Math");	
		    driver.findElement(marks_update).clear();
		    driver.findElement(marks_update).sendKeys("93");
		    driver.findElement(assign_subjects_btn_update).click(); 
	 }
	 
	 
	 	 
	
//	 data provider to fill in class form 
	 @DataProvider(name = "Subjects_Data")
	    public static Object[][] loginData() {
	        return new Object[][]{
	        	{"Grade 4", "Science", "91"},
	            {"Grade 5", "Math", "93"},
	            {"Grade 1", "English", "93"},
	            {"Grade 1", "History", "98"},
	            {"Grade 9", "Science", "99"},
	            {"Grade 11", "Art", "93"},
	            {"Grade 3", "Science", "92"},
	            {"Grade 4", "Art", "94"},
	            {"Grade 7", "Math", "97"},
	            {"Grade 2", "Art", "98"},
	            {"Grade 10", "Art", "96"},
	            {"Grade 6", "History", "97"},
	            {"Grade 1", "Math", "91"},
	            {"Grade 8", "Science", "96"}
	            
	        };
	 }
	 
//	 this method to navigate to all subjects 
	 public void allSubjects() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(menu)).click();
		    driver.findElement(menu).click();
		    driver.findElement(subjects).click();
		    
		    driver.findElement(classes_With_Subjects).click();
		 
	 }
	 public void addnew_subject(String classname, String Subjectname, String marksf) {
		 
		    driver.findElement(assign_subject_button).click();
		    driver.findElement(select_class_List).sendKeys(classname);
		    driver.findElement(select_class_List).sendKeys(Keys.RETURN);
		    
		    driver.findElement(Subject_name).sendKeys(Subjectname);
		    driver.findElement(marks).sendKeys(marksf);;
		    driver.findElement(assign_subjects_btn).click();
		 
		       
		       }
	 }
	 
	 