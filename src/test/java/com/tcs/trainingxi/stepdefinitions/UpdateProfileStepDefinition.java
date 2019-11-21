package com.tcs.trainingxi.stepdefinitions;

import com.tcs.trainingxi.exceptions.FieldsExeption;
import com.tcs.trainingxi.models.Credentials;
import com.tcs.trainingxi.models.UserData;
import com.tcs.trainingxi.models.builders.CredentialsBuilder;
import com.tcs.trainingxi.models.builders.UserDataBuilder;
import com.tcs.trainingxi.questions.Enabled;
import com.tcs.trainingxi.questions.Field;
import com.tcs.trainingxi.questions.GetMaxLength;
import com.tcs.trainingxi.task.Edit;
import com.tcs.trainingxi.task.Login;
import com.tcs.trainingxi.task.NavegateTo;
import com.tcs.trainingxi.utils.PropsCsv;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.tcs.trainingxi.userinterfaces.EditProfilePage.INPUT_FIELD;
import static com.tcs.trainingxi.userinterfaces.EditProfilePage.MESSAGE_REQUIRED;
import static com.tcs.trainingxi.utils.constans.MessageException.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UpdateProfileStepDefinition {

    public static Credentials credentials;
    public static UserData userData;

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
    public void theUserLoginOnThePage(List<Map<String,String>> credentialsList)throws IOException {
        credentials= CredentialsBuilder.credentialInformation(PropsCsv.getDataCsv("Credentials",credentialsList.get(0).get("id"))).build();
        OnStage.theActorInTheSpotlight().wasAbleTo(Login.inThePage(credentials));
    }

    @When("^The user edits his profile$")
    public void theUserEditsHisProfile() {
        OnStage.theActorInTheSpotlight().attemptsTo(NavegateTo.editPage());
    }

    @Then("^He cannot edit the fields of mail, document type and identification number$")
    public void heCannotEditTheFieldsOfMailDocumentTypeAndIdentificationNumber(List<String> target) {
        OnStage.theActorInTheSpotlight().should(seeThat(Enabled.fields(INPUT_FIELD.of(target.get(2))),
                is(equalTo(target.get(3)))).orComplainWith(FieldsExeption.class, FIELD_IS_ENABLED));
    }
    @Then("^He visualized all fields$")
    public void heVisualizedAllFields(List<String> target) {
        OnStage.theActorInTheSpotlight().should(seeThat(Field.isVisible(INPUT_FIELD.of(target.get(1))),
                Matchers.is(Matchers.equalTo(true))).orComplainWith(FieldsExeption.class, FIELD_IS_NOT_VISIBLE));
    }

    @Then("^He cannot enter more data in the fields$")
    public void heCannotEnterMoreDataInTheFields(List<String> target) {
        OnStage.theActorInTheSpotlight().should(seeThat(GetMaxLength.field(INPUT_FIELD.of(target.get(2))),
                is(equalTo(target.get(3)))).orComplainWith(FieldsExeption.class,FIELD_LENGHT));
    }


    @When("^The user diligently edits the information$")
    public void theUserDiligentlyEditsTheInformation(List<Map<String,String>> userDataList)throws IOException {
        OnStage.theActorInTheSpotlight().attemptsTo(NavegateTo.editPage());
        userData = UserDataBuilder.userDataInformation(PropsCsv.getDataCsv("UserDataInformation",userDataList.get(0).get("id"))).build();
        OnStage.theActorInTheSpotlight().wasAbleTo(Edit.profile(userData));
    }

    @Then("^He visualized a message indicanding that you must complete the fields\\.$")
    public void heVisualizedAMessageIndicandingThatYouMustCompleteTheFields() {
        OnStage.theActorInTheSpotlight().should(seeThat(Field.isVisible(MESSAGE_REQUIRED)));
    }
}
