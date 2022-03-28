package co.com.sofka.stepdefinition.contactus;

import co.com.sofka.exception.ValidationTextDoNotMatch;
import co.com.sofka.runner.setup.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.sofka.exception.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.question.contactus.ContactUsFormFailure.contactUsFormFailure;
import static co.com.sofka.question.contactus.ContactUsFormSuccess.contactUsFormSuccess;
import static co.com.sofka.task.contactus.BrowseToContactUsForm.browseToContactUsForm;
import static co.com.sofka.task.contactus.FillContactUsForm.fillContactUsForm;
import static co.com.sofka.task.landingpage.OpenLandingPage.openLandingPage;
import static co.com.sofka.userinterface.contactus.ContactUsForm.ALERT_SUCCESS;
import static co.com.sofka.userinterface.contactus.ContactUsForm.MESSAGE_ERROR_VALIDATION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactUsTestStepDefinition extends Setup {

    private static final String ACTOR_NAME = "Carlos";
    private DataTable dataToValidate;

    @Dado("que el cliente se encuentra en la landing page de automationpractice")
    public void queElClienteSeEncuentraEnLaLandingPageDeAutomationpractice() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().wasAbleTo(
                openLandingPage()
        );
    }

    @Cuando("el cliente navega y entra a la opcion de contactanos")
    public void elClienteNavegaYEntraALaOpcionDeContactanos() {
        theActorInTheSpotlight().attemptsTo(
                browseToContactUsForm()
        );
    }

    @Cuando("ha llenado los campos obligatorios y enviado")
    public void haLlenadoLosCamposObligatoriosYEnviado(DataTable dataTable) {
        dataToValidate = dataTable;
        theActorInTheSpotlight().attemptsTo(
                fillContactUsForm()
                        .usingTheSubjectHeading(dataTable.row(0).get(1))
                        .usingTheEmailAddress(dataTable.row(1).get(1))
                        .AndUsingTheMessage(dataTable.row(2).get(1))
        );
    }

    @Entonces("el sistema debera mostrar en pantalla un mensaje de operacion exitosa")
    public void elSistemaDeberaMostrarEnPantallaUnMensajeDeOperacionExitosa() {
        theActorInTheSpotlight().should(
                seeThat(
                        contactUsFormSuccess()
                                .wasFilledWithSubjectHeading(dataToValidate.row(0).get(1))
                                .andWithEmailAddress(dataToValidate.row(1).get(1))
                                .andWithMessage(dataToValidate.row(2).get(1))
                                .is(), equalTo(true)
                )
                        .orComplainWith(ValidationTextDoNotMatch.class, String.format(VALIDATION_DO_NOT_MATCH, compareInWithSystemOutcome(ALERT_SUCCESS)))
        );
    }


    @Cuando("ha llenado ciertos campos y enviado")
    public void haLlenadoCiertosCamposYEnviado(DataTable dataTable) {
        dataToValidate = dataTable;
        theActorInTheSpotlight().attemptsTo(
                fillContactUsForm()
                        .usingTheSubjectHeading(dataTable.row(0).get(1))
                        .usingTheEmailAddress(dataTable.row(1).get(1))
                        .AndUsingTheMessage("")
        );
    }

    @Entonces("el sistema debera mostrar en pantalla un mensaje de error pidiendo que se envie un mensaje")
    public void elSistemaDeberaMostrarEnPantallaUnMensajeDeErrorPidiendoQueSeEnvieUnMensaje() {
        theActorInTheSpotlight().should(
                seeThat(
                        contactUsFormFailure()
                                .wasFilledWithSubjectHeading(dataToValidate.row(0).get(1))
                                .andWithEmailAddress(dataToValidate.row(1).get(1))
                                .is(), equalTo(true)
                )
                        .orComplainWith(ValidationTextDoNotMatch.class, String.format(VALIDATION_DO_NOT_MATCH, compareInWithSystemOutcome(MESSAGE_ERROR_VALIDATION)))
        );
    }

    private String compareInWithSystemOutcome(Target target){
        return "\n" + "Data for test : System outcome"
                + "\n" + "Your message has been successfully sent to our team." + " : " + target.resolveFor(theActorInTheSpotlight()).getText()
                ;
    }
}
