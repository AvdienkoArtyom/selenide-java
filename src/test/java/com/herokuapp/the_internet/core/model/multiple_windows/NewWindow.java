package com.herokuapp.the_internet.core.model.multiple_windows;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class NewWindow extends BasePageObject {
    private final SelenideElement title = $(".example h3");

    @Step("Переключаемся на окно 'The Internet'")
    public void switchToTheInternet(){
        switchTo().window("The Internet");
    }

    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }
}
