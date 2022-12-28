package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.html.parser.TagElement;
import java.time.Duration;
import java.util.Set;

public class C03_WindowHandle {


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
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        // elemental selenium linkini tiklayin
        //link'e tıkladıgınızda yenı sayfa acılacagından clıck yapmadan önce ilk sayfanın
        // windowHandle degerını alıp kaydedelim
        String ilkSayfaWHD=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        // yeni tab'a gecip sayfadaki en buyuk yazinin "Elemental Selenium" oldugunu test edin
        //click yapınca yeni tab açılır ancak driver eski tabda kalır yeni tab'a driveri
        //geçirmek için yeni tab'ın windowsHandle degerıne ıhtıyacımız var

        Set<String> ikiSayfaninWHDegerleriSeti=driver.getWindowHandles();
        String ikinciSayfaninWHD="";
        for (String eachWHD: ikiSayfaninWHDegerleriSeti
             ) {
            if (!eachWHD.equals(ilkSayfaWHD)){
                ikinciSayfaninWHD=eachWHD;
            }

        }

        // foreachLoop bittiğinde ikinci sayfanın wındowHand degerını elde etmıs olacagız
        // bu degeri kullanrak ıkıncı sayfaya gecıs driveri ikinci sayfaya gecirebiliriz

        driver.switchTo().window(ikinciSayfaninWHD);
        String expectedSayfaYazisi="Elemental Selenium";
       String actualSayfaYazisi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualSayfaYazisi,expectedSayfaYazisi);
        Thread.sleep(3000);
        // ilk sayfaya geri donup sayfadaki yazinin
        driver.switchTo().window(ilkSayfaWHD);
        // "An iFrame containing the TinyMCE WYSIWYG Editor" oldugunu test edin

        String expectedIlkSayfaYazi="An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualIlkSayfaYazi=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedIlkSayfaYazi,actualIlkSayfaYazi);

        Thread.sleep(3000);



    }

}

