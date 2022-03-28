package co.com.sofka.stepdefinition.register;

import co.com.sofka.exception.ValidationTextDoNotMatch;
import co.com.sofka.runner.setup.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Random;

import static co.com.sofka.exception.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.question.register.RegisterFormFailure.registerFormFailure;
import static co.com.sofka.question.register.RegisterFormSuccess.registerFormSuccess;
import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.task.login.BrowseToLoginField.browseToLoginField;
import static co.com.sofka.task.register.BrowseToRegisterForm.browseToRegisterForm;
import static co.com.sofka.task.register.FillRegisterForm.fillRegisterForm;
import static co.com.sofka.userinterface.register.RegisterForm.LOGIN_SUCCES_WELCOME_MSG;
import static co.com.sofka.userinterface.register.RegisterForm.REGISTRATION_PASSWD_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterTestStepDefinition extends Setup{

    private static final String ACTOR_NAME = "Carlos";
    private DataTable dataToValidate;
    private String emailRandomized;
    private Random rand = new Random();
    private String GMAIL_EXTENSION = "@gmail.com";

    @Dado("que el cliente se encuentra en el landing page de la pagina web")
    public void queElClienteSeEncuentraEnElLandingPageDeLaPaginaWeb() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
    }

    @Cuando("el cliente navega y entra a la opcion de login")
    public void elClienteNavegaYEntraALaOpcionDeLogin() {
        theActorInTheSpotlight().attemptsTo(
                browseToLoginField()
        );
    }

    @Cuando("el cliente ingresa un correo valido para el registro {string} y presiona crear un nuevo usuario")
    public void elClienteIngresaUnCorreoValidoParaElRegistroYPresionaCrearUnNuevoUsuario(String email) {
        emailRandomized = email + rand.nextInt(10000) + GMAIL_EXTENSION;
        theActorInTheSpotlight().attemptsTo(
                browseToRegisterForm()
                        .usingTheEmailAddress(emailRandomized)
        );
    }

    @Cuando("ha llenado los campos obligatorios para el registro y enviado")
    public void haLlenadoLosCamposObligatoriosParaElRegistroYEnviado(DataTable dataTable) {
        dataToValidate = dataTable;
        theActorInTheSpotlight().attemptsTo(
                fillRegisterForm()
                        .usingTheFirstName(dataTable.row(0).get(1))
                        .usingTheLastName(dataTable.row(1).get(1))
                        .usingThePassword(dataTable.row(2).get(1))
                        .usingTheAddress(dataTable.row(3).get(1))
                        .usingTheCity(dataTable.row(4).get(1))
                        .usingTheState(dataTable.row(5).get(1))
                        .usingTheZipCode(dataTable.row(6).get(1))
                        .usingTheCountry(dataTable.row(7).get(1))
                        .andUsingTheMobilePhone(dataTable.row(8).get(1))
        );
    }

    @Entonces("el sistema debera mostrar en pantalla funciones para el manejo de mis datos y ordenes")
    public void elSistemaDeberaMostrarEnPantallaFuncionesParaElManejoDeMisDatosYOrdenes() {
        theActorInTheSpotlight().should(
                seeThat(
                        registerFormSuccess()
                                .wasFilledWithFirstName(dataToValidate.row(0).get(1))
                                .wasFilledWithLastName(dataToValidate.row(1).get(1))
                                .wasFilledWithPassword(dataToValidate.row(2).get(1))
                                .wasFilledWithAddress(dataToValidate.row(3).get(1))
                                .wasFilledWithCity(dataToValidate.row(4).get(1))
                                .wasFilledWithState(dataToValidate.row(5).get(1))
                                .wasFilledWithZipCode(dataToValidate.row(6).get(1))
                                .wasFilledWithCountry(dataToValidate.row(7).get(1))
                                .andWithMobilePhone(dataToValidate.row(8).get(1))
                                .is(), equalTo(true)
                )
                        .orComplainWith(ValidationTextDoNotMatch.class, String.format(VALIDATION_DO_NOT_MATCH, compareInWithSystemOutcome(LOGIN_SUCCES_WELCOME_MSG)))
        );
    }

    @Cuando("ha llenado los campos obligatorios para el registro menos la contrasena y enviado")
    public void haLlenadoLosCamposObligatoriosParaElRegistroMenosLaContrasenaYEnviado(DataTable dataTable) {
        dataToValidate = dataTable;
        theActorInTheSpotlight().attemptsTo(
                fillRegisterForm()
                        .usingTheFirstName(dataTable.row(0).get(1))
                        .usingTheLastName(dataTable.row(1).get(1))
                        .usingThePassword("")
                        .usingTheAddress(dataTable.row(2).get(1))
                        .usingTheCity(dataTable.row(3).get(1))
                        .usingTheState(dataTable.row(4).get(1))
                        .usingTheZipCode(dataTable.row(5).get(1))
                        .usingTheCountry(dataTable.row(6).get(1))
                        .andUsingTheMobilePhone(dataTable.row(7).get(1))
        );
    }

    @Entonces("el sistema debera mostrar en pantalla un mensaje de error indicando que la contrasena es requerida")
    public void elSistemaDeberaMostrarEnPantallaUnMensajeDeErrorIndicandoQueLaContrasenaEsRequerida() {
        theActorInTheSpotlight().should(
                seeThat(
                        registerFormFailure()
                                .wasFilledWithFirstName(dataToValidate.row(0).get(1))
                                .wasFilledWithLastName(dataToValidate.row(1).get(1))
                                .wasFilledWithAddress(dataToValidate.row(2).get(1))
                                .wasFilledWithCity(dataToValidate.row(3).get(1))
                                .wasFilledWithState(dataToValidate.row(4).get(1))
                                .wasFilledWithZipCode(dataToValidate.row(5).get(1))
                                .wasFilledWithCountry(dataToValidate.row(6).get(1))
                                .andWithMobilePhone(dataToValidate.row(7).get(1))
                                .is(), equalTo(false)
                )
                        .orComplainWith(ValidationTextDoNotMatch.class, String.format(VALIDATION_DO_NOT_MATCH, compareInWithSystemOutcome(REGISTRATION_PASSWD_ERROR)))
        );
    }

    private String compareInWithSystemOutcome(Target target){
        return "\n" + "Data for test : System outcome"
                + "\n" + "Welcome to your account. Here you can manage all of your personal information and orders." + " : " + target.resolveFor(theActorInTheSpotlight()).getText()
                ;
    }
}
