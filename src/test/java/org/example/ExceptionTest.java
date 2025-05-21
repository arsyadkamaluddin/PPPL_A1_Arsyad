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

public class ExceptionTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-exceptions");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        try {
            driver.findElement(By.id("add_btn")).click();
            WebElement inputField = driver.findElement(By.cssSelector("#row2 .input-field"));
            Assertions.assertTrue(inputField.isDisplayed());
        } catch (Exception e) {
            System.out.println("Class : " + e.getClass());
            System.out.println("Desc : " + e.getMessage());
        }
    }

    @Test
    public void thirdTest() {
        try {
            WebElement input = driver.findElement(By.className("input-field"));
            input.clear();
            input.sendKeys("edit");
            Assertions.assertEquals("edit", input.getText());
        } catch (Exception e) {
            System.out.println("Class : " + e.getClass());
            System.out.println("Desc : " + e.getMessage());
        }
    }

    @Test
    public void fourthTest() {
        try {
            WebElement instruction = driver.findElement(By.id("instructions"));
            driver.findElement(By.id("add_btn")).click();
            Assertions.assertFalse(instruction.isDisplayed());
        } catch (Exception e) {
            System.out.println("Class : " + e.getClass());
            System.out.println("Desc : " + e.getMessage());
        }
    }

    @Test
    public void fifthTest() {
        try {
            driver.findElement(By.id("add_btn")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#row2 .input-field")));
            Assertions.assertTrue(driver.findElement(By.cssSelector("#row2 .input-field")).isDisplayed());
        } catch (Exception e) {
            System.out.println("Class : " + e.getClass());
            System.out.println("Desc : " + e.getMessage());
        }
    }
}
