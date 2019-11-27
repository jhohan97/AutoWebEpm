package com.tcs.trainingxi.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class Enabled implements Question<String> {

    private Target campo;

    public Enabled(Target campo) {
        this.campo = campo;
    }

    @Override
    public String answeredBy(Actor actor) {
        return campo.resolveFor(actor).getAttribute("disabled");
    }

    public static Enabled fields (Target campo){
        return new Enabled(campo);
    }
}