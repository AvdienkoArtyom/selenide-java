package com.herokuapp.the_internet.test;

import com.codeborne.selenide.Condition;
import com.herokuapp.the_internet.core.model.exit_intent.ExitIntentPO;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ExitIntentTest {

    @Disabled("Пока не реализован")
    @Test()
    @Description("Exit Intent")
    public void exitIntentTest(){
        ExitIntentPO pageObject = open(ExitIntentPO.URL, ExitIntentPO.class);

        // TODO как узнаю как выносить курсор из рабочей области браузера, так реализую
        // executeJavaScript("var event = new MouseEvent('mouseleave'); document.dispatchEvent
        // (event)");

    }
}
