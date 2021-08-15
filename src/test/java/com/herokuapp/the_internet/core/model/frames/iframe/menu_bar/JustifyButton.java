package com.herokuapp.the_internet.core.model.frames.iframe.menu_bar;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class JustifyButton {

    private SelenideElement justifyButton = $(By.cssSelector("div[title='alignment'] button[title='Justify']"));

    @Step("Жмем на кнопку выравнить по ширене")
    public void clickJustify() {
        justifyButton.click();
    }

    @Step("Проверяем что элемент на странице активный")
    public boolean isActiv() {
        String status = justifyButton.getAttribute("aria-pressed");
        if (status != null) {
            return status.equals("true");
        } else {
            throw new RuntimeException("Неизвестный " +
                    "статус кнопки");
        }
    }
}
