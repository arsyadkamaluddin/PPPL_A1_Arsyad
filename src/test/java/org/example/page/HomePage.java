package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomeDisplayed() {
        return driver.findElement(By.tagName("body")).getText().contains("Home");
    }

    public void clickSignupLogin() {
        driver.findElement(By.linkText("Signup / Login")).click();
    }
}
