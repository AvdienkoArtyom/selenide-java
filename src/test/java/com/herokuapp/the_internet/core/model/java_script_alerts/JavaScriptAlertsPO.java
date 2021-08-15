package com.herokuapp.the_internet.core.model.java_script_alerts;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.*;

public class JavaScriptAlertsPO {

    public static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";
    private ElementsCollection buttons =  $$(By.cssSelector(".example ul li"));
    private SelenideElement result = $(By.id("result"));

    @Step("Кликнуть на кнопку  JS Alert")
    public void clickJsAlert(){
        buttons.get(0).findElement(By.cssSelector("button")).click();
    }

    @Step("Кликнуть на кнопку  JS Confirm")
    public void clickJsConfirm(){
        buttons.get(1).findElement(By.cssSelector("button")).click();
    }

    @Step("Кликнуть на кнопку  JS Prompt")
    public void clickJsPrompt(){
        buttons.get(2).findElement(By.cssSelector("button")).click();
    }

    @Step("Соглашаемся (OK)")
    public void accept(){
        switchTo().alert().accept();
    }

    @Step("Отклоняем, (отмена)")
    public void dismiss(){
        switchTo().alert().dismiss();
    }

    @Step("Вводим текст")
    public void sPrompt(String text){
        prompt(text);
    }

    @Step("Получаем результат")
    public String getResult(){
        return result.getText();
    }
}
