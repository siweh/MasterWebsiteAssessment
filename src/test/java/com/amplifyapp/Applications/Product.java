package com.amplifyapp.Applications;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product {
    public static WebDriver driver;

    public Product(WebDriver driver) {
        this.driver = driver;
    }

    public By itemName = By.xpath("//div[normalize-space()='Grapes']");
    public By addQuantity = By.xpath("(//button[@type='button'][normalize-space()='+'])[5]");
    public By addToCartButton = By.xpath("(//button[@type='button'][normalize-space()='ADD TO CART'])[5]");
    public void ScrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
    }

    public String AddProductToCart(){
        String alertMessage;
        try {
            ScrollDown();
            driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='+'])[3]")).click();
            driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='ADD TO CART'])[3]")).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//            itemMessage = driver.findElement(By.xpath("//div[@role='alert']")).getText();
            alertMessage = alert.getText();
            System.out.println(alertMessage);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return alertMessage;
    }

    public boolean RemoveProductFromCart(){
        try {
            ScrollDown();
            driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='+'])[3]")).click();
            driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='ADD TO CART'])[3]")).click();
            driver.findElement(By.xpath("(//div[@class='col-3'])[2]")).click();
            driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='REMOVE'])[1]")).click();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean clickOnSpecials(){
        driver.findElement(By.xpath("//a[normalize-space()='Specials']")).click();
        return true;
    }

    public boolean searchAProduct(String item){
        WebElement searchInputField = driver.findElement(By.cssSelector("input[placeholder='Enter Category (fruits, cereal) ']"));
        searchInputField.sendKeys(item);
        searchInputField.sendKeys(Keys.ENTER);

//        WebElement productResults = driver.findElement(By.xpath("(//div[@class='col-md-4'])[1]"));
//        if (productResults.isDisplayed()){
//            if (productResults.getText() == item){
//                return true;
//            }else {
//                return false;
//            }
//        }
        return true;
    }

    public String addProducts(){
        String alertMessage;
        try {
            ScrollDown();
            for (int i = 0; i < 4; i++){
                driver.findElement(addQuantity).click();
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            alertMessage = alert.getText();
            System.out.println(alertMessage);

//            WebElement messageAlert = driver.findElement(By.xpath("//ngb-alert[@role='alert']"));


        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return alertMessage;
    }

    public boolean ContinueShopping(){
        ScrollDown();
        driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='+'])[5]")).click();
        driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='ADD TO CART'])[5]")).click();
        driver.findElement(By.xpath("(//div[@class='col-3'])[2]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='CONTINUE SHOPPING']")).click();
        return true;
    }
}
