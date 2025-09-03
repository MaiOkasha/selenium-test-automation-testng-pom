/*
 * package testWorkflows;
 * 
 * import org.testng.annotations.BeforeClass; import
 * org.testng.annotations.DataProvider; import org.testng.annotations.Test;
 * import base.TeseBase;
 * 
 * import pages.AddStudentSection; import pages.AdminLoginPage; import
 * pages.AdmissionFormPage; import pages.AdmissionLetterPage; import
 * pages.StudentLoginPage;
 * 
 * public class testStudentsWorkflow extends TestBase{
 * 
 * private AdminLoginPage loginPage; private AddStudentSection
 * studentSectionPage; private AdmissionFormPage admissionFormPage; private
 * AdmissionLetterPage admissionLetterPage; private StudentLoginPage
 * studentLoginPage;
 * 
 * @BeforeClass public void init() { loginPage = new AdminLoginPage(driver);
 * studentSectionPage = new AddStudentSection(driver); admissionFormPage = new
 * AdmissionFormPage(driver); admissionLetterPage = new
 * AdmissionLetterPage(driver); studentLoginPage = new StudentLoginPage(driver);
 * }
 * 
 * // PreCondition For Test Cases
 * 
 * @Test(priority = 1, dataProvider = "Admin Login credentials") public void
 * testLogin(String email, String password) { loginPage.login(email, password);
 * }
 * 
 * @DataProvider(name = "Admin Login credentials") public Object[][]
 * getLoginData() { return new Object[][] { { "badaha.22@gmail.com",
 * "Aa00147235@@" }, };
 * 
 * }
 * 
 * //1- View All Students
 * 
 * 
 * 
 * 
 * 
 * }
 */