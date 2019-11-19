package com.tcs.trainingxi.task;

import com.tcs.trainingxi.userinterfaces.WebCheckMyWebCheck;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Edit implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Click.on(WebCheckMyWebCheck.PROFILE_BUTTON));
    }
    public static Edit profile(){
        return Tasks.instrumented(Edit.class);
    }
}
