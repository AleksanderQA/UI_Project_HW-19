package ui_tests_and_page_objects;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomDataGenerator;



public class LoginFormTest extends BasePage {

    BasePage basePage = new BasePage();


    @DisplayName("Test Authentication")
    @Description("This test attempts to log into the website using a random username and password.")
    @Owner("Aleksander")
    @Link("https://business.gett.com/auth")
    @Test
    public void loginWithRandomData() {

        basePage.enterSomeEmail(RandomDataGenerator.generateRandomEmail());
        basePage.clickNextButton();
        basePage.enterSomePassword(RandomDataGenerator.generatePassword());
        basePage.highLightPassword();
        basePage.clickSignInButton();
        basePage.receiveErrorMessage("We didn't recognise your email or password");
    }



    @DisplayName("Entering invalid type of Email")
    @Description("This test attempts to log into the website using a invalid type of Email.")
    @Owner("Aleksander")
    @Link("https://business.gett.com/auth")
    @Test
    public void enterInvalidTypeOfEmail() {
        basePage.enterSomeEmail(RandomDataGenerator.generateInvalidEmail());
        basePage.clickNextButton();
        basePage.emailValidationError("Your email is invalid");
    }


    @DisplayName("Reset password or Email by using invalid Data ")
    @Description("This test attempts to reset non-existing account Email or Password by using a invalid type of Email.")
    @Owner("Aleksander")
    @Link("https://business.gett.com/auth")
    @Test
    public void resetPassword() {
        basePage.enterSomeEmail(RandomDataGenerator.generateRandomEmail());
        basePage.clickNextButton();
        basePage.enterSomePassword(RandomDataGenerator.generatePassword());
        basePage.clickSignInButton();
        basePage.receiveErrorMessage("We didn't recognise your email or password");
        basePage.resetPasswordLink();
        basePage.clickContinueButton();
        basePage.instructionsSent();
    }
}
