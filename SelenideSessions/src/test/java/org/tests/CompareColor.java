package org.tests;

import org.junit.Test;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CompareColor extends CondutTests{
    private static final String QA_TENANT_URL = "https://angular.realworld.io/";
    HashMap<String, String> map = new HashMap<String, String>();

    private static final String exit_color = "rgb(184, 92, 92)";

    @Test
    public void CheckColor(){
        open(QA_TENANT_URL);
        //putting key-value for authorization
        map.put("email", "volk@gmail.com");
        map.put("password", "qf4fo87&");

        Set<String> keys = map.keySet();

        logIn(map, keys);

        //open settings
        $(By.xpath("//*[@routerlink='/settings']")).click();

        String color = $(".btn-outline-danger").getCssValue("color");
        System.out.println(color);
        if(color.equals(exit_color)){
            System.out.println("Button with text “Or click here to logout” has a color fill '#b85c5c' or rgb(184, 92, 92)");
        }


    }

}
