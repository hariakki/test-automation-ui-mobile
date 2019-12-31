package com.atcn.bdd.ui.mobile.pages;

import com.atcn.bdd.ui.mobile.core.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class WebCommonBingSearchPage extends BasePage {

    /**
     * Initiated by Android Driver -
     * 1st priority is to use @AndroidFindBy(Supports WebElement/ MobileElement/ AndroidElement))
     * 2nd priority is to use @FindBy(Supports WebElement/ MobileElement/ AndroidElement/ IOSElement/ WindowsElement)
     *
     * Same for IOS/ Windows as above.
     *
     * If Existing multiple elements, on BasePage, should below 1) Option, not 2)
     * 1) PageFactory.initElements(new AppiumFieldDecorator(this.webDriver), this);
     * 2) PageFactory.initElements(this.webDriver, this);
     *
     *
     * Suggest to only use WebElement type if this framework is used for both web and mobile.
     *
     */

    @FindBy(how = How.NAME, using = "q")
    @AndroidFindBy(id = "sb_form_q")
    @iOSXCUITFindBy()
    private WebElement searchTextField;

    @FindBy(id = "sb_form_go")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.Button[2]")
    @iOSXCUITFindBy()
    private WebElement searchBTN;

    @FindBy(how = How.LINK_TEXT, using = "GitHub中文社区")
    @AndroidFindBy(accessibility = "GitHub中文社区")
    @iOSXCUITFindBy()
    private WebElement resultLINKTXT;

    public WebElement getSearchTextField() {
        waitFluentVisibilityOfElm(searchTextField);
        return searchTextField;
    }

    public WebElement getSearchBTN() {
        waitFluentVisibilityOfElm(searchBTN);
        return searchBTN;
    }

    public WebElement getResultLINKTXT() {
        waitFluentVisibilityOfElm(resultLINKTXT);
        logger.debug("Search result link text is: " + resultLINKTXT.getText());
        return resultLINKTXT;
    }
}
