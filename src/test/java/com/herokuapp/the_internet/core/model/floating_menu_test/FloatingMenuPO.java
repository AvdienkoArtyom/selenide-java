package com.herokuapp.the_internet.core.model.floating_menu_test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FloatingMenuPO extends BasePageObject {
    public static final String URL = "https://the-internet.herokuapp.com/floating_menu#home";
    public static final String TEXT_BOTTOM_ELEMENT = "Elemental Selenium";
    private final SelenideElement firstParagraph =
            $(By.cssSelector(".example .row scroll.large-10.columns.large-centered p"));
    private final ElementsCollection floatMenu =
            $$(By.cssSelector("#menu li"));

    @Override
    @Step("Получаем первый абзац или описание страницы")
    @Attachment("Абзац или описание")
    public String getFirstParagraph() {
        return firstParagraph.getText();
    }

    @Step("Получаем элементы плавающего меню на странице")
    public ElementsCollection getMenuElement(){
        return floatMenu;
      }

    @Step("Прокручиваем страницу до текста")
    public void scrollByText(String textElement){
        $(By.linkText(textElement)).scrollIntoView(true);
    }
}
