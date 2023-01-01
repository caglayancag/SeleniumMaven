package day10_FileTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.FileInputStream;

public class C03_FileUploadTesti extends TestBase {

    @Test
    public void test01(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //2.chooseFile butonuna basalim

        //3.Yuklemek istediginiz dosyayi secelim.

        /*
        Bu görevi yapabilmek için chooseFİle butonuna basıldığında açılan bilgisayarımızdaki file dosyalarını
        click yapabilmemiz gerekir ancak selenium bilgisayarımızdaki dosyaları click yapamaz

        Bunun yerine  söyle bir çözüm üretilmiştir

            1-ChooseFile butonunu locate edin
            2-Upload edilecek dosyanın dosya yolunu oluşturun
            3-ChooseFile butonuna sentKeys ile dosya yolunu gönderin
         */

        WebElement chooseFileButonu=driver.findElement(By.id("file-upload"));
        String dosyaYolu= System.getProperty("user.home")+"\\Desktop\\MerhabaJava.docx";
        chooseFileButonu.sendKeys(dosyaYolu);


        //4.Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();
        //5.“File Uploaded!” textinin goruntulendigini test edelim.

        ReusableMethods.bekle(3);
    }
}
