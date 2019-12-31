package com.atcn.bdd.ui.debug;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BingSearchCommonPage {

    public BingSearchCommonPage(AppiumDriver driver) {
        // Init MobileElement - @AndroidFindBy
        // or
        // IOSElement - @iOSXCUITFindBy
        /**
         * AppiumFieldDecorator PO
         *  AppiumDriver
         * Supporting Elements: {WebElement, MobileElement, IOSElement}
         *
         */
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        // Init WebElement/MobileElement/IOSElement - @FindBy
//        PageFactory.initElements(driver, this);
    }

    //    @iOSXCUITFindBy(id = "sb_form_q")

    /**
     * @FindAll : When required WebElement objects need to match at least one of the given criteria use @FindAll annotation
     */
//    @FindAll({
//            @FindBy(how = How.NAME, using = "q"),
//            @FindBy(how = How.ID, using = "sb_form_q")
//    })
    /**
     * @FindBys : When the required WebElement objects need to match all of the given criteria use @FindBys annotation
     */
    @FindBys({
            @FindBy(how = How.ID_OR_NAME, using = "q")
//            @FindBy(how = How.ID, using = "sb_form_q")
    })
    private WebElement searchTextField;

    public WebElement getSearchTextField() {
        return searchTextField;
    }

    @FindBy(id = "sbBtn")
    private WebElement searchBTN;

    public WebElement getSearchBTN() {
        return searchBTN;
    }
}
