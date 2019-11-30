package Mobipunkt.OrderFormInputTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class OrderFormInputTest {
    JavascriptExecutor js;
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        Map<String, Object> vars = new HashMap<>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void orderTest() {
        driver.get("https://www.mobipunkt.ee/");
        driver.manage().window().setSize(new Dimension(1680, 955));
        driver.findElement(By.linkText("iPhone")).click();
        driver.findElement(By.cssSelector(".disambugation:nth-child(6) > .disambiguation-message > .alates-a")).click();
        driver.findElement(By.linkText("alates €1179.00 ›")).click();
        driver.findElement(By.cssSelector(".blue-button")).click();
        driver.findElement(By.id("addtocart")).click();
        driver.findElement(By.id("cartbutton")).click();
        driver.findElement(By.cssSelector(".blue-button-g")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).sendKeys("asdsadsa");
        driver.findElement(By.id("trackpurchase")).click();
        driver.findElement(By.name("email")).sendKeys("dsda@dada.co");
        driver.findElement(By.id("trackpurchase")).click();
    }
}
