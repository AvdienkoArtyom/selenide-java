package com.herokuapp.the_internet.test;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.dropdown_test.DropdownData;
import com.herokuapp.the_internet.core.model.dropdown_test.DropdownPO;
import com.herokuapp.the_internet.core.model.dropdown_test.Option;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class DropdownTest {

    @Test
    @Description("Dropdown List")
    public void dropdownTest(){
        DropdownPO pageObject = open(DropdownPO.URL, DropdownPO.class);

        SelenideElement dropDownLis = pageObject.getDropDownList();

        Validation.checkTextElement(dropDownLis, DropdownData.NO_CHOOSE);

        pageObject.selectOption(Option.OPTION_1);

        Validation.checkTextElement(dropDownLis, Option.OPTION_1);

        pageObject.selectOption(Option.OPTION_2);

        Validation.checkTextElement(dropDownLis, Option.OPTION_2);
    }
}
