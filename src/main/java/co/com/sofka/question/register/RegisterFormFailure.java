package co.com.sofka.question.register;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.register.RegisterForm.REGISTRATION_PASSWD_ERROR;

public class RegisterFormFailure implements Question <Boolean> {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String mobilePhone;

    public RegisterFormFailure wasFilledWithFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public RegisterFormFailure wasFilledWithLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public RegisterFormFailure wasFilledWithAddress(String address) {
        this.address = address;
        return this;
    }

    public RegisterFormFailure wasFilledWithCity(String city) {
        this.city = city;
        return this;
    }

    public RegisterFormFailure wasFilledWithState(String state) {
        this.state = state;
        return this;
    }

    public RegisterFormFailure wasFilledWithZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public RegisterFormFailure wasFilledWithCountry(String country) {
        this.country = country;
        return this;
    }

    public RegisterFormFailure andWithMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public RegisterFormFailure is(){return this;}

    @Override
    public Boolean answeredBy(Actor actor) {
        return (REGISTRATION_PASSWD_ERROR.resolveFor(actor)
                .containsOnlyText("passwd -")
        );
    }

    public static RegisterFormFailure registerFormFailure(){
        return new RegisterFormFailure();
    }
}
