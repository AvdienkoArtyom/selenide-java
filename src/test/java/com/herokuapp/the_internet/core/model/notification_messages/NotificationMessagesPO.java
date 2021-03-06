package com.herokuapp.the_internet.core.model.notification_messages;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NotificationMessagesPO extends BasePageObject {
    public static final String URL = baseURL + "/notification_message_rendered";

    private SelenideElement element = $(By.cssSelector(".example p a"));
    private SelenideElement messageElement = $(By.id("flash"));

    @Step("Получаем 'Notification Message' на странице")
    public void loadNewMessage(){
        element.click();
    }

    @Step("Получаем текст 'Notification Message' на странице")
    public String getTextMessage(){
        String text = messageElement.getText();
        return text.substring(0, text.length() - 2);
    }
}
