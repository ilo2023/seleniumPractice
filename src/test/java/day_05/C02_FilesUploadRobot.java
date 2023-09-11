package day_05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_FilesUploadRobot extends TestBase {

    // https://www.ilovepdf.com/compress_pdf adrese gidelim
// Dosya sec butonuna tıklayalım
// Dosya yuklemek icin robot class'ını kullanalım


    @Test
    public void test01() {

        // https://www.ilovepdf.com/compress_pdf adrese gidelim
        driver.get(" https://www.ilovepdf.com/compress_pdf");
        // Dosya sec butonuna tıklayalım
        WebElement dosyaSec = driver.findElement(By.xpath("//*[text()='Select PDF files']"));
        dosyaSec.click();
        //sendKeys ile dosyayi gonderemedik. onun icin robot kilasi kullancagiz

        // Dosya yuklemek icin robot class'ını kullanalım
        //"C:\Users\ilyas\OneDrive\Masaüstü\PDF.pdf"
        String farkliKisim=System.getProperty("user.home");
        System.out.println(farkliKisim);
        String ortakKisim ="\\Masaüstü\\PDF.pdf";
        String dosyaYolu = farkliKisim+ortakKisim;

        uploadFilePath(dosyaYolu);



    }


}
