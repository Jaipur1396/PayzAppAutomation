package com.operrappium.serenity.cucumber.features.pages;

import com.operrappium.serenity.cucumber.features.utils.TestDataSetup;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TripDetailsPage extends BasePage {

    @AndroidFindBy(className = "//text()='Password'")
    @FindBy(xpath = "//android.widget.RelativeLayout[@index='2']//android.widget.RelativeLayout//android.widget.TextView")
    private WebElement scheduled_tripId;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/tv_telephone")
    private WebElement telephone_num;
    @FindBy(id = "com.google.android.dialer:id/incall_end_call")
    private WebElement end_call_btn;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/tv_pickup")
    private WebElement pickup_add;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/tv_dropoff")
    private WebElement dropoff_add;
    @FindBy(id = "android:id/text1")
    private WebElement select_cancel_reason;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/trip_id_item_billing")
    private WebElement rejected_trip_id_item;

    public void clickTab(String arg0) throws Throwable {
        Thread.sleep(2999);
        clickButtonUsingClassname("android.widget.TextView", arg0);

    }


    public boolean scheduledTripsMayDisplayed() throws InterruptedException {
        Thread.sleep(1999);
        String xpathExpression = "//android.widget.TextView[@index='1']";
        String str = getDriver().findElement(By.xpath(xpathExpression)).getText();
        System.out.println(str);
        if (str.contains("0")){
            TestDataSetup.setDoNotSkipStep("N");
            return false;
        }else {
            TestDataSetup.setDoNotSkipStep("Y");
            return true;
        }

    }


    public void clickOnTrip() throws InterruptedException {
        Thread.sleep(9999);

        String str = getDriver().findElement(By.xpath("//android.widget.RelativeLayout[@index='2']//android.widget.RelativeLayout//android.widget.TextView")).getText();
        TestDataSetup.setScheduled_trip_Id(str);
        clickButtonUsingClassname("android.widget.FrameLayout", "");
        Thread.sleep(9999);

    }

    public void clickOnTelephoneNumberToCall() throws InterruptedException {
        Thread.sleep(999);
        waitForElement(telephone_num, 20).click();
        Thread.sleep(2999);
        waitForElement(end_call_btn, 20).click();
    }

    public void clickOnBackButton() throws InterruptedException {
        Thread.sleep(999);
        clickButtonUsingClassname("android.widget.ImageButton", "");
    }


    public boolean userBackToPreviousPage() throws InterruptedException {
        Thread.sleep(3999);
        String xpathExpression = "//android.widget.LinearLayout//android.widget.TextView[@text='SCHEDULED']";
        return getDriver().findElement(By.xpath(xpathExpression)).isSelected();
    }

    public void longClickOnAddress(String arg0) throws Throwable {
        Thread.sleep(4999);
        if(arg0.equals("P/U:")){
            Thread.sleep(999);
            String str = pickup_add.getText();
            TestDataSetup.setPickUp_dropOff_add(str);
            waitForElement(pickup_add, 20).click();
        }else {
            Thread.sleep(999);
            String str = pickup_add.getText();
            TestDataSetup.setPickUp_dropOff_add(str);
            waitForElement(dropoff_add, 20).click();
        }

    }


    public boolean userWillGoToMap() throws InterruptedException {
        Thread.sleep(5999);
        String xpathExpression = "//android.widget.TextView[@text='"+TestDataSetup.getPickUp_dropOff_add()+"']";
        return getDriver().findElement(By.xpath(xpathExpression)).isDisplayed();
    }

    public void clickOnMobileBackButton() throws InterruptedException {
        Thread.sleep(1999);
        getDriver().navigate().back();
    }

    public void selectACancelReason() throws InterruptedException {
        Thread.sleep(999);
        List<WebElement> elements = getDriver().findElements(By.id("android:id/text1"));
        int size = elements.size();
        System.out.println("size:" + size);
        int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
        System.out.println("randomNumber:" + randomNumber);
        elements.get(randomNumber).click();
    }

    public String verifyUserCanSeeTheREJECTEDTrip() throws InterruptedException {
        Thread.sleep(999);
        String str = getDriver().findElement(By.id("com.operr.operrprovider.us.dev:id/trip_id_item_billing")).getText();
        return str;
    }

    public String verifyUserCanSeeTheCONFIRMEDTrip() throws InterruptedException {
        Thread.sleep(999);
        String str = getDriver().findElement(By.id("com.operr.operrprovider.us.dev:id/trip_id_item_billing")).getText();
        return str;
    }




}
