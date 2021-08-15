package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.large_deep_dom.LargeAndDeepDOMPO;
import com.herokuapp.the_internet.core.validation.Validation;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LargeAndDeepDOMTest {

    @Disabled
    @Test
    public void largeAndDeepDOMTest(){

        //FIXME не понимаю что и как тестировать,

        LargeAndDeepDOMPO pageObject = open(LargeAndDeepDOMPO.URL, LargeAndDeepDOMPO.class);

        Validation.checkVisibleElement(pageObject.getNestedElement());

        Validation.checkVisibleElement(pageObject.getTableElement());
    }
}
