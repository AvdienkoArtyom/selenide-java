package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.secure_file_download.SecureFileDownloadData;
import com.herokuapp.the_internet.core.model.secure_file_download.SecureFileDownloadPO;
import com.herokuapp.the_internet.core.utils.ComparingTwoFiles;
import com.herokuapp.the_internet.core.utils.FileDownloadByUrl;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SecureFileDownloadTest {

    @Test
    @Description("Secure File Downloader")
    public void secureFileDownloadTest(){
        SecureFileDownloadPO po = open(SecureFileDownloadPO.URL, SecureFileDownloadPO.class);

        po.login();

        FileDownloadByUrl.downLoad(SecureFileDownloadData.URL_TO_DOWNLOAD, SecureFileDownloadData.FILE_PATH_TO_SAVE);

        ComparingTwoFiles.comparing(SecureFileDownloadData.EXPECTED_FILE_PATH,
                SecureFileDownloadData.FILE_PATH_TO_SAVE);
    }
}
