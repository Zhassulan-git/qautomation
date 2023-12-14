package org.tests;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
}
