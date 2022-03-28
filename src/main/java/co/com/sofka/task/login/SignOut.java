package co.com.sofka.task.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.register.RegisterForm.SIGN_OUT;

public class SignOut implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SIGN_OUT),
                Click.on(SIGN_OUT)
        );
    }

    public static SignOut signOut(){
        return new SignOut();
    }
}
