package testWorkflows;

import base.BaseTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AttendancePage;

public class AttendanceTest extends BaseTest {

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 1)
    public void TC_AT_001_SubmitStudentAttendance_CurrentDate() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("badaha.22@gmail.com", "Aa00147235@@");
        sleep(2000); // allow login to complete

        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToStudentAttendance();
        sleep(2000); // wait for student attendance page to load

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String today = LocalDate.now().format(formatter);

        attendancePage.selectDate(today);
        attendancePage.selectClass("Grade 2");
        attendancePage.submitAttendance();
        sleep(2000); // wait for submit action to process
    }

    @Test(priority = 2)
    public void TC_AT_002_SubmitStudentAttendance_PastDate() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToStudentAttendance();
        sleep(2000);

        String twoDaysAgo = LocalDate.now().minusDays(2).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        attendancePage.selectDate(twoDaysAgo);
        attendancePage.selectClass("Grade 2");
        attendancePage.submitAttendance();
        sleep(2000);
    }

    @Test(priority = 3)
    public void TC_AT_003_SubmitStudentAttendance_FutureDate() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToStudentAttendance();
        sleep(2000);

        String twoDaysLater = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        attendancePage.selectDate(twoDaysLater);
        attendancePage.selectClass("Grade 2");
        attendancePage.submitAttendance();
        sleep(2000);
    }

    @Test(priority = 4)
    public void TC_AT_004_SubmitEmployeeAttendance_CurrentDate() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToEmployeeAttendance();
        sleep(2000);

        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        attendancePage.selectDate(today);
        attendancePage.submitAttendance();
        sleep(2000);
    }

    @Test(priority = 5)
    public void TC_AT_005_SubmitEmployeeAttendance_PastDate() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToEmployeeAttendance();
        sleep(2000);

        String twoDaysAgo = LocalDate.now().minusDays(2).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        attendancePage.selectDate(twoDaysAgo);
        attendancePage.submitAttendance();
        sleep(2000);
    }

    @Test(priority = 6)
    public void TC_AT_006_SubmitEmployeeAttendance_FutureDate() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToEmployeeAttendance();
        sleep(2000);

        String twoDaysLater = LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        attendancePage.selectDate(twoDaysLater);
        attendancePage.submitAttendance();
        sleep(2000);
    }

    // ---------- Reports Section ----------

    @Test(priority = 7)
    public void TC_AT_007_ViewClassWiseAttendanceReport() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToClassWiseReport();
        sleep(2000);
    }

    @Test(priority = 8)
    public void TC_AT_008_ViewStudentAttendanceReport() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToStudentReport();
        sleep(2000);
    }

    @Test(priority = 9)
    public void TC_AT_009_ViewEmployeeAttendanceReport() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToEmployeeReport();
        sleep(2000);
    }

    @Test(priority = 10)
    public void TC_AT_010_FilterStudentReport_ByDate() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToStudentReport();
        sleep(2000);

        attendancePage.search("04-09-25");
        sleep(2000); // wait for filter results
        Assert.assertEquals(attendancePage.getFirstRowDate(), "04-09-25", "Date filter failed!");
    }

    @Test(priority = 11)
    public void TC_AT_011_FilterStudentReport_ByClass() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToStudentReport();
        sleep(2000);

        attendancePage.search("Grade 2");
        sleep(2000);
        Assert.assertEquals(attendancePage.getFirstRowClass(), "Grade 2", "Class filter failed!");
    }

    @Test(priority = 12)
    public void TC_AT_012_FilterEmployeeReport_ByName() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToEmployeeReport();
        sleep(2000);

        attendancePage.search("Alexandros Gaspero");
        sleep(2000);
        Assert.assertEquals(attendancePage.getFirstRowName(), "Alexandros Gaspero", "Name filter failed!");
    }

    @Test(priority = 13)
    public void TC_AT_013_FilterEmployeeReport_ByDepartment() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToEmployeeReport();
        sleep(2000);

        attendancePage.search("Teacher");
        sleep(2000);
        Assert.assertEquals(attendancePage.getFirstRowType(), "Teacher", "Type filter failed!");
    }

    @Test(priority = 14)
    public void TC_AT_014_DownloadStudentReport() {
        AttendancePage attendancePage = new AttendancePage(driver);
        attendancePage.goToEmployeeReport();
        sleep(2000);

        attendancePage.search("Teacher");
        sleep(2000);
        attendancePage.downlodeEmployeeReport();
        sleep(3000); // allow file download
    }
}
