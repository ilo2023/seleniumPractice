package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase {

    // Bu Class a extends ettigimiz test class larindan ulasabiliriz
    // Test Base class indan object olusturulmasinin önüne gecilmesi icin abstract yapilabilir

    protected WebDriver driver; //public de olur fakat minumum seviyede ayarlamak da fayda var

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

    public void ddmVisibleText(WebElement ddm, String secenek) {

        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }


    public void ddmIndex(WebElement ddm, int index) {

        Select select = new Select(ddm);
        select.selectByIndex(index);

    }


    public void ddmValue(WebElement ddm, String value) {

        Select select = new Select(ddm);
        select.selectByValue(value);

    }


    public void bekle(int saniye) {

        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
        public void uploadFilePath(String dosyaYolu) {
            try {
                bekle(3);
                StringSelection stringSelection = new StringSelection(dosyaYolu);
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                bekle(3);
                robot.keyPress(KeyEvent.VK_V);
                bekle(3);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                bekle(3);
                robot.keyRelease(KeyEvent.VK_V);
                bekle(3);
                robot.keyPress(KeyEvent.VK_ENTER);
                bekle(3);
                robot.keyRelease(KeyEvent.VK_ENTER);
                bekle(3);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
    }

    public void tumSayfaEkranGoruntusu(){

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        TakesScreenshot ts = (TakesScreenshot) driver;

        File kaydet = new File("target/ekranGoruntusu/tumSayfa.jpeg");

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,kaydet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}




