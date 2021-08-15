package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.dynamic_loading.DynamicLoadingPO;
import com.herokuapp.the_internet.core.model.dynamic_loading.Example1PO;
import com.herokuapp.the_internet.core.model.dynamic_loading.Example2PO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DynamicLoadingTest {

    @Test
    @Description("Dynamically Loaded Page Elements")
    public void dynamicLoadingTest() {

        DynamicLoadingPO pageObject = open(DynamicLoadingPO.URL, DynamicLoadingPO.class);

        Example1PO example1PO = pageObject.getExample1PO();

        Validation.checkHiddenElement(example1PO.getLoadingAnimation());
        Validation.checkHiddenElement(example1PO.getFinishMessage());

        example1PO.clickStartButton();

        Validation.checkVisibleElement(example1PO.getLoadingAnimation());
        Validation.checkElementShouldBeHiddenInDuringTime(example1PO.getFinishMessage());

        Validation.checkElementShouldBeHiddenInDuringTime(example1PO.getLoadingAnimation());
        Validation.checkVisibleElement(example1PO.getFinishMessage());

        Example2PO example2PO = pageObject.getExample2PO();

        example2PO.clickStartButton();

        Validation.checkVisibleElement(example2PO.getLoadingAnimation());
        Validation.checkHiddenElement(example2PO.getFinishMessage());

        Validation.checkElementShouldBeHiddenInDuringTime(example2PO.getLoadingAnimation());
        Validation.checkVisibleElement(example2PO.getFinishMessage());

    }
}
