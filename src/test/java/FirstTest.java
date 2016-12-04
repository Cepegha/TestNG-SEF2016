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
        //�������� ��������
        System.setProperty("webdriver.chrome.driver", System.getProperty("C:\\seleniumdriver") + "\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        //�� ��� ��������
        driver.manage().window().maximize();
        //�������� �������� ��������
        ////driver.manage().window()
        //��������� �� ��������
        driver.get("https://www.google.by");
        //������� ������� ID ������ ������ �� ��������
        WebElement searchField = driver.findElement(By.id("gs_lc0"));
        //�������� � ������
        searchField.sendKeys("Selenium");
        //���������� �����
        searchField.submit();
        //������� ������ ����������� - ������ �� ��������
        List<WebElement> searchResults = (List<WebElement>) driver.findElement(By.cssSelector(".r>a"));
        //�������� �� ���� ������� - ������ ��������� ����� ��������
        for (WebElement searchResult : searchResults){
            assertTrue(searchResult.getText().toLowerCase().contains("selenium"));
        }
        driver.quit();
    }
}
