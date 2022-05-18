import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest {

    //Тест кейс:
    //1 Открыть страницу https://www.99-bottles-of-beer.net/
    //2 Нажать пункт меню BrowseLanguages
    //3 Нажать пункт меню start
    //4 Убедиться что пользователь видит загодовок Welcome to 99 Bottles of Beer
    //5 закрыть браузер

    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/iliavanvay/Documents/chromedriver";  //ваш путь к драйверу
        String url = "https://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer"; // ожидаемый рез.

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']")
        );
        menuBrowseLanguages.click();
        // Thread.sleep(1000);  // задержка на 1 секунду после каждого действия

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();
     //   Thread.sleep(1000);

        WebElement h2 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h2"));

        String actualResult = h2.getText();
      //  Thread.sleep(1000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();


    }
}
