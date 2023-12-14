package org.tests;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Set;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CondutTests {
	public void setUp(){
        Configuration.browser = "firefox";
    }

    @Before
    public void init(){
        setUp();
    }

    @After
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    //for create article we need to be authorized
    public void logIn(HashMap<String, String> logInfo, Set<String> keys){

        $(By.xpath("//*[@routerlink='/login']")).click();

        for(String key : keys){
            fillField(key, logInfo.get(key));
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        $(By.xpath("//*[@type='submit']")).click();

    }

    //function for fill register and login fields
    public void fillField(String formName, String value){
        //  //*[@formcontrolname='']
        String xpathExpression = "//*[@formcontrolname='"+formName+"']";

        $(By.xpath(xpathExpression)).shouldBe(visible).setValue(value);
    }
}
