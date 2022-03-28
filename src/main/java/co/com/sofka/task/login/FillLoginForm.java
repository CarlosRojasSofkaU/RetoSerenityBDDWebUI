package co.com.sofka.task.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.login.LoginForm.*;

public class FillLoginForm implements Task {

    private String emailAddress;
    private String password;

    public FillLoginForm usingTheEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public FillLoginForm usingThePassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(EMAIL_ADDRESS),
                Enter.theValue(emailAddress).into(EMAIL_ADDRESS),

                Scroll.to(PASSWORD),
                Enter.theValue(password).into(PASSWORD),

                Scroll.to(SUBMIT_LOGIN),
                Click.on(SUBMIT_LOGIN)
        );
    }

    public static FillLoginForm fillLoginForm(){
        return new FillLoginForm();
    }
}
