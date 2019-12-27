package com.atcn.bdd.ui.mobile.steps;

import com.atcn.bdd.ui.mobile.pages.CalculatorPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class CalculatorStep {

    @Autowired
    CalculatorPage calculatorPage;

    @Given("^I am on calculator page$")
    public void iAmOnCalculatorPage() throws Throwable {

    }

    @When("^Tap number twelve$")
    public void tapNumberTwelve() throws Throwable {
        calculatorPage.getDigi_1_btn().click();
        calculatorPage.getDigi_2_btn().click();
    }

    @And("^Tap 'delete'$")
    public void tapDelete() throws Throwable {
        calculatorPage.getDelete_btn().click();
    }

    @And("^Tap 'add' button$")
    public void tapAddButton() throws Throwable {
        calculatorPage.getPlus_btn().click();
    }

    @When("^Tap number six")
    public void tapNumberSix() throws Throwable {
        calculatorPage.getDigi_6_btn().click();
    }

    @And("^Tap equal button$")
    public void tapEqualButton() throws Throwable {
        calculatorPage.getEqual_btn().click();
    }

    @Then("^Calculated result is correct$")
    public void calculatedResultIsCorrect() throws Throwable {
        Assert.assertEquals("Verify result", "7", calculatorPage.getResult_txt().getText() );
    }

}
