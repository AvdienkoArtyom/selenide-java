package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.frames.FramesData;
import com.herokuapp.the_internet.core.model.frames.FramesPO;
import com.herokuapp.the_internet.core.model.frames.iframe.IFramePO;
import com.herokuapp.the_internet.core.model.frames.nested_frame.NestedFramePO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FramesTest {

    @Test
    @Description("Frames")
    public void framesTest() {

        FramesPO pageObject = open(FramesPO.URL, FramesPO.class);

        NestedFramePO nestedFramePO = pageObject.goToNestedFrame();

        nestedFramePO.goToFrameLeft();
        Validation.checkText(nestedFramePO.getText(), "LEFT");
        nestedFramePO.exitTheFrame();

        nestedFramePO.goToFrameMiddle();
        Validation.checkText(nestedFramePO.getText(), "MIDDLE");
        nestedFramePO.exitTheFrame();

        nestedFramePO.goToFrameRight();
        Validation.checkText(nestedFramePO.getText(), "RIGHT");
        nestedFramePO.exitTheFrame();

        nestedFramePO.goToFrameBottom();
        Validation.checkText(nestedFramePO.getText(), "BOTTOM");

        back();

        IFramePO iFramePO = pageObject.goToIFrame();

        Validation.checkText(iFramePO.getTextFromTextArea(), FramesData.DEFAULT_TEXT_FOR_TEXTAREA);

        iFramePO.getFileMenu()
                .newDocument();

        iFramePO.setTextToTextAria(FramesData.NEW_TEXT_FOR_TEXTAREA);

        Validation.checkText(iFramePO.getTextFromTextArea(), FramesData.NEW_TEXT_FOR_TEXTAREA);

        iFramePO.getFormat()
                .getAlign()
                .setJustify();

        Assertions.assertTrue(iFramePO.getJustifyButton().isActiv());
    }
}
