package com.tcs.trainingxi.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;


public class GetMaxLength implements Question {

    private Target campo;

    public GetMaxLength(Target campo) {
        this.campo = campo;
    }

    @Override
    public Object answeredBy(Actor actor) {
        System.out.println(campo.resolveFor(actor).getAttribute("maxlength"));
        return campo.resolveFor(actor).getAttribute("maxlength");
    }

    public static GetMaxLength field(Target campo){
        return new GetMaxLength(campo);
    }



}
