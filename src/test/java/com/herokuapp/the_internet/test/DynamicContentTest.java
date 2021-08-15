package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.dynamic_content.ContentRow;
import com.herokuapp.the_internet.core.model.dynamic_content.DynamicContentPO;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class DynamicContentTest {

    @Test
    @Description("Dynamic Content")
    public void dynamicContentTest() {

        DynamicContentPO pegaObject = open(DynamicContentPO.URL, DynamicContentPO.class);

        List<ContentRow> firstData = pegaObject.getRowContent();

        List<ContentRow> newDataBeforeRefresh = pegaObject.getRowContent();

        Assertions.assertTrue(firstData.containsAll(newDataBeforeRefresh));

        pegaObject.refreshContent();

        List<ContentRow> newDataAfterRefresh = pegaObject.getRowContent();

        Assertions.assertFalse(firstData.containsAll(newDataAfterRefresh));
    }
}
