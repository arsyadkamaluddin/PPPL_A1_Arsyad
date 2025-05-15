package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void searchTest(){
        driver.get("https://www.bing.com");
        WebElement searchInput = driver.findElement(By.id("sb_form_q"));
        searchInput.sendKeys("Arsyad");
        searchInput.submit();
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.contains("Arsyad"));
    }

    @Test
    public void navigationTest(){
        driver.get("https://demoqa.com/menu");
        WebElement menu2 = driver.findElement(By.linkText("Main Item 2"));
        action.moveToElement(menu2).perform();
        WebElement sub_list = driver.findElement(By.partialLinkText("SUB SUB LIST"));
        action.moveToElement(sub_list).perform();
        WebElement sub_item = driver.findElement(By.linkText("Sub Sub Item 1"));
        action.moveToElement(sub_item).click().perform();
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.endsWith("#"));
    }

    @Test
    public void loginTest(){
        driver.get("https://www.saucedemo.com");
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        passwordInput.submit();
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.endsWith("inventory.html"));
    }

    @Test
    public void hoverTest(){
        driver.get("https://the-internet.herokuapp.com");
        WebElement linkToHoverPage = driver.findElement(By.linkText("Hovers"));

        action.moveToElement(linkToHoverPage).click().perform();
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.endsWith("hovers"));

        WebElement firstImage = driver.findElement(By.cssSelector(".figure img"));
        WebElement firstName = driver.findElement(By.cssSelector(".figure .figcaption h5"));
        action.moveToElement(firstImage).perform();
        Assertions.assertTrue(firstName.isDisplayed());
        Assertions.assertEquals("name: user1",firstName.getText());
    }

    @Test
    public void dragDropTest(){
        driver.get("https://the-internet.herokuapp.com");
        WebElement linkToHoverPage = driver.findElement(By.linkText("Drag and Drop"));

        action.moveToElement(linkToHoverPage).click().perform();
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.endsWith("drag_and_drop"));

        WebElement firstBlock = driver.findElement(By.id("column-a"));
        WebElement secondBlock = driver.findElement(By.id("column-b"));

        Assertions.assertEquals("A",  firstBlock.findElement(By.tagName("header")).getText());
        Assertions.assertEquals("B",  secondBlock.findElement(By.tagName("header")).getText());

        action.clickAndHold(firstBlock).moveToElement(secondBlock).release(secondBlock).build().perform();

        Assertions.assertEquals("B",  firstBlock.findElement(By.tagName("header")).getText());
        Assertions.assertEquals("A",  secondBlock.findElement(By.tagName("header")).getText());
    }

    @Test
    public void keyPressTest(){
        driver.get("https://the-internet.herokuapp.com");
        WebElement linkToHoverPage = driver.findElement(By.linkText("Key Presses"));

        action.moveToElement(linkToHoverPage).click().perform();
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.endsWith("key_presses"));

        WebElement inputField = driver.findElement(By.id("target"));
        inputField.sendKeys(Keys.SHIFT);
        WebElement enteredKey = driver.findElement(By.id("result"));
        Assertions.assertEquals("You entered: SHIFT",enteredKey.getText());
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



