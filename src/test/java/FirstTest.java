import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Admin on 03.12.2016.
 */
public class FirstTest {

    @Test
    public void seleniumTest() {
        //создание браузера
        System.setProperty("webdriver.chrome.driver", System.getProperty("C:\\seleniumdriver") + "\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        //на всю страницу
        driver.manage().window().maximize();
        //ожидание загрузки страницы
        ////driver.manage().window()
        //переходим на страницу
        driver.get("https://www.google.by");
        //находим элемент ID строку поиска на странице
        WebElement searchField = driver.findElement(By.id("gs_lc0"));
        //передаем в строку
        searchField.sendKeys("Selenium");
        //инициируем поиск
        searchField.submit();
        //создаем массив результатов - ссылки на странице
        List<WebElement> searchResults = (List<WebElement>) driver.findElement(By.cssSelector(".r>a"));
        //проходим по всем ссылкам - должны содержать текст селениум
        for (WebElement searchResult : searchResults){
            assertTrue(searchResult.getText().toLowerCase().contains("selenium"));
        }
        driver.quit();
    }
}
