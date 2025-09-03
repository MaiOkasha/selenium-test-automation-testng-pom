package testWorkflows;


import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Employees_Section;

public class Employee_Test extends TestBase {
	
	Employees_Section test;
	
	@BeforeClass
	 public void setUpEmployeeSection() {
        test = new Employees_Section(driver, action);
    }

	
	@Test(priority=1)
	public void Login() throws InterruptedException {
		
		test.login("badaha.22@gmail.com","Aa00147235@@");
		Assert.assertTrue(test.login_assert());
		
		
		}
	
	@Test(priority = 2)
	public void Update_Emp_info() throws InterruptedException {
		test.edit_emp_info();
		Assert.assertTrue(test.checkupdate());
	}
	
	
	@Test(priority = 3)
	public void view_employeeinfo() {
		test.view_employee_info();
		Assert.assertTrue(test.employee_view());
		
	}
	
	
	
	@Test(priority = 4)
	public void search() {
		test.search_for_employye("Bernita Flieger");
		Assert.assertTrue(test.check_search("Bernita Flieger"));
	}
	
	@Test(priority = 5)
	public void allbutton() {
		test.allbutton();
		Assert.assertTrue(test.check_all_employyes_displayed());

	}
	
	@Test(priority = 6)
	public void Search_with_invalid_Data() throws InterruptedException {
		test.search_for_employye_with_invalid_data();
		Assert.assertTrue(test.check_search_invalid());
		
	}
	@Test(priority = 7)
	public void delete_emp_byname() throws InterruptedException {
		test.delete_Emp("Perry Kneeshaw");
		
		  Assert.assertFalse(test.isEmployeePresent("Perry Kneeshaw"),"employee exist");
		  
		
	}
	
	
	

    
    @Test(priority = 8,dataProvider="AllInfoData", dataProviderClass = pages.Employees_Section.class)
	public void addEmployeewithAll_Information_Vlaid(String name, String phoneNum, String rolef, String picturef, String date, String salaryf, String fatehrn, String genderf, String experiancef, String id, String religionf, String emalif, String educationf, String bloodf, String date_ofB, String homeAddress) throws InterruptedException  {
		
		test.All_Information(name,  phoneNum,  rolef,  picturef,  date,  salaryf, fatehrn,  genderf,  experiancef,  id,  religionf,  emalif,  educationf,  bloodf,date_ofB,homeAddress);

		  
		  
		  

	}
	 @Test(priority = 9)
	    public void check_valid() {
	    	test.allemployee_page();
	    	Assert.assertTrue(test.isEmployeePresent("Will Bodicum"));
			  Assert.assertTrue(test.isEmployeePresent("Sherwynd Doone"));
			  Assert.assertTrue(test.isEmployeePresent("Paulina Brazelton"));
			  Assert.assertTrue(test.isEmployeePresent("Greta Hasted"));
			  Assert.assertTrue(test.isEmployeePresent("Leyla Martinat"));
			  Assert.assertTrue(test.isEmployeePresent("Lennie Wilkie"));
			  Assert.assertTrue(test.isEmployeePresent("Trudy Mullinger"));
			  Assert.assertTrue(test.isEmployeePresent("Merissa Claessens"));
			  Assert.assertTrue(test.isEmployeePresent("Norman Anglish"));
			  Assert.assertTrue(test.isEmployeePresent("Bram Mitford"));
	    }
    
    @Test(priority = 10,dataProvider="AllInfoData_Form_Full_invalid", dataProviderClass = pages.Employees_Section.class)
	public void addEmployeewithAll_Information_inVlaid(String name, String phoneNum, String rolef, String picturef, String date, String salaryf, String fatehrn, String genderf, String experiancef, String id, String religionf, String emalif, String educationf, String bloodf, String date_ofB, String homeAddress) throws InterruptedException  {
		
		test.All_Information(name,  phoneNum,  rolef,  picturef,  date,  salaryf, fatehrn,  genderf,  experiancef,  id,  religionf,  emalif,  educationf,  bloodf,date_ofB,homeAddress);
		
		  

		  

	}
    @Test(priority = 11)
    public void check_invlaid() {
    	test.allemployee_page();
		  Assert.assertTrue(test.isEmployeePresent("Sherwynd Doonedddddddddddddddd"));
		  Assert.assertTrue(test.isEmployeePresent("Will Bodicumdddddddddddddddddd"));
    }
    
    @Test(priority = 12,dataProvider="AllInfoData_Form_Full_duplicated", dataProviderClass = pages.Employees_Section.class)
   	public void addEmployeewithAll_Information_dublicated(String name, String phoneNum, String rolef, String picturef, String date, String salaryf, String fatehrn, String genderf, String experiancef, String id, String religionf, String emalif, String educationf, String bloodf, String date_ofB, String homeAddress) throws InterruptedException  {
   		
   		test.All_Information(name,  phoneNum,  rolef,  picturef,  date,  salaryf, fatehrn,  genderf,  experiancef,  id,  religionf,  emalif,  educationf,  bloodf,date_ofB,homeAddress);

   		  

   	}
    @Test(priority=13)
    public void check_dublicated() {
    	test.allemployee_page();
    	  Assert.assertTrue(test.isEmployeePresent("Will Bodicum"));
 		  Assert.assertTrue(test.isEmployeePresent("Sherwynd Doone"));
 		  Assert.assertTrue(test.isEmployeePresent("Paulina Brazelton"));
    }
		 
    @Test(priority=14)
    public void Print_job_letter() throws AWTException, InterruptedException {
    	test.Job_letter();
    	Assert.assertTrue(test.check_jobLetter());
    }
    
    @Test(priority=15)
    public void Manage_login_Usernam_Password() throws InterruptedException, AWTException {
    	test.Manage_login();

    }
    @Test(priority=16)
    public void Login_As_employee() throws InterruptedException, AWTException {
    	test.LogOut();
    	test.login_As_Employee();


    }


}
