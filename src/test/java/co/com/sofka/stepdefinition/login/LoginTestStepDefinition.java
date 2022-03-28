package co.com.sofka.stepdefinition.login;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class LoginTestStepDefinition {
    @Dado("el usuario ya posee una cuenta registrada en la plataforma.")
    public void elUsuarioYaPoseeUnaCuentaRegistradaEnLaPlataforma() {
    }

    @Dado("que el cliente se encuentra en el landing page de la pagina web")
    public void queElClienteSeEncuentraEnElLandingPageDeLaPaginaWeb() {
    }

    @Cuando("el cliente navega y entra a la opcion de login")
    public void elClienteNavegaYEntraALaOpcionDeLogin() {
    }

    @Cuando("ha llenado con sus credenciales y enviado")
    public void haLlenadoConSusCredencialesYEnviado(io.cucumber.datatable.DataTable dataTable) {
    }

    @Entonces("el sistema debera mostrar en pantalla funciones para el manejo de mis datos y ordenes")
    public void elSistemaDeberaMostrarEnPantallaFuncionesParaElManejoDeMisDatosYOrdenes() {
    }

    @Cuando("ha llenado con credenciales erroneas y enviado")
    public void haLlenadoConCredencialesErroneasYEnviado(io.cucumber.datatable.DataTable dataTable) {
    }

    @Entonces("el sistema debera mostrar en pantalla un mensaje de error indicando que la autenticacion fallo")
    public void elSistemaDeberaMostrarEnPantallaUnMensajeDeErrorIndicandoQueLaAutenticacionFallo() {
    }
}
