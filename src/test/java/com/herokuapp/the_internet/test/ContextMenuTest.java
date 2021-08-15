package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.context_menu.ContextMenuData;
import com.herokuapp.the_internet.core.model.context_menu.ContextMenuPO;
import com.herokuapp.the_internet.core.validation.Validation;
import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.*;

public class ContextMenuTest {

    @Test
    @Description("Context Menu")
    public void contextMenu() {

        ContextMenuPO contextMenuPO = open(ContextMenuPO.URL, ContextMenuPO.class);

        contextMenuPO.getContextMenuAria();

        Alert alert = contextMenuPO.getAlert();

        Validation.checkAlert(alert, ContextMenuData.TEXT_ALERT);

        alert.accept();

        // Вызываем закрытия окна так как попап мышки весит на других тестах
        closeWindow();
    }
}
