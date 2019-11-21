package com.tcs.trainingxi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class EditProfilePage {

    public static final Target INPUT_FIELD = Target.the("{0} input")
            .locatedBy("//*[@id='ctl00_cphPrincipal_{0}']");

    public static final Target SAVE_BUTTON = Target.the("Save Button")
            .locatedBy("//*[@id='ctl00_cphPrincipal_btnGuardar'] ");

    public static final Target MESSAGE_REQUIRED = Target.the("Message Required")
            .locatedBy("//*[@id='simple-modal-required']/div[2]/div");

    public static final Target MESSAGE_SUCCES = Target.the("Message Succes")
            .locatedBy("//span[text()='La información ingresada fue almacenada con éxito.']");
}
