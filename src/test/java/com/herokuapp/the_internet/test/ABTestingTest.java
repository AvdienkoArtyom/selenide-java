package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.abtesting.ABTestingData;
import com.herokuapp.the_internet.core.model.abtesting.ABTestingPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

/**
 * Also known as split testing. This is a way in which businesses are able to simultaneously test
 * and learn different versions of a page to see which text and/or functionality works best towards
 * a desired outcome (e.g. a user action such as a click-through).
 */
public class ABTestingTest {

    @Test
    @Description("A/B Testing")
    public void abTestingTest() {

        ABTestingPO pageObject = open(ABTestingPO.URL, ABTestingPO.class);

        Validation.checkingOptionsForExpectedHeaders(
                pageObject,
                ABTestingData.FIRST_RANDOM_TITLE,
                ABTestingData.SECOND_RANDOM_TITLE);

        Validation.checkText(
                pageObject.getFirstParagraph(),
                ABTestingData.FIRST_PARAGRAPH);

    }
}
