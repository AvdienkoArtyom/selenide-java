package com.herokuapp.the_internet.core.model.exit_intent;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ExitIntentPO extends BasePageObject {
    public static final String URL = "https://the-internet.herokuapp.com/exit_intent";
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
