package com.tcs.trainingxi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class WebCheckEpmPage {
    public static final Target SEARCH_HERE = Target.the("Search check")
            .locatedBy("//*[@id='dnn_ctr839_HtmlModule_lblContent']/table/tbody/tr[4]/td[1]/a/img");
}
