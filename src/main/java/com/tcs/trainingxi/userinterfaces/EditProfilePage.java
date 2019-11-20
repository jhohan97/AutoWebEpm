package com.tcs.trainingxi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class EditProfilePage {

    public static final Target INPUT_FIELD = Target.the("{0} input")
            .locatedBy("//*[@id='ctl00_cphPrincipal_{0}']");
}
