package co.com.sofka.question.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.login.LoginForm.LOGIN_SUCCES_WELCOME_MSG;

public class LoginSuccess implements Question <Boolean> {

    private String password;

    public LoginSuccess wasFilledWithPassword(String password) {
        this.password = password;
        return this;
    }

    public LoginSuccess is(){return this;}

    @Override
    public Boolean answeredBy(Actor actor) {
        return (LOGIN_SUCCES_WELCOME_MSG.resolveFor(actor)
                .containsOnlyText("Welcome to your account. Here you can manage all of your personal information and orders.")
        );
    }

    public static LoginSuccess loginSuccess(){
        return new LoginSuccess();
    }
}
