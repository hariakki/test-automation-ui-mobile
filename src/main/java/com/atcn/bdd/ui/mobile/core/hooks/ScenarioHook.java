package com.atcn.bdd.ui.mobile.core.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScenarioHook {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before
    public void setup(Scenario scenario) {
        logger.info("Scenario before hook started");
    }

    @After
    public void teardown(Scenario scenario) {
        logger.info("Scenario after hook started");

    }
}
