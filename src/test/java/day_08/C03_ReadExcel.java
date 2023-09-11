package day_08;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    @Test
    public void test01() throws IOException {

        // Ulkeler dosyasındaki 3.satırdaki indexin, 3.sutunundaki indexinin
        // "Cezayir" oldugunu test eden method olusturunuz
       int satirNoIdx= 4;
       int sutunNoIdx=2;
         String actual = banaDataGetir(satirNoIdx,sutunNoIdx); // asagida bir method olusturduk
         String expected = "Andorra";
        Assert.assertEquals(expected,actual);



    }

    private String banaDataGetir(int satirNoIdx, int sutunNoIdx) throws IOException {
        FileInputStream fis = new FileInputStream("src/resources/ulkeler (1).xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
       String istenenData = workbook.getSheet("Sayfa1").getRow(satirNoIdx).getCell(sutunNoIdx).toString();
       return istenenData;  // istenen datayi yukariya banaDataGetir e return yaptik
    }


}
