package com.herokuapp.the_internet.core.model.challenging_dom;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ChallengingDOMPO extends BasePageObject {
    public static final String URL = "https://the-internet.herokuapp.com/challenging_dom";
    private final SelenideElement button1 = $(By.cssSelector(".large-2.columns .button"));
    private final SelenideElement button2 = $(By.cssSelector(".large-2.columns .button.alert"));
    private final SelenideElement button3 = $(By.cssSelector(".large-2.columns .button.success"));
    private final ElementsCollection rowCollection =
            $$(By.cssSelector("table tbody tr"));

    public SelenideElement getFirstButton(){
       return button1;
    }

    public SelenideElement getSecondButton(){
        return button2;
    }

    public SelenideElement getThirdButton(){
        return button3;
    }

    @Step("Получаем колекцию кнопок на странице")
    public List<SelenideElement> getAllButtons(){
        return Arrays.asList(
                getFirstButton(),
                getSecondButton(),
                getThirdButton()
        );
    }

    @Step("Получаем колекцию строк в таблице на странице")
    public ElementsCollection getRowsAndHeader(){
        return rowCollection;
    }

    @Step("Получаем колекцию ячеек в строке: {number} в таблице на странице")
    public ElementsCollection getCellsInByRowNumber(int number){
        return getRowsAndHeader().get(number).$$(By.cssSelector("td"));
    }
}
