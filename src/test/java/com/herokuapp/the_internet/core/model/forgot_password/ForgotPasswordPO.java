package com.herokuapp.the_internet.core.model.forgot_password;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPO extends BasePageObject {
    public static final String URL = "https://the-internet.herokuapp.com/forgot_password";
    private final SelenideElement inputMail = $(By.id("email"));
    private final SelenideElement retrieveButton =  $(By.id("form_submit"));
    private final SelenideElement title = $(By.cssSelector(".example h2"));
    private final SelenideElement result = $(By.cssSelector("h1"));

    @Step("Вводим свой email {email}")
    public void setEmail(String email) {
        inputMail.sendKeys(email);
    }

    @Step("Жмем кнопку RetrievePassword")
    public void clickRetrievePasswordButton() {
        retrieveButton.click();
    }

    @Step("Получаем SelenideElement с результатом")
    public SelenideElement getResultAfterRetrievePassword() {
        return result;
    }

    @Override
    public String getTitle() {
        return title.getText();
    }

    @Override
    public String getFirstParagraph() {
         throw new RuntimeException("У страницы нет абзаца или параграфа");
    }
}
