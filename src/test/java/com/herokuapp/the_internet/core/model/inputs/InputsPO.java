package com.herokuapp.the_internet.core.model.inputs;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class InputsPO extends BasePageObject {
    public static final String URL = baseURL + "/inputs";
    private final SelenideElement element = $(By.cssSelector(".example input"));
    private final SelenideElement title = $(".example h3");

    @Step("Увеличиваем значение на еденицу")
    public void arrowUp() {
        element.sendKeys(Keys.ARROW_UP);
    }

    @Step("Уменьшаем значение на еденицу")
    public void down() {
        element.sendKeys(Keys.DOWN);
    }

    @Step("Получаем значение поля ввода")
    public String getInputValue() {
        return element.getAttribute("value");
    }

    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }
}
