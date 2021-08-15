package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.horizontal_slider.HorizontalSliderPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class HorizontalSliderTest {

    @Test
    @Description("Horizontal Slider")
    public void horizontalSliderTest(){
        HorizontalSliderPO pageObject = open(HorizontalSliderPO.URL, HorizontalSliderPO.class);

        Validation.checkText(pageObject.toLeftOrRight(0), "2.5");

        Validation.checkText(pageObject.toRight(),"3");

        Validation.checkText( pageObject.toLeft(),"2.5");

        Validation.checkText(pageObject.toLeft(),"2");

        Validation.checkText(pageObject.toLeftOrRight(70),"5");
    }
}
