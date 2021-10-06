package com.herokuapp.the_internet.core.model.entry_ad;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EntryAdPO extends BasePageObject {

    public static final String URL = baseURL + "/entry_ad";
    private final SelenideElement modalWindow = $(By.cssSelector(".modal"));
    private final SelenideElement buttonClose =
            $(By.cssSelector(".modal .modal-footer p"));
    private final SelenideElement restart = $(By.cssSelector("#restart-ad"));

    @Step("Получаем элемент модального окна")
    public SelenideElement getModalWindow(){
     return modalWindow;
    }

    @Step("Закрываем модальное окно на кнопке 'Close'")
    public void closeModalWindow(){
         buttonClose.click();
    }

    @Step("Перезагружаем страницу для всплытия модального окна")
    public void restartAd(){
        restart.click();
    }
}
