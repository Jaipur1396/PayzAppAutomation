package com.operrappium.serenity.cucumber.features.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringReader;

public class BasePage extends PageObject {
    public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
    private static boolean isIOS;
    private static boolean isAndroid;
    public String filePath = "D://mobile automation code//payzapp git//testdata.xlsx";
    public String apiUrl = "http://127.0.0.1:9501/api?action=receivemessage&username=admin1&password=Admin@123&folder=inbox&limit=2&afterdownload=untouch";
    public String deleteMessageApiUrl = "http://127.0.0.1:9501/api?action=receivemessage&username=admin1&password=Admin@123&folder=inbox&limit=100&afterdownload=delete";

    public static void setAndroid(boolean android) {
        isAndroid = android;
    }

    public static boolean isAndroid() {
        return isAndroid;
    }

    public static void setIOS(boolean iOS) {
        isIOS = iOS;
    }

    public static boolean isIOS() {
        return isIOS;
    }

    //general
    public WebElement waitForElement(WebElement element) {
        return waitForElement(element, 10);
    }

    public WebElement waitForElement(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void setText(WebElement element, String value) {
        typeInto(waitForElement(element), value);
        getDriver().navigate().back();
    }

    public String getText(WebElement element) {
        String txt = waitForElement(element).getText();
        if (txt.equals("")) {
            txt = element.getAttribute("value");
        }
        LOGGER.info(element.toString() + "  -  " + txt);
        return txt;
    }

    public void clickButtonUsingClassname(String className, String buttonName) throws InterruptedException {
        int len = getDriver().findElements(By.className(className)).size();
        int i;
        LOGGER.info("Click " + buttonName);
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className(className)).get(i).getText();
            LOGGER.info("str : " + str);
            if (str.equals(buttonName)) {
                getDriver().findElements(By.className(className)).get(i).click();
                return;
            }
        }
        if (i == len) {
            throw new InterruptedException("Element Not Found");
        }
    }

    public void scrollAndClick(String visibleText) {
        WebDriver facade = getDriver();
        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
        ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))").click();
    }

    public void scrollToElement(String visibleText) {
        WebDriver facade = getDriver();
        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
        ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))");
        ((AndroidDriver) driver).hideKeyboard();
    }

    public void waitForLoadPage() throws InterruptedException {
        Thread.sleep(999);
        for (int i = 0; i < 120; i++) {
            int len = getDriver().findElements(By.className("android.widget.ProgressBar")).size();
            System.out.println("String len " + len);
            if (len == 0) {
                return;
            }
            Thread.sleep(300);
            LOGGER.info("Waiting for page to load");
        }
    }

    public void waitForLoadPage2(String xpth) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(By
                .xpath(xpth)));
    }

    public void SendValueUsingClassname(String className, String fieldName, String value) throws InterruptedException {
        int len = getDriver().findElements(By.className(className)).size();
        int i;
        LOGGER.info("Click " + fieldName);
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className(className)).get(i).getText();
            LOGGER.info("str : " + str);
            if (str.equals(fieldName)) {
                getDriver().findElements(By.className(className)).get(i).sendKeys(value);
                return;
            }
        }
        if (i == len) {
            throw new InterruptedException("Element Not Found");
        }
    }

    public void pressKeyUsingKeyCode() throws Throwable {
//        AndroidDriver.pressKeyCode(AndroidKeyCode.SPACE, AndroidKeyMetastate.META_SHIFT_ON);
        WebDriver facade = getDriver();
        int numKey;
        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_J, AndroidKeyMetastate.META_SHIFT_ON);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_A, AndroidKeyMetastate.META_SHIFT_ON);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_I, AndroidKeyMetastate.META_SHIFT_ON);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_P, AndroidKeyMetastate.META_SHIFT_ON);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_A, AndroidKeyMetastate.META_SHIFT_ON);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_R, AndroidKeyMetastate.META_SHIFT_ON);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_K, AndroidKeyMetastate.META_SHIFT_ON);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_A, AndroidKeyMetastate.META_SHIFT_ON);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_H, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(1999);
//        System.out.println("Move to next edit feild");
//        ((AndroidDriver) driver).executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
        Thread.sleep(1999);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER, AndroidKeyMetastate.META_SHIFT_ON);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_4, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_7, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_2, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_9, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_8, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_7, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_5, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_3, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_4, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1, AndroidKeyMetastate.META_SHIFT_ON);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_2, AndroidKeyMetastate.META_SHIFT_ON);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0, AndroidKeyMetastate.META_SHIFT_ON);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_2, AndroidKeyMetastate.META_SHIFT_ON);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_2, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(1999);
