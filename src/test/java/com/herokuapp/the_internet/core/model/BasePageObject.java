package com.herokuapp.the_internet.core.model;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasePageObject {

    private final SelenideElement title = $(".example h3");
    private final SelenideElement firstParagraph =
            $(By.cssSelector(".example p"));


    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }

    @Step("Получаем первый абзац или описание страницы")
    @Attachment("Абзац или описание")
    public String getFirstParagraph() {
        return firstParagraph.getText();
    }
}
