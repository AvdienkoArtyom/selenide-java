package com.herokuapp.the_internet.core.model.file_downloader;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class FileDownloaderPO extends BasePageObject {
    public static final String URL = baseURL + "/download";
    private final SelenideElement title = $(".example h3");

    @Step("Получаем Заголовок страницы")
    @Attachment("Заголовок:")
    public String getTitle() {
        return title.getText();
    }
}
