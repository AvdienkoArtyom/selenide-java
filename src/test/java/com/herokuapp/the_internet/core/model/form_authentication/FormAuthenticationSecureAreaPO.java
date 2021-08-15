package com.herokuapp.the_internet.core.model.form_authentication;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FormAuthenticationSecureAreaPO extends BasePageObject {
    private final SelenideElement title = $(By.cssSelector(".example h2"));
    private final SelenideElement paragraph =
            $(By.cssSelector(".example h4"));
    private final SelenideElement flashMessage = $(By.cssSelector("#flash"));
    private final SelenideElement logout =  $(By.cssSelector(".button.secondary.radius"));

    @Override
    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }

    @Override
    @Step("Получаем первый абзац или описание страницы")
    @Attachment("Абзац или описание")
    public String getFirstParagraph() {
        return paragraph.getText();
    }

    @Step("Получить тект всплывающего сообщении после входа")
    public String getFlashMessage() {
        String text = flashMessage.getText();
        return text.substring(0, text.length() - 2);
    }

    @Step("Выходим из акаунта")
    public FormAuthenticationPO logout() {
        logout.click();
        return new FormAuthenticationPO();
    }
}
