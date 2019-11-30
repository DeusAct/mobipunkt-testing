package Mobipunkt.UudiskiriTest;

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

public class MobipunktUudiskiriTest {
    JavascriptExecutor js;
    private WebDriver driver;
    private Map<String, Object> vars;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void uudiskiriTest() {
        driver.get("https://www.mobipunkt.ee/");
        driver.manage().window().setSize(new Dimension(1680, 955));
        driver.findElement(By.id("email2")).click();
        driver.findElement(By.id("email2")).sendKeys("23213");
        driver.findElement(By.cssSelector(".blue-button4")).click();
        driver.findElement(By.id("email2")).click();
        driver.findElement(By.id("email2")).sendKeys("23213@dsdas");
        driver.findElement(By.cssSelector(".blue-button4")).click();
    }
}
