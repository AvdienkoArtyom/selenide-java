package com.herokuapp.the_internet.core.model.frames.iframe.file;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FileMenu {
    @Step("Жмем на new Document")
    public void newDocument() {
        $(By.cssSelector(".tox-collection__group")).click();
    }
}
