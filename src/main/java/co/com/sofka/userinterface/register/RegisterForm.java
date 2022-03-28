package co.com.sofka.userinterface.register;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class RegisterForm extends PageObject {

    public static final Target SUBMIT_CREATE = Target
            .the("Submit create")
            .located(id("SubmitCreate"));

    //For fill elements.
    public static final Target FIRST_NAME = Target
            .the("First name")
            .located(id("customer_firstname"));

    public static final Target LAST_NAME = Target
            .the("Last name")
            .located(id("customer_lastname"));

    public static final Target PASSWORD = Target
            .the("Password")
            .located(id("passwd"));

    public static final Target ADDRESS_ONE = Target
            .the("Address 1")
            .located(id("address1"));

    public static final Target CITY = Target
            .the("City")
            .located(id("city"));

    public static final Target STATE = Target
            .the("State")
            .located(id("id_state"));

    public static final Target POST_CODE = Target
            .the("Zip Code")
            .located(id("postcode"));

    public static final Target COUNTRY = Target
            .the("Country")
            .located(id("id_country"));

    public static final Target MOBILE_PHONE = Target
            .the("Mobile Phone")
            .located(id("phone_mobile"));

    public static final Target SUBMIT_ACCOUNT = Target
            .the("Submit Account")
            .located(id("submitAccount"));

    //For validations.
    public static final Target REGISTRATION_PASSWD_ERROR = Target
            .the("Registration password error")
            .located(xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li/b"));

    public static final Target COMPLETE_NAME = Target
            .the("Complete name of the user")
            .located(xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span"));

    public static final Target LOGIN_SUCCES_WELCOME_MSG = Target
            .the("Login succesfully")
            .located(xpath("/html/body/div/div[2]/div/div[3]/div/p"));

    public static final Target SIGN_OUT = Target
            .the("Log Out")
            .located(xpath("/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a"));
}
