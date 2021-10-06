package com.herokuapp.the_internet.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.broken_image.BrokenImagesPO;
import com.herokuapp.the_internet.core.utils.FilterCorrectImages;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class BrokenImagesTest {

    @Test
    @Description("Broken Images")
    public void brokenImagesTest() {

        BrokenImagesPO pageObject = open(BrokenImagesPO.URL, BrokenImagesPO.class);

        ElementsCollection images = pageObject.getAllImage();

        Assertions.assertEquals(3, images.size());

        List<SelenideElement> correctImages = FilterCorrectImages.getCorrectImage(images);

        Assertions.assertEquals(1, correctImages.size());

    }
}
