package com.tcs.trainingxi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target PAY_CHECK_BUTTON = Target.the("Pay the check button")
            .locatedBy("//a[@class='btn btn-pay gradient-yellow color-white']");
}