package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        // - “An IFrame containing….” textinin erisilebilir oldugunu test edin
        // ve  konsolda yazdirin.

        WebElement actualSayfaYazisi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(actualSayfaYazisi.isEnabled());
        Thread.sleep(3000);

        // - Text Box’a “Merhaba Dunya!” yazin.

        /* Normal locate yapıp yazdırmayı denediğimizde NoSuchElementException verdi
        yani elementi bulamadı
        Kontrol ederken istediğimiz Webelement'in bir IFrame içinde oldugunu gorduk
        Bu durumda önce o IFrame swichTo() yapmalıyız
         */
        WebElement iframeWebElementi=driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeWebElementi);
        WebElement yaziKutuElementi=driver.findElement(By.xpath("//body[@id='tinymce']"));
        yaziKutuElementi.clear();
        yaziKutuElementi.sendKeys("Merhaba Dünya");
        // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        // gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        //IFrame'in içine girdikten sonra , oradan

        /*
        1- Dropdown menu : Select tagı ile olusturulan acılır menudur. Secenekler de option tag'ı ile olusturulur.Dropdown ile islem yapabilmemiz için Selenium
        Select class' olusturmustur.Bizde  bu class'dan olusturacagımız obje ıle dropdown menuden ıstediğimiz işlemleri yapabılırız.
                1.adim : dropdown webelementini locate etmek
                2.adim : Select class'ından bır obje olusturmak ve parametre olarak dropdown  elementini girmek
                3.adim : select objesi ile istediğimiz hazır method'u kullanmak
        2- JSAlerts    :    HTML sayfalarda iki tür alert ile karsılasabiliriz.
                1-    HTML alerts :  inspect yapılabilir ve locate edilerek kullanılabilir.
                2-    JSAlerts    : inspect yapılamaz dolayısıyla locate edip kullanılamaz.Bu tur bır alert ile karsılastıgımızda
                her işlem yapmak istediğimizde Driver.switchTo().alert diyerek önce alert'e geçiş yapıp sonra nokta (.) koyup
                istediğimiz işlemi yapabiliriz.
        3-iFrame : Bir HTML sayfasının içinde gömülü bir HTML sayfa oluşturmak için kullanılır.Bir sayfada webelement'i locate etmemize
        rağmen kullanamıyorsak , kullanmak istediğimiz webelement bir Iframe içerisinde olabilir.
        Eğer aradığımız webelement bir iframe içerisindeyse önce o iframe'i locate edip o iframe'e driver.switchTo().iframe()
        ile geçiş yapıp sonra istediğimiz elementi locate etmeliyiz.iframe'de işimiz bittiğinde yeniden anasayfaya geçmek içinde switchTo
        kullanmalıyız.
         */
    }
}
