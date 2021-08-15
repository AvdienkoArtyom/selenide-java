package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.javascript_onload_event_error.JavaScriptOnloadEventErrorData;
import com.herokuapp.the_internet.core.model.javascript_onload_event_error.JavaScriptOnloadEventErrorPO;
import com.herokuapp.the_internet.core.validation.Validation;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class JavaScriptOnloadEventErrorTest {

    @Test
    public void javaScriptOnloadEventErrorTest() {
        JavaScriptOnloadEventErrorPO pageObject = open(JavaScriptOnloadEventErrorPO.URL,
                JavaScriptOnloadEventErrorPO.class);

        Validation.checkText(pageObject.loadJSException(),
                JavaScriptOnloadEventErrorData.ERROR_MESSAGE);

    }
}
