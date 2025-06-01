package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeletePage {
    WebDriver driver;

    public DeletePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAccountDeletedVisible() {
        return driver.findElement(By.xpath("//b[text()='Account Deleted!']")).isDisplayed();
    }

    public void clickContinue() {
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
    }
}