package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class C01 {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.edgedriver().setup(); // chromeDriver da yapilir , daha cok kullaniyor
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        // "https://www.amazon.com/" adresine gidiniz.
       // driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.amazon.com/"); // bu da ayni sekilde url e gider
        Thread.sleep(1000);  // bu java dan gelen bir bekleme islemidir

        // "https://www.n11.com/" adresine gidiniz.
        driver.get("https://www.n11.com");
        Thread.sleep(1000);

        // amazon adresine geri donunuz
        driver.navigate().back();  // navigate : gezinmek demek, ileriye geriye dogru
        Thread.sleep(1000);

        // n11 adresine ilerleyiniz
        driver.navigate().forward();
        Thread.sleep(1000);

        // sayfayi yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(1000);

        // pencereyi kapat
        driver.close();

        // Konsola "HER ŞEY YOLUNDA" yazdir
        System.out.println("Her sey yolunda");

    }
}
