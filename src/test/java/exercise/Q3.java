package exercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Q3 extends TestBase {

    @Test
    public void test01(){
        ////● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWHD=  driver.getWindowHandle();
        ////● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText=  driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        String expectedText="Opening a new window";

        Assert.assertEquals(expectedText,actualText);


        ////● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertEquals(driver.getTitle(),"The Internet");
        ////● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        Set<String> tumWHD=driver.getWindowHandles();
        String ikinciSayfaWHD="";

        for (String eachWHD: tumWHD) {

           if (!ilkSayfaWHD.equals(eachWHD)){
               ikinciSayfaWHD=eachWHD;
           }

        }

        ////● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWHD);
        Assert.assertEquals(driver.getTitle(),"New Window");


        ////● Sayfadaki textin “New Window” olduğunu doğrulayın.

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(),"New Window");

        ////● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkSayfaWHD);
        Assert.assertEquals(driver.getTitle(),"The Internet");
    }

}
