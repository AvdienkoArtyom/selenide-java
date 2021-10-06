package com.herokuapp.the_internet.core.model.multiple_windows;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MultipleWindowsPO extends BasePageObject {
    public static final String URL = baseURL + "/windows";
    private final SelenideElement clickHere =  $(By.cssSelector(".example a"));
    private final SelenideElement title = $(".example h3");

    @Step("Открываем новое окно")
    public void openNewMultipleWindow(){
        clickHere.click();
    }

    @Step("Переходим в новое окно")
    public NewWindow switchToNewWindow(){
        switchTo().window("New Window");
        return new NewWindow();
    }

    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }
}
