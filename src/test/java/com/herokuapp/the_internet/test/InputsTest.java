package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.inputs.InputsPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class InputsTest {

    @Test
    @Description("Inputs")
    public void inputsTest(){
        InputsPO inputPO = open(InputsPO.URL, InputsPO.class);

        inputPO.arrowUp();
        Validation.checkText(inputPO.getInputValue(),"1" );
        inputPO.arrowUp();
        Validation.checkText(inputPO.getInputValue(),"2" );
        inputPO.arrowUp();
        Validation.checkText(inputPO.getInputValue(),"3" );
        inputPO.down();
        Validation.checkText(inputPO.getInputValue(),"2" );
    }
}
