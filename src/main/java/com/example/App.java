package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args){

        ChromeOptions options = new ChromeOptions();

        // REQUIRED for Jenkins / Linux headless execution
        options.addArguments("--headless=new");   // run without UI
        options.addArguments("--no-sandbox");     // required if running as root
        options.addArguments("--disable-dev-shm-usage"); // avoid memory issues
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://automationexercise.com/products");
        driver.manage().window().maximize();

        driver.findElement(By.id("search_product")).sendKeys("shirt");
        driver.findElement(By.id("submit_search")).click();

        // Optional: wait a bit to see results in logs
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
