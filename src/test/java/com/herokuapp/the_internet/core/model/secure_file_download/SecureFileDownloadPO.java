package com.herokuapp.the_internet.core.model.secure_file_download;

import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.switchTo;

public class SecureFileDownloadPO extends BasePageObject {
    public static final String URL = baseURL + "/download_secure";

    @Step("Логинимся на сайте")
    public void login(){
        switchTo().defaultContent().navigate().to("http://admin:admin@the-internet.herokuapp.com/download_secure");
    }
}
