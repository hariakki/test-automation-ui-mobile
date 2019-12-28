package com.atcn.bdd.ui.mobile.pages;

import com.atcn.bdd.ui.mobile.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CalculatorPage extends BasePage {

    //    @FindBy(how = How.ID, using = "digit1")
//    @iOSXCUITFindBy(id = "digit1")
    @AndroidFindBy(id = "digit_1")
    private MobileElement digi_1_btn;

    @AndroidFindBy(id = "digit_2")
    private MobileElement digi_2_btn;

    @AndroidFindBy(id = "digit_3")
    private MobileElement digi_3_btn;

    @AndroidFindBy(id = "digit_4")
    private MobileElement digi_4_btn;

    @AndroidFindBy(id = "digit_5")
    private MobileElement digi_5_btn;

    @AndroidFindBy(id = "digit_6")
    private MobileElement digi_6_btn;

    @AndroidFindBy(id = "digit_7")
    private MobileElement digi_7_btn;

    @AndroidFindBy(id = "digit_8")
    private MobileElement digi_8_btn;

    @AndroidFindBy(id = "digit9")
    private MobileElement digi_9_btn;

    @AndroidFindBy(accessibility = "plus")
    private MobileElement plus_btn;

    @AndroidFindBy(accessibility = "minus")
    private MobileElement minus_btn;

    @AndroidFindBy(accessibility = "multiply")
    private MobileElement mul_btn;

    @AndroidFindBy(accessibility = "divide")
    private MobileElement div_btn;

    @AndroidFindBy(accessibility = "equals")
    private MobileElement equal_btn;

    @AndroidFindBy(accessibility = "delete")
    private MobileElement delete_btn;

    @AndroidFindBy(id = "result")
    private MobileElement result_txt;

    public MobileElement getDigi_1_btn() {
        waitFluentVisibilityOfElm(digi_1_btn);
        return digi_1_btn;
    }

    public MobileElement getDigi_2_btn() {
        waitFluentVisibilityOfElm(digi_2_btn);
        return digi_2_btn;
    }

    public MobileElement getDigi_3_btn() {
        waitFluentVisibilityOfElm(digi_3_btn);
        return digi_3_btn;
    }

    public MobileElement getDigi_4_btn() {
        waitFluentVisibilityOfElm(digi_4_btn);
        return digi_4_btn;
    }

    public MobileElement getDigi_5_btn() {
        waitFluentVisibilityOfElm(digi_5_btn);
        return digi_5_btn;
    }

    public MobileElement getDigi_6_btn() {
        waitFluentVisibilityOfElm(digi_6_btn);
        return digi_6_btn;
    }

    public MobileElement getDigi_7_btn() {
        waitFluentVisibilityOfElm(digi_7_btn);
        return digi_7_btn;
    }

    public MobileElement getDigi_8_btn() {
        waitFluentVisibilityOfElm(digi_8_btn);
        return digi_8_btn;
    }

    public MobileElement getDigi_9_btn() {
        waitFluentVisibilityOfElm(digi_9_btn);
        return digi_9_btn;
    }

    public MobileElement getPlus_btn() {
        waitFluentVisibilityOfElm(plus_btn);
        return plus_btn;
    }

    public MobileElement getMinus_btn() {
        waitFluentVisibilityOfElm(minus_btn);
        return minus_btn;
    }

    public MobileElement getMul_btn() {
        waitFluentVisibilityOfElm(mul_btn);
        return mul_btn;
    }

    public MobileElement getDiv_btn() {
        waitFluentVisibilityOfElm(div_btn);
        return div_btn;
    }

    public MobileElement getEqual_btn() {
        waitFluentVisibilityOfElm(equal_btn);
        return equal_btn;
    }

    public MobileElement getDelete_btn() {
        waitFluentVisibilityOfElm(delete_btn);
        return delete_btn;
    }

    public MobileElement getResult_txt() {
        waitFluentVisibilityOfElm(result_txt);
        logger.debug("Calculated result is: " + result_txt.getText());
        return result_txt;
    }
}
