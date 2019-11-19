package com.tcs.trainingxi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class EditProfilePage {

    public static final Target IMPUT_FIELD = Target.the("{0} imput")
            .locatedBy("//*[@id='ctl00_cphPrincipal_{0}']");
}
