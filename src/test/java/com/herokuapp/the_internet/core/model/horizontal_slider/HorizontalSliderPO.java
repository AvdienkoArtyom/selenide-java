package com.herokuapp.the_internet.core.model.horizontal_slider;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class HorizontalSliderPO extends BasePageObject {
    public static final String URL = "https://the-internet.herokuapp.com/horizontal_slider";
    private final SelenideElement title = $(By.cssSelector(".example h4"));
    private final SelenideElement input = $(By.cssSelector("input[type='range']"));
    private final SelenideElement range = $(By.id("range"));

    @Override
    @Step("Получаем первый абзац или описание страницы")
    @Attachment("Абзац или описание")
    public String getFirstParagraph() {
        return title.getText();
    }
    //первый способ

    @Step("Переместить бегунок на шаг вправо")
    public String toRight(){
        input.sendKeys(Keys.RIGHT);
        return range.getText();
    }

    @Step("Переместить бегунок на шаг влево")
    public String toLeft(){
        input.sendKeys(Keys.LEFT);
        return range.getText();
    }

    // второй способ, середина 0 лево -70 право +70

    @Step("Задаём значение бегунка {value}")
    public String toLeftOrRight(int value){
        actions().dragAndDropBy(input, value, 0).build().perform();
        return range.getText();
    }
}
