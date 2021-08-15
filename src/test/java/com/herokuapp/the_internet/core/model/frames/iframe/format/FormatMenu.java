package com.herokuapp.the_internet.core.model.frames.iframe.format;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FormatMenu {

    @Step("Переходив в раздел выравнивание")
    public AlignMenu getAlign(){
        $(By.cssSelector("div[title='Align']")).click();
        return new AlignMenu();
    }
}
