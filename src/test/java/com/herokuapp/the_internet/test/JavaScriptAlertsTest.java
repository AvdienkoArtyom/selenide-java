package com.herokuapp.the_internet.test;

import com.codeborne.selenide.Configuration;
import com.google.common.collect.ImmutableMap;
import com.herokuapp.the_internet.core.model.java_script_alerts.JavaScriptAlertsData;
import com.herokuapp.the_internet.core.model.java_script_alerts.JavaScriptAlertsPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;

public class JavaScriptAlertsTest {

    @BeforeAll
    public static void setConfigure() {
        Configuration.browserCapabilities = DesiredCapabilities
                .chrome()
                .merge(new DesiredCapabilities(ImmutableMap
                        .of(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE)));
    }

    @Test
    @Description("JavaScript Alerts")
    public void javaScriptAlertsTest() {
        JavaScriptAlertsPO pageObject = open(JavaScriptAlertsPO.URL, JavaScriptAlertsPO.class);

        pageObject.clickJsAlert();
        pageObject.accept();
        Validation.checkText(pageObject.getResult(),JavaScriptAlertsData.JS_ALERT);

        pageObject.clickJsConfirm();
        pageObject.accept();
        Validation.checkText(pageObject.getResult(), JavaScriptAlertsData.JS_CONFIRM_OK);
        pageObject.clickJsConfirm();
        pageObject.dismiss();
        Validation.checkText(pageObject.getResult(), JavaScriptAlertsData.JS_CONFIRM_CANCEL);

        pageObject.clickJsPrompt();
        pageObject.sPrompt("123456");
        Validation.checkText(pageObject.getResult(), JavaScriptAlertsData.JS_PROMPT);

        pageObject.clickJsPrompt();
        pageObject.dismiss();
        Validation.checkText(pageObject.getResult(), JavaScriptAlertsData.JS_PROMPT_CANCEL);
    }
}
