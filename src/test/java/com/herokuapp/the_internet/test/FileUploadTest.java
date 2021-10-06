package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.file_upload.FileUploadData;
import com.herokuapp.the_internet.core.model.file_upload.FileUploadPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class FileUploadTest {

    @Test
    @Description("File Uploader")
    public void fileUploadTest(){
        FileUploadPO pageObject = open(FileUploadPO.URL, FileUploadPO.class);

        Validation.checkText(pageObject.getTitle(), FileUploadData.TITLE_BEFORE_DOWNLOAD);

        pageObject.chooseFileToDownload(FileUploadData.FILE_TO__UPLOAD);

        pageObject.upLoadButton();

        Validation.checkText(pageObject.getTitle(), FileUploadData.TITLE_AFTER_DOWNLOAD);

    }
}
