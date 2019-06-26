package org.mattpayne.fun.jpa.cucumber.simplejpa;

// Start with https://github.com/eugenp/tutorials/blob/master/spring-cucumber/src/test/java/com/baeldung/CucumberIntegrationTest.java
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
public class CucumberIntegrationTest extends SpringIntegrationTest{
}

