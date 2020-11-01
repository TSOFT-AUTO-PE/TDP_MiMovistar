package com.tsoft.bot.frontend.steps.webMiMovistar;

import com.tsoft.bot.frontend.pages.webMiMovistar.PageRecargasCorreo;
import cucumber.api.java.en.When;


public class stepsRecargasCorreo extends PageRecargasCorreo{

    @When("^se ingresa el email \"([^\"]*)\" y se da click en continuar$")
    public void seIngresaElEmailYSeDaClickEnContinuar(String casoDePrueba) throws Throwable {
        PageRecargasCorreo.ingresarCorreo_clickContinuar(casoDePrueba);
    }

    @When("^se ingresara el email \"([^\"]*)\" y se da click en continuar$")
    public void seIngresaraElEmailYSeDaClickEnContinuar(String casoDePrueba) throws Throwable {
        PageRecargasCorreo.ingresarCorreov2_clickContinuar(casoDePrueba);
    }
}
