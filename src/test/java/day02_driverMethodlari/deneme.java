package day02_driverMethodlari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class deneme {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://facebook.com");
        WebElement mailGirisi= driver.findElement(By.id("email"));
        mailGirisi.sendKeys("fatih-polat@hotmail.com");
        mailGirisi.submit();
        WebElement sifre= driver.findElement(By.id("pass"));
        sifre.sendKeys("123456");
        sifre.submit();
        Thread.sleep(8000);
        driver.close();

    }
}
