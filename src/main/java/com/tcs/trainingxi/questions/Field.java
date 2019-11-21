package com.tcs.trainingxi.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class Field implements Question {

    private Target campo;

    public Field(Target campo) {
        this.campo = campo;
    }

    @Override
    public Object answeredBy(Actor actor) {
        return Visibility.of(campo).viewedBy(actor).asBoolean();
    }

    public static Field isVisible(Target campo){
        return new Field(campo);
    }
}
