package com.herokuapp.the_internet.core.validation;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.BasePageObject;
import com.herokuapp.the_internet.core.model.disappearing_elements.DisappearingElementsPO;
import com.herokuapp.the_internet.core.model.dropdown_test.Option;
import com.herokuapp.the_internet.core.model.notification_messages.NotificationMessagesPO;
import com.herokuapp.the_internet.core.utils.ComparingTwoFiles;
import com.herokuapp.the_internet.core.utils.SingleCollector;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;

public class Validation {

    @Step("Проверяем есть ли в {pageObject} один из ожидаемых заголовков {expendedText}")
    public static String checkingOptionsForExpectedHeaders(BasePageObject pageObject,
                                                   String... expendedText) {
       return Arrays.stream(expendedText)
                .filter(pageObject.getTitle()::equals)
                .collect(SingleCollector.toSingleton("Должен быть только один элемент"));
    }

    @Step("Проверяем текст первого параграфа")
    public static void checkingTextFirstParagraph(BasePageObject pageObject, String expectedText) {
        String actualText = pageObject.getFirstParagraph();
        Assertions.assertEquals(expectedText, actualText);
    }

    @Step("Проверяем допустимые названия кнопок {buttonNames}")
    public static void checkNameButton(List<String> buttonNames, List<SelenideElement> buttons){
        buttons.forEach(selenideElement -> {
            selenideElement.click();
            buttons.forEach(
                    element -> {
                        String textButton = element.getText();
                        Assertions.assertTrue(buttonNames.contains(textButton));
                    });
        });
    }

    @Step("Проверяем текст алерта")
    public static void checkAlert(Alert alert, String textAlert){
        Assertions.assertNotNull(alert);
        Assertions.assertEquals(textAlert, alert.getText());
    }

    @Step("Проверка будет ли на странице отображаться {count} элементов меню при несольких " +
            "обновлений страницы")
    public static void checkMutationCountButton(DisappearingElementsPO pageObject, int count){
        ElementsCollection elements = pageObject.getButtons();

        for (int i = 0; i<10; i++){
            if (elements.size()==count){
                break;
            }
            refresh();
            elements = pageObject.getButtons();
        }

        Assertions.assertEquals(elements.size(), count);
    }

    @Step("Проверка текста")
    public static void checkText(String actualText, String expectedText){
        Assertions.assertEquals(expectedText, actualText);
    }

    @Step("Проверка текста елемента")
    public static void checkTextElement(SelenideElement element, String expectedText){
        Assertions.assertEquals(expectedText, element.getText());
    }

    @Step("Проверка текста елемента")
    public static void checkTextElement(SelenideElement element, Option option){
        Assertions.assertEquals(option.getText(), element.getText());
    }

    @Step("Проверка видимости елементов")
    public static void checkVisibleElements(ElementsCollection elements, int countElement){
        Assertions.assertEquals(elements.size(), countElement);
        elements.forEach(element -> element.shouldBe(Condition.visible));
    }

    @Step("Проверка наличия елемента")
    public static void checkExistElement(SelenideElement element){
       element.shouldBe(Condition.exist);
    }

    @Step("Проверка отсутствия елемента")
    public static void checkNotExistElement(SelenideElement element){
        Assertions.assertFalse(element.is(Condition.exist));
    }

    @Step("Проверка отсутствия елемента")
    public static void checkHiddenElement(SelenideElement element){
        element.shouldBe(Condition.hidden);
    }

    @Step("Проверка видимости елемента")
    public static void checkVisibleElement(SelenideElement element){
        element.shouldBe(Condition.visible);
    }

    @Step("Проверка скрытия елемента в течении 10 секунд")
    public static void checkElementShouldBeHiddenInDuringTime(SelenideElement element){
        int tryCount = 0;
        while (!element.is(Condition.hidden)){
            sleep(1000);
            if (++tryCount>10){
                throw new RuntimeException("Елемент должен пропасть с экрана");
            }
        }
    }

    @Step("Сравнение скачаного файла")
    public static void checkTwoFile(Path expected, Path actual) {
        if (!ComparingTwoFiles.comparing(expected, actual)){
            Allure.addAttachment("Файлы не равны",
                    String.format("Имя эталонного файла %s, Имя скачанного %s",
                            expected.getFileName(), actual.getFileName()));
           throw new RuntimeException("Файлы не равны");
        }
    }

    @Step("Проверку отображение ссылки")
    public static void isDisplayed(WebElement element){
        Assertions.assertTrue(element.isDisplayed());
    }

    @Step("Проверку что ссылка не отображается ")
    public static void isNotDisplayed(WebElement element){
        Assertions.assertFalse(element.isDisplayed());
    }

    @Step("Проверяем всплывающие сообшения при 10 попытках")
    public static void checkMessage(NotificationMessagesPO po, String expectedMessage){
        int count = 0;
        while (count<11){
            po.loadNewMessage();
            count++;
            if (po.getTextMessage().equals(expectedMessage)){
                break;
            }
        }

        if (count>10){
            throw new RuntimeException(String.format("Сообщение %s не появилось.",
                    expectedMessage));
        }
    }
}
