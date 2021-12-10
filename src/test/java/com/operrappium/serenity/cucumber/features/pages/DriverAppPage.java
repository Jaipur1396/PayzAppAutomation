package com.operrappium.serenity.cucumber.features.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DriverAppPage extends BasePage {

    @AndroidFindBy(className = "//text()='Password'")
    @FindBy(id = "com.operr.operrprovider.us.dev:id/checkbox")
    private WebElement check_box;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/logo_text")
    private WebElement logo_text;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/logo")
    private WebElement logo;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/btn_login_login_activity")
    private WebElement driverLogin_btn;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/remember_me")
    private WebElement remember_me;

    public boolean checkIsDisplayed(String arg0) throws Throwable {
        Thread.sleep(9999);
        return waitForElement(logo, 40).isDisplayed();

    }

    public String checkTheIsDisplayed(String arg0) throws Throwable {
        Thread.sleep(1999);
        return waitForElement(logo_text, 20).getText();
    }


    public String checkInputFieldIsDisplayed(String arg0) throws Throwable {
        Thread.sleep(1999);
        String xpathExpression = "//android.widget.EditText[@text='"+arg0+"']";
        String str = getDriver().findElement(By.xpath(xpathExpression)).getText();
        return str;

    }


    public String checkCheckboxIsDisplayed(String arg0) throws Throwable {
        Thread.sleep(999);
        String str;
        return str = waitForElement(remember_me, 20).getText();
    }


    public boolean checkButtonIsDisplayedAndClickable(String arg0) throws Throwable {
        Thread.sleep(999);
        clickButtonUsingClassname("android.widget.Button", "Driver Login");
        Thread.sleep(1999);
        for(int i=0; i<5; i++){
            clickButtonUsingClassname("android.widget.Button", "ALLOW");
            Thread.sleep(999);
        }

        return waitForElement(driverLogin_btn, 20).isDisplayed();
    }


    public String checkLinkIsDisplayed(String arg0) throws Throwable {
        Thread.sleep(999);
        String xpathExpression = "//android.widget.TextView[@text='"+arg0+"']";
        String str = getDriver().findElement(By.xpath(xpathExpression)).getText();
        System.out.println(str);
        return str;
    }

    public void clickLink(String arg0) throws Throwable {
        Thread.sleep(999);
        clickButtonUsingClassname("android.widget.TextView", arg0);
    }

    public void clickOnButton(String arg0) throws Throwable {
        Thread.sleep(999);
        clickButtonUsingClassname("android.widget.Button", arg0);
    }


    public String messageIsDisplayed(String arg0) throws Throwable {
//        Thread.sleep(999);
        WebElement toastView = getDriver().findElement(By.xpath("//android.widget.Toast[1]"));
        String text = toastView.getAttribute("name");
        System.out.println(text);
        return text;
    }


    public void enterTheEmail(String email) throws Throwable {
        Thread.sleep(1999);
        getDriver().findElement(By.className("android.widget.EditText")).sendKeys(email);
    }

    public void clickButton(String arg0) throws Throwable {
        Thread.sleep(999);
        clickButtonUsingClassname("android.widget.Button", arg0);
    }



}
