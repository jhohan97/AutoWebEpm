package com.tcs.trainingxi.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/update_profile.feature",
                    snippets = SnippetType.CAMELCASE,
                    glue="com.tcs.trainingxi.stepdefinitions",
                    dryRun = false,
                    tags = "@this")
public class UpdateProfile {
}
