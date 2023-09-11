package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

    // maximize iken pencere konumunu ve pencere olcusunu yazdiriniz
     System.out.println("max pencere konumu:"+ driver.manage().window().getPosition());
     System.out.println("max pencere ölcüsü:" +driver.manage().window().getSize());

     // fullscreen iken pencere konumunu ve pencere olcusunu yazdiriniz
        driver.manage().window().fullscreen();
        System.out.println("fullscreen pencere konumu:" +driver.manage().window().getPosition());
        System.out.println("fullscreen pencere ölcüsü :" +driver.manage().window().getSize());

        // sayfayi kapatiniz
        driver.close();



    }
}
