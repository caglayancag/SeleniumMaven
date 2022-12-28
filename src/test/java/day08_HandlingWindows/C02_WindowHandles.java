package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandles {
    /*
● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void teardown() {
        driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedSayfaYazisi="Opening a new window";
        String actualSayfaYazisi=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedSayfaYazisi,actualSayfaYazisi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedSayfaTitle="The Internet";
        String actualSayfaTitle=driver.getTitle();
        Assert.assertEquals(expectedSayfaTitle,actualSayfaTitle);
        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        /*
        Kontrolsüz açılan TAB'a geçiş yapmak için
        1 - ilk sayfada iken o sayfanın windowHandle değerini alıp kaydedin.
        2 - ikinci sayfa açıldıktan sonra getWindowHandles() kullanarak açık olan
        tüm sayfaların windowHandle değerlerini bir Set olarak kaydedin
        3 - Şuanda elimizde iki elementli bir Set var ,
        elementlerden bir tanesi birinci sayfanın windowHandle değeri
        birinci sayfanın windowHandle degerıne eşit olmayan ise
        ikinci sayfanın windowHandle değeri olur
        4 - bu sekılde 2. sayfanın WHD elde edıldıkten sonra
        WHD'leri kullanılarak sayfalar arasında geçiş yapılabilir

         */
        Set<String> tumWindowHanleSeti=driver.getWindowHandles();
        String ikinciSayfaWHD="";
        for (String eachWhD:tumWindowHanleSeti
             ) {
            if (!eachWhD.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaWHD=eachWhD;
            }

        }

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaWHD);
        Thread.sleep(3000);
        String expectedNewSayfaTitle="New Window";
        String actualNewSayfaTitle=driver.getTitle();

        Assert.assertEquals(expectedNewSayfaTitle,actualNewSayfaTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.

       String actualNewSayfaYazisi= driver.findElement(By.tagName("h3")).getText();
       String expectedNewSayfaYazisi="New Window";
       Assert.assertEquals(expectedNewSayfaYazisi,actualNewSayfaYazisi);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        String actualOncekiSayfaYazisi=driver.switchTo().window(ilkSayfaHandleDegeri).getTitle();
        Thread.sleep(3000);
        String expectedOncekiSayfaYazisi="The Internet";
        Assert.assertEquals(expectedOncekiSayfaYazisi,actualOncekiSayfaYazisi);



        Thread.sleep(3000);

    }
}
