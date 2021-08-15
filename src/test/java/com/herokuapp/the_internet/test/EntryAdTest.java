package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.entry_ad.EntryAdPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;

public class EntryAdTest {

    @Test
    @Description("Entry Ad")
    public void entryAdTest(){

        EntryAdPO pageObject = open(EntryAdPO.URL, EntryAdPO.class);

        Validation.checkVisibleElement(pageObject.getModalWindow());

        refresh();

        Validation.checkVisibleElement(pageObject.getModalWindow());

        pageObject.closeModalWindow();

        Validation.checkHiddenElement(pageObject.getModalWindow());

        refresh();

        Validation.checkHiddenElement(pageObject.getModalWindow());

        pageObject.restartAd();

        refresh();

        Validation.checkVisibleElement(pageObject.getModalWindow());
    }
}
