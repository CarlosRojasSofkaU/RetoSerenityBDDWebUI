package co.com.sofka.task.register;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.login.LoginForm.EMAIL_CREATE;
import static co.com.sofka.userinterface.register.RegisterForm.SUBMIT_CREATE;

public class BrowseToRegisterForm implements Task {

    private String emailAddress;

    public BrowseToRegisterForm usingTheEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(EMAIL_CREATE),
                Enter.theValue(emailAddress).into(EMAIL_CREATE),
                Scroll.to(SUBMIT_CREATE),
                Click.on(SUBMIT_CREATE)
        );
    }

    public static BrowseToRegisterForm browseToRegisterForm(){
        return new BrowseToRegisterForm();
    }
}
