package co.com.sofka.question.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.contactus.ContactUsForm.MESSAGE_ERROR_VALIDATION;

public class ContactUsFormFailure implements Question <Boolean> {

    private String subjectHeading;
    private String emailAddress;

    public ContactUsFormFailure wasFilledWithSubjectHeading(String subjectHeading) {
        this.subjectHeading = subjectHeading;
        return this;
    }

    public ContactUsFormFailure andWithEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ContactUsFormFailure is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (MESSAGE_ERROR_VALIDATION.resolveFor(actor)
                .containsOnlyText("The message cannot be blank.")
        );
    }

    public static ContactUsFormFailure contactUsFormFailure(){
        return new ContactUsFormFailure();
    }
}
