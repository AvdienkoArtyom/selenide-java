package com.herokuapp.the_internet.core.model.checkboxes_test;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckboxesTestPO extends BasePageObject {
    public final static String URL = "https://the-internet.herokuapp.com/checkboxes";
    private final SelenideElement checkBox1 = $(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
    private final SelenideElement checkBox2 = $(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

    @Override
    public String getFirstParagraph() {
        throw new  RuntimeException("У страницы нет абзаца.");
    }

    public SelenideElement getFirstCheckbox(){
        return checkBox1;
    }

    public SelenideElement getSecondCheckbox(){
        return checkBox2;
    }

    @Step("Нажать на первый чекбокс")
    public void clickToCheckBox1(){
        checkBox1.click();
    }
    @Step("Нажать на второй чекбокс")
    public void clickToCheckBox2(){
        checkBox2.click();
    }

}
