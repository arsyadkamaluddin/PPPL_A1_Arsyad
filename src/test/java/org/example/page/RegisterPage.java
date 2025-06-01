package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNewUserSignupVisible() {
        return driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
    }

    public void enterNameAndEmail(String name, String email) {
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
    }

    public boolean isEnterAccountInfoVisible() {
        return driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed();
    }

    public void fillAccountInformation() {
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("Test@1234");

        new Select(driver.findElement(By.id("days"))).selectByValue("10");
        new Select(driver.findElement(By.id("months"))).selectByValue("5");
        new Select(driver.findElement(By.id("years"))).selectByValue("2000");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();
    }

    public void fillAddressInformation() {
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
    }

    public boolean isAccountCreatedVisible() {
        return driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();
    }

    public void clickContinue() {
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
    }
}
