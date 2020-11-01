package com.tsoft.bot.frontend.pages.webMiMovistar;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;


public class PageRecargaFinal {

    public static By BTN_FINAL                          = By.xpath("//button[contains(text(),'')]");
    public static By LBL_CODIGO_E                       = By.xpath("/html/body/app-root/app-confirm/div/div[1]/div[6]/span");
    public static By LBL_CODIGO_C                       = By.xpath("/html/body/app-root/app-confirm/div/div/div[1]/div[6]/p[2]");
    public static By FRAMEWAIT                          = By.xpath("/html/body/app-root/app-checkout/div/div/p");


    public static final String EXCEL_WEB = "excel/TDP_MiMovistar_Recarga_Web/MiMovistar_Recargas.xlsx";
    public static final String RECARGAS_WEB = "Recargas";
    public static GenerateWord generateWord = new GenerateWord();
    public static WebDriver driver;

    public PageRecargaFinal() {
        this.driver = Hook.getDriver();
    }

    public static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, RECARGAS_WEB);
    }

    public static void verificarRecargaFinal() throws Exception {
        try{
            Thread.sleep(20000);
            driver.findElement(LBL_CODIGO_C).isDisplayed();
            String codigo2 = driver.findElement(LBL_CODIGO_C).getText();
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "PASS");
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 10, codigo2);
            ExtentReportUtil.INSTANCE.stepWarning(driver, "Verificar Imagen Flujo");
            ExtentReportUtil.INSTANCE.stepWarning(driver, "Se extrae los siguientes datos: "+codigo2);
            generateWord.sendText("Finalizo la recarga correctamente con el ID de Pedido: " + codigo2);
            generateWord.addImageToWord(driver);
            driver.findElement(BTN_FINAL).click();
            System.out.println("[LOG] Finaliza la recarga correctamente con el ID de Pedido: " + codigo2);
        }catch(Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }
}
