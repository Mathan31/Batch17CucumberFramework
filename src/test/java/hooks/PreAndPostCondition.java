package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.PicoTestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class PreAndPostCondition {
	
	private WebDriver driver;
	
	public PreAndPostCondition(PicoTestContext picoTestContext) {
		driver = picoTestContext.getTestBase().launchBrowser();
	}
	
	
	@After
	public void afterMethod() {
		//System.out.println("I will be executing after each scenario and scenario outline presence in all the features file.");
		driver.quit();
	}
	

	@AfterStep
	public void takeScreenShot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", "screenFailure");
		}
	}

}
