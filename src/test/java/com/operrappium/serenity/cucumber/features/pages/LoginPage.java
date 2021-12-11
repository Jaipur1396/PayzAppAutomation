package com.operrappium.serenity.cucumber.features.pages;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

//    @FindBy(className = "//text()='Password'")
    @FindBy(id = "com.operr.operrprovider.us.dev:id/email_login_activity")
    private WebElement editText_email;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/password_login_activity")
    private WebElement editText_password;
    @FindBy(id = "com.operr.operrprovider.us.dev:id/skip_screen_slide")
    private WebElement skip_button;
    @FindBy(id = "com.enstage.wibmo.hdfc:id/textbutton_login")
    private WebElement login_btn;

    public boolean isEmailFieldDisplayed() throws InterruptedException {
//        Thread.sleep(9999);
//        return waitForElement(skip_button, 60).isDisplayed();
        return waitForElement(login_btn, 60).isDisplayed();
    }

    public void login(String email, String password) throws InterruptedException {
//        Thread.sleep(999);
//        skip_button.click();
        Thread.sleep(1999);
        getDriver().findElements(By.className("android.widget.EditText")).get(0).sendKeys(email);
        getDriver().findElements(By.className("android.widget.EditText")).get(1).sendKeys(password);
        clickButtonUsingClassname("android.widget.Button", "Sign in");
        Thread.sleep(1999);
//        for(int i=0; i<5; i++){
//            clickButtonUsingClassname("android.widget.Button", "ALLOW");
//            Thread.sleep(999);
//        }
//
//        clickButtonUsingClassname("android.widget.Button", "Driver Login");
        Thread.sleep(2999);
    }


    @FindBy(id = "com.bynfor.dev:id/edt_product_search")
    private WebElement home_page;

    public boolean home_page_is_displayed() throws Throwable {
        Thread.sleep(9999);
        return waitForElement(home_page, 40).isDisplayed();
    }

    public void setEmail(String email) throws InterruptedException {
        waitForElement(editText_email).sendKeys(email);
    }

    @AndroidFindBy(id = "android:id/message")
//    @iOSFindBy(xpath = "ios:id/message")
    @FindBy(xpath = "android:id/message")
    private WebElement errorMessage;

    public String getErrorMsg() throws InterruptedException {
        return waitForElement(errorMessage).getText();
    }

    @AndroidFindBy(id = "android:id/button1")
//    @iOSFindBy(xpath = "ios:id/message")
    @FindBy(xpath = "android.widget.TextView")
    private WebElement btn_ok;

    public void clickOkBtn() {
        btn_ok.click();
    }

    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement helloMessage;

    public String getHelloMsg() throws InterruptedException {
        Thread.sleep(5999);
        waitForLoadPage();
        return getText(helloMessage);
    }

    public void clickForgotPassword() throws InterruptedException {
        clickButtonUsingClassname("android.widget.TextView", "Forgot Password");
    }

    public void click_on_Skip_button() throws InterruptedException {
        Thread.sleep(999);
        skip_button.click();
    }

    public void closeApp(){
        getDriver().quit();
//        ((AppiumDriver)getDriver()).quit();
//        ((AppiumDriver) getDriver()).resetApp();
    }

    //PayzApp
    public void clickLoginButton() throws InterruptedException{
        String xpathLogin = "//*[@text=\"Login\"]";
        withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.xpath(xpathLogin));
        getDriver().findElement(By.xpath(xpathLogin)).click();
