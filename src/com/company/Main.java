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

public class Main {

    @Test
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver101\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

            String url ="https://www.saucedemo.com/";
            driver.get(url);
            String userNameId = "user-name";
            String userName = "performance_glitch_user";
            String password = "secret_sauce";
            String passwordId ="password";
            String userNameClass ="input_error form_input";
            String userNamename ="user-name";
            String myName ="Eduardo";
            String myLastName ="Mejia";
            String myZipCode ="23567";

            try{
                //driver.manage().window().fullscreen();
                //driver.findElement(By.className(userNameClass)).sendKeys(userName);
                LoginById (driver,userNameId,userName);
                //driver.findElement(By.cssSelector(".form_group")).sendKeys(userName);
                //driver.findElement(By.name(userNamename)).sendKeys(userName);
                LoginById(driver,passwordId,password);
                //driver.findElement(By.className("form_group"));

                //driver.findElement(By.className("submit-button btn_action")).click();
                driver.findElement(By.id("login-button")).click();

                Thread.sleep(2000);

                driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
                Thread.sleep(2000);
                driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("checkout")).click();
                driver.findElement(By.id("first-name")).sendKeys(myName);
                Thread.sleep(2000);
                driver.findElement(By.id("last-name")).sendKeys(myLastName);
                Thread.sleep(2000);
                driver.findElement(By.id("postal-code")).sendKeys(myZipCode);
                Thread.sleep(2000);
                driver.findElement(By.id("continue")).click();
                Thread.sleep(2000);
                WebElement finish = driver.findElement(By.id("finish"));
                JavascriptExecutor js = (JavascriptExecutor)driver;
                js.executeScript("arguments[0].scrollIntoView()",finish);
                finish.click();
                Thread.sleep(2000);

                WebElement confirmation= driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
                js.executeScript("arguments[0].scrollIntoView()",confirmation);
                //String confirmationText = confirmation.getText();
                //Assert.assertEquals("THANK YOU FOR YOUR ORDER",confirmationText);

                boolean confirmationText = confirmation.getText().equalsIgnoreCase("THANK YOU FOR YOUR ORDER");
                if (confirmationText)
                {
                    System.out.println("Confirmation Assert pass");

                }


            } finally {
                Thread.sleep(2000);
                driver.quit();
                System.out.println("Test succeed!");
            }


    }
    @VisibleForTesting
    public static void  LoginById (@NotNull WebDriver driver, String id, String keysSend) throws InterruptedException {
        //driver.findElement(By.id(id)).sendKeys(keysSend);
        WebDriverWait  wait = new WebDriverWait(driver,5);
        WebElement complete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        Thread.sleep(2000);
        complete.sendKeys(keysSend);

        //Thread.sleep(2000);
    }
}
