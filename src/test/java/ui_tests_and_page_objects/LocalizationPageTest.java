package ui_tests_and_page_objects;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LocalizationPageTest extends BasePage {
    BasePage basePage = new BasePage();
    @DisplayName("Change page Language")
    @Owner("Aleksander")
    @Link("https://business.gett.com/auth")
    @Test
    public void changeMainPageLanguage(){
        basePage.clickOnLanguageDropDownMenu();
        basePage.changeLanguageToRussian();
        basePage.headerLanguageOnRussian();
        basePage.clickOnLanguageDropDownMenu();
        basePage.changeLanguageToEnglish();
        basePage.headerLanguageToEnglish();
    }
}