package com.herokuapp.the_internet.core.model.broken_image;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BrokenImagesPO extends BasePageObject {

    public static final String URL = baseURL + "/broken_images";
    private final ElementsCollection images = $$(By.cssSelector(".example img"));
    private final SelenideElement title = $(".example h3");

    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }

    @Step("Получаем колекцию изображений, которые должны быть загружанны на странице")
    public ElementsCollection getAllImage() {
        Allure.addAttachment("Общее количество изображений", String.valueOf(images.size()));
        return images;
    }
}
