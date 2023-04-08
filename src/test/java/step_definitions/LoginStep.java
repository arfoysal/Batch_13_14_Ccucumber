package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DarazLoginPage;

import static org.testng.Assert.assertEquals;
import static utilities.DriverSetup.getDriver;

public class LoginStep {
    DarazLoginPage darazLoginPage = new DarazLoginPage();
    @Given("User is on the Login page")
    public void userIsOnTheLoginPage() {
        getDriver().get(darazLoginPage.LOGINPAGE_URL);
    }

    @Given("User enter valid username {string}")
    public void userEnterValidUsername(String arg0) {
        darazLoginPage.writeTextOnElement(darazLoginPage.EMAIL_PHONE_INPUT_FIELD, arg0);
    }

    @When("User enter invalid password {string}")
    public void userEnterInvalidPassword(String arg0) {
        darazLoginPage.writeTextOnElement(darazLoginPage.PASSWORD_INPUT_FIELD, arg0);
    }

    @And("user click on the log in button")
    public void userClickOnTheLogInButton() {
        darazLoginPage.clickOnElement(darazLoginPage.LOGIN_BUTTON);
    }

    @Then("User should see the error message {string}")
    public void userShouldSeeTheErrorMessage(String arg0) {
        assertEquals(darazLoginPage.getElementText(darazLoginPage.ERROR_MESSAGE), arg0);
    }

    @And("User should be in the login page")
    public void userShouldBeInTheLoginPage() {
        assertEquals(getDriver().getTitle(), darazLoginPage.LOGIN_PAGE_TITLE );
    }

    @When("User enter valid password {string}")
    public void userEnterValidPassword(String arg0) {
        darazLoginPage.writeTextOnElement(darazLoginPage.PASSWORD_INPUT_FIELD, arg0);
    }

    @Given("User enter invalid username {string}")
    public void userEnterInvalidUsername(String arg0) {
        darazLoginPage.writeTextOnElement(darazLoginPage.EMAIL_PHONE_INPUT_FIELD, arg0);
    }

    @When("User enter username {string}")
    public void userEnterUsernameUsername(String username) {
        darazLoginPage.writeTextOnElement(darazLoginPage.EMAIL_PHONE_INPUT_FIELD, username);
    }

    @And("User enter password {string}")
    public void userEnterPasswordPassword(String password) {
        darazLoginPage.writeTextOnElement(darazLoginPage.PASSWORD_INPUT_FIELD, password);
    }

    @When("User enter username {string} and password {string}")
    public void userEnterUsernameUsernameAndPasswordPassword(String username, String password) {
        darazLoginPage.writeTextOnElement(darazLoginPage.EMAIL_PHONE_INPUT_FIELD, username);
        darazLoginPage.writeTextOnElement(darazLoginPage.PASSWORD_INPUT_FIELD, password);
    }
}
