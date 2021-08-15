package com.herokuapp.the_internet.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TyposTest {

   @Test
    public void typosTest(){
       open("https://the-internet.herokuapp.com");

       $(By.linkText("Typos"))
               .should(Condition.exist)
               .shouldBe(Condition.visible)
               .click();
   }
}
