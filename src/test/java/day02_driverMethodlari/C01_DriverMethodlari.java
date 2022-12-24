package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        /* Biz browser'ları olusturdugumuz driver sayesinde  otomate edebiliyoruz.
           Bunun için her testin başında mutlaka driver objesi olusturacagız.
         */
        System.setProperty("webdriver.chrome.driver","C:\\Users\\caglayan\\IdeaProjects\\com.Team105Selenium\\src\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        /* Açılan sayfanın baslıgının amazon icerdigini test edin.
         */
        String expectedKelime="amazon";
        String actualResult=driver.getTitle();
        if(actualResult.contains(expectedKelime)){
            System.out.println("Title testi PASSED ");
        }
        else {
            System.out.println("Title amazon içermiyor test FAILED");
            System.out.println(driver.getTitle());
        }
        // gittigimiz sayfanın URL'inin https://www.amazon.com/ oldugunu test edin
        String expectedUrl="https://www.amazon.com/";
        String actualUrl=driver.getCurrentUrl();
        if(expectedUrl.equals(actualUrl)){

            System.out.println("Url test PASSED");
        }
        else {
            System.out.println("Url test FAILED");
        }
        // Thread.sleep(5000);
        driver.close();
    }
}
