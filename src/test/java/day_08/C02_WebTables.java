package day_08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_WebTables extends TestBase {

    @Test
    public void test01() {
        // girisYap methodu olusturun
        // https://www.hotelmycamp.com adresine gidin
        // Log in butonuna tıklayın
         // Username: manager
        // Password: Manager1!
        girisYap();

    // input olarak verilen (3,3) satır sayısı ve sutun sayısına sahip cell'deki text'i dinamik olarak yazdırın.
        int satir = 3;
        int sutun = 3;
       WebElement aranancell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(aranancell.getText());

    }

    private void girisYap() {
        // https://www.hotelmycamp.com adresine gidin
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
        // Log in butonuna tıklayın
        bekle(2);
        driver.findElement(By.cssSelector("#navLogon")).click();

        // Username: manager
        // Password: Manager1!
        WebElement userName = driver.findElement(By.cssSelector("#UserName"));
        Actions actions = new Actions(driver);
        bekle(2);
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("manager1!").sendKeys(Keys.ENTER).perform();


    }
}
