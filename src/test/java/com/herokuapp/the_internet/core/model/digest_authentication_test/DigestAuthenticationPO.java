package com.herokuapp.the_internet.core.model.digest_authentication_test;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class DigestAuthenticationPO extends BasePageObject {
    public final static String URL = baseURL + "/digest_auth";
    private final SelenideElement title = $(".example h3");
    private final SelenideElement firstParagraph =
            $(By.cssSelector(".example p"));

    @Step("Вводим логин {name} и пароль {pass}.")
    public void login(String name, String pass) {
        switchTo()
                .defaultContent()
                .navigate()
                .to(String.format("http://%s:%s@the-internet.herokuapp.com/digest_auth",
                        name, pass));

    }

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
}
