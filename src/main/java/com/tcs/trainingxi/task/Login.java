package com.tcs.trainingxi.task;

import com.tcs.trainingxi.interaction.ChangePage;
import com.tcs.trainingxi.userinterfaces.*;
import com.tcs.trainingxi.utils.constans.Pages;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task {

    private String usserName;
    private String password;

    public Login(String usserName, String password) {
        this.usserName = usserName;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PopuoComponent.INITIAL_POPUP),
                Click.on(HomePage.PAY_CHECK_BUTTON),
                ChangePage.in(Pages.FACTURA_WEB_EPM),
                Click.on(WebCheckEpmPage.SEARCH_HERE),
                ChangePage.in(Pages.FACTURA_WEB_EPM_INICIO),
                Click.on(WebCheckStartPage.LOGIN_BUTTON),
                Enter.theValue(usserName).into(WebCheckLoginPage.USSERNAME_IMPUT),
                Enter.theValue(password).into(WebCheckLoginPage.PASSWORD_IMPUT),
                Click.on(WebCheckLoginPage.LOGIN_BUTTON));
    }

    public static Login inThePage(String ussername, String password){
        return Tasks.instrumented(Login.class,ussername,password);
    }
}