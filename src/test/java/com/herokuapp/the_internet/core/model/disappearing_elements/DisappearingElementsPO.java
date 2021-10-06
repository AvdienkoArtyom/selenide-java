package com.herokuapp.the_internet.core.model.disappearing_elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DisappearingElementsPO extends BasePageObject {
    public static final String URL = baseURL + "/disappearing_elements";
    private final ElementsCollection buttons = $$(By.cssSelector(".example ul li a"));
        private final SelenideElement title = $(".example h3");
    private final SelenideElement firstParagraph =
            $(By.cssSelector(".example p"));

    @Step("Получаем список кнопок меню")
    public ElementsCollection getButtons() {
        return buttons;
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
