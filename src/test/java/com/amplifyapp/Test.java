package com.amplifyapp;

import com.amplifyapp.Applications.Product;
import com.amplifyapp.Utilities.SetUp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Test {
    public WebDriver driver;
    public Product product;
    @BeforeTest
    @Parameters({"browser", "url"})
    public void setupDriver(String browser, String url) {
        try {
            driver = SetUp.SetUpDriver(browser, url);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        product = new Product(driver);
    }

    @org.testng.annotations.Test(priority = 5)
    public void addProductToCartTest(){
        String expectedText = "You have just added 0 of Grapes to cart";
        String actualText = product.AddProductToCart();
        Assert.assertEquals(actualText, expectedText,  "Product not added to cart");
    }

    @org.testng.annotations.Test(priority = 1)
    public void addProductTest(){
        String expectedText = "Only 4 items available";
        String actualText = product.addProducts();
        Assert.assertEquals(actualText, expectedText, "Product is not added.");
    }

    @org.testng.annotations.Test(priority = 2)
    public void continueShoppingTest(){
        Assert.assertTrue(product.ContinueShopping(), "Product added and can not continue shopping");
    }

    @org.testng.annotations.Test(priority = 4)
    public void removeItemFromCartTest(){
        Assert.assertTrue(product.RemoveProductFromCart(), "Product is not removed from the cart");
    }

    @org.testng.annotations.Test(priority = 6)
    public void clickOnSpecialsTest(){
        Assert.assertTrue(product.clickOnSpecials(), "It directs to a 404 page not found");
    }

    @org.testng.annotations.Test(priority = 3)
    public void searchForAProductTest(){
        String itemName = "Grapes";
        Assert.assertTrue(product.searchAProduct(itemName), "Able to search a product but returns a different product");
    }

    @AfterTest
    public void cleanup() {
        driver.quit();
    }

}

