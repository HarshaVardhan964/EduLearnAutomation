package TestPack;

import org.testng.annotations.Test;

import PageObjects.LoginPage;
import TestComponents.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        driver.get("https://www.saucedemo.com/");
        LoginPage login = new LoginPage(driver);
        login.enterUsername("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLogin();

        assert driver.getCurrentUrl().contains("inventory") : "Login failed!";
    }
}
