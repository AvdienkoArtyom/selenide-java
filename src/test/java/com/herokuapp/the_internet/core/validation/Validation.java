package com.herokuapp.the_internet.core.validation;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.herokuapp.the_internet.core.model.abtesting.ABTestingPO;
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
    public static String checkingOptionsForExpectedHeaders(ABTestingPO pageObject,
                                                           String... expectedText) {
        return Arrays.stream(expectedText)
                .filter(pageObject.getTitle()::equals)
                .collect(SingleCollector.toSingleElement("Должен быть только один элемент"));
    }

    @Step("Проверяем допустимые названия кнопок {buttonNames}")
    public static void checkNameButton(List<String> buttonNames, List<SelenideElement> buttons) {
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
    public static void checkAlert(Alert alert, String textAlert) {
        Assertions.assertNotNull(alert);
        Assertions.assertEquals(textAlert, alert.getText());
    }

    @Step("Проверяем будет ли на странице отображаться {count} элементов меню при несольких " +
            "обновлений страницы")
    public static void checkMutationCountButton(DisappearingElementsPO pageObject, int count) {
        ElementsCollection elements = pageObject.getButtons();

        for (int i = 0; i < 10; i++) {
            if (elements.size() == count) {
                break;
            }
            refresh();
            elements = pageObject.getButtons();
        }

        Assertions.assertEquals(elements.size(), count);
    }

    @Step("Проверяем текст")
    public static void checkText(String actualText, String expectedText) {
        Assertions.assertEquals(expectedText, actualText);
    }

    @Step("Проверяем текст элемента")
    public static void checkTextElement(SelenideElement element, String expectedText) {
        Assertions.assertEquals(expectedText, element.getText());
    }

    @Step("Проверяем текст элемента")
    public static void checkTextElement(SelenideElement element, Option option) {
        checkTextElement(element, option.getText());
    }

    @Step("Проверяем видимость и количество элементов")
    public static void checkVisibleElements(ElementsCollection elements, int countElement) {
        Assertions.assertEquals(elements.size(), countElement);
        elements.forEach(element -> element.shouldBe(Condition.visible));
    }

    @Step("Проверяем наличие элемента")
    public static void checkExistElement(SelenideElement element) {
        element.shouldBe(Condition.exist);
    }

    @Step("Проверяем отсутствие элемента")
    public static void checkNotExistElement(SelenideElement element) {
        Assertions.assertFalse(element.is(Condition.exist));
    }

    @Step("Проверяем отсутствие элемента")
    public static void checkHiddenElement(SelenideElement element) {
        element.shouldBe(Condition.hidden);
    }

    @Step("Проверяем видимость элемента")
    public static void checkVisibleElement(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    @Step("Проверка скрытия элемента в течении 10 секунд")
    public static void checkElementShouldBeHiddenInDuringTime(SelenideElement element) {
        int tryCount = 0;
        while (!element.is(Condition.hidden)) {
            sleep(1000);
            if (++tryCount > 10) {
                throw new RuntimeException("Элемент должен пропасть с экрана");
            }
        }
    }

    @Step("Сравнение скачаного файла")
    public static void checkTwoFile(Path expected, Path actual) {
        ComparingTwoFiles.comparing(expected, actual);
    }

    @Step("Проверку отображение ссылки")
    public static void isDisplayed(WebElement element) {
        Assertions.assertTrue(element.isDisplayed());
    }

    @Step("Проверку что ссылка не отображается ")
    public static void isNotDisplayed(WebElement element) {
        Assertions.assertFalse(element.isDisplayed());
    }

    @Step("Проверяем всплывающие сообшения при 10 попытках")
    public static void checkMessage(NotificationMessagesPO po, String expectedMessage) {
        int count = 0;
        while (count < 11) {
            po.loadNewMessage();
            count++;
            if (po.getTextMessage().equals(expectedMessage)) {
                break;
            }
        }

        if (count > 10) {
            throw new RuntimeException(String.format("Сообщение %s не появилось.",
                    expectedMessage));
        }
    }
}
