package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.form_authentication.FormAuthenticationData;
import com.herokuapp.the_internet.core.model.form_authentication.FormAuthenticationPO;
import com.herokuapp.the_internet.core.model.form_authentication.FormAuthenticationSecureAreaPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class FormAuthenticationTest {

    @Test
    @Description("Form Authentication")
    public void formAuthenticationTest() {
        FormAuthenticationPO pageObject = open(FormAuthenticationPO.URL,
                FormAuthenticationPO.class);

        pageObject.sendUsername(FormAuthenticationData.USER_NAME);
        pageObject.sendPassword(FormAuthenticationData.PASSWORD);

        FormAuthenticationSecureAreaPO pageObjectSE = pageObject.login();

        Validation.checkText(pageObjectSE.getFlashMessage(), "You logged into a secure area!");

        Validation.checkText(pageObjectSE.getTitle(), "Secure Area");
        Validation.checkText(
                pageObjectSE.getFirstParagraph(),
                "Welcome to the Secure Area. When you are done click logout below."
        );

        pageObject = pageObjectSE.logout();

        Assertions.assertEquals("Login Page", pageObject.getTitle());
        Validation.checkText(pageObject.getFlashMessage(), "You logged out of the secure area!");

    }
}
