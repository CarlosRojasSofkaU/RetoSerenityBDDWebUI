package co.com.sofka.task.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.com.sofka.userinterface.contactus.ContactUsForm.*;

public class FillContactUsForm implements Task {

    private String subjectHeading;
    private String emailAddress;
    private String message;

    public FillContactUsForm usingTheSubjectHeading(String subjectHeading) {
        this.subjectHeading = subjectHeading;
        return this;
    }

    public FillContactUsForm usingTheEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;

    }

    public FillContactUsForm AndUsingTheMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SUBJECT_HEADING),
                SelectFromOptions.byVisibleText(subjectHeading).from(SUBJECT_HEADING),

                Scroll.to(EMAIL_ADDRESS),
                Enter.theValue(emailAddress).into(EMAIL_ADDRESS),

                Scroll.to(MESSAGE),
                Enter.theValue(message).into(MESSAGE),

                Scroll.to(SUBMIT),
                Click.on(SUBMIT)
        );
    }

    public static FillContactUsForm fillContactUsForm(){
        return new FillContactUsForm();
    }
}