//        clickButtonUsingClassname("android.widget.TextView", "Login");
    }

    public void enterEmailOrPhoneNumber(String emailOrPhoneNumber) throws Throwable{
        Thread.sleep(1999);
        String getPhoneNumber = fetchValueFromExcelSheet(1,0);
        Thread.sleep(999);
        getDriver().findElement(By.id("com.enstage.wibmo.hdfc:id/fl_text_username")).sendKeys(getPhoneNumber+"");
        clickButtonUsingClassname("android.widget.Button", "Login");
        Thread.sleep(2999);
    }

    public void clicAllowButton() throws InterruptedException{
        clickButtonUsingClassname("android.widget.Button", "Allow");
    }

    public void enterSecurePin()throws Throwable{
        // fetch secure pin from excel
        String securePin = fetchValueFromExcelSheet(1,1);
        System.out.println("value of cell "+ securePin);
        for(int i=0; i<4;i++) {
                    clickButtonUsingClassname("android.widget.Button", securePin.charAt(i)+"");
                    Thread.sleep(500);
        }
        clickButtonUsingClassname("android.widget.Button", "Login");
        Thread.sleep(2997);
        clickButtonUsingClassname("android.widget.Button", "OK");
        Thread.sleep(1999);
        clickButtonUsingClassname("android.widget.Button","Only this time");
        Thread.sleep(999);
    }

    @AndroidFindBy(id = "com.enstage.wibmo.hdfc:id/check_personal_device")
    private WebElement this_is_my_personal_device;

    public void clickOnContinueAndSkipButton() throws Throwable{
        withTimeoutOf(5, TimeUnit.SECONDS).waitForPresenceOf(By.id("com.enstage.wibmo.hdfc:id/check_personal_device"));
        this_is_my_personal_device.click();
        Thread.sleep(999);
        String xpathSkipBtn  = "//*[@text=\"Skip\"]";
        withTimeoutOf(5, TimeUnit.SECONDS).waitForPresenceOf(By.xpath(xpathSkipBtn));
        getDriver().findElement(By.xpath(xpathSkipBtn)).click();
//        clickButtonUsingClassname("android.widget.TextView", "Skip");
//        Thread.sleep(999);
    }

    @AndroidFindBy(id = "com.enstage.wibmo.hdfc:id/main_mbOtp_edit")
    private WebElement otp_field;
    public void getDVCCodeFromApi()throws Throwable {
        String authenticationOtpString = fetchAndExtractOtpFromAPI();
        System.out.println("OTP DVC : "+ authenticationOtpString);
//        String xpthInputDVCInputField = "//*[@text=\"Input DVC\"]";
//        int xpthInputDVCInputFieldLength = getDriver().findElements(By.xpath(xpthInputDVCInputField)).size();
//        System.out.println("x path of xpthInputDVCInputFieldLength : "+ xpthInputDVCInputFieldLength);
        if(!"OTP NOT FOUND".equals(authenticationOtpString)){
            System.out.println("OTP Received :");
            SendValueUsingClassname("android.widget.EditText", "Input DVC", "" + authenticationOtpString);
            otp_field.sendKeys(authenticationOtpString + "");
            clickButtonUsingClassname("android.widget.Button", "Login");
            Thread.sleep(999);
            try{
                clickButtonUsingClassname("android.widget.Button", "Skip for Now");
            }catch (Exception e) {}
        }

    }

    // loop code
    public void enterEmailOrPhoneNumber(int rowNo) throws Throwable{
        String getPhoneNumber = fetchValueFromExcelSheet(rowNo,0);
//        Thread.sleep(999);
        getDriver().findElement(By.id("com.enstage.wibmo.hdfc:id/fl_text_username")).sendKeys(getPhoneNumber+"");
        System.out.println("Login id for the user: "+ getPhoneNumber);
//        clickButtonUsingClassname("android.widget.Button", "Login");
//        Thread.sleep(999);
        clickLoginButton();
    }

    public void enterSecurePin(int rowNumber)throws Throwable{
        // fetch secure pin from excel
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String securePin = fetchValueFromExcelSheet(rowNumber,1);
        System.out.println("value of cell "+ securePin);
        for(int i=0; i<4;i++) {
            String xpthPin = "//*[@text=\""+securePin.charAt(i)+"\"]";
            getDriver().findElement(By.xpath(xpthPin)).click();
//            clickButtonUsingClassname("android.widget.Button", securePin.charAt(i)+"");
//            Thread.sleep(500);
        }
        clickButtonUsingClassname("android.widget.Button", "Login");
//        Thread.sleep(999);

        String xpathOK = "//*[@text=\"OK\"]";
        withTimeoutOf(5, TimeUnit.SECONDS).waitForPresenceOf(By.xpath(xpathOK));
        getDriver().findElement(By.xpath(xpathOK)).click();
//        clickButtonUsingClassname("android.widget.Button", "OK");
//        Thread.sleep(999);
//        clickButtonUsingClassname("android.widget.Button","Only this time");
//        Thread.sleep(999);
        String xpathOnlyThisTime = "//*[@text=\"Only this time\"]";
        withTimeoutOf(5, TimeUnit.SECONDS).waitForPresenceOf(By.xpath(xpathOnlyThisTime));
        getDriver().findElement(By.xpath(xpathOnlyThisTime)).click();
        waitForLoadPage();
    }

    public void loopLogin()throws Throwable {
        waitForLoadPage();
        Thread.sleep(999);
        String xpathLoginButton = "//*[@text=\"Login\"]";
        int len = getDriver().findElements(By.xpath(xpathLoginButton)).size();
        if(len>0) {
            clickButtonUsingClassname("android.widget.Button", "Login");
//            Thread.sleep(2997);
            withTimeoutOf(5, TimeUnit.SECONDS).waitForPresenceOf(By.id("com.enstage.wibmo.hdfc:id/check_personal_device"));
            this_is_my_personal_device.click();
            Thread.sleep(500);
            String xpathSkipBtn = "//*[@text=\"Skip\"]";
            withTimeoutOf(5, TimeUnit.SECONDS).waitForPresenceOf(By.xpath(xpathSkipBtn));
            getDriver().findElement(By.xpath(xpathSkipBtn)).click();
//        clickButtonUsingClassname("android.widget.Button","Only this time");
//            Thread.sleep(999);
//            waitForLoadPage();
        }
    }
}
