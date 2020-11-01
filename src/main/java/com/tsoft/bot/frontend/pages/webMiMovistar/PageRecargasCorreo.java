package com.tsoft.bot.frontend.pages.webMiMovistar;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;


public class PageRecargasCorreo {

    public static By TXT_CORREO2                        = By.xpath("/html/body/app-root/app-checkout/div/div[1]/div[5]/mat-form-field/div/div[1]/div/input");
    public static By BTN_CONTINUAR22                    = By.xpath("/html/body/app-root/app-checkout/div/div[2]/button");
    public static By FRAMECORREO                        = By.xpath("/html/body/app-root/app-checkout");

    public static final String EXCEL_WEB = "excel/TDP_MiMovistar_Recarga_Web/MiMovistar_Recargas.xlsx";
    public static final String RECARGAS_WEB = "Recargas";
    public static final String COLUMNA_CORREO = "CORREO";
    public static GenerateWord generateWord = new GenerateWord();
    public static  WebDriver driver;

    public PageRecargasCorreo() {
        this.driver = Hook.getDriver();
    }

    public static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, RECARGAS_WEB);
    }


    public static void ingresarCorreo_clickContinuar(String casoDePrueba) throws Throwable{
        try {
            driver.findElement(FRAMECORREO).isDisplayed();
            int recargas = Integer.parseInt(casoDePrueba) - 1;
            String correo = getData().get(recargas).get(COLUMNA_CORREO);
            Thread.sleep(5000);
            driver.switchTo().frame(0);
            driver.findElement(TXT_CORREO2).clear();
            driver.findElement(TXT_CORREO2).sendKeys(correo);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresa el correo: " + correo + "Se da clic en continuar");
            generateWord.sendText("Se ingresa el correo: " + correo + "Se da clic en continuar");
            generateWord.addImageToWord(driver);
            System.out.println("[LOG] Se ingresa el correo: "+ correo+" Correctamente");
            //ExtentReportUtil.INSTANCE.stepPass(driver, "Se dió clic en el botón Contiuar2");
            //generateWord.sendText("Se dió clic en el botón Continuar 2");
            //generateWord.addImageToWord(driver);
            driver.findElement(BTN_CONTINUAR22).click();
            System.out.println("[LOG] Se da clic en el boton Cotinuar Correctamente");
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }
    public static void ingresarCorreov2_clickContinuar(String casoDePrueba) throws Throwable{
        try {
            driver.findElement(FRAMECORREO).isDisplayed();
            int recargas = Integer.parseInt(casoDePrueba) - 1;
            String correo = getData().get(recargas).get(COLUMNA_CORREO);
            driver.findElement(TXT_CORREO2).clear();
            driver.findElement(TXT_CORREO2).sendKeys(correo);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresa el correo: " + correo + "Se da clic en continuar");
            generateWord.sendText("Se ingresa el correo: " + correo + "Se da clic en continuar");
            generateWord.addImageToWord(driver);
            //ExtentReportUtil.INSTANCE.stepPass(driver, "Se dió clic en el botón Contiuar2");
            //generateWord.sendText("Se dió clic en el botón Continuar 2");
            //generateWord.addImageToWord(driver);
            driver.findElement(BTN_CONTINUAR22).click();
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

}
