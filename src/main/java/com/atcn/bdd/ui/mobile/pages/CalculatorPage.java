package com.atcn.bdd.ui.mobile.pages;

import com.atcn.bdd.ui.mobile.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.temporal.ChronoUnit;

@Component
@Scope("prototype")
public class CalculatorPage extends BasePage {

    /**
     * @FindBys : When the required WebElement objects need to match all of the given criteria use @FindBys annotation
     * @FindAll : When required WebElement objects need to match at least one of the given criteria use @FindAll annotation
     *
     * @AndroidFindAl : At least one of @AndroidBy value should be matched
     * e.g.
     * @AndroidFindAll({
     *      @AndroidBy(accessibility = "plus"),
     *      @AndroidBy(id = "op_add")
     * })
     *
     *
     * @AndroidFindBys : Each one of @AndroidBy value should be matched.
     * e.g.
     * @AndroidFindBys({
     *      @AndroidBy(id = "formula"),
     *      @AndroidBy(id = "formula")
     * })
     *
     * Other optional timeout by annotation to use
     * @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
     *
     */


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

    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindAll({
            /**
             * At least one of them should be matched
             */
            @AndroidBy(accessibility = "plus"),
            @AndroidBy(id = "op_add")
    })
    private MobileElement plus_btn;

    @AndroidFindBy(accessibility = "minus")
    private MobileElement minus_btn;

    @AndroidFindBy(accessibility = "multiply")
    private MobileElement mul_btn;

    @AndroidFindBy(accessibility = "divide")
    private MobileElement div_btn;

    @WithTimeout(time = 10, chronoUnit = ChronoUnit.SECONDS)
    @AndroidFindAll({
            /**
             * At least one of them should be matched
             */
            @AndroidBy(id = "eq"),
            @AndroidBy(accessibility = "equals")
    })
    private MobileElement equal_btn;

    @AndroidFindAll({
            /**
             * At least one of them should be matched
             */
            @AndroidBy(accessibility = "delete"),
            @AndroidBy(id = "del")
    })
    private MobileElement delete_btn;

    @AndroidFindAll({
            /**
             * Each one of them should be ALL matched
             */
            @AndroidBy(id = "formula"),
            @AndroidBy(id = "result")
    })
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
