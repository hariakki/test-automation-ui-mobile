package com.atcn.bdd.ui.mobile.core.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class ScenarioHook {

    @Before
    public void setup(Scenario scenario) {
        System.out.println("============================== Scenario before hook started");
    }

    @After
    public void teardown(Scenario scenario) {
        System.out.println("============================== Scenario after hook started");

    }
}
