package com.tsoft.bot.frontend.pages.webMiMovistar;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;


public class PageRecargasPago {

    public static By TXT_NUM_TARJETA                    = By.id("cardNumber");
    public static By TXT_CVV2                           = By.id("csc");
    public static By BTN_PAGAR2                         = By.id("bConfirmPaymentButton");

    public static final String EXCEL_WEB = "excel/TDP_MiMovistar_Recarga_Web/MiMovistar_Recargas.xlsx";
    public static final String RECARGAS_WEB = "Recargas";
    public static final String COLUMNA_NUMTARJETA = "NUM_TARJETA";
    public static final String COLUMNA_FV_MES = "FV_MES";
    public static final String COLUMNA_FV_ANIO = "FV_ANIO";
    public static final String COLUMNA_COD_CVV = "COD_CVV";
    public static GenerateWord generateWord = new GenerateWord();
    public static WebDriver driver;

    public PageRecargasPago() {
        this.driver = Hook.getDriver();
    }

    public static List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, RECARGAS_WEB);
    }

    public static void ingresoNumeroTarjeta(String casoDePrueba) throws Throwable{
        try {

            int recargas = Integer.parseInt(casoDePrueba) - 1;
            String tarjeta = getData().get(recargas).get(COLUMNA_NUMTARJETA);
            Thread.sleep(5000);
            driver.switchTo().frame(0);
            driver.findElement(TXT_NUM_TARJETA).isDisplayed();
            driver.findElement(TXT_NUM_TARJETA).sendKeys(tarjeta);
            Thread.sleep(5000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó la tarjeta de crédito : "+tarjeta);
            generateWord.sendText("Se ingresó la tarjeta de crédito : 4919148107859067");
            generateWord.addImageToWord(driver);
            System.out.println("[LOG] Se ingresa el numero de tarjeta: "+ tarjeta+" Correctamente");
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void ingresoMesVencimiento(String casoDePrueba) throws Throwable{
        try {
            int recargas = Integer.parseInt(casoDePrueba) - 1;
            String mes = getData().get(recargas).get(COLUMNA_FV_MES);
            Select select = new Select(driver.findElement(By.id("expiryDateMonthInput")));
            select.selectByValue(mes);
            Thread.sleep(5000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el mes: "+mes);
            System.out.println("[LOG] Se ingresa el mes de vencimiento: "+ mes+" Correctamente");
            // generateWord.sendText("Se ingresó el mes : 03");
            //generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void ingresoAnioVencimiento(String casoDePrueba) throws Throwable{
        try {
            int recargas = Integer.parseInt(casoDePrueba) - 1;
            String anio = getData().get(recargas).get(COLUMNA_FV_ANIO);
            Select select = new Select(driver.findElement(By.id("expiryDateYearInput")));
            select.selectByVisibleText(anio);
            Thread.sleep(5000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el año: "+anio);
            System.out.println("[LOG] Se ingresa el anio de vencimiento: "+ anio+" Correctamente");
            //generateWord.sendText("Se ingresó el año: 2020");
            //generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void ingresoCodigoVerificacion(String casoDePrueba) throws Throwable{
        try{
            int recargas = Integer.parseInt(casoDePrueba) - 1;
            String cvv = getData().get(recargas).get(COLUMNA_COD_CVV);
            driver.findElement(TXT_CVV2).sendKeys(cvv);
            Thread.sleep(5000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó EL CÓDIGO CVV: "+cvv);
            System.out.println("[LOG] Se ingresa el codigo de verificacion: "+cvv+" Correctamente");
            //generateWord.sendText("Se ingresó EL CÓDIGO CVV: " + cvv);
            //generateWord.addImageToWord(driver);
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void clickEnElBotonPagar() throws Throwable {
        try {
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingrresaron los datos de la tarjeta, se da clic en pagar");
            generateWord.sendText("Se realizara la recarga con los datos de la tarjeta completos " );
            generateWord.addImageToWord(driver);
            driver.findElement(BTN_PAGAR2).click();
            System.out.println("[LOG] Se de clic en el boton PAGAR Correctamente");
        } catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 9, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

}
