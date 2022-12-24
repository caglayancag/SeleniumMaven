package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\caglayan\\IdeaProjects\\com.Team105Selenium\\src\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        // Sayfayi tam ekran yapalim
        driver.manage().window().maximize();
        System.out.println("Maximize window size"+driver.manage().window().getSize());
        System.out.println("Maximize window konum"+driver.manage().window().getPosition());


        Thread.sleep(3000);
        driver.manage().window().fullscreen();
        System.out.println("Fullscreen window size"+driver.manage().window().getSize());
        System.out.println("Fullscreen window konum"+driver.manage().window().getPosition());

        // Browser'i istedigimiz konuma ve boyuta getirelim
        Thread.sleep(3000);
        driver.close();

        driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(300,300));

        Thread.sleep(3000);
        driver.close();

    }

}
