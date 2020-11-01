package com.tsoft.bot.frontend.pages.webMiMovistar;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;


public class PageRecargasHome {

    public static By TXT_NUMERO_MOVISTAR                = By.id("input_celular"); //id
    public static By TXT_MONTO                          = By.id("input_monto"); //id
    public static By BTN_CONTINUAR                      = By.id("button_recargar"); //id

    public static final String EXCEL_WEB = "excel/TDP_MiMovistar_Recarga_Web/MiMovistar_Recargas.xlsx";
    public static final String RECARGAS_WEB = "Recargas";
    public static final String COLUMNA_URL = "URL";
    public static final String COLUMNA_TELEFONO = "TELEFONO";
    public static final String COLUMNA_MONTO = "MONTO";
    public static GenerateWord generateWord = new GenerateWord();
    public static WebDriver driver;

    public PageRecargasHome() {
        this.driver = Hook.getDriver();
    }

    public static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, RECARGAS_WEB);
    }


    public static void ingresoDeUrlDelTokenGenerado(String casoDePrueba) throws Throwable {
        try {
            int recargas = Integer.parseInt(casoDePrueba) - 1;
            String url = getData().get(recargas).get(COLUMNA_URL);
            driver.get(url);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se inició correctamente la página Mi Movistar con el token");
            generateWord.sendText("Se inició correctamente la página Mi Movistar con el token");
            generateWord.addImageToWord(driver);
            System.out.println("[LOG] Se ingresa al URL del Token Generado Correctamente");
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void ingresoDeNumeroCelular(String casoDePrueba) throws Throwable{
        try {
            int recargas = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_NUMERO_MOVISTAR).clear();
            String telefono = getData().get(recargas).get(COLUMNA_TELEFONO);
            driver.findElement(TXT_NUMERO_MOVISTAR).sendKeys(telefono);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el telefono : " + telefono);
            System.out.println("[LOG] Se ingresa el numero de celular: "+ telefono+" Correctamente");
            // generateWord.sendText("Se ingresó el telefono :" + telefono);
            // generateWord.addImageToWord(driver);

        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void ingresoDeMontoRecargar(String casoDePrueba) throws Throwable{
        try {
            int recargas = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_MONTO).clear();
            String monto = getData().get(recargas).get(COLUMNA_MONTO);
            driver.findElement(TXT_MONTO).sendKeys(monto);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el monto en soles : " + monto);
            generateWord.sendText("Se ingresó el monto en soles: " + monto);
            generateWord.addImageToWord(driver);
            System.out.println("[LOG] Se ingresa el monto a Recargar: "+ monto+" Correctamente");
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;

        }
    }

    public static void clickBotonContinuar() throws Throwable{
        try {
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en el botón Continuar");
            generateWord.sendText("Se dió clic en el botón Continuar ");
            generateWord.addImageToWord(driver);
            driver.findElement(BTN_CONTINUAR).click();
            System.out.println("[LOG] Se da clic en el botón Cotinuar Correctamente");
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

}
