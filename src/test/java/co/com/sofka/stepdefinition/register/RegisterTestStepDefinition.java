package co.com.sofka.stepdefinition.register;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class RegisterTestStepDefinition {
    @Dado("que el cliente se encuentra en el landing page de la pagina web")
    public void queElClienteSeEncuentraEnElLandingPageDeLaPaginaWeb() {
    }

    @Cuando("el cliente navega y entra a la opcion de login")
    public void elClienteNavegaYEntraALaOpcionDeLogin() {
    }

    @Cuando("el cliente ingresa un correo valido para el registro {string} y presiona crear un nuevo usuario")
    public void elClienteIngresaUnCorreoValidoParaElRegistroYPresionaCrearUnNuevoUsuario(String string) {
    }

    @Cuando("ha llenado los campos obligatorios para el registro y enviado")
    public void haLlenadoLosCamposObligatoriosParaElRegistroYEnviado(io.cucumber.datatable.DataTable dataTable) {
    }

    @Entonces("el sistema debera mostrar en pantalla funciones para el manejo de mis datos y ordenes")
    public void elSistemaDeberaMostrarEnPantallaFuncionesParaElManejoDeMisDatosYOrdenes() {
    }

    @Cuando("ha llenado los campos obligatorios para el registro menos la contrasena y enviado")
    public void haLlenadoLosCamposObligatoriosParaElRegistroMenosLaContrasenaYEnviado(io.cucumber.datatable.DataTable dataTable) {
    }

    @Entonces("el sistema debera mostrar en pantalla un mensaje de error indicando que la contrasena es requerida")
    public void elSistemaDeberaMostrarEnPantallaUnMensajeDeErrorIndicandoQueLaContrasenaEsRequerida() {
    }
}
