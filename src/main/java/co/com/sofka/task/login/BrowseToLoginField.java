package co.com.sofka.task.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.login.LoginForm.SIGN_IN;

public class BrowseToLoginField implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SIGN_IN),
                Click.on(SIGN_IN)
        );
    }

    public static BrowseToLoginField browseToLoginField(){
        return new BrowseToLoginField();
    }
}
