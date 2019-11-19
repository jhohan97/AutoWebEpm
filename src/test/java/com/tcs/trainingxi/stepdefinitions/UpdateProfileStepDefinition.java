package com.tcs.trainingxi.stepdefinitions;

import com.tcs.trainingxi.exceptions.FieldIsEnabled;
import com.tcs.trainingxi.models.Credentials;
import com.tcs.trainingxi.questions.Enabled;
import com.tcs.trainingxi.task.Edit;
import com.tcs.trainingxi.task.Login;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.tcs.trainingxi.userinterfaces.EditProfilePage.IMPUT_FIELD;
import static com.tcs.trainingxi.utils.constans.MessageException.FIELD_IS_ENABLED;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UpdateProfileStepDefinition {

    @Managed
    private WebDriver hisBrowser;

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
        OnStage.theActorCalled("User on the page");
        OnStage.theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://www.epm.com.co"));
    }

    @Given("^The user login on the page$")
    public void theUserLoginOnThePage(List<Credentials> credentialsList) {
        OnStage.theActorInTheSpotlight().wasAbleTo(Login.inThePage(credentialsList.get(0).getUsserName(),
                credentialsList.get(0).getPassword()));
    }

    @When("^The user edits his profile$")
    public void theUserEditsHisProfile() {
        OnStage.theActorInTheSpotlight().attemptsTo(Edit.profile());
    }

    @Then("^He cannot edit the fields of correo , tipo de documento y número de identificación$")
    public void heCannotEditTheFieldsOfCorreoTipoDeDocumentoYNúmeroDeIdentificación(List<String> target) {
        OnStage.theActorInTheSpotlight().should(seeThat(Enabled.fields(IMPUT_FIELD.of(target.get(2))),
                is(equalTo(target.get(3)))).orComplainWith(FieldIsEnabled.class, FIELD_IS_ENABLED));
    }

}
