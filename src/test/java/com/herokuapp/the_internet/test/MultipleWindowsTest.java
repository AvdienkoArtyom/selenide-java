package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.multiple_windows.MultipleWindowData;
import com.herokuapp.the_internet.core.model.multiple_windows.MultipleWindowsPO;
import com.herokuapp.the_internet.core.model.multiple_windows.NewWindow;
import com.herokuapp.the_internet.core.validation.Validation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MultipleWindowsTest {

    @Test
    public void multipleWindowsTest(){

        MultipleWindowsPO pageObject = open(MultipleWindowsPO.URL, MultipleWindowsPO.class);

        Validation.checkText(pageObject.getTitle(), MultipleWindowData.TITLE_THE_INTERNET);

        pageObject.openNewMultipleWindow();

        NewWindow newWindowObject = pageObject.switchToNewWindow();

        Validation.checkText(newWindowObject.getTitle(), MultipleWindowData.TITLE_NEW_WINDOW);

        newWindowObject.switchToTheInternet();

        Validation.checkText(pageObject.getTitle(), MultipleWindowData.TITLE_THE_INTERNET);
    }
}
