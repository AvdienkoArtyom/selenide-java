package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.dynamic_controls.DynamicControlsPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DynamicControlsTest {

    @Test
    @Description("Dynamic Controls")
    public void dynamicControlsTest() {

        DynamicControlsPO pageObject = open(DynamicControlsPO.URL, DynamicControlsPO.class);

        Validation.checkExistElement(pageObject.getCheckbox());

        Validation.checkVisibleElement(pageObject.getCheckbox());

        pageObject.getAddRemoveButton().click();

        Validation.checkVisibleElement(pageObject.getLoadingAnimationAfterAddRemoveButton());

        Validation.checkElementShouldBeHiddenInDuringTime(pageObject.getLoadingAnimationAfterAddRemoveButton());

        Validation.checkNotExistElement(pageObject.getCheckbox());

        Validation.checkTextElement(pageObject.getMessageAfterAddRemoveCheckbox(), "It's gone!");

        pageObject.getAddRemoveButton().click();

        Validation.checkVisibleElement(pageObject.getLoadingAnimationAfterAddRemoveButton());

        Validation.checkElementShouldBeHiddenInDuringTime(pageObject.getLoadingAnimationAfterAddRemoveButton());

        Validation.checkVisibleElement(pageObject.getCheckbox());

        Validation.checkTextElement(pageObject.getMessageAfterAddRemoveCheckbox(), "It's back!");

        pageObject.getButtonEnableDisable().click();

        Validation.checkTextElement(pageObject.getMessageAfterEnableDisableButton(), "It's " +
                "enabled!");

        pageObject.getButtonEnableDisable().click();

        Validation.checkTextElement(pageObject.getMessageAfterEnableDisableButton(), "It's " +
                "disabled!");

    }
}
