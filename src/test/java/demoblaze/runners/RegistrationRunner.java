package demoblaze.runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "summary", "html:target/reports/cucumber-reports/cucumber.html", "json:target/reports/cucumber-reports/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = "src/test/java/demoblaze/features",
        glue = "demoblaze.stepdefinitions",
        tags = "@registration"
)

public class RegistrationRunner extends BaseTestRunner {
}
