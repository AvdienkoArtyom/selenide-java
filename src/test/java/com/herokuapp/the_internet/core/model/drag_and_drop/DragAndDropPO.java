package com.herokuapp.the_internet.core.model.drag_and_drop;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DragAndDropPO extends BasePageObject {
    public final static String URL = baseURL + "/drag_and_drop";
    private final SelenideElement leftElement =
            $(By.cssSelector("#column-a"));
    private final SelenideElement rightElement =
            $(By.cssSelector("#column-b"));
    private final SelenideElement title = $(".example h3");
    private final SelenideElement firstParagraph =
            $(By.cssSelector(".example p"));

    @Step("Получаем элемент находящийся слева")
    public SelenideElement getLeftSquare() {
        return leftElement;
    }

    @Step("Получаем элемент находящийся справа")
    public SelenideElement getRightSquare() {
        return rightElement;
    }

    @Step("Переносим элемент на другой элемент")
    public void moveElementToAnotherElement(SelenideElement moveElement, SelenideElement anotherElement) {
        moveElement.dragAndDropTo(anotherElement);
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
