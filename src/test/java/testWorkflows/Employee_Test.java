package testWorkflows;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		}
	

	
//    @Test(priority = 2,dataProvider="BasicInfoData", dataProviderClass = pages.Employees_Section.class)

	public void addnewemployee_withvalid(String name, String phoneNum, String rolef, String picturef, String date, String salaryf)  {
		
		test.Basic_Information_Valid(name, phoneNum, rolef, picturef, date, salaryf);
//		test.Other_Information();
		
	}
    
    
    @Test(priority = 3,dataProvider="AllInfoData", dataProviderClass = pages.Employees_Section.class)

	public void addEmployeewithAll_Information_Vlaid(String name, String phoneNum, String rolef, String picturef, String date, String salaryf, String fatehrn, String genderf, String experiancef, String id, String religionf, String emalif, String educationf, String bloodf, String date_ofB, String homeAddress)  {
		
		test.All_Information(name,  phoneNum,  rolef,  picturef,  date,  salaryf, fatehrn,  genderf,  experiancef,  id,  religionf,  emalif,  educationf,  bloodf,date_ofB,homeAddress);

		
	}
//	@Test(priority = 4)
	public void deleteTest() throws InterruptedException {
//		test.deleteallEmp("Ahmed Salah");
		test.deleteEmp_Byname("Therese Fforde");
	}

}
