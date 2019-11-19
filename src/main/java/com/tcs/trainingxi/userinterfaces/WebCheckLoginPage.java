package com.tcs.trainingxi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class WebCheckLoginPage {

    public static final Target USSERNAME_IMPUT = Target.the("Ussername imput")
            .locatedBy("//input[@name='ctl00$cphPrincipal$txtCorreo']");

    public static final Target PASSWORD_IMPUT = Target.the("Password imput")
            .locatedBy("//input[@name='ctl00$cphPrincipal$txtClave']");

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .locatedBy("//input[@type='submit']");
}
