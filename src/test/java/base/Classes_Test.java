package base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.AssertJUnit.assertTrue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

//import Automation_Project.Employees_Section;

public class Classes_Test extends BaseTest{
	
	
	ClassesPage test1;
	
	@BeforeClass
	 public void setUpEmployeeSection() {
        
        test1=new ClassesPage (driver);
    }

	
	@Test(priority=1)
	public void Login() throws InterruptedException {
		
		test1.login("badaha.22@gmail.com","Aa00147235@@");
		test1.allclasses();
	    //test1.Edit_class();
		test1.delete_class();
		}

	@Test(priority=4,dataProvider="class_Data", dataProviderClass = ClassesPage.class)
	public void add_class(String classn, String fees, String teacher) throws InterruptedException {
		
	       test1.addnew_Class(classn, fees, teacher);
		   // Assert that the new element shows up on the page
		WebElement newClass = driver.findElement(By.xpath("//h6[contains(text(),'Grade 1')]"));
		Assert.notNull(newClass, "New class was not found after adding.");
		System.out.println(newClass);

	   
	}
}
