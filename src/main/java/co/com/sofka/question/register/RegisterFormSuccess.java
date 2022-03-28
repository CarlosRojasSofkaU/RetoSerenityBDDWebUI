package co.com.sofka.question.register;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.register.RegisterForm.*;

public class RegisterFormSuccess implements Question <Boolean> {

    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String mobilePhone;

    public RegisterFormSuccess wasFilledWithFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public RegisterFormSuccess wasFilledWithLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public RegisterFormSuccess wasFilledWithPassword(String password) {
        this.password = password;
        return this;
    }

    public RegisterFormSuccess wasFilledWithAddress(String address) {
        this.address = address;
        return this;
    }

    public RegisterFormSuccess wasFilledWithCity(String city) {
        this.city = city;
        return this;
    }

    public RegisterFormSuccess wasFilledWithState(String state) {
        this.state = state;
        return this;
    }

    public RegisterFormSuccess wasFilledWithZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public RegisterFormSuccess wasFilledWithCountry(String country) {
        this.country = country;
        return this;
    }

    public RegisterFormSuccess andWithMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public RegisterFormSuccess is(){return this;}

    @Override
    public Boolean answeredBy(Actor actor) {
        return (COMPLETE_NAME.resolveFor(actor).containsOnlyText(firstName + " " + lastName)
        );
    }

    public static RegisterFormSuccess registerFormSuccess(){
        return new RegisterFormSuccess();
    }
}
