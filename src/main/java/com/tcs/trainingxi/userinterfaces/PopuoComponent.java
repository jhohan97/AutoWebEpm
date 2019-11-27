package com.tcs.trainingxi.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class PopuoComponent {

    public static final Target INITIAL_POPUP = Target.the("Initial popup in a home page")
            .locatedBy("//span[@title='Cerrar']");
}