package co.com.sofka.question.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.register.RegisterForm.REGISTRATION_PASSWD_ERROR;

public class LoginFailure implements Question <Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return (REGISTRATION_PASSWD_ERROR.resolveFor(actor)
                .containsOnlyText("passwd -")
        );
    }

    public static LoginFailure loginFailure(){
        return new LoginFailure();
    }
}
