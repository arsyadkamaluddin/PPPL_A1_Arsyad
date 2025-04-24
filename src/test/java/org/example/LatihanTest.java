package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LatihanTest {

    @Test
    public void youtubeChromeTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://youtube.com");
        String title = driver.getTitle();
        driver.quit();
        Assertions.assertEquals("YouTube",title);
    }
    @Test
    public void facebookChromeTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com");
        String title = driver.getTitle();
        driver.quit();
        Assertions.assertEquals("Facebook - Masuk atau Daftar",title);
    }

    @Test
    public void youtubeEdgeTest(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://youtube.com");
        String title = driver.getTitle();
        driver.quit();
        Assertions.assertEquals("YouTube",title);
    }
    @Test
    public void facebookEdgeTest(){
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://web.facebook.com");
        String title = driver.getTitle();
        driver.quit();
        Assertions.assertEquals("Facebook - Masuk atau Daftar",title);
    }
}
