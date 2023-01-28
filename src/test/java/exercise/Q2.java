package exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q2 extends TestBase {



    @Test
    public void test01(){
        ////              ..Exercise2...
        ////  http://www.bestbuy.com 'a gidin,
        driver.get("https://www.bestbuy.com");

        ////  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String actualSayfaBasligi=driver.getTitle();
        String expectedSayfaBasligi="Best";

        Assert.assertTrue(actualSayfaBasligi.contains(expectedSayfaBasligi));

        ////  Ayrica Relative Locator kullanarak;
        ////      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin

        driver.findElement(By.xpath("//*[@class='logo']")).isDisplayed();

        ////  Ayrica Relative Locator kullanarak;
        ////      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin

        driver.findElement(By.xpath("//h4[text()='Mexico']")).isDisplayed();


    }
}
