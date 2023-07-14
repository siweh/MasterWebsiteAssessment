package com.amplifyapp.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class SetUp {
    public static WebDriver driver;
    public static WebDriver SetUpDriver(String browser, String url) {
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(url);
            }else {
                throw new IllegalArgumentException("Invalid browser value provided: " + browser);
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            return driver;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
