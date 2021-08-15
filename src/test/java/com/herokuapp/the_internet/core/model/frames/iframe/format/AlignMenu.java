package com.herokuapp.the_internet.core.model.frames.iframe.format;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AlignMenu {

    @Step("Выравнивание по левой стороне")
    public void setLeft(){
        $(By.cssSelector("div[title='Left']")).click();
    }

    @Step("Выравнивание по центру")
    public void setCenter(){
        $(By.cssSelector("div[title='Center']")).click();
    }

    @Step("Выравнивание по правой стороне")
    public void setRight(){
        $(By.cssSelector("div[title='Right']")).click();
    }

    @Step("Выравнивание по шерене")
    public void setJustify(){
        $(By.cssSelector("div[title='Justify']")).click();
    }
}
