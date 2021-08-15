package com.herokuapp.the_internet.test;

import com.codeborne.selenide.Condition;
import com.herokuapp.the_internet.core.model.jquery_uimenus.JQueryUIMenusPO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class JQueryUIMenusTest {

    @Disabled
    @Test
    public void jQueryUIMenusTest() {
        JQueryUIMenusPO pageObject = open(JQueryUIMenusPO.URL, JQueryUIMenusPO.class);

        //TODO возможно тут нужно проексперементировать с jquery, чем тупо проверить отображение
        // кнопок
    }
}
