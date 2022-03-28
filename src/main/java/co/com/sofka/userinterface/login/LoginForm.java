package co.com.sofka.userinterface.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class LoginForm extends PageObject {

    public static final Target SIGN_IN = Target
            .the("Sign in")
            .located(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"));

    //For fill elements.
    public static final Target EMAIL_ADDRESS = Target
            .the("Email Address")
            .located(id("email"));

    public static final Target PASSWORD = Target
            .the("Password")
            .located(id("passwd"));

    public static final Target SUBMIT_LOGIN= Target
            .the("Submit login")
            .located(id("SubmitLogin"));

    public static final Target EMAIL_CREATE = Target
            .the("Email For Create User")
            .located(id("email_create"));

    public static final Target SUBMIT_CREATE = Target
            .the("Submit create")
            .located(id("SubmitCreate"));

    //For validations.
    public static final Target CREATE_ACCOUNT_ERROR = Target
            .the("Create account error")
            .located(id("create_account_error"));

    public static final Target AUTHENTICATION_ERROR = Target
            .the("Authentication Error")
            .located(xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/ol/li"));

    public static final Target LOGIN_SUCCES_WELCOME_MSG = Target
            .the("Login succesfully")
            .located(xpath("/html/body/div/div[2]/div/div[3]/div/p/text()"));
}
