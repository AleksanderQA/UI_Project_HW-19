package ui_tests_and_page_objects;

import org.junit.jupiter.api.Test;
import utils.RandomDataGenerator;


public class LoginFormTest extends ui_tests_and_page_objects.BasePage {

    BasePage basePage = new ui_tests_and_page_objects.BasePage();

    @Test
    public void loginWithRandomData() {

        basePage.enterSomeEmail(RandomDataGenerator.generateRandomEmail());
        basePage.clickNextButton();
        basePage.enterSomePassword(RandomDataGenerator.generatePassword());
        basePage.highLightPassword();
        basePage.clickSignInButton();
        basePage.receiveErrorMessage("We didn't recognise your email or password");
    }

    @Test
    public void enterInvalidTypeOfEmail() {
        basePage.enterSomeEmail(RandomDataGenerator.generateInvalidEmail());
        basePage.clickNextButton();
        basePage.emailValidationError("Your email is invalid");
    }

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
