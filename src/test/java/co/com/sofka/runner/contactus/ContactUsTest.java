package co.com.sofka.runner.contactus;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/contactus/contactUs.feature"},
        glue = {"co.com.sofka.stepdefinition.contactus"},
        tags = {""}
)
public class ContactUsTest {
}
