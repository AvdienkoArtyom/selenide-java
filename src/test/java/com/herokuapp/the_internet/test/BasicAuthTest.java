package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.basic_auth_test.BasicAuthData;
import com.herokuapp.the_internet.core.model.basic_auth_test.BasicAuthPO;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class BasicAuthTest {

    @Test
    @Description("Basic Auth")
    public void basicAuthTest() {

        BasicAuthPO pageObject =open(BasicAuthPO.URL, BasicAuthPO.class);

        pageObject.login(BasicAuthData.NAME , BasicAuthData.PASS);

        Assertions.assertEquals(pageObject.getTitle(), BasicAuthData.TITLE);

        Assertions.assertEquals(pageObject.getFirstParagraph(), BasicAuthData.PARAGRAPH);

    }
}
