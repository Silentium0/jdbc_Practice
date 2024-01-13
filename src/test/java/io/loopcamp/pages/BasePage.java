package io.loopcamp.pages;

import io.loopcamp.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    @FindBy(xpath = "//div[@class='v-list-item__title']//span")
     List<WebElement> allModules;
    @FindBy(xpath = "//div[@class=\"v-data-footer__pagination\"]")
    public WebElement totalResultCount;

    public void navigateModule(String moduleName){
        for (WebElement each : allModules){
            if (each.getText().equals(moduleName)){
                each.click();
            }
        }
    }

    public int getResultCount(){
        String expectedCount = totalResultCount.getText().substring(totalResultCount.getText().lastIndexOf(" ")+1);
        return Integer.parseInt(expectedCount);
    }
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }


}
