package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // "https://teknosa.com/" adresine gidiniz
        driver.navigate().to("https://teknosa.com/");
        Thread.sleep(2000);

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String teknosaTitle =driver.getTitle();
        System.out.println("teknosaTitle :" +teknosaTitle);
        String teknosaUrl =driver.getCurrentUrl();
        System.out.println("teknosa Url :" + teknosaUrl);

        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz
        if (teknosaTitle.contains("Teknoloji")){
            System.out.println("Title Teknoloji iceriyor");
        }else {
            System.out.println("Title Teknoloji icermiyor");
        }
        Thread.sleep(2000);

        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz
        if (teknosaUrl.contains("teknosa")){
            System.out.println("Url teknosa kelimesini iceriyor");
        }else System.out.println("Url teknosa kelimesi icermiyor");
        Thread.sleep(2000);

        // "https://medunna.com/" adresine gidiniz
        driver.get("https://medunna.com/");

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String medunnaUrl = driver.getCurrentUrl();
        System.out.println("medunnaUrl:"+ medunnaUrl);
        String medunnaTitle = driver.getTitle();
        System.out.println("medunnTitle : " +medunnaTitle);
        Thread.sleep(2000);

        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        if (medunnaTitle.contains("MEDUNNA")){
            System.out.println("Title MEDUNNA iceriyor");
        }else System.out.println("Title MEDUNNA icermiyor");
        Thread.sleep(2000);

        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        if (medunnaUrl.contains("medunna")){
            System.out.println("Url medunna iceriyor");

        }else System.out.println("Url medunna icermiyor");
        Thread.sleep(2000);

        // teknosa adresine geri donunuz
        driver.navigate().back();
        Thread.sleep(2000);

        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(2000);

        // medunna adresine ilerleyiniz
        driver.navigate().forward();
        Thread.sleep(2000);

        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(2000);

        // pencereyi kapat
        driver.close();

    }
}
