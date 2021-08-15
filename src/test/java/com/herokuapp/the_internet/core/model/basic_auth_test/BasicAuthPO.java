package com.herokuapp.the_internet.core.model.basic_auth_test;

import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.switchTo;

public class BasicAuthPO extends BasePageObject {

    public static final String URL = "https://the-internet.herokuapp.com/basic_auth";

    @Step("Вводим логин {name} и пароль {pass}.")
    public void login(String name, String pass) {
        switchTo()
                .defaultContent()
                .navigate()
                .to(String.format("http://%s:%s@the-internet.herokuapp" +
                        ".com/basic_auth", name, pass));
    }
}
