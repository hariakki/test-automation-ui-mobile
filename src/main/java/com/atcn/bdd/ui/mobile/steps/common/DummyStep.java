package com.atcn.bdd.ui.mobile.steps.common;

import com.atcn.bdd.ui.mobile.core.springConfig.SpringConfig;
import cucumber.api.java.en.Given;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(
        classes = {SpringConfig.class},
        loader = SpringBootContextLoader.class
)
public class DummyStep {
    @Given("^Dummy Step for cucumber to start spring$")
    public void dummyStep() {
    }
}
