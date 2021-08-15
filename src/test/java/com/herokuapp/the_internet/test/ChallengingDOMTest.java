package com.herokuapp.the_internet.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.challenging_dom.ChallengingDOMData;
import com.herokuapp.the_internet.core.model.challenging_dom.ChallengingDOMPO;
import com.herokuapp.the_internet.core.validation.Validation;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ChallengingDOMTest {

    @Test
    @Description("Challenging DOM")
    public void challengingDOMTest() {

        ChallengingDOMPO pageObject = open(ChallengingDOMPO.URL, ChallengingDOMPO.class);

        Validation.checkNameButton(ChallengingDOMData.TEXT_BUTTON, pageObject.getAllButtons());

        //FIXME больше нет идей как тестировать таблицу

        ElementsCollection elementsCollection = pageObject.getRowsAndHeader();

        Assertions.assertEquals(10, elementsCollection.size());

        for (int i = 0; i < 10; i++){

            ElementsCollection rowElement = pageObject.getCellsInByRowNumber(i);

            Assertions.assertEquals(7, rowElement.size());

            Assertions.assertEquals("Iuvaret" + i, rowElement.get(0).getText());
            Assertions.assertEquals("Apeirian" + i, rowElement.get(1).getText());
            Assertions.assertEquals("Adipisci" + i, rowElement.get(2).getText());
            Assertions.assertEquals("Definiebas" + i, rowElement.get(3).getText());
            Assertions.assertEquals("Consequuntur" + i, rowElement.get(4).getText());
            Assertions.assertEquals("Phaedrum" + i, rowElement.get(5).getText());

            ElementsCollection tdHrefElements = rowElement.get(6).$$(By.cssSelector("a"));

            Assertions.assertEquals(2, tdHrefElements.size());

            tdHrefElements.get(0).should(Condition.text("edit"));
            tdHrefElements.get(1).should(Condition.text("delete"));
        }

        SelenideElement canvasElement = $(By.cssSelector("#canvas"));

        //FIXME незнаю как тестировать canvas, могу проверить высоту и ширину
        canvasElement.should(Condition.visible);
        Dimension dimension = canvasElement.getSize();
        Assertions.assertEquals(202, dimension.height);
        Assertions.assertEquals(601, dimension.width);
    }
}
