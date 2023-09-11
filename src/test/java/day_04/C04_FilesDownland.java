package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilesDownland extends TestBase {


         // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        // some-file.txt dosyasini indirelim
        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");
        String farkliKisim1= System.getProperty("user.home");

        String ortakKisim1="\\Downloads\\some-file.txt";
        String dosyaYolu1 = farkliKisim1+ortakKisim1;
        try {
            Files.delete(Paths.get(dosyaYolu1)); //bunu try catch dosyasinin icine aldik.eski dosya varsa siler,yoksa exception vermeden catch a düser ve dosya bulunamadi yazar, isleme devam eder
        } catch (IOException e) {
            System.out.println("dosya bulunamadi");
        }

        //try catchicine almadan exception u kabul etseydik, dosya yolunu bulamadan farkli hata verirdi,

        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz
        //"C:\Users\ilyas\Downloads\some-file.txt"
        String farkliKisim= System.getProperty("user.home");
        System.out.println(farkliKisim);
        String ortakKisim="\\Downloads\\some-file.txt";
        String dosyaYolu = farkliKisim+ortakKisim;
        bekle(3);

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}
