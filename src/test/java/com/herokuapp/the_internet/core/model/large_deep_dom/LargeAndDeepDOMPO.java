package com.herokuapp.the_internet.core.model.large_deep_dom;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LargeAndDeepDOMPO extends BasePageObject {
    public static final String URL = baseURL + "/large";

    private final SelenideElement selenideElement = $(By.id("sibling-50.3"));

    private final SelenideElement selenideElement2 = $(By.cssSelector(".row-50 .column-50"));

    @Step("Получаем самый вложеный элемент")
    public SelenideElement getNestedElement(){
        return selenideElement;
    }

    @Step("Получаем самую правую нижнюю ячейку таблицы")
    public SelenideElement getTableElement(){
        return selenideElement2;
    }
}
