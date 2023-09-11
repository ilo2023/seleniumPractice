package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    // https://html.com/tags/iframe sayfasına gidiniz

    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // Videoyu calistirdiginizi test ediniz
    // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

    @Test
    public void test01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        //yukarda ifram in locate ini aldik
        driver.switchTo().frame(iframe); //burada da iframe(icteki web sayfasina)gectik
        WebElement play =driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();

        /*
     play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı
     bunun üzerine HTML kodlarını inceleyince play'in aslında bir iframe icerisinde oldugunu gorduk
     bu durumda once iframe'i locate edip
     switchTo() ile o iframe'e gecmeliyiz
     */
        bekle(2);

        // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazisi = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());
        bekle(2);

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

        //once driver imizi disardaki web sayfasina ( bir üst web sayfasina) gecirmeliyiz
        driver.switchTo().parentFrame();    //burada parentFrame()  yerine defaultContent() i de kuallanabiliriz
        WebElement powerYazisi = driver.findElement(By.id("Powerful_but_easy_to_misuse"));  //yazinin locate ini aldik
        Assert.assertTrue(powerYazisi.isDisplayed());  //iceriyor mu yu test etseydik getText() ile String e dönüstürmeliyidik.

        //contains kullanmak istersek getText() kulalnarak  String e cevirmeliyiz

    }
}
