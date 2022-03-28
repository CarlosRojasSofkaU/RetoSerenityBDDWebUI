package co.com.sofka.stepdefinition.contactus;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class ContactUsTestStepDefinition {
    @Dado("que el cliente se encuentra en la landing page de automationpractice")
    public void queElClienteSeEncuentraEnLaLandingPageDeAutomationpractice() {
    }

    @Cuando("el cliente navega y entra a la opcion de contactanos")
    public void elClienteNavegaYEntraALaOpcionDeContactanos() {
    }

    @Cuando("ha llenado los campos obligatorios y enviado")
    public void haLlenadoLosCamposObligatoriosYEnviado(io.cucumber.datatable.DataTable dataTable) {
    }

    @Entonces("el sistema debera mostrar en pantalla un mensaje de operacion exitosa")
    public void elSistemaDeberaMostrarEnPantallaUnMensajeDeOperacionExitosa() {
    }


    @Cuando("ha llenado ciertos campos y enviado")
    public void haLlenadoCiertosCamposYEnviado(io.cucumber.datatable.DataTable dataTable) {
    }

    @Entonces("el sistema debera mostrar en pantalla un mensaje de error pidiendo que se envie un mensaje")
    public void elSistemaDeberaMostrarEnPantallaUnMensajeDeErrorPidiendoQueSeEnvieUnMensaje() {
    }
}
