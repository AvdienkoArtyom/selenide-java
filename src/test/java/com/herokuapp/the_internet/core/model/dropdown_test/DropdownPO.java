package com.herokuapp.the_internet.core.model.dropdown_test;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class DropdownPO extends BasePageObject {

    public static final String URL = baseURL + "/dropdown";
    private final SelenideElement dropdown = $(By.cssSelector("#dropdown"));

    @Step("Получаем элемент выпадаещего списка")
    public SelenideElement getDropDownList() {
        return dropdown;
    }

    @Step("Выбираем значение из выподаещего списка")
    public void selectOption(Option option) {
        dropdown.selectOption(option.getPosition());
    }

}
