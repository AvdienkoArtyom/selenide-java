package com.herokuapp.the_internet.core.model.disappearing_elements;

import com.codeborne.selenide.ElementsCollection;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class DisappearingElementsPO extends BasePageObject {
    public static final String URL = "https://the-internet.herokuapp.com/disappearing_elements";
    private final ElementsCollection buttons = $$(By.cssSelector(".example ul li a"));

    @Step("Получаем список кнопок меню")
    public ElementsCollection getButtons() {
        return buttons;
    }
}
