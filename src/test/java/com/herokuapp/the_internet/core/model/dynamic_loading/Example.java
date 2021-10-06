package com.herokuapp.the_internet.core.model.dynamic_loading;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class Example extends BasePageObject {
    private final SelenideElement title = $(".example h3");
    private final SelenideElement firstParagraph =
            $(By.cssSelector(".example h4"));
    private final SelenideElement startButton = $(By.cssSelector("#start button"));
    private final SelenideElement loadingAnimation =
            $(By.cssSelector("#loading"));
    private final SelenideElement finish =
            $(By.cssSelector("#finish"));

    @Step("Получаем первый абзац или описание страницы")
    @Attachment("Абзац или описание")
    public String getFirstParagraph() {
        return firstParagraph.getText();
    }

    @Step("Нажимаем на кнопку 'Start'")
    public void clickStartButton() {
         startButton.click();
    }

    @Step("Получаем элемент анимации на странице.")
    public SelenideElement getLoadingAnimation() {
        return loadingAnimation;
    }

    @Step("Получаем сообщение после анимации на странице.")
    public SelenideElement getFinishMessage() {
        return finish;
    }

    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }
}
