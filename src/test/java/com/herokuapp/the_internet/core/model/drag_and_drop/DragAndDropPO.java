package com.herokuapp.the_internet.core.model.drag_and_drop;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DragAndDropPO {
    public final static String URL = "https://the-internet.herokuapp.com/drag_and_drop";
    private final SelenideElement leftElement =
            $(By.cssSelector("#column-a"));
    private final SelenideElement rightElement =
            $(By.cssSelector("#column-b"));

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
}
