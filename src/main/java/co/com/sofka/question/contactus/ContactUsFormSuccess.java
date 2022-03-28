package co.com.sofka.question.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.contactus.ContactUsForm.ALERT_SUCCESS;

public class ContactUsFormSuccess implements Question <Boolean> {

    private String subjectHeading;
    private String emailAddress;
    private String message;

    public ContactUsFormSuccess wasFilledWithSubjectHeading(String subjectHeading) {
        this.subjectHeading = subjectHeading;
        return this;
    }

    public ContactUsFormSuccess andWithEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ContactUsFormSuccess andWithMessage(String message) {
        this.message = message;
        return this;
    }

    public ContactUsFormSuccess is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (ALERT_SUCCESS.resolveFor(actor)
                .containsOnlyText("Your message has been successfully sent to our team.")
        );
    }

    public static ContactUsFormSuccess contactUsFormSuccess(){
        return new ContactUsFormSuccess();
    }
}
