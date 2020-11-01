package com.tsoft.bot.frontend.steps.webMiMovistar;

import com.tsoft.bot.frontend.pages.webMiMovistar.PageRecargaFinal;
import cucumber.api.java.en.Then;

public class stepsRecargasFinal extends PageRecargaFinal {

    @Then("^se verifica que se hizo la recarga correcta\\.$")
    public void seVerificaQueSeHizoLaRecargaCorrecta() throws Exception {
        PageRecargaFinal.verificarRecargaFinal();

}
}
