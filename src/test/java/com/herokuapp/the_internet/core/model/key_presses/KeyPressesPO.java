package com.herokuapp.the_internet.core.model.key_presses;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class KeyPressesPO {
    public static final String URL = "https://the-internet.herokuapp.com/key_presses";

    private SelenideElement input = $(By.cssSelector(".example form input"));
    private SelenideElement result = $(By.cssSelector("#result"));

    @Step("Вводим текст {value}.")
    public void setInput(String value){
        input.sendKeys(value);
    }

    @Step("Получаем результат.")
    public String getResult(){
        return result.getText();
    }
}
