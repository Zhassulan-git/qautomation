package org.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class CheckPreviews extends CondutTests{

    private static final String QA_TENANT_URL = "https://angular.realworld.io/";
    private static final Integer COUNT_PREVIEWS= 12;

    @Test
    public void searchPreviews(){
//		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver/chromedriver");

        open(QA_TENANT_URL);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Boolean checkSecondPageExist = false;
        ElementsCollection previews = $$(".preview-link");
        if (previews.size() < COUNT_PREVIEWS){
            ElementsCollection pages = $$(".page-link");
            for(int i=0; i< pages.size();i++){
                if (pages.get(i).getText().equals("2")){
                    pages.get(i).click();
                    checkSecondPageExist = true;
                    break;
                }
            }
        }
        if(!checkSecondPageExist){
            System.out.println("Page is not exist");
            return;
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        ElementsCollection previews_next = $$(".preview-link");
        if((previews_next.size()+ previews.size())>COUNT_PREVIEWS){
            System.out.println("This website have more than 12 previews");
        }

    }
}
