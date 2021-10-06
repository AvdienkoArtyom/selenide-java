package com.herokuapp.the_internet.core.model.dynamic_content;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DynamicContentPO extends BasePageObject {
    public static final String URL = baseURL + "/dynamic_content";
    private final ElementsCollection contents =
            $$(By.cssSelector(".example .row #content .row"));
    private final SelenideElement refresh = $(By.linkText("click here"));


    @Step("Получаем коллекцию контентов на странице")
    public List<ContentRow> getRowContent() {
        List<ContentRow> dataList = new ArrayList<>();
        contents.forEach(element -> dataList.add(new ContentRow(getImageSrc(element), getTextFromContent(element))));
        return dataList;
    }

    @Step("Обновляем контент на странице")
    public void refreshContent() {
        refresh.click();
    }

    private String getImageSrc(SelenideElement element) {
        return element.$(By.cssSelector(".large-2.columns img")).getAttribute("src");
    }

    private String getTextFromContent(SelenideElement element) {
        return element.$(By.cssSelector(".large-10.columns")).getText();
    }
}
