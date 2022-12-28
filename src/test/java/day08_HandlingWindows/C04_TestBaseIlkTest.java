package day08_HandlingWindows;

import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TestBaseIlkTest extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        // amazon'a gidin
        driver.get("https://www.amazon.com/");
        // amazon'a gittiğinizi test edin
        ReusableMethods.bekle(3);
    }
}
