package com.herokuapp.the_internet.core.utils;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class FilterCorrectImages {

    @Step("Проверяем и фильтруем изображения которые загрузились и корректно отображаются")
    public static List<SelenideElement> getCorrectImage(ElementsCollection images) {
        Allure.addAttachment("Общее количество изображений", String.valueOf(images.size()));
        List<SelenideElement> correctImages = filter(images);
        Allure.addAttachment("Изображения которые загрузились и корректно отображаются",
                String.valueOf(correctImages.size()));
        return correctImages;
    }

    private static List<SelenideElement> filter(ElementsCollection elements){
        return elements.stream().filter(FilterCorrectImages::isCorrect).collect(Collectors.toList());
    }

    private static boolean isCorrect(SelenideElement selenideElement) {
        return executeJavaScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", selenideElement);
    }
}
