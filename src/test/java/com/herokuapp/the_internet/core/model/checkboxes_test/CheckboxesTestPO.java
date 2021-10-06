package com.herokuapp.the_internet.core.model.checkboxes_test;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckboxesTestPO extends BasePageObject {
    public final static String URL = baseURL + "/checkboxes";
    private final SelenideElement checkBox1 = $(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
    private final SelenideElement checkBox2 = $(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
    private final SelenideElement title = $(".example h3");

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

    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }
}
