package co.com.sofka.runner.register;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/register/register.feature"},
        glue = {"co.com.sofka.stepdefinition.register"},
        tags = {""}
)
public class RegisterTest {
}
