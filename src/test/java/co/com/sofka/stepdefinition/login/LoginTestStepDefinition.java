package co.com.sofka.stepdefinition.login;

import co.com.sofka.exception.ValidationTextDoNotMatch;
import co.com.sofka.runner.setup.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Random;

import static co.com.sofka.exception.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.question.login.LoginSuccess.loginSuccess;
import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.task.login.BrowseToLoginField.browseToLoginField;
import static co.com.sofka.task.login.FillLoginForm.fillLoginForm;
import static co.com.sofka.task.login.SignOut.signOut;
import static co.com.sofka.task.register.BrowseToRegisterForm.browseToRegisterForm;
import static co.com.sofka.task.register.FillRegisterForm.fillRegisterForm;
import static co.com.sofka.userinterface.login.LoginForm.AUTHENTICATION_ERROR;
import static co.com.sofka.userinterface.login.LoginForm.LOGIN_SUCCES_WELCOME_MSG;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginTestStepDefinition extends Setup {
    private DataTable dataToValidate;
    private String emailRandomized;
    private Random rand = new Random();
    private String GMAIL_EXTENSION = "@gmail.com";
    private static final String ACTOR_NAME = "Carlos";

    @Dado("que el cliente se encuentra en el landing page de la pagina web")
    public void queElClienteSeEncuentraEnElLandingPageDeLaPaginaWeb() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
        theActorInTheSpotlight().wasAbleTo(
                browseToLoginField()
        );
        emailRandomized = "senor" + rand.nextInt(10000) + GMAIL_EXTENSION;
        theActorInTheSpotlight().wasAbleTo(
                browseToRegisterForm()
                        .usingTheEmailAddress(emailRandomized)
        );
        theActorInTheSpotlight().wasAbleTo(
                fillRegisterForm()
                        .usingTheFirstName("Caly")
                        .usingTheLastName("Mano")
                        .usingThePassword("calymandela")
                        .usingTheAddress("El Bronx")
                        .usingTheCity("Bogota")
                        .usingTheState("Florida")
                        .usingTheZipCode("12345")
                        .usingTheCountry("United States")
                        .andUsingTheMobilePhone("6063333335")
        );
        theActorInTheSpotlight().wasAbleTo(
                signOut()
        );
    }

    @Cuando("el cliente navega y entra a la opcion de login")
    public void elClienteNavegaYEntraALaOpcionDeLogin() {
        theActorInTheSpotlight().attemptsTo(
                browseToLoginField()
        );
    }

    @Cuando("ha llenado con sus credenciales y enviado")
    public void haLlenadoConSusCredencialesYEnviado(DataTable dataTable) {
        dataToValidate = dataTable;
        theActorInTheSpotlight().attemptsTo(
                fillLoginForm()
                        .usingTheEmailAddress(emailRandomized)
                        .usingThePassword(dataTable.row(1).get(1))
        );
    }

    @Entonces("el sistema debera mostrar en pantalla funciones para el manejo de mis datos y ordenes")
    public void elSistemaDeberaMostrarEnPantallaFuncionesParaElManejoDeMisDatosYOrdenes() {
        theActorInTheSpotlight().should(
                seeThat(
                        loginSuccess()
                                .wasFilledWithPassword(dataToValidate.row(1).get(1))
                                .is(), equalTo(true)
                )
                        .orComplainWith(ValidationTextDoNotMatch.class, String.format(VALIDATION_DO_NOT_MATCH, compareInWithSystemOutcome(LOGIN_SUCCES_WELCOME_MSG)))

        );
    }

    @Cuando("ha llenado con credenciales erroneas y enviado")
    public void haLlenadoConCredencialesErroneasYEnviado(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                fillLoginForm()
                        .usingTheEmailAddress(emailRandomized)
                        .usingThePassword("calyman")
        );
    }

    @Entonces("el sistema debera mostrar en pantalla un mensaje de error indicando que la autenticacion fallo")
    public void elSistemaDeberaMostrarEnPantallaUnMensajeDeErrorIndicandoQueLaAutenticacionFallo() {
        theActorInTheSpotlight().should(
                seeThat(
                        loginSuccess()
                                .wasFilledWithPassword(dataToValidate.row(1).get(1))
                                .is(), equalTo(true)
                )
                        .orComplainWith(ValidationTextDoNotMatch.class, String.format(VALIDATION_DO_NOT_MATCH, compareInWithSystemOutcome(AUTHENTICATION_ERROR)))

        );
    }

    private String compareInWithSystemOutcome(Target target){
        return "\n" + "Data for test : System outcome"
                + "\n" + "Welcome to your account. Here you can manage all of your personal information and orders." + " : " + target.resolveFor(theActorInTheSpotlight()).getText()
                ;
    }
}
