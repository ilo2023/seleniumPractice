package day_08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    @Test
    public void test01() {

        // girisYap methodu olusturun
        girisYap();  //bunu yazina kirmizi olur, sonra methot creat diyoruz ve asagida method u olusturruyor


        // sutun sayısını yazdırın
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println(sutunBasliklariListesi.size());
        System.out.println("***************************************");

        // tum body'i yazdirin
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        System.out.println("********************************************");

        // body'de bulunan satır sayısını yazdırın
        List<WebElement> satirListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(satirListesi.size());
        System.out.println("********************************************");

        // body'de bulunan satırları yazdırın
        for (WebElement each : satirListesi) {
            System.out.println(each.getText());
        }
        System.out.println("*****************");
        bekle(3);


        // 4.satırdaki elementleri yazdırın
        List<WebElement> dördüncüSatirElementleri = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (int i = 0; i < dördüncüSatirElementleri.size(); i++) {
            System.out.println(dördüncüSatirElementleri.get(i).getText());
        }
        System.out.println("********************************");
        bekle(3);

        // son satırdaki elementleri yazdırın
        List<WebElement> sonSatirElementleri = driver.findElements(By.xpath("//tbody//tr[last()]//td"));
        // lambda ile de yazdirabiliriz
        // sonSatirElementleri.forEach(t-> System.out.println(t.getText()));
        for (WebElement each : sonSatirElementleri) {
            System.out.println(each.getText());
        }
        System.out.println("***********************************+");

        // sondan bir önceki satırdaki elementleri yazdırın
        List<WebElement> sondanBirÖncekiSatirElementleri = driver.findElements(By.xpath("//tbody//tr[last()-1]//td"));
        sondanBirÖncekiSatirElementleri.forEach(t -> System.out.println(t.getText()));

        // Email baslıgındaki tum elementleri(sutun) yazdırı

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));

        int emailSutunNo = 0;

        for (int i = 0; i < basliklarListesi.size(); i++) {

            if (basliklarListesi.get(i).getText().equals("Email")) {
                emailSutunNo = i;
            }


        }


        List<WebElement> emailSutunListesi = driver.findElements(By.xpath("//tbody//tr//td[" + emailSutunNo + "]"));


        for (WebElement each : emailSutunListesi) {
            System.out.println(each.getText());

        }
    }
    private void girisYap() {
        // https://www.hotelmycamp.com adresine gidin
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
        // Log in butonuna tıklayın
        driver.findElement(By.cssSelector("#navLogon")).click();

        // Username: manager
        // Password: Manager1!
        WebElement userName = driver.findElement(By.cssSelector("#UserName"));
        Actions actions = new Actions(driver);
        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("manager1!").sendKeys(Keys.ENTER).perform();

    }
}
