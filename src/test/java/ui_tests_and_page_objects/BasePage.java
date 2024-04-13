package ui_tests_and_page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Selenide.*;


public class BasePage {

  @BeforeAll
  public static void setUpAll() {
    Configuration.browserCapabilities = new ChromeOptions();
    Configuration.browserSize = "1920x1080";
    Configuration.holdBrowserOpen = true;
    SelenideLogger.addListener("allure", new AllureSelenide());
  }

  @BeforeEach
  public void setUp() {
    // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
    open("https://business.gett.com/auth");
  }


  // login form
  public void enterSomeEmail(String string) {
    SelenideElement emailForm = $x("//*[@data-name ='emailLoginForm']");
    emailForm.setValue(string);
    emailForm.shouldBe(Condition.visible);
  }


  public void clickNextButton() {
    SelenideElement nextButton = $x("//*[@data-name ='loginNextButton']");
    nextButton.shouldBe(Condition.enabled);
    nextButton.click();
  }

  public void enterSomePassword(String string) {
    SelenideElement passwordInputForm = $x("//*[@data-name ='passwordLoginForm']");
    passwordInputForm.setValue(string);
    passwordInputForm.shouldBe(Condition.visible);
  }

  public void clickSignInButton() {
    SelenideElement signInButton = $x("//*[@data-name ='loginButton']");
    signInButton.shouldBe(Condition.enabled);
    signInButton.click();
  }

  public void receiveErrorMessage(String string) {
    SelenideElement errorMessage = $x("//*[@data-name ='errorMessage']");
    errorMessage.shouldHave(Condition.matchText("We didn't recognise your email or password"));
  }

  public void highLightPassword() {
    SelenideElement eye = $x("//*[@fill-rule ='evenodd'][@data-component='Eye']");
    eye.shouldBe(Condition.visible);
    eye.shouldBe(Condition.enabled);
    eye.click();
  }

  public void emailValidationError(String string) {
    SelenideElement invalidEmail = $x("//*[@data-name='emailValidationError']");
    invalidEmail.shouldHave(Condition.matchText("Your email is invalid"));
    invalidEmail.shouldBe(Condition.visible);
  }



  // Language change

  public void clickOnLanguageDropDownMenu() {
    SelenideElement click = $x("//*[@*='Auth_langSelect__lubUa ant-select ant-select-enabled']");
    click.click();
  }

  public void headerLanguageOnRussian() {
    SelenideElement click = $x("//*[@*='Auth_title__zIWBS']");
    click.shouldHave(Condition.matchText("Добро пожаловать!"));
    click.click();

  }public void headerLanguageToEnglish() {
    SelenideElement click = $x("//*[@*='Auth_title__zIWBS']");
    click.shouldHave(Condition.matchText("Welcome!"));
    click.click();
  }

  public void changeLanguageToRussian() {
    SelenideElement changeLanguage = $x("//*[@*='Auth_ru__7+uS5']");
    changeLanguage.shouldBe(Condition.visible);
    changeLanguage.click();
  }

  public void changeLanguageToEnglish() {
    SelenideElement changeLanguage = $x("//*[@*='Auth_gb__+R0VQ']");
    changeLanguage.click();
  }



  // Reset password link

  public void resetPasswordLink () {
    SelenideElement reset = $x("//*[@data-name='forgotPasswordLink']");
    reset.click();
  }

  public void clickContinueButton(){
    SelenideElement continueButton = $x("//button[@data-name='forgotPasswordBtn']");
    continueButton.click();
  }

  public void instructionsSent(){
    SelenideElement receivedMessage = $x("//*[@*='wrap-break-word'][contains(text(), 'We sent an email with further instructions')]");
    receivedMessage.shouldBe(Condition.visible);
  }
}
