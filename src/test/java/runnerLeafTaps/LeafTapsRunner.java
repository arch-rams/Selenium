package runnerLeafTaps;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import stepsLeafTaps.BaseClassLeafTaps;

@CucumberOptions(
		features = "src/test/java/featuresLeafTap",
		glue = "stepsLeafTaps",
		monochrome = true,
		dryRun = true,
		snippets = SnippetType.CAMELCASE 
		)


public class LeafTapsRunner extends BaseClassLeafTaps{

}
