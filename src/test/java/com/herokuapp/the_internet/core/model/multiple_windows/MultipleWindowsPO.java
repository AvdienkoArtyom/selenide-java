package com.herokuapp.the_internet.core.model.multiple_windows;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MultipleWindowsPO extends BasePageObject {
    public static final String URL = "https://the-internet.herokuapp.com/windows";
    private final SelenideElement clickHere =  $(By.cssSelector(".example a"));

    @Override
    public String getFirstParagraph() {
        throw new RuntimeException("у страници нет абзаца или описания");
    }

    @Step("Открываем новое окно")
    public void openNewMultipleWindow(){
        clickHere.click();
    }

    @Step("Переходим в новое окно")
    public NewWindow switchToNewWindow(){
        switchTo().window("New Window");
        return new NewWindow();
    }
}
