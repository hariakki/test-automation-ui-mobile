package com.atcn.bdd.ui.mobile.pages;

import com.atcn.bdd.ui.mobile.core.BasePage;
import com.atcn.bdd.ui.mobile.core.helpers.WaitHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CalculatorPage extends BasePage {

//    @FindBy(how = How.ID, using = "digit1")
//    @iOSXCUITFindBy(id = "digit1")
    @AndroidFindBy( id = "digit_1")
    private MobileElement digi_1_btn;

    @AndroidFindBy( id = "digit_2")
    private MobileElement digi_2_btn;

    @AndroidFindBy( id = "digit_3")
    private MobileElement digi_3_btn;

    @AndroidFindBy( id = "digit_4")
    private MobileElement digi_4_btn;

    @AndroidFindBy( id = "digit_5")
    private MobileElement digi_5_btn;

    @AndroidFindBy( id = "digit_6")
    private MobileElement digi_6_btn;

    @AndroidFindBy( id = "digit_7")
    private MobileElement digi_7_btn;

    @AndroidFindBy( id = "digit_8")
    private MobileElement digi_8_btn;

    @AndroidFindBy( id = "digit9")
    private MobileElement digi_9_btn;

    @AndroidFindBy( accessibility = "plus")
    private MobileElement plus_btn;

    @AndroidFindBy( accessibility = "minus")
    private MobileElement minus_btn;

    @AndroidFindBy( accessibility = "multiply")
    private MobileElement mul_btn;

    @AndroidFindBy( accessibility = "divide")
    private MobileElement div_btn;

    @AndroidFindBy( accessibility = "equals")
    private MobileElement equal_btn;

    @AndroidFindBy( accessibility = "delete")
    private MobileElement delete_btn;

    @AndroidFindBy( id = "result")
    private MobileElement result_txt;

    @Autowired
    private WaitHelper waitHelper;

    public MobileElement getDigi_1_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(digi_1_btn);
        return digi_1_btn;
    }

    public MobileElement getDigi_2_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(digi_2_btn);
        return digi_2_btn;
    }

    public MobileElement getDigi_3_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(digi_3_btn);
        return digi_3_btn;
    }

    public MobileElement getDigi_4_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(digi_4_btn);
        return digi_4_btn;
    }

    public MobileElement getDigi_5_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(digi_5_btn);
        return digi_5_btn;
    }

    public MobileElement getDigi_6_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(digi_6_btn);
        return digi_6_btn;
    }

    public MobileElement getDigi_7_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(digi_7_btn);
        return digi_7_btn;
    }

    public MobileElement getDigi_8_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(digi_8_btn);
        return digi_8_btn;
    }

    public MobileElement getDigi_9_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(digi_9_btn);
        return digi_9_btn;
    }

    public MobileElement getPlus_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(plus_btn);
        return plus_btn;
    }

    public MobileElement getMinus_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(minus_btn);
        return minus_btn;
    }

    public MobileElement getMul_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(mul_btn);
        return mul_btn;
    }

    public MobileElement getDiv_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(div_btn);
        return div_btn;
    }

    public MobileElement getEqual_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(equal_btn);
        return equal_btn;
    }

    public MobileElement getDelete_btn() {
        waitHelper.waitUntilVisibilityOfElementFluent(delete_btn);
        return delete_btn;
    }

    public MobileElement getResult_txt() {
        waitHelper.waitUntilVisibilityOfElementFluent(result_txt);
        logger.info("Calculated result is: " +result_txt.getText());
        return result_txt;
    }
}
