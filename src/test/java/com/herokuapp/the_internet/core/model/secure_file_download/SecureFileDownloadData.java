package com.herokuapp.the_internet.core.model.secure_file_download;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SecureFileDownloadData {
    public static final Path FILE_PATH_TO_SAVE =
            Paths.get(System.getProperty("user.dir")
                    , "src"
                    , "test"
                    , "resources"
                    , "actual_result_secure_file_download"
                    , "sample.png");
    public static final Path EXPECTED_FILE_PATH =
            Paths.get(System.getProperty("user.dir")
                    , "src"
                    , "test"
                    , "resources"
                    , "expected_result_secure_file_download"
                    , "sample.png");
    public static final String URL_TO_DOWNLOAD = "https://the-internet.herokuapp.com/download_secure/sample.png";
}
