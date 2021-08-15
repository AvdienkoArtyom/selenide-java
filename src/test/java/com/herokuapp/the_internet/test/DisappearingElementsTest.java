package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.disappearing_elements.DisappearingElementsPO;
import com.herokuapp.the_internet.core.validation.Validation;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DisappearingElementsTest {

    @Test
    @Description("Disappearing Elements")
    public void disappearingElementsTest(){

        DisappearingElementsPO pageObject = open(DisappearingElementsPO.URL,
                DisappearingElementsPO.class);

        Validation.checkMutationCountButton(pageObject, 4);

        Validation.checkMutationCountButton(pageObject, 5);

    }
}
