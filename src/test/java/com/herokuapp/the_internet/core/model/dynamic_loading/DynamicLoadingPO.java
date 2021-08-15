package com.herokuapp.the_internet.core.model.dynamic_loading;

import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class DynamicLoadingPO extends BasePageObject {
    public static final String URL = "https://the-internet.herokuapp.com/dynamic_loading";

    @Step("Переходим на страницу 'Example 1: Element on page that is hidden'")
    public Example1PO getExample1PO() {
        return open(Example1PO.URL, Example1PO.class);
    }

    @Step("Переходим на страницу 'Example 2: Element rendered after the fact'")
    public Example2PO getExample2PO() {
        return open(Example2PO.URL, Example2PO.class);
    }
}
