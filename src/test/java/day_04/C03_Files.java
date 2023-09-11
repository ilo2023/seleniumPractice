package day_04;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_Files {

    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin


    @Test
    public void test01() {
        // Desktop(masaustu)'da bir text dosyası olusturun

        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
        //bu test i java ile yapacagiz cünkü selenium web sayfalarini testeder benim bilgisayarimda ki dosyayi kontrol etmez.
        //"C:\Users\ilyas   \OneDrive\Masaüstü\text.txt"  dosya yolum
        String farkliKisim= System.getProperty("user.home"); //herkesin kendi bilgisayarindaki farklikismi System.getProperty("user.home") ile aldik
        System.out.println(farkliKisim);
        String ortakKisim ="\\OneDrive\\Masaüstü\\text.txt";

        String dosyaYolu = farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));  // bu dosya yolundaki dosya mevcut mu?  kontrol ettik


    }
}
