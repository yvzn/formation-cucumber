package fr.exemple;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features")
@ContextConfiguration(classes = AppConfig.class)
public class CucumberTA {

    // TODO Commencer par un exemple où les feeature sont dans le même dossier

}
