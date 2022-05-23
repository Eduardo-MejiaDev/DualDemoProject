package com.company;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestSauceLabsWorkflow {

    @Test
    public void TestStandardPurchase() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver101\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.saucedemo.com/";
        driver.get(url);
        String userNameId = "user-name";
        String userName = "standard_user";
        String password = "secret_sauce";
        String passwordId = "password";

        boolean confirmationbackPack = false;
        boolean confirmationTShirt = false;
        try {

            // Login
            LoginById(driver, userNameId, userName);
            LoginById(driver, passwordId, password);
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(1000);

            // Add  Backpack
            driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
            Thread.sleep(1000);

            // Navigate and add T-Shirt
            driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
            Thread.sleep(1000);

            // Go to cart
            driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
            Thread.sleep(1000);

            // Click on Checkout
            driver.findElement(By.id("checkout")).click();
            Thread.sleep(1000);

            // Fill in checkout info
            driver.findElement(By.id("first-name")).sendKeys("User");
            Thread.sleep(1000);
            driver.findElement(By.id("last-name")).sendKeys("Test");
            Thread.sleep(1000);
            driver.findElement(By.id("postal-code")).sendKeys("20000");
            Thread.sleep(1000);

            // Click to Continue
            driver.findElement(By.id("continue")).click();
            Thread.sleep(1000);

            //Sauce Labs Backpack
            WebElement backPackAssert = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div"));
            //Sauce Labs Bolt T-Shirt
            WebElement tShirtAssert = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div"));

            confirmationbackPack = backPackAssert.getText().equalsIgnoreCase("Sauce Labs Backpack");
            if (confirmationbackPack) {
                System.out.println("Sauce Labs Backpack correctly added");

            }
            confirmationTShirt = tShirtAssert.getText().equalsIgnoreCase("Sauce Labs Bolt T-Shirt");
            if (confirmationTShirt) {
                System.out.println("Sauce Labs Bolt T-Shirt correctly added");

            }

            WebElement finish = driver.findElement(By.id("finish"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView()", finish);
            finish.click();
            Thread.sleep(1000);


        } finally {
            Thread.sleep(1000);
            driver.quit();
            if (confirmationbackPack && confirmationTShirt){System.out.println("Test succeed!");}
        }


    }

    @Test
    public void TestProblemUserPurchase ()throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver101\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://www.saucedemo.com/";
        driver.get(url);
        String userNameId = "probblem-name";
        String userName = "standard_user";
        String password = "secret_sauce";
        String passwordId = "password";

        boolean confirmationbackPack = false;
        boolean confirmationTShirt = false;
        try {

            // Login
            LoginById(driver, userNameId, userName);
            LoginById(driver, passwordId, password);
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(1000);

            // Add  Backpack
            driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
            Thread.sleep(1000);

            // Navigate and add T-Shirt
            driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
            Thread.sleep(1000);

            // Go to cart
            driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
            Thread.sleep(1000);

            // Click on Checkout
            driver.findElement(By.id("checkout")).click();
            Thread.sleep(1000);

            // Fill in checkout info
            driver.findElement(By.id("first-name")).sendKeys("User");
            Thread.sleep(1000);
            driver.findElement(By.id("last-name")).sendKeys("Test");
            Thread.sleep(1000);
            driver.findElement(By.id("postal-code")).sendKeys("20000");
            Thread.sleep(1000);

            // Click to Continue
            driver.findElement(By.id("continue")).click();
            Thread.sleep(1000);

            //Sauce Labs Backpack
            WebElement backPackAssert = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div"));
            //Sauce Labs Bolt T-Shirt
            WebElement tShirtAssert = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div"));

            confirmationbackPack = backPackAssert.getText().equalsIgnoreCase("Sauce Labs Backpack");
            if (confirmationbackPack) {
                System.out.println("Sauce Labs Backpack correctly added");

            }
            confirmationTShirt = tShirtAssert.getText().equalsIgnoreCase("Sauce Labs Bolt T-Shirt");
            if (confirmationTShirt) {
                System.out.println("Sauce Labs Bolt T-Shirt correctly added");

            }

            WebElement finish = driver.findElement(By.id("finish"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView()", finish);
            finish.click();
            Thread.sleep(1000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            Thread.sleep(1000);
            driver.quit();
            if (confirmationbackPack && confirmationTShirt){System.out.println("Test succeed!");}
        }


    }
    @VisibleForTesting
    public static void  LoginById (@NotNull WebDriver driver, String id, String keysSend) throws InterruptedException {
        //driver.findElement(By.id(id)).sendKeys(keysSend);
        WebDriverWait  wait = new WebDriverWait(driver,5);
        WebElement complete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        Thread.sleep(1000);
        complete.sendKeys(keysSend);

        //Thread.sleep(2000);
    }

}
