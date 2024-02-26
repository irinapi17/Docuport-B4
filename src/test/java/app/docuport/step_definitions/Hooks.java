package app.docuport.step_definitions;


import app.docuport.utilities.DBUtils;
import app.docuport.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

	@Before("@db")
	public void dbHook() {
		System.out.println("creating database connection");
		DBUtils.createConnection();
	}
	
	@After("@db")
	public void afterDbHook() {
		System.out.println("closing database connection");
		DBUtils.destroyConnection();
	}
	
	@Before("@ui")
	public void setUp() {
		// we put a logic that should apply to every scenario
		//System.out.println("Setting up webdriver");
		Driver.getDriver();

	}
	
	@After("@ui")
	public void tearDown(Scenario scenario) {
		// only takes a screenshot if the scenario fails
		if (scenario.isFailed()) {
			// taking a screenshot
			final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "Failed scenario screenshot","image/png");
		}
		Driver.closeDriver();
	}
}
