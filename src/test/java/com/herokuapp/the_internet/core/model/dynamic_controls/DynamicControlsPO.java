package com.herokuapp.the_internet.core.model.dynamic_controls;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class DynamicControlsPO extends BasePageObject {
    public static final String URL = baseURL + "/dynamic_controls";
    private final SelenideElement checkbox = $(By.cssSelector("#checkbox"));
    private final SelenideElement dynamicAddRemoveButton =  $(By.cssSelector("#checkbox-example button"));
    private final SelenideElement loadingAnimationAfterAddRemoveButton =
            $(By.cssSelector("#checkbox-example #loading"));
    private final SelenideElement messageAfterAddRemoveCheckbox =
            $(By.cssSelector("#checkbox-example #message"));
    private final SelenideElement buttonEnableDisable =
            $(By.cssSelector("#input-example button"));
    private final SelenideElement messageAfterEnableDisableButton =
            $(By.cssSelector("#input-example #message"));

    @Step("Получаем элемент checkbox на странице")
    public SelenideElement getCheckbox(){
        return checkbox;
    }

    @Step("Получаем элемент динамической кнопки ADD/Remove на странице")
    public SelenideElement getAddRemoveButton(){
       return dynamicAddRemoveButton;
    }

    @Step("Получаем элемент анимации на странице после нажатия кнопки ADD/Remove на странице")
    public SelenideElement getLoadingAnimationAfterAddRemoveButton(){
        return loadingAnimationAfterAddRemoveButton;
    }

    @Step("Получаем элемент сообщение после нажатия кнопки ADD/Remove на странице")
    public SelenideElement getMessageAfterAddRemoveCheckbox(){
        return messageAfterAddRemoveCheckbox;
    }

    @Step("Получаем элемент кнопки ENABLE/DISABLE")
    public SelenideElement getButtonEnableDisable(){
        return buttonEnableDisable;
    }

    @Step("Получаем элемент сообщения после нажатия кнопки ENABLE/DISABLE")
    public SelenideElement getMessageAfterEnableDisableButton(){
        return messageAfterEnableDisableButton;
    }
}
