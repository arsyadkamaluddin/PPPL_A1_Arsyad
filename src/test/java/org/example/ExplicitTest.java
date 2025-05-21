package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTest(){
        driver.get("https://saucedemo.com");
        String err = errMsg();
        Assertions.assertTrue(err.contains("required"));
    }

    public String errMsg(){
        driver.findElement(By.id("login-button")).submit();
        WebElement err = driver.findElement(By.className("error-message-container"));
        wait.until(ExpectedConditions.visibilityOf(err));
        return err.getText();
    }
}
