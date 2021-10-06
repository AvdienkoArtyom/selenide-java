package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.file_downloader.FileDownloaderData;
import com.herokuapp.the_internet.core.model.file_downloader.FileDownloaderPO;
import com.herokuapp.the_internet.core.utils.FileDownloadByUrl;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static com.codeborne.selenide.Selenide.open;

public class FileDownloaderTest {

    @Test
    @Description("File Downloader")
    public void fileDownloaderTest() {
        open(FileDownloaderPO.URL, FileDownloaderPO.class);

        Path toDownload = FileDownloaderData.FILE_PATH_TO_SAVE;

        FileDownloadByUrl.downLoad(FileDownloaderData.URL_TO_DOWNLOAD, toDownload);

        Validation.checkTwoFile(FileDownloaderData.EXPECTED_FILE_PATH, toDownload);
    }
}
