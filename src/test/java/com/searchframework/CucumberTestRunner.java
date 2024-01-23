package com.searchframework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/com/searchframework/features",
        glue={"com.searchframework.steps"}
        //plugin = {"pretty", "html:target/cucumber-reports"}
)

@ComponentScan(
        basePackages = {"com.searchframework.hooks", "com.searchframework.wrappers", "com.searchframework.pages"}
)

public class CucumberTestRunner {
}