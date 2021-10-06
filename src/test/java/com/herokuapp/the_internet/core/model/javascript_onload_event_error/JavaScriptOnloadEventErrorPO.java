package com.herokuapp.the_internet.core.model.javascript_onload_event_error;

import com.herokuapp.the_internet.core.model.BasePageObject;
import org.openqa.selenium.JavascriptException;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JavaScriptOnloadEventErrorPO extends BasePageObject {
    public static final String URL = baseURL + "/javascript_error";

    @Step("Получаем exception от js на странице")
    public String loadJSException(){
        String msError = "";
        try {
            executeJavaScript("loadError()");
        }catch (JavascriptException je){
            msError = je.getMessage();
        }
        return msError.substring( 0, msError.indexOf("\n"));
    }
}
