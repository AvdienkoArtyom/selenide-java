package com.herokuapp.the_internet.core.utils;

import io.qameta.allure.Step;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.protocol.BasicHttpContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDownLoadByUrl {

    @Step("Скачиваем файл")
    public static void downLoad( String url, Path pathToSave) {
        try {
            Files.deleteIfExists(pathToSave);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(url);
            HttpEntity entity = httpClient.execute(httpGet, new BasicHttpContext()).getEntity();
            Files.copy(entity.getContent(), pathToSave);
        }catch (IOException ioException){
         ioException.printStackTrace();
        }
    }
}
