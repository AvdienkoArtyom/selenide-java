package com.herokuapp.the_internet.core.model.frames;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.frames.iframe.IFramePO;
import com.herokuapp.the_internet.core.model.frames.nested_frame.NestedFramePO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FramesPO {

    public static final String URL = "https://the-internet.herokuapp.com/frames";
    private final SelenideElement nestedFrames = $(By.linkText("Nested Frames"));
    private final SelenideElement iFrame = $(By.linkText("iFrame"));

    @Step("Переходим в раздел Nested Frames")
    public NestedFramePO goToNestedFrame(){
        nestedFrames.click();
        return new NestedFramePO();
    }

    @Step("Переходим в раздел iFrame")
    public IFramePO goToIFrame(){
        iFrame.click();
        return new IFramePO();
    }
}
