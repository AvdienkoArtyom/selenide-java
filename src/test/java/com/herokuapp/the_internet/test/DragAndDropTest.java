package com.herokuapp.the_internet.test;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.drag_and_drop.DragAndDropPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    @Description("Drag and Drop")
    public void dragAndDropTest() {
        DragAndDropPO pageObject = open(DragAndDropPO.URL, DragAndDropPO.class);

        SelenideElement elementA = pageObject.getLeftSquare();
        SelenideElement elementB = pageObject.getRightSquare();

        Validation.checkTextElement(elementA, "A");
        Validation.checkTextElement(elementB, "B");

        pageObject.moveElementToAnotherElement(elementA, elementB);

        Validation.checkTextElement(pageObject.getLeftSquare(), "B");
        Validation.checkTextElement(pageObject.getRightSquare(), "A");
    }
}
