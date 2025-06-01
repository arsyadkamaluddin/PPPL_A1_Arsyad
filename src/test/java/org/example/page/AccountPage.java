package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoggedInVisible() {
        return driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]")).isDisplayed();
    }

    public void deleteAccount() {
        driver.findElement(By.linkText("Delete Account")).click();
    }
}