package testWorkflows;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("badaha.22@gmail.com", "Aa00147235@@");

        // After login, assert something that proves success
        Assert.assertTrue(
            driver.getCurrentUrl().contains("dashboard"),
            "Login failed, dashboard not loaded!"
        );
    }
}
