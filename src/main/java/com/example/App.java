package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class App {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");           // ✅ Use new headless mode (Chrome 112+)
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");            // ✅ Required on Linux
        options.addArguments("--window-size=1920,1080");  // ✅ Replace maximize() in headless
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");     // ✅ Avoid extension crashes

        WebDriver driver = null;

        try {
            driver = new ChromeDriver(options);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get("https://practicetestautomation.com/practice-test-login/");

            // ✅ Wait for elements instead of relying on implicit timing
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")))
                .sendKeys("student");

            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            // ✅ Verify login success
            WebElement successMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("post-title"))
            );
            System.out.println("Login result: " + successMsg.getText());

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit(); // ✅ Always close the browser
            }
        }
    }
}
