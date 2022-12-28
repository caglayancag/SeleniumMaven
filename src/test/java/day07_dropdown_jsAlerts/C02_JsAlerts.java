package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.trace.propagation.internal.W3CTraceContextEncoding;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JsAlerts {
    /*
    Gerekli ayarlamaları yapıp
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin

    3 test methodu olusturup her method'da bir JsAlert'e basın
    ilgili method'ları kullanın
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        Thread.sleep(9000);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // 1. alert'e tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        // Alert'deki yazının " I am a JS Alert" oldugunu test edelim

        String actualAlertYazisi=driver.switchTo().alert().getText();
        String expectedAlertYazisi="I am a JS Alert";
        Thread.sleep(3000);
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        // OK tuşuna basalım

        driver.switchTo().alert().accept();
    }
    @Test
    public void test02() throws InterruptedException {
        /*
    2. Alert'e tıklayalım
    cancel'e basıp , çıkan sonuc yazısının " You clicked: Cancel" oldugunu test edin
    */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();

        String actualSonucYazisi=driver.findElement(By.xpath("//*[text()='You clicked: Cancel']")).getText();

        String expectedSonucYazisi="You clicked: Cancel";
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }

    @Test
    public void test03() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //3. alert'e tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        // Çıkan prampt ekranına "Abdullah" yazdıralım ve OK tusuna basarak Alert'i kapatalım

        // Çıkan sonuç yazısının "Abdullah" İçerdiğini test edelim

        driver.switchTo().alert().sendKeys("Abdullah");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        String actualSonucYazisi=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedSonucYazisi="Abdullah";
        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucYazisi));


    }


}
