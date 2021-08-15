package com.herokuapp.the_internet.core.model.file_upload;

import java.io.File;

public class FileUploadData {
    public static final String TITLE_BEFORE_DOWNLOAD = "File Uploader";
    public static final String TITLE_AFTER_DOWNLOAD = "File Uploaded!";

    public static final File FILE_TO__UPLOAD =
            new File(System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "test"
                    + File.separator + "resources"
                    + File.separator + "expected_result_download_file"
                    + File.separator + "sample.png");
}
