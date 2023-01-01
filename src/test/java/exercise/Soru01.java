package exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Soru01 extends TestBase {
@Test
    public void test01(){
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    driver.get("http://automationexercise.com");
    //3. Verify that home page is visible successfully

    String expectedSayfaYazisi="Automation Exercise";
    String actualSayfaYazisi=driver.getTitle();
    Assert.assertEquals(expectedSayfaYazisi,actualSayfaYazisi);

    //4. Click on 'Products' button
    driver.findElement(By.xpath("//*[text()=' Products']")).click();

   // WebElement iframe=driver.findElement(By.xpath("//*[@id='ad_position_box']"));
    WebElement frame1 = driver.findElement(By.xpath("//*[@name='google_esf']"));
    driver.switchTo().frame(frame1);
    WebElement frame2 = driver.findElement(By.xpath("//*[@name='aswift_6']"));
    driver.switchTo().frame(frame2);
    WebElement frame3 = driver.findElement(By.xpath("//*[@name='ad_iframe']"));
    driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();

    ReusableMethods.bekle(3);
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    actualSayfaYazisi = driver.findElement(By.xpath("//*[text()='All Products']")).getText();

    expectedSayfaYazisi="ALL PRODUCTS";

    Assert.assertEquals(actualSayfaYazisi,expectedSayfaYazisi);
    //6. Enter product name in search input and click search button
    //7. Verify 'SEARCHED PRODUCTS' is visible
    //8. Verify all the products related to search are visible
    
    }


    //    driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
    //    driver.switchTo().defaultContent();
    ////*[@name='ad_iframe']
}
