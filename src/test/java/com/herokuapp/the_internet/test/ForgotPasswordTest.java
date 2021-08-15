package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.forgot_password.ForgotPasswordData;
import com.herokuapp.the_internet.core.model.forgot_password.ForgotPasswordPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class ForgotPasswordTest {

    @Test
    @Description("Forgot Password")
    public void forgotPasswordTest(){
        ForgotPasswordPO pageObject = open(ForgotPasswordPO.URL, ForgotPasswordPO.class);

        pageObject.setEmail(ForgotPasswordData.SOME_EMAIL);

        pageObject.clickRetrievePasswordButton();

        Validation.checkTextElement(pageObject.getResultAfterRetrievePassword(),
                ForgotPasswordData.ERROR_MESSAGE);
    }
}
