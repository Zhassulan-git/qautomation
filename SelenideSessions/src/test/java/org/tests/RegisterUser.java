package org.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import java.util.HashMap;
import java.util.Set;
import java.util.*;



import org.openqa.selenium.By;

public class RegisterUser extends CondutTests{
    private static final String Register_link = "https://angular.realworld.io/";

    HashMap<String, String> map = new HashMap<String, String>();

    Set<String> keys = map.keySet();
    @Test
    public void Register(){
        open(Register_link);

        $(By.xpath("//*[@routerlink='/register']")).shouldBe(visible).click();

        // Putting key-value pairs
        map.put("username", "");
        map.put("email", "");
        map.put("password", "");

        for(String key : keys){
            fillField(key,map.get(key));
        }
        //see what to do
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SelenideElement submitButton = $(By.xpath("//*[@type='submit']"));
        System.out.println(submitButton.getAttribute("class"));
        submitButton.click();


    }
}
