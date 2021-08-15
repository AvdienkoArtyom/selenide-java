package com.herokuapp.the_internet.core.model.frames.nested_frame;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class NestedFramePO {

    @Step("Выходим в defaultContent")
    public void exitTheFrame(){
        switchTo().defaultContent();
    }

    @Step("Переходим в Left фрейм")
    public void goToFrameLeft(){
        switchTo().frame("frame-top").switchTo().frame("frame-left");
    }

    @Step("Переходим в Right фрейм")
    public void goToFrameRight(){
        switchTo().frame("frame-top").switchTo().frame("frame-right");
    }

    @Step("Переходим в Middle фрейм")
    public void goToFrameMiddle(){
        switchTo().frame("frame-top").switchTo().frame("frame-middle");
    }

    @Step("Переходим в Bottom фрейм")
    public void goToFrameBottom(){
        switchTo().frame("frame-bottom");
    }

    @Step("Получаем текст фрейма")
    public String getText(){
        return $(By.cssSelector("body")).getText();
    }
}
