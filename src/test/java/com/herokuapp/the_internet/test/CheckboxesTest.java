package com.herokuapp.the_internet.test;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.checkboxes_test.CheckboxesTestPO;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class CheckboxesTest {

    @Test
    @Description("Checkboxes")
    public void checkboxesTest() {

        CheckboxesTestPO checkboxesTestPO = open(CheckboxesTestPO.URL, CheckboxesTestPO.class);

        SelenideElement checkBox1 = checkboxesTestPO.getFirstCheckbox();
        SelenideElement checkBox2 = checkboxesTestPO.getSecondCheckbox();

        Assertions.assertFalse(checkBox1.isSelected());
        Assertions.assertTrue(checkBox2.isSelected());

        checkboxesTestPO.clickToCheckBox1();
        checkboxesTestPO.clickToCheckBox2();

        Assertions.assertTrue(checkBox1.isSelected());
        Assertions.assertFalse(checkBox2.isSelected());
    }
}
