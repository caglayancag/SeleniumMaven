package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\caglayan\\IdeaProjects\\com.Team105Selenium\\src\\drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");
        System.out.println(driver.getPageSource());

        driver.close();
        // pagaSource'un MEOW icerdiğini test edin

        String pageSource=driver.getPageSource();

        String expectionPageSource="Meow";

    }
}
