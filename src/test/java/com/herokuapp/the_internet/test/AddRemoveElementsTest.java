package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.add_remove_elements.AddRemoveElementsPO;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AddRemoveElementsTest {

    @Test
    @Description("Add/Remove Elements")
    public void addRemoveElementsTest() {

        AddRemoveElementsPO pageObject = open(AddRemoveElementsPO.URL, AddRemoveElementsPO.class);

        pageObject.addElement();
        pageObject.addElement();
        pageObject.addElement();

        Assertions.assertEquals(3, pageObject.getSize());

        pageObject.deleteOneElement();
        pageObject.deleteOneElement();

        Assertions.assertEquals(1, pageObject.getSize());

    }
}
