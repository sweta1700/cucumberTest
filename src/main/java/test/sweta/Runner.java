package test.sweta;

import org.junit.runner.*;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features",glue={"test.sweta"})
public class Runner
{
}