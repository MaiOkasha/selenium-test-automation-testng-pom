package testWorkflows;


import org.testng.annotations.Test;


import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import dev.failsafe.internal.util.Assert;
import pages.Subjects_Page;

//import Automation_Project.Employees_Section;

public class Subjects_Test extends BaseTest{
	
	
	Subjects_Page test1;
	
	@BeforeClass
	 public void setUpEmployeeSection() {
        
        test1 = new Subjects_Page (driver);
    }

	
	@Test(priority=1)
	public void Login() throws InterruptedException {
		
		test1.login("badaha.22@gmail.com","Aa00147235@@");
		test1.allSubjects();
	//	test1.Edit_subject();
		
		}

	@Test(priority=4,dataProvider="Subjects_Data", dataProviderClass = Subjects_Page.class)
	public void add_class(String classn, String subject, String marksf) throws InterruptedException {
		
		test1.addnew_subject(classn, subject, marksf);
		
	}
}