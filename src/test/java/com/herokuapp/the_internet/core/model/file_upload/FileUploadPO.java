package com.herokuapp.the_internet.core.model.file_upload;

import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.$;

public class FileUploadPO extends BasePageObject {
    public static final String URL = "https://the-internet.herokuapp.com/upload";
    private final SelenideElement fileUpload = $(By.id("file-upload"));
    private final SelenideElement upLoadButton = $(By.id("file-submit"));

    @Step("Выбираем файл для загрузки")
    public void chooseFailToDownload(File file){
        fileUpload.uploadFile(file);
        Allure.addAttachment("Имя файла", file.getName());
    }

    @Step("Нажимаем на кнопку 'UPLOAD'")
    public void upLoadButton(){
        upLoadButton.click();
    }
}
