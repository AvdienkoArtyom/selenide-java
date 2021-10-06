package com.herokuapp.the_internet.core.model.add_remove_elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class AddRemoveElementsPO extends BasePageObject {

    public static final String URL = baseURL + "/add_remove_elements/";
    private final SelenideElement title = $(".example h3");
    private final SelenideElement addElement =
            $(By.cssSelector(".example button"));
    private final ElementsCollection collectionDeleteElement =
            $$(By.className("added-manually"));
    private final SelenideElement leftDeleteElement =
            $$(By.className("added-manually")).get(0);
    private long size = 0;

    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }

    @Step("Жмем на кнопку добавить элемент")
    public ElementsCollection addElement() {
        addElement.click();
        size++;
        Allure.addAttachment("Количество элементов: ", String.valueOf(size));
        return collectionDeleteElement;
    }

    @Step("Удаляем один левый элемент, если есть конечно)")
    public ElementsCollection deleteOneElement() {
        Allure.addAttachment("Количество элементов до удаления: ", String.valueOf(size));
        if (size > 0) {
            leftDeleteElement.click();
            size--;
        }
        Allure.addAttachment("Количество элементов после удаления: ", String.valueOf(size));
        return collectionDeleteElement;
    }

    @Step("Получаем количество элементов")
    public long getSize() {
        Allure.addAttachment("Количество элементов: ", String.valueOf(size));
        return size;
    }
}
