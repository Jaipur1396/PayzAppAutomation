package com.operrappium.serenity.cucumber.features.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TripPage extends BasePage {
    public void clickonGivenTab(String classname, String pageName) throws InterruptedException {
        waitForLoadPage();
        Thread.sleep(1999);
        withTimeoutOf(20, TimeUnit.SECONDS).waitForPresenceOf(By.className(classname));
        int len = getDriver().findElements(By.className(classname)).size();
        int i;
        LOGGER.info("btnname " + pageName);
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className(classname)).get(i).getText();
            LOGGER.info("str : " + str);
            if (str.equals(pageName)) {
                getDriver().findElements(By.className(classname)).get(i).click();
                break;
            }
        }
        if (i == len) {
            throw new InterruptedException("Element Not Found");
        }

    }

    @FindBy(id = "com.operr.operrprovider.us.dev:id/current_trips_btn")
    private WebElement current_trips;

    public void clickOnCurrentTrips() throws InterruptedException {
        waitForLoadPage();
        Thread.sleep(1999);
        withTimeoutOf(20, TimeUnit.SECONDS).waitForPresenceOf(By.className("com.operr.operrprovider.us.dev:id/current_trips_btn"));
        current_trips.click();
        Thread.sleep(4999);
    }

    public void progressbarisDisplayed() throws InterruptedException {
        try {
            withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.className("android.widget.ProgressBar"));
        }catch (Exception e){

        }
    }
}
