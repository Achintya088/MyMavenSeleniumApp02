package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Setup Chrome options for headless execution (Jenkins compatible)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");                // Run without GUI
        options.addArguments("--no-sandbox");              // Required in Jenkins/VM
        options.addArguments("--disable-dev-shm-usage");   // Prevent crashes
        options.addArguments("--remote-allow-origins=*");  // Fix for newer Chrome issues

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
    }
}
