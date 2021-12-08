import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bspb {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://idemo.bspb.ru/");

        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("login-otp-button")).click();
        driver.findElement(By.id("deposits-index")).click();
        driver.findElement(By.id("btn-show-rates")).click();
        driver.findElement(By.xpath("//*[@value='USD']")).click();
        driver.findElement(By.xpath("//*[@value='91']")).click();
        driver.findElement(By.xpath("//*[@data-rate-id='10182']//*[@class='btn btn-mini btn-primary place-deposit']")).click();
        driver.findElement(By.id("endDate")).click();
        driver.findElement(By.xpath("//td[.='26']")).click();
        driver.findElement(By.id("amount")).sendKeys("1000");
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name='prolongation']")).click();
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.xpath("//*[@class='immune required condition']")).click();
        Thread.sleep(500);
        driver.findElement(By.id("confirm")).click();
        Thread.sleep(900);
        driver.quit();
    }
}