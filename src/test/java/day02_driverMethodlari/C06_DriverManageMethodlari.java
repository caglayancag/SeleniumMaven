package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverManageMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\caglayan\\IdeaProjects\\com.Team105Selenium\\src\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /* implicitlyWait gittiğimiz sayfa acılıncaya veya aradıgımız webelement bulununcaya kadar
        driver'in bekleyebılecegı maxımım sureyi belirler

        bu dortlu her test method'unun basına yazılacak
         */
        driver.close();
    }
}
