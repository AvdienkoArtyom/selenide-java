package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.key_presses.KeyPressesData;
import com.herokuapp.the_internet.core.model.key_presses.KeyPressesPO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class KeyPressesTest {

    @Test
    public void kyPressesTest(){

        KeyPressesPO pageObject = open(KeyPressesPO.URL, KeyPressesPO.class);

        pageObject.setInput(KeyPressesData.SET_A);

        Assertions.assertEquals(KeyPressesData.RESULT_A, pageObject.getResult());

        pageObject.setInput(KeyPressesData.SET_ABB);

        Assertions.assertEquals(KeyPressesData.RESULT_ABB, pageObject.getResult());

        pageObject.setInput(KeyPressesData.SET_SPACE);

        Assertions.assertEquals(KeyPressesData.RESULT_SPACE, pageObject.getResult());

        pageObject.setInput(KeyPressesData.SET_BACK_SPACE);

        Assertions.assertEquals(KeyPressesData.RESULT_BACK_SPACE, pageObject.getResult());
    }
}
