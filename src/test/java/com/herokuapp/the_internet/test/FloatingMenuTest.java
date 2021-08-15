package com.herokuapp.the_internet.test;

import com.codeborne.selenide.ElementsCollection;
import com.herokuapp.the_internet.core.model.floating_menu_test.FloatingMenuPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class FloatingMenuTest {

    @Test
    @Description("Floating Menu")
    public void floatingMenuTest(){
        FloatingMenuPO pageObject = open(FloatingMenuPO.URL, FloatingMenuPO.class);

        ElementsCollection elementsMenuUp = pageObject.getMenuElement();

        Validation.checkVisibleElements(elementsMenuUp, 4);

        pageObject.scrollByText(FloatingMenuPO.TEXT_BOTTOM_ELEMENT);

        Validation.checkVisibleElements(elementsMenuUp, 4);
    }
}
