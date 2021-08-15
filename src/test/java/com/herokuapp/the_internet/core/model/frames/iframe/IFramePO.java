package com.herokuapp.the_internet.core.model.frames.iframe;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.frames.iframe.file.FileMenu;
import com.herokuapp.the_internet.core.model.frames.iframe.format.FormatMenu;
import com.herokuapp.the_internet.core.model.frames.iframe.menu_bar.JustifyButton;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.switchTo;

public class IFramePO {

    private final SelenideElement file = $$(By.cssSelector(".tox-menubar .tox-mbtn" +
            ".tox-mbtn--select")).get(0);
    private final SelenideElement format = $$(By.cssSelector(".tox-menubar .tox-mbtn" +
            ".tox-mbtn--select")).get(3);

    @Step("Получаем текст из текстовой области")
    public String getTextFromTextArea(){
        String text = switchTo().frame("mce_0_ifr").findElement(By.id("tinymce")).getText();
        switchTo().defaultContent();
        return text;
    }

    @Step("Заходим в меню File")
    public FileMenu getFileMenu(){
        file.click();
        return new FileMenu();
    }

    @Step("Вставляем текст в текстовую область")
    public void setTextToTextAria(String text){
        switchTo().frame("mce_0_ifr").findElement(By.cssSelector("#tinymce p")).sendKeys(text);
        switchTo().defaultContent();
    }

    @Step("Переходим в меню Format")
    public FormatMenu getFormat(){
        format.click();
        return new FormatMenu();
    }

    @Step("Получаем елемент меню-бара 'Justify'")
    public JustifyButton getJustifyButton(){
        return new JustifyButton();
    }
}
