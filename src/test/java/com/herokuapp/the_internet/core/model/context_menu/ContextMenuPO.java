package com.herokuapp.the_internet.core.model.context_menu;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class ContextMenuPO extends BasePageObject {
    public static final String URL = baseURL + "/context_menu";
    private final SelenideElement menuArea = $(By.cssSelector("#hot-spot"));
    private final SelenideElement title = $(".example h3");
    private final SelenideElement firstParagraph =
            $(By.cssSelector(".example p"));

    @Step("Кликаем по области правой кнопки мыши")
    public void getContextMenuAria() {
        menuArea.contextClick();
    }

    @Step("Получаем всплывающее сообщение")
    public Alert getAlert(){
        return switchTo().alert();
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
