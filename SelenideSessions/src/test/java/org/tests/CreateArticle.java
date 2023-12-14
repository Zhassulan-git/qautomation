package org.tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Set;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CreateArticle extends CondutTests{
    private static final String QA_TENANT_URL = "https://angular.realworld.io/";

    String[] articleNew = {"Exploring Angular Lazy Loading",
            "Learn how to optimize your Angular applications by implementing lazy loading. Dive into the details of lazy loading modules, routes, and components to enhance performance and improve user experience.",
            "Angular applications can benefit significantly from lazy loading, a technique that defers the loading of certain modules or components until they are actually needed. This optimization strategy contributes to faster initial page loads and reduces the overall application bundle size.\n" +
                    "\tWhat is Lazy Loading in Angular?\n" +
                    "\tLazy loading is a design pattern that enables loading parts of an application on-demand, rather than upfront. In Angular, this is achieved by dividing the application into feature modules and loading them only when necessary. This can lead to a better user experience by minimizing the initial load time and decreasing the amount of data transferred over the network.",
            "Lazy Loading, Performance Optimization, Angular Modules, Angular Routes, Angular Components"};

    HashMap<String, String> map = new HashMap<String, String>();

    @Test
    public void CreateArt(){
        open(QA_TENANT_URL);
        //putting key-value for authorization
        map.put("email", "volk@gmail.com");
        map.put("password", "qf4fo87&");

        Set<String> keys = map.keySet();

        logIn(map, keys);

        //putting key-value for creating new article

        $(By.xpath("//*[@routerlink='/editor']")).click();

        //write to fields
        $(By.xpath("//*[@formcontrolname='title']")).setValue(articleNew[0]);
        $(By.xpath("//*[@formcontrolname='description']")).setValue(articleNew[1]);
        $(By.xpath("//*[@formcontrolname='body']")).setValue(articleNew[2]);
        $(By.xpath("//*[@placeholder='Enter tags']")).setValue(articleNew[3]);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        $(By.xpath("//*[@type='button']")).click();

        $(By.xpath("//*[@routerlink='/']")).click();

        ElementsCollection links_in_home = $$(".nav-link");
        for(SelenideElement e: links_in_home){
            if(e.getText().equals("Global Feed")){
                e.click();
            }
        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SelenideElement our_preview_title = $("a.preview-link h1");

        if(our_preview_title.getText() == articleNew[0]){
            System.out.println("Our article was posted");
        }

    }

}
