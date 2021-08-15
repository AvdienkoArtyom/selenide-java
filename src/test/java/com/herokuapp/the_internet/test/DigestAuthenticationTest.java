package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.digest_authentication_test.DigestAuthenticationData;
import com.herokuapp.the_internet.core.model.digest_authentication_test.DigestAuthenticationPO;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DigestAuthenticationTest {

    @Test
    @Description("Digest Authentication")
    public void digestAuthenticationTest() {
        DigestAuthenticationPO pageObject = open(DigestAuthenticationPO.URL,
                DigestAuthenticationPO.class);

        pageObject.login(DigestAuthenticationData.NAME, DigestAuthenticationData.PASS);

        Assertions.assertEquals(
                DigestAuthenticationData.TITLE,
                pageObject.getTitle()
        );
        Assertions.assertEquals(
                DigestAuthenticationData.PARAGRAPH,
                pageObject.getFirstParagraph()
        );
    }
}
