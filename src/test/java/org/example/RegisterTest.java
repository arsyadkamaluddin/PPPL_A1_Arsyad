package org.example;

import org.example.page.AccountPage;
import org.example.page.DeletePage;
import org.example.page.HomePage;
import org.example.page.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class RegisterTest {
    WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;
    AccountPage accountPage;
    DeletePage deletePage;

    @BeforeEach
    void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com");

        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        accountPage = new AccountPage(driver);
        deletePage = new DeletePage(driver);
    }

    @Test
    void registerTest() {
        Assertions.assertTrue(homePage.isHomeDisplayed());
        homePage.clickSignupLogin();

        Assertions.assertTrue(registerPage.isNewUserSignupVisible());

        String uniqueEmail = "testuser" + System.currentTimeMillis() + "@mail.com";
        registerPage.enterNameAndEmail("TestUser", uniqueEmail);

        Assertions.assertTrue(registerPage.isEnterAccountInfoVisible());

        registerPage.fillAccountInformation();
        registerPage.fillAddressInformation();

        Assertions.assertTrue(registerPage.isAccountCreatedVisible());
        registerPage.clickContinue();

        Assertions.assertTrue(accountPage.isLoggedInVisible());

        accountPage.deleteAccount();

        Assertions.assertTrue(deletePage.isAccountDeletedVisible());
        deletePage.clickContinue();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