//        ((AndroidDriver) driver).executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
//        Thread.sleep(999);
//        ((AndroidDriver) driver).executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
        Thread.sleep(4999);
    }

    public void clickTabButton() throws Throwable {
        WebDriver facade = getDriver();
        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_TAB, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(1999);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_TAB, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(500);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_TAB, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(500);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_TAB, AndroidKeyMetastate.META_SHIFT_ON);
        Thread.sleep(500);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_TAB, AndroidKeyMetastate.META_SHIFT_ON);
//        Thread.sleep(999);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_TAB, AndroidKeyMetastate.META_SHIFT_ON);
        ((AndroidDriver) driver).executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
        Thread.sleep(500);
        ((AndroidDriver) driver).executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
        Thread.sleep(3999);
    }

    public void pressKeyCode(String keyName) throws Throwable {
        WebDriver facade = getDriver();
        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
//        Thread.sleep(999);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_7, AndroidKeyMetastate.META_SHIFT_ON);
//        Thread.sleep(999);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1, AndroidKeyMetastate.META_SHIFT_ON);
//        Thread.sleep(999);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_9, AndroidKeyMetastate.META_SHIFT_ON);
//        Thread.sleep(999);
//        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_8, AndroidKeyMetastate.META_SHIFT_ON);
//        Thread.sleep(4999);
//        Thread.sleep(999);
        //dynamic click
        if (keyName.equals("0")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_0, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("1")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("2")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_2, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("3")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_3, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("4")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_4, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("5")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_5, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("6")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_6, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("7")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_7, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("8")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_8, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("9")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_9, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("A") || keyName.equals("a")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_A, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("B") || keyName.equals("b")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_B, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("C") || keyName.equals("c")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_C, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("D") || keyName.equals("d")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_D, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("E") || keyName.equals("e")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_E, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("F") || keyName.equals("f")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_F, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("G") || keyName.equals("g")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_G, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("H") || keyName.equals("h")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_H, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("I") || keyName.equals("i")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_I, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("J") || keyName.equals("j")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_J, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("K") || keyName.equals("k")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_K, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("L") || keyName.equals("l")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_L, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("M") || keyName.equals("m")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_M, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("N") || keyName.equals("n")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_N, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("O") || keyName.equals("o")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_O, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("P") || keyName.equals("p")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_P, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("Q") || keyName.equals("q")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Q, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("R") || keyName.equals("r")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_R, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("S") || keyName.equals("s")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_S, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("T") || keyName.equals("t")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_T, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("U") || keyName.equals("u")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_U, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("V") || keyName.equals("v")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_V, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("W") || keyName.equals("w")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_W, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("X") || keyName.equals("x")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_X, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("Y") || keyName.equals("y")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Y, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("Z") || keyName.equals("z")) {
//            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_Z, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("DONE") || keyName.equals("done")) {
            Thread.sleep(100);
            ((AndroidDriver) driver).executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
        } else if (keyName.equals("NEXT") || keyName.equals("next")) {
            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_TAB, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("ENTER") || keyName.equals("enter")) {
            Thread.sleep(999);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_NUMPAD_ENTER, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("CLEAR") || keyName.equals("clear")) {
            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CLEAR, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("BACK") || keyName.equals("back")) {
            Thread.sleep(500);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("DOUBLEBACK") || keyName.equals("doubleback")) {
            Thread.sleep(500);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK, AndroidKeyMetastate.META_SHIFT_ON);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals(" ")) {
            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_SPACE, AndroidKeyMetastate.META_SHIFT_ON);
        } else if (keyName.equals("DOWN")) {
            Thread.sleep(100);
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_DPAD_DOWN, AndroidKeyMetastate.META_SHIFT_ON);
        }

    }

    public void moveToNextInputField() throws Throwable {
        WebDriver facade = getDriver();
        WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_TAB, AndroidKeyMetastate.META_SHIFT_ON);
    }

    public String fetchValueFromExcelSheet(int rowNum, int colNum) throws Throwable {
        Thread.sleep(1999);
        XSSFWorkbook workbook = new XSSFWorkbook(filePath);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        try {
            //for String
//            System.out.println("inside try...");
            String phoneNumber = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//            System.out.println("value of phoneNumber : "+ phoneNumber);
            return phoneNumber;
        } catch (Exception e) {
            //for int
//            System.out.println("inside catch...");
            Long phoneNumber = (long) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
//            System.out.println("phoner Number into int form : "+ phoneNumber);
            String phoneNumberinStringFormat = "" + phoneNumber;
//            System.out.println("phone Number in string format :"+ phoneNumberinStringFormat);
            //remove decimal
//            String withutdecimalPhoneNumber = phoneNumberinStringFormat.replaceAll(".","");
//            System.out.println("value of withutdecimalPhoneNumber : "+ withutdecimalPhoneNumber);
            return phoneNumberinStringFormat;
        }
    }

    public String fetchAndExtractOtpFromAPI() throws Throwable {
        String xmlResponse;
        for (int i = 0; i < 60; i++) {
            Response response = RestAssured.get(apiUrl);
            xmlResponse = response.getBody().asString();
            System.out.println("Response .... " + xmlResponse);
            //wait for the 1 minute until do not get OTP for DVC

            if (!xmlResponse.contains("Device Verification Code for your device authentication at PayZapp is")) {
                Thread.sleep(999);
                System.out.println("wait for the DVC OTP: ");
            } else if (xmlResponse.contains("Device Verification Code for your device authentication at PayZapp is")) {
                break;
            }
        }
        Response response = RestAssured.get(apiUrl);
        xmlResponse = response.getBody().asString();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(xmlResponse));
        Document doc = builder.parse(src);
        try {
            String msgData = doc.getElementsByTagName("messagedata").item(0).getTextContent();
//        System.out.println("xml msgData text ...." + msgData);
            String authenticationCode = msgData.replaceAll("[^-?0-9]+", "");
//        System.out.println(Arrays.asList("authenticationCode is ...."+authenticationCode));
            String authenticationCodeOrg = authenticationCode.replaceAll(" .*", "");
//        System.out.println("original authenticationCodeOrg "+ authenticationCodeOrg);
            String authenticationOtpString = authenticationCodeOrg.substring(0, Math.min(authenticationCodeOrg.length(), 6));
            System.out.println("upToNCharacters upToNCharacters " + authenticationOtpString);
//        int authenticationOtpInt = Integer.parseInt(authenticationOtpString);
            System.out.println("authentication OTP " + authenticationOtpString);
            return authenticationOtpString;
        }catch (Exception e){
            System.out.println("OTP NOT FOUND");
            return "OTP NOT FOUND";
        }
    }

    public void writeDataIntoExcelSheet(int rowNo, int colNo, String text) throws Throwable{
        File file =    new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet2=wb.getSheet("sheet1");
        Row row = sheet2.getRow(rowNo);
        row.createCell(colNo).setCellValue(""+text);
        FileOutputStream outputStream = new FileOutputStream(filePath);
        wb.write(outputStream);
        wb.close();
    }

    public int getRowNumberOfExcelSheet()throws Throwable{
        File file =    new File(filePath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet2=wb.getSheet("sheet1");
        int row = sheet2.getPhysicalNumberOfRows();
        return row;
    }

    public String fetchAndExtractBankOtpFromAPI() throws Throwable{
        String xmlResponse;
        for(int i=0;i<60;i++) {
            Response response = RestAssured.get(apiUrl);
            xmlResponse = response.getBody().asString();
            System.out.println("Response .... " + xmlResponse);
            //wait for the 1 minute until do not get OTP for DVC

            if (!xmlResponse.contains("OTP")) {
                Thread.sleep(999);
                System.out.println("wait for the DVC OTP: ");
            }else if((xmlResponse.contains("Zingoy Transcorp Card")) || xmlResponse.contains("OTP")){
                System.out.println("Break the loop");
                i=i+62;
                break;
            }
        }
        Response response = RestAssured.get(apiUrl);
        xmlResponse = response.getBody().asString();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(xmlResponse));
        Document doc = builder.parse(src);
        String msgData = doc.getElementsByTagName("messagedata").item(0).getTextContent();
//        String msgData = "Use OTP 676113 to authorize your transaction using PinePerks RuPay Card";
        String cardName = fetchValueFromExcelSheet(1,17);
        if(cardName.equals("Zingoy_Transcop")){
            String separator =" OTP. Dont share";
            int sepPos = msgData.lastIndexOf(separator);
            System.out.println("Substring before last separator = "+msgData.substring(0,sepPos));
            String s = msgData.substring(0,sepPos);
            String[] split = s.split("Zingoy Transcorp Card ");
            String firstSubString = split[0];
            String bankOtp = split[1];
//            System.out.println("firstSubString "+firstSubString);
            System.out.println("secondSubString "+bankOtp);
            return bankOtp;

        }
        else {
            String authenticationCode = msgData.replaceAll("[^-?0-9]+", "");
            String authenticationCodeOrg = authenticationCode.replaceAll(" .*", "");
            String bankOtp = authenticationCodeOrg.substring(0, Math.min(authenticationCodeOrg.length(), 6));
            System.out.println("bank otp: " + bankOtp);
            return bankOtp;
        }
    }

    public void waitForTextUsingClassname(String className, String text,int sec) throws InterruptedException {
//        int len = getDriver().findElements(By.className(className)).size();
        int i;
        LOGGER.info("Click " + text);
        LOGGER.info("LEN : " + sec);
        for (i = 0; i < sec; i++) {
            String str = getDriver().findElements(By.className(className)).get(i).getText();
            Thread.sleep(999);
            LOGGER.info("str : " + str);
            if (str.equals(text)) {
//                getDriver().findElements(By.className(className)).get(i).click();
                return;
            }
        }
        if (i == sec) {
            throw new InterruptedException("Text Not Found");
        }
    }

    public void doubleClickOnBackButtonIfTextIsVisible(String className, String buttonName) throws Throwable{
        int len = getDriver().findElements(By.className(className)).size();
        int i;
        LOGGER.info("Click on button and then double click on back button" + buttonName);
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className(className)).get(i).getText();
            LOGGER.info("str : " + str);
            if (str.equals(buttonName)) {
                getDriver().findElements(By.className(className)).get(i).click();
                WebDriver facade = getDriver();
                WebDriver driver = ((WebDriverFacade) facade).getProxiedDriver();
                ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK, AndroidKeyMetastate.META_SHIFT_ON);
                ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.KEYCODE_BACK, AndroidKeyMetastate.META_SHIFT_ON);
                return;
            }
        }
        if (i == len) {
            throw new InterruptedException("Element Not Found");
        }
    }

    public void deleteOldMessageFromAPI2() throws Throwable{
//        Response response = RestAssured.get("http://127.0.0.1:9501/api?action=receivemessage&username=admin1&password=Admin@123&folder=inbox&limit=100&afterdownload=delete");
        Response response = RestAssured.delete(deleteMessageApiUrl);
        String xmlResponse = response.getBody().asString();
        System.out.println("Response .... "+ xmlResponse);
        RestAssured.delete(deleteMessageApiUrl);
    }

    public String fetchAndExtractBankOtpFromAPI(int index) throws Throwable{
        String xmlResponse;
        for(int i=0;i<60;i++) {
            Response response = RestAssured.get(apiUrl);
            xmlResponse = response.getBody().asString();
            System.out.println("Response .... " + xmlResponse);
            //wait for the 1 minute until do not get OTP for DVC

            if (!xmlResponse.contains("OTP")) {
                Thread.sleep(999);
                System.out.println("wait for the DVC OTP: ");
            }else if((xmlResponse.contains("Zingoy Transcorp Card")) || xmlResponse.contains("OTP")){
                System.out.println("Break the loop");
                i=i+62;
                break;
            }
        }
        Response response = RestAssured.get(apiUrl);
        xmlResponse = response.getBody().asString();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource src = new InputSource();
        src.setCharacterStream(new StringReader(xmlResponse));
        Document doc = builder.parse(src);
//        String msgData = doc.getElementsByTagName("messagedata").item(0).getTextContent();

        //new code
        int msgDataLength = doc.getElementsByTagName("messagedata").getLength();
        int lastMessage = msgDataLength-1;
        String msgData = doc.getElementsByTagName("messagedata").item(lastMessage).getTextContent();
//        String msgData = "Use OTP 676113 to authorize your transaction using PinePerks RuPay Card";
        String cardName = fetchValueFromExcelSheet(index,17);
        if(cardName.equals("Zingoy_Transcop")){
//            String separator =" OTP. Dont share";
            String separator =" is your Zingoy";
            int sepPos = msgData.lastIndexOf(separator);
            System.out.println("Substring before last separator = "+msgData.substring(0,sepPos));
//            String s = msgData.substring(0,sepPos);
//            String[] split = s.split("Zingoy Transcorp Card ");
//            String firstSubString = split[0];
//            String bankOtp = split[1];
////            System.out.println("firstSubString "+firstSubString);
//            System.out.println("secondSubString "+bankOtp);
            String bankOtp =msgData.substring(0,sepPos);
            System.out.println("otp is "+ bankOtp);
            return bankOtp;

        }
        else {
            String authenticationCode = msgData.replaceAll("[^-?0-9]+", "");
            String authenticationCodeOrg = authenticationCode.replaceAll(" .*", "");
            String bankOtp = authenticationCodeOrg.substring(0, Math.min(authenticationCodeOrg.length(), 6));
            System.out.println("bank otp: " + bankOtp);
            return bankOtp;
        }
    }

}
