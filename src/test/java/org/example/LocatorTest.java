package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LocatorTest {

    WebDriver driver;
    Actions action;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    void registerTest() {
        driver.get("http://automationexercise.com");
        Assertions.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Home"));
        driver.findElement(By.linkText("Signup / Login")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed());

        driver.findElement(By.name("name")).sendKeys("TestUser");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("testuser" + System.currentTimeMillis() + "@mail.com");

        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed());

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("Test@1234");

        new Select(driver.findElement(By.id("days"))).selectByValue("10");
        new Select(driver.findElement(By.id("months"))).selectByValue("5");
        new Select(driver.findElement(By.id("years"))).selectByValue("2000");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("first_name")).sendKeys("Test");
        driver.findElement(By.id("last_name")).sendKeys("User");
        driver.findElement(By.id("company")).sendKeys("Automation Inc.");
        driver.findElement(By.id("address1")).sendKeys("123 Test Street");
        driver.findElement(By.id("address2")).sendKeys("Suite 100");
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");
        driver.findElement(By.id("state")).sendKeys("StateTest");
        driver.findElement(By.id("city")).sendKeys("CityTest");
        driver.findElement(By.id("zipcode")).sendKeys("123456");
        driver.findElement(By.id("mobile_number")).sendKeys("1234567890");

        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed());

        driver.findElement(By.xpath("//button[text()='Continue']")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed());

        driver.findElement(By.linkText("Delete Account")).click();

        Assertions.assertTrue(driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed());
        driver.findElement(By.linkText("Continue")).click();
    }
}



