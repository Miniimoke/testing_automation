import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class BspbTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String BSPB_BASE_URL = "https://idemo.bspb.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        driver.get(BSPB_BASE_URL);
    }

    @Test
    void OpenDepositTest () {
        login();
        driver.findElement(By.id("deposits-index")).click();
        driver.findElement(By.id("btn-show-rates")).click();
        driver.findElement(By.xpath("//*[@value='USD']")).click();
        driver.findElement(By.xpath("//*[@value='91']")).click();
        driver.findElement(By.xpath("//*[@data-rate-id='10182']//*[@class='btn btn-mini btn-primary place-deposit']")).click();
        driver.findElement(By.id("endDate")).click();
        driver.findElement(By.xpath("//td[.='26']")).click();
        driver.findElement(By.id("amount")).sendKeys("2000");
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.xpath("//span[@class='input-borderless uneditable-input']//span[@id='interest-rate']"), String.valueOf(2.95)));
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.xpath("//*[@class='immune required condition']")).click();
        driver.findElement(By.id("confirm")).click();
        assertThat(driver.findElement(By.xpath("//div[@class='alert alert-success']")),
                hasText("Вклад открыт. Средства будут зачислены на него через некоторое время. " +
                        "Состояние зачисления отражено в истории переводов. Получить Уведомление об открытии вклада можно, " +
                        "обратившись в любое отделение Банка."));
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

    void login () {
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("login-otp-button")).click();
    }
}
