package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.hovers.HoversPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class HoversTest {

    @Test
    @Description("Hovers")
    public void hoversTest(){
        HoversPO hoversPO = open(HoversPO.URL, HoversPO.class);

        Validation.isNotDisplayed(hoversPO.getLeftHover());

        hoversPO.getLeftImg().hover();

        Validation.isDisplayed(hoversPO.getLeftHover());
    }
}
