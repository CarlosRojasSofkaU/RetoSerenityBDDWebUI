package co.com.sofka.userinterface.contactus;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class ContactUsForm extends PageObject{

    public static final Target CONTACT_US = Target
            .the("Contact Us")
            .located(By.xpath("//*[@id=\"contact-link\"]/a"));

    //For fill elements.
    public static final Target SUBJECT_HEADING = Target
            .the("Subject Heading")
            .located(id("id_contact"));

    public static final Target EMAIL_ADDRESS = Target
            .the("Email address")
            .located(id("email"));

    public static final Target ORDER_REFERENCE = Target
            .the("Order reference")
            .located(id("id_order"));

    public static final Target CHOOSE_FILE = Target
            .the("Choose File")
            .located(xpath("//*[@id=\"uniform-fileUpload\"]/span[2]"));

    public static final Target MESSAGE = Target
            .the("Message")
            .located(id("message"));

    public static final Target SUBMIT = Target
            .the("Send")
            .located(id("submitMessage"));

    //For validations.
    public static final Target ALERT_SUCCESS = Target
            .the("Alert Success")
            .located(xpath("/html/body/div/div[2]/div/div[3]/div/p"));

    public static final Target MESSAGE_ERROR_VALIDATION = Target
            .the("Message Error")
            .located(xpath("/html/body/div/div[2]/div/div[3]/div/div/ol/li"));
}
