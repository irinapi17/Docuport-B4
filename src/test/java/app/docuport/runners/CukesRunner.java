package app.docuport.runners;

import app.docuport.utilities.Driver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber/report.html",
                "junit:target/junit/junit-report.xml",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features/",
        glue = "app/docuport/step_definitions",
        tags = "",
        dryRun = false
)
public class CukesRunner {
       /*
    Command to run from terminal:
    mvn test -Dcucumber.filter.tags=@smoke
    mvn test -Dcucumber.filter.tags=@stockData
    */
}


