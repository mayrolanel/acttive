package br.com.cursocucumber.test.runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"},
				 glue = {"br.com.cursocucumber.test.steps", "br.com.cursocucumber.config"},
				 plugin = {"pretty","html:target/import-html", "json:target/import.json"},
				 monochrome = true,
				 snippets = SnippetType.CAMELCASE,
				 dryRun = false,
				 strict = false,
				 tags = {"@unitários", "not @ignore"})
public class Runner {
}