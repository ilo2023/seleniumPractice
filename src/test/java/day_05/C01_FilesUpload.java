package day_05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FilesUpload    extends TestBase {

    @Test
    public void test01() {

        // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.
        // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        bekle(2);




        // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
        driver.findElement(By.xpath("//input[@name='note']")).sendKeys("Benim Dosyam");

        bekle(2);



        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.

        //           "C:\Users\BURAK\Desktop\deneme.txt"  "C:\Users\ilyas\OneDrive\Masaüstü\deneme.docx"  "C:\Users\ilyas\OneDrive\Masaüstü\deneme.txt"
            //"C:\Users\ilyas\OneDrive\Masaüstü\deneme.txt"
        //String farkliKisim = System.getProperty("user.home");
        //System.out.println(farkliKisim);
        //String ortakKisim = "\\Masaüstü\\deneme.txt";

        //String dosyaYolu = farkliKisim + ortakKisim;
        String dosyaYolu ="C:\\Users\\ilyas\\OneDrive\\Masaüstü\\deneme.txt";

        WebElement dosyaSec = driver.findElement(By.xpath("//input[@name='upfile']"));

        dosyaSec.sendKeys(dosyaYolu);

        //'Press' butonuna basın

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Dosya notunun 'Benim Dosyam' oldugunu test ediniz


        WebElement dosyaNotu = driver.findElement(By.tagName("blockquote"));


        Assert.assertEquals("Benim Dosyam",dosyaNotu.getText());



        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.

        WebElement dosyaIcerigi = driver.findElement(By.tagName("pre"));

        Assert.assertTrue(dosyaIcerigi.getText().contains("Merhaba Dunya"));


        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.



    }
}

