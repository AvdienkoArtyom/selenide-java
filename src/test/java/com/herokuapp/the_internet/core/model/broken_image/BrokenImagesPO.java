package com.herokuapp.the_internet.core.model.broken_image;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import com.herokuapp.the_internet.core.utils.FilterNoBrokenImages;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class BrokenImagesPO extends BasePageObject {

    public static final String URL = "https://the-internet.herokuapp.com/broken_images";
    private final ElementsCollection images = $$(By.cssSelector(".example img"));

    @Override
    @Step("Получаем первый абзац или описание страницы")
    public String getFirstParagraph() {
        throw new RuntimeException("У данной страницы нет абзаца или описания");
    }

    @Step("Получаем колекцию изображений, которые должны быть загружанны на странице")
    public ElementsCollection getAllImage() {
        Allure.addAttachment("Общее количество изображений", String.valueOf(images.size()));
        return images;
    }
}
