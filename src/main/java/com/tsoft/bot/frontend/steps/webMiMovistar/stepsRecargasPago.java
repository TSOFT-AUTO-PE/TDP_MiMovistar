package com.tsoft.bot.frontend.steps.webMiMovistar;

import com.tsoft.bot.frontend.pages.webMiMovistar.PageRecargasPago;
import cucumber.api.java.en.And;

public class stepsRecargasPago extends PageRecargasPago{

    @And("^se ingresa el numero de tarjeta \"([^\"]*)\"$")
    public void seIngresaElNumeroDeTarjeta(String casoDePrueba) throws Throwable {
        PageRecargasPago.ingresoNumeroTarjeta(casoDePrueba);
    }

    @And("^se ingresa el mes de vencimiento \"([^\"]*)\"$")
    public void seIngresaElMesDeVencimiento(String casoDePrueba) throws Throwable {
       PageRecargasPago.ingresoMesVencimiento(casoDePrueba);
    }

    @And("^se ingresa el anio de vencimiento \"([^\"]*)\"$")
    public void seIngresaElAnioDeVencimiento(String casoDePrueba) throws Throwable {
        PageRecargasPago.ingresoAnioVencimiento(casoDePrueba);
    }

    @And("^se ingresa el codigo de verificacion \"([^\"]*)\"$")
    public void seIngresaElCodigoDeVerificacion(String casoDePrueba) throws Throwable {
        PageRecargasPago.ingresoCodigoVerificacion(casoDePrueba);
    }

    @And("^se da click en el boton Pagar$")
    public void seDaClickEnElBotonPagar() throws Throwable {
        PageRecargasPago.clickEnElBotonPagar();
    }
}
