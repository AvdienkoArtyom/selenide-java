package com.herokuapp.the_internet.core.model.dynamic_loading;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DynamicLoadingPO extends BasePageObject {
    public static final String URL = baseURL + "/dynamic_loading";
    private final SelenideElement title = $(".example h3");
    private final SelenideElement firstParagraph =
            $(By.cssSelector(".example p"));

    @Step("Переходим на страницу 'Example 1: Element on page that is hidden'")
    public Example1PO getExample1PO() {
        return open(Example1PO.URL, Example1PO.class);
    }

    @Step("Переходим на страницу 'Example 2: Element rendered after the fact'")
    public Example2PO getExample2PO() {
        return open(Example2PO.URL, Example2PO.class);
    }

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
