package co.com.sofka.task.register;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.com.sofka.userinterface.contactus.ContactUsForm.SUBJECT_HEADING;
import static co.com.sofka.userinterface.register.RegisterForm.*;

public class FillRegisterForm implements Task {

    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String mobilePhone;

    public FillRegisterForm usingTheFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FillRegisterForm usingTheLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public FillRegisterForm usingThePassword(String password) {
        this.password = password;
        return this;
    }

    public FillRegisterForm usingTheAddress(String address) {
        this.address = address;
        return this;
    }

    public FillRegisterForm usingTheCity(String city) {
        this.city = city;
        return this;
    }

    public FillRegisterForm usingTheState(String state) {
        this.state = state;
        return this;
    }

    public FillRegisterForm usingTheZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public FillRegisterForm usingTheCountry(String country) {
        this.country = country;
        return this;
    }

    public FillRegisterForm andUsingTheMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(FIRST_NAME),
                Enter.theValue(firstName).into(FIRST_NAME),

                Scroll.to(LAST_NAME),
                Enter.theValue(lastName).into(LAST_NAME),

                Scroll.to(PASSWORD),
                Enter.theValue(password).into(PASSWORD),

                Scroll.to(ADDRESS_ONE),
                Enter.theValue(address).into(ADDRESS_ONE),

                Scroll.to(CITY),
                Enter.theValue(city).into(CITY),

                Scroll.to(STATE),
                SelectFromOptions.byVisibleText(state).from(STATE),

                Scroll.to(POST_CODE),
                Enter.theValue(zipCode).into(POST_CODE),

                Scroll.to(COUNTRY),
                SelectFromOptions.byVisibleText(country).from(COUNTRY),

                Scroll.to(MOBILE_PHONE),
                Enter.theValue(mobilePhone).into(MOBILE_PHONE),

                Scroll.to(SUBMIT_ACCOUNT),
                Click.on(SUBMIT_ACCOUNT)
        );
    }

    public static FillRegisterForm fillRegisterForm(){
        return new FillRegisterForm();
    }
}
