package com.atcn.bdd.ui.mobile.steps;

import com.atcn.bdd.ui.mobile.pages.WebCommonBingSearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;

public class WebCommonBingSearchStep {

    @Autowired
    private WebCommonBingSearchPage webCommonBingSearchPage;


    @Given("^I am on bing home page$")
    public void iAmOnBingHomePage() throws Throwable {

    }

    @When("^Input something on search text field and hit search$")
    public void inputSomethingOnSearchTextFieldAndHitSearch() throws Throwable {
        webCommonBingSearchPage.getSearchTextField().sendKeys("github");
        webCommonBingSearchPage.getSearchTextField().sendKeys(Keys.ENTER);
    }

    @Then("^I can see the search result$")
    public void iCanSeeTheSearchResult() throws Throwable {
        Assert.assertEquals("Search result", "GitHub中文社区", webCommonBingSearchPage.getResultLINKTXT().getText());
    }
}
