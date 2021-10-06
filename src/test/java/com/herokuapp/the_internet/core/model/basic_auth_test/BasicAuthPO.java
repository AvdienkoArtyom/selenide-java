package com.herokuapp.the_internet.core.model.basic_auth_test;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class BasicAuthPO extends BasePageObject {

    public static final String URL = baseURL + "/basic_auth";
    private final SelenideElement title = $(".example h3");
    private final SelenideElement firstParagraph =
            $(By.cssSelector(".example p"));

    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }

    @Step("Получаем первый абзац или описание страницы")
    @Attachment("Абзац или описание")
    public String getFirstParagraph() {
        return firstParagraph.getText();
    }

    @Step("Вводим логин {name} и пароль {pass}.")
    public void login(String name, String pass) {
        switchTo().defaultContent()
                .navigate()
                .to(String.format("http://%s:%s@the-internet.herokuapp" +
                        ".com/basic_auth", name, pass));
    }
}
