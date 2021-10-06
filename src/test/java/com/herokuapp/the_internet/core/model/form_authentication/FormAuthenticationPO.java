package com.herokuapp.the_internet.core.model.form_authentication;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormAuthenticationPO extends BasePageObject {
    public static final String URL = baseURL + "/login";
    private final SelenideElement title = $(By.cssSelector(".example h2"));
    private final SelenideElement paragraph = $(By.cssSelector(".example h4"));
    private final SelenideElement userNameInput = $(By.id("username"));
    private final SelenideElement passwordInput = $(By.id("password"));
    private final SelenideElement login = $(By.cssSelector("#login button"));
    private final SelenideElement flashMessage = $(By.cssSelector("#flash"));


    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }

    @Step("Получаем первый абзац или описание страницы")
    @Attachment("Абзац или описание")
    public String getFirstParagraph() {
        return paragraph.getText();
    }

    @Step("Вводим username {Username}")
    public void sendUsername(String name) {
        userNameInput.sendKeys(name);
    }

    @Step("Вводим username {Password}")
    public void sendPassword(String pass) {
        passwordInput.sendKeys(pass);
    }

    @Step("Нажинаем кнопку Login")
    public FormAuthenticationSecureAreaPO login() {
        login.click();
        return new FormAuthenticationSecureAreaPO();
    }

    @Step("Получить тект всплывающего сообщении после выхода")
    public String getFlashMessage() {
        String text = flashMessage.getText();
        return text.substring(0, text.length() - 2);
    }
}
