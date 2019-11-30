package Mobipunkt.ResolutionTest;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MobipunktResolutionTest {
    private WebDriver driver;
    private String url;

    @Before
    public void setUp() {
        // test url
        this.url = "http://www.mobipunkt.ee/";

        driver = new ChromeDriver();

        driver.get(this.url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testResolution() {
        driver.navigate().to(this.url);

        String[] resolutions = {
                "128x72",
                "256x144",
                "384x216",
                "512x288",
                "640x360",
                "768x432",
                "896x504",
                "1024x576",
                "1152x648",
                "1280x720",
                "1408x792",
                "1536x864",
                "1664x936",
                "1792x1008",
                "1920x1080",
                "2048x1152",
                "2176x1224",
                "2304x1296",
                "2432x1368",
                "2560x1440",
                "2668x1512",
                "2816x1584",
                "2944x1656",
                "3072x1728",
                "3200x1800",
                "3328x1872",
                "3456x1944",
                "3584x2016",
                "3712x2088",
                "3840x2160",
                "3968x2232",
                "4096x2304",
                "4224x2376",
                "4352x2448",
                "4608x2592",
                "4736x2664",
                "4864x2736",
                "4992x2808",
                "5120x2880",
                "5248x2952",
                "5376x3024",
                "5504x3096",
                "5632x3168",
                "5760x3240",
                "5888x3312",
                "6016x3384",
                "6144x3456",
                "6272x3528",
                "6400x3600",
                "6528x3672",
                "6656x3744",
                "6784x3816",
                "6912x3888",
                "7040x3960",
                "7168x4032",
                "7296x4104",
                "7424x4176",
                "7552x4248",
                "7680x4320"
        };

        for (String resolution : resolutions) {
            String[] parts = resolution.split("x");
            Dimension screenRes = new Dimension(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

            // Set browser resolution
            driver.manage().window().setSize(screenRes);
            driver.navigate().refresh();
        }
    }
}
