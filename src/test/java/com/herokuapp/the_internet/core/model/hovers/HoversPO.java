package com.herokuapp.the_internet.core.model.hovers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HoversPO extends BasePageObject {
    public static final String URL = baseURL + "/hovers";
    private final ElementsCollection images = $$(By.cssSelector(".example .figure"));
    private final SelenideElement title = $(".example h3");
    private final SelenideElement firstParagraph = $(By.cssSelector(".example p"));

    @Step("Получаем правое изображение")
    public SelenideElement getRightImg() {
        return images.get(0);
    }

    @Step("Получаем центральное изображение")
    public SelenideElement getCenterImg() {
        return images.get(1);
    }

    @Step("Получаем левое изображение")
    public SelenideElement getLeftImg() {
        return images.get(2);
    }

    @Step("Получаем правый элемент ссылки")
    public WebElement getRightHover() {
        return images.get(0).findElement(By.cssSelector(".figcaption"));
    }

    @Step("Получаем центральный элемент ссылки")
    public WebElement getCenterHover() {
        return images.get(1).findElement(By.cssSelector(".figcaption"));
    }

    @Step("Получаем левый элемент ссылки")
    public WebElement getLeftHover() {
        return images.get(2).findElement(By.cssSelector(".figcaption"));
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
