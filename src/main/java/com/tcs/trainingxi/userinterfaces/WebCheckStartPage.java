package com.tcs.trainingxi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class WebCheckStartPage {
    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .locatedBy("//a[text()='Inicia tu sesión']");
}