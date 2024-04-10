package ui_tests_and_page_objects;

import org.junit.jupiter.api.Test;

public class LocalizationPageTest extends ui_tests_and_page_objects.BasePage {
    ui_tests_and_page_objects.BasePage basePage = new ui_tests_and_page_objects.BasePage();
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