package com.atcn.bdd.ui.mobile.pages;

import com.atcn.bdd.ui.mobile.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class BingSearchPage extends BasePage {

    @FindBy(how = How.NAME, using = "q")
    private WebElement searchTextField;

    @FindBy(id = "sb_form_go")
    private WebElement searchBTN;

    @FindBy(how = How.LINK_TEXT, using = "GitHub中文社区")
    private WebElement resultLINKTXT;

    public WebElement getSearchTextField() {
        waitFluentVisibilityOfElm(searchTextField);
        return searchTextField;
    }

    public WebElement getSearchBTN() {
        return searchBTN;
    }

    public WebElement getResultLINKTXT() {
        waitFluentVisibilityOfElm(resultLINKTXT);
        logger.debug("Search result link text is: " + resultLINKTXT.getText());
        return resultLINKTXT;
    }
}
