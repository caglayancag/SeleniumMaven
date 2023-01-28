package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {
    /*
    Selenium 4 ile windows konusunda  yeni bir özellik geldi
    İstersek kontrollu olarak driver için yeni bir window veya tab olusturabılırız
    Bu durumda drver'imiz otomotik olarak yeni sayfaya geçmiş olur.Testin ilerleyen asamalarında yenıden eski sayfalara
    donus gorevi varsa , o sayfada iken o sayfanın window Handle değeri alınıp kaydedilir.
    ve o sayfaya geçmek istendiğinde driver.switchTo.window(istenenSayfanınWindowHandleDegeri)
    kodu ile o sayfaya geçiş yapılır.
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
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        // Test'in ilerleyen asamalarında yeniden amazon sayfasına dönmek gerekiyorsa
        // amazon sayfasındayken bu window'un window handle degerını alıp kaydetmelıyız

        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        // Yeni bir tab'da wisequarter.com'a gidin ve gittiğimizi test edin.

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.wisequarter.com");

        String actualUrl= driver.getCurrentUrl();
        String expectedKelime="wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        Thread.sleep(3000);

        /* wisequarter testini yaptıktan sonra yeniden
        amazon'un acık oldugu TAB'a geçin ve amazon anasayfanın
        açık oldugunu test edin.
         */

        driver.switchTo().window(ilkSayfaHandleDegeri);
         actualUrl= driver.getCurrentUrl();
         expectedKelime="amazon";
        Assert.assertTrue(actualUrl.contains(expectedKelime));
        Thread.sleep(3000);

    }
}
