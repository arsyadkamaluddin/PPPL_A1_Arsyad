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
        WebElement sub_item = driver.findElement(By.partialLinkText("Sub Sub Item 1"));
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
        action.sendKeys(Keys.SHIFT);
        WebElement enteredKey = driver.findElement(By.id("result"));
        Assertions.assertEquals("You entered: SHIFT",enteredKey.);
    }
}
