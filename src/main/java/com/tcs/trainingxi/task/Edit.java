package com.tcs.trainingxi.task;

import com.tcs.trainingxi.models.UserData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.tcs.trainingxi.userinterfaces.EditProfilePage.INPUT_FIELD;
import static com.tcs.trainingxi.userinterfaces.EditProfilePage.SAVE_BUTTON;

public class Edit implements Task {

    private UserData userData;

    public Edit(UserData userData) {
        this.userData = userData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(Enter.theValue(userData.getNames()).into(INPUT_FIELD.of("txtNombres")),
                Enter.theValue(userData.getLastNames()).into(INPUT_FIELD.of("txtApellidos")),
                Enter.theValue(userData.getAdress()).into(INPUT_FIELD.of("txtDireccion")),
                Enter.theValue(userData.getTelephone()).into(INPUT_FIELD.of("txtTelefono")),
                Enter.theValue(userData.getCelNumber()).into(INPUT_FIELD.of("txtCelular")),
                Click.on(SAVE_BUTTON)
                );
    }
    public static Edit profile(UserData userData){
        return Tasks.instrumented(Edit.class,userData);
    }
}
