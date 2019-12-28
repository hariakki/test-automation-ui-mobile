package com.atcn.bdd.ui.mobile.steps;

import com.atcn.bdd.ui.mobile.pages.BingSearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;

public class WebBingSearchStep {

    @Autowired
    private BingSearchPage bingSearchPage;


    @Given("^I am on bing home page$")
    public void iAmOnBingHomePage() throws Throwable {

    }

    @When("^Input something on search text field and hit search$")
    public void inputSomethingOnSearchTextFieldAndHitSearch() throws Throwable {
        bingSearchPage.getSearchTextField().sendKeys("github");
        bingSearchPage.getSearchTextField().sendKeys(Keys.ENTER);
    }

    @Then("^I can see the search result$")
    public void iCanSeeTheSearchResult() throws Throwable {
        Assert.assertEquals("Search result", "GitHub中文社区", bingSearchPage.getResultLINKTXT().getText());
    }
}
