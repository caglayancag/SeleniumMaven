package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocators {
    public static void main(String[] args) {
        /*
        1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
2 ) Berlin’i 3 farkli relative locator ile locate edin
3 ) Relative locator’larin dogru calistigini test edin
         */

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        WebElement sailorElementi=driver.findElement(By.xpath("//p[text()='Sailor']"));
        WebElement berlin1=driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElementi));
        WebElement bastonElement=driver.findElement(By.xpath("//p[text()='Boston']"));
        WebElement berlin2=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bastonElement));

        String expectedIdDegeri="pid7_thumb";
        String actualDegeri=berlin2.getAttribute("Id");

        if (expectedIdDegeri.equals(actualDegeri)){
            System.out.println("Relative locator testi PASSED");
        }
        else {
            System.out.println("Relative locator testi FAILED");
        }
        driver.close();
        }
}
