package XKCDTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class XKCDTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public String baseURL;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        baseURL = "https://xkcd.com/";

    }

    @Test
    public void myTest() throws InterruptedException {

        driver.get(baseURL);
        String FirstPictures = driver.findElement(By.xpath("//body/div[@id='middleContainer']/div[@id='comic']/img[1]")).getAttribute("src");
        driver.findElement(By.xpath("//*[@id=\"middleContainer\"]/ul[1]/li[3]/a")).click();
        Thread.sleep(1000);
        String SecondPictures = driver.findElement(By.xpath("//body/div[@id='middleContainer']/div[@id='comic']/img[1]")).getAttribute("src");
        Thread.sleep(1000);
        Assert.assertNotEquals(FirstPictures, SecondPictures);

    }

    @AfterTest
    public void endTest() {
        driver.quit();
    }
}
