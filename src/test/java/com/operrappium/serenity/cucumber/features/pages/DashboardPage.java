package com.operrappium.serenity.cucumber.features.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    @AndroidFindBy(className = "//text()='Password'")
    @FindBy(id = "com.operr.operrprovider.us.dev:id/tv_total_earnings_activity")
    private WebElement total_earnings_activity;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/tv_from_trip")
    private WebElement from_trip_add;
    @FindBy(xpath = "//android.widget.LinearLayout[@index='0']")
    private WebElement trip_detail;

    public boolean verifyThatDriverEarningIsShowing() throws InterruptedException {
        Thread.sleep(1999);
        String xpath = "//android.widget.FrameLayout[@index='1']//android.widget.TextView[@index='0']";
        String str = getDriver().findElement(By.xpath(xpath)).getText();
        System.out.println("total_earnings_activity " + str);
        return waitForElement(getDriver().findElement(By.xpath(xpath)), 20).isDisplayed();
    }

    public boolean checkDriverCurrentZoneActivity() throws InterruptedException {
        Thread.sleep(999);
        String str = from_trip_add.getText();
        if (str != null){
            return true;
        }
        return false;
    }

    public void clickOnCurrentTrip() throws InterruptedException {
        Thread.sleep(999);
//        clickButtonUsingClassname("android.widget.ImageView", "");
        getDriver().findElement(By.xpath("//android.widget.LinearLayout[@index='0']//android.view.ViewGroup[@index='0']//android.widget.ImageView")).click();
        Thread.sleep(9999);
    }

    public boolean checkThatTripDetailShowing() throws InterruptedException {
        Thread.sleep(999);
        String str = trip_detail.getText();
        if (str != null){
            return true;
        }
        return false;
    }

    public String checkAreDisplayed(String arg0) throws Throwable {
        Thread.sleep(3999);
        String xpathExpression = "//android.widget.TextView[@index='1']";
        String str = getDriver().findElement(By.xpath(xpathExpression)).getText();
        System.out.println(str);
        return str;

    }

    public void clickBackButton() throws InterruptedException {
        Thread.sleep(999);
        clickButtonUsingClassname("android.widget.ImageButton", "");
    }


}
