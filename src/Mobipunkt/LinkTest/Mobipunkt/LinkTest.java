package Mobipunkt.LinkTest.Mobipunkt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinkTest {

    private WebDriver driver;
    private String url;

    private static void verifyLink(String urlLink) {
        try {
            URL link = new URL(urlLink);
            HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
            httpConn.setConnectTimeout(2000);
            httpConn.connect();

            if (httpConn.getResponseCode() == 200) {
                System.out.println(urlLink + " - " + httpConn.getResponseMessage());
            }
            if (httpConn.getResponseCode() == 404) {
                System.out.println(urlLink + " - " + httpConn.getResponseMessage());
            }
        } catch (Exception ignored) {
        }
    }

    @Before
    public void setup() {
        this.url = "http://www.mobipunkt.ee/";
        driver = new ChromeDriver();
        driver.get(this.url);
    }

    @Test
    public void main() throws InterruptedException {

        driver.navigate().to(this.url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(5000);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links are " + links.size());
        for (WebElement element : links) {
            String url = element.getAttribute("href");
            verifyLink(url);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}