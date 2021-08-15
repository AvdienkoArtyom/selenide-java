package com.herokuapp.the_internet.core.model.multiple_windows;

import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.switchTo;

public class NewWindow extends BasePageObject {

    @Override
    public String getFirstParagraph() {
        throw new RuntimeException("у страници нет абзаца или описания");
    }

    @Step("Переключаемся на окно 'The Internet'")
    public void switchToTheInternet(){
        switchTo().window("The Internet");
    }
}
