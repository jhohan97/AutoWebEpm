package com.tcs.trainingxi.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ChangePage implements Interaction {

    private String title;

    public ChangePage(String title) {
        this.title = title;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Set<String> ListPage = BrowseTheWeb.as(actor).getDriver().getWindowHandles();
        for (String page:ListPage) {
            driver.switchTo().window(page);
            if(driver.getTitle().contains(title))
                break;
        }
        if (!driver.getTitle().contains(title)){
            throw new NoSuchWindowException("No se encontro la pagina: "+ title);
        }
    }
    public static ChangePage in(String title){
        return Tasks.instrumented(ChangePage.class,title);
    }
}
