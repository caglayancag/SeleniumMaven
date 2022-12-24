package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XPath {
    public static void main(String[] args) throws InterruptedException {
      System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
        1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin

        2- Add Element butonuna basin
        3- Delete butonu’nun gorunur oldugunu test edin
        4- Delete tusuna basin
        5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
                */
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();

        WebElement deleteButonu=driver.findElement(By.xpath("//*[text()=‘Delete’]"));

        if (deleteButonu.isDisplayed()){
            System.out.println("Delete butonu goruntuleme testi PASSED");
        }
        else {
            System.out.println("Delete butonu goruntuleme testi FAILED");

        }

        deleteButonu.click();

        WebElement addRemoveYaziElementi=driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add/Remove yazi testi PASSED");
        }
        else {
            System.out.println("Add/Remove yazi testi FAILED");

        }

        Thread.sleep(3000);


        driver.close();
    }
}
