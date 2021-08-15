package com.herokuapp.the_internet.test;

import com.herokuapp.the_internet.core.model.notification_messages.NotificationMessagesData;
import com.herokuapp.the_internet.core.model.notification_messages.NotificationMessagesPO;
import com.herokuapp.the_internet.core.validation.Validation;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class NotificationMessagesTest {

    @Test
    @Description("Notification Message")
    public void notificationMessagesTest(){
        NotificationMessagesPO pageObject = open(NotificationMessagesPO.URL,
                NotificationMessagesPO.class);

      Validation.checkMessage(pageObject, NotificationMessagesData.SUCCESSFUL);
      Validation.checkMessage(pageObject, NotificationMessagesData.UNSUCCESSFUL);
    }
}
