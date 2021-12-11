package com.operrappium.serenity.cucumber.features.pages;

import com.operrappium.serenity.cucumber.features.stepdefinitions.StepDefinitions;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
    StepDefinitions stepDefinitions;

    public void clickOnNavigationBar() throws InterruptedException {
        Thread.sleep(1999);
        withTimeoutOf(20, TimeUnit.SECONDS).waitForPresenceOf(By.className("android.widget.ImageButton"));
        getDriver().findElement(By.className("android.widget.ImageButton")).click();
        Thread.sleep(1999);
    }

    public boolean getMenuText(String btnName) {
        withTimeoutOf(20, TimeUnit.SECONDS).waitForPresenceOf(By.className("android.widget.TextView"));
        String className = "android.widget.TextView";
        int len = getDriver().findElements(By.className(className)).size();
        int i;
        LOGGER.info("btnname " + btnName);
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className(className)).get(i).getText();
            LOGGER.info("str : " + str);
            if (str.equals(btnName)) {

                return true;
            }
        }
        if (i == len) {

            return false;
        }
        return true;
    }

    public void clickOnGivenMenu(String menuName) throws InterruptedException {
        clickButtonUsingClassname("android.widget.TextView", menuName);
        Thread.sleep(2999);
    }

    public boolean isTextDisplayed(String classname, String pageName) throws InterruptedException {
        Thread.sleep(2999);
        waitForLoadPage();
        withTimeoutOf(20, TimeUnit.SECONDS).waitForPresenceOf(By.className(classname));
        int len = getDriver().findElements(By.className(classname)).size();
        int i;
        LOGGER.info("btnname " + pageName);
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className(classname)).get(i).getText();
            LOGGER.info("str : " + str);
            if (str.equals(pageName)) {

                return true;
            }
        }
        if (i == len) {

            return false;
        }
        return true;
    }

    public void clickOnPreviousIcon() throws InterruptedException {
        Thread.sleep(3999);
        //        getDriver().navigate().back();
        String xpathExpression = "//android.widget.ImageButton[@content-desc='Navigate up']";
        getDriver().findElement(By.xpath(xpathExpression)).click();
    }

    public void isCurrentTripsDisplayed() throws InterruptedException {
        waitForLoadPage();
        Thread.sleep(1999);
        getDriver().navigate().back();
        withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//android.widget.TextView[@text='Current Trips']"));
    }

    public void checkCustomerFriendPageDisplayed() throws InterruptedException {
        waitForLoadPage();
        Thread.sleep(6999);
        getDriver().findElement(By.id("com.operr.operrprovider.us.dev:id/fab_expand_menu_button")).click();
    }

    //PayzApp code

    public void clickOnBillPayOption() throws Throwable{
        waitForLoadPage();
        String xpthBillPayField = "//*[@text=\"Bill pay\"]";
        int xpthBillPayLength = getDriver().findElements(By.xpath(xpthBillPayField)).size();
        System.out.println("xpthBillPayLength lenght: "+ xpthBillPayLength);
        if(xpthBillPayLength>0) {
//            clickButtonUsingClassname("android.widget.TextView", "Bill pay");
            getDriver().findElement(By.xpath(xpthBillPayField)).click();
        }
    }

    public void selectUtilityBillPayTypeFromExcelAndClickOnOption() throws Throwable{
        //select utility Bill pay type
        String billPayType = fetchValueFromExcelSheet(1,2);
        System.out.println("value of Bill PayType : "+ billPayType);
        clickButtonUsingClassname("android.widget.TextView", billPayType);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    private WebElement biller_input_field;
    public void getBillerNameFromExcelAndSelectonApp() throws Throwable{
        //select BillerName/Distributer name from Excel and select on app
        String distributorName = fetchValueFromExcelSheet(1,3);
        System.out.println("value of distributer name : "+ distributorName);
        String arr[] = distributorName.split(" ", 2);
        String distributorNameFirstWord = arr[0];   //first word of distributor name for searching purpose
        System.out.println("value of distributor first word : "+ distributorNameFirstWord);
        biller_input_field.click();
        for(int i=0; i<4;i++) {
//            clickButtonUsingClassname("android.widget.Button", distributorNameFirstWord.charAt(i)+"");
            pressKeyCode(distributorNameFirstWord.charAt(i)+"");
            Thread.sleep(500);
        }
        int index = distributorName.lastIndexOf(" ");
        String exceptLastWord = distributorName.substring(0, index);
        System.out.println("Biller name (ignore last world):" +exceptLastWord);
        biller_input_field.click();
        Thread.sleep(1999);
        scrollToElement(""+exceptLastWord);
        Thread.sleep(1999);
        clickButtonUsingClassname("android.view.View",""+exceptLastWord);
        Thread.sleep(1999);
    }

    @AndroidFindBy(id = "k_number")
    private WebElement k_number;
    public void enterKNumber() throws Throwable{
        //get K Number
        String kNumber = fetchValueFromExcelSheet(1,4);
        System.out.println("value of kNumber : "+ kNumber);
        Thread.sleep(1999);
        SendValueUsingClassname("android.widget.EditText","",kNumber);
    }
    public void clickConfirmButton() throws Throwable{
        String consumerKNumberField = "//*[@text=\"ENTER CONSUMER DETAILS\"]";
        int consumerKNumberFieldLength = getDriver().findElements(By.xpath(consumerKNumberField)).size();
        System.out.println("x path of consumerKNumberFieldLength for confirm button: "+ consumerKNumberFieldLength);
        if(consumerKNumberFieldLength>0) {
//            Thread.sleep(500);
//            clickButtonUsingClassname("android.widget.Button", "CONFIRM");
//            Thread.sleep(1999);
        getDriver().findElement(By.xpath("//*[@text=\"CONFIRM\"]")).click();
            waitForLoadPage();
        }
    }

    @AndroidFindBy(id = "billDetails_Btn")
    private WebElement amount;
    public void matchBilAmountAndPrintSameOrNotSameAmountInExcel() throws Throwable{
//        waitForTextToAppear("Billstatus:",20999);
        Thread.sleep(3999);
        getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        scrollToElement("PAY NOW");
        Thread.sleep(999);
        String amountOfExelSheet = fetchValueFromExcelSheet(1,5);
        System.out.println("value of amountOfExelSheet : "+ amountOfExelSheet);
        double excelSheetAmount = Double.parseDouble(amountOfExelSheet);
        System.out.println("value of amountOfExelSheet in double format : "+ excelSheetAmount);

        String str1 = getDriver().findElements(By.className("android.widget.EditText")).get(0).getText();
        double paymentPageAmount = Double.parseDouble(str1);
        System.out.println("amouunt of payment1 page"+ str1);
        System.out.println("amouunt of payment1 page in double format"+ paymentPageAmount);
        if(excelSheetAmount == paymentPageAmount){
            System.out.println("amount is same");
            // click on Pay Now button if amount is same
            Thread.sleep(999);
            clickButtonUsingClassname("android.widget.Button","PAY NOW");
            Thread.sleep(3999);
        }
        else {
            System.out.println("amount is not same");
            //print into excel
            writeDataIntoExcelSheet(1,16,"Amount is not same. amount in excel sheet is :"+amountOfExelSheet +" but amount on payment page is :"+ paymentPageAmount);

        }
//        Thread.sleep(999);
//        clickButtonUsingClassname("android.widget.Button","PAY NOW");
//        Thread.sleep(3999);
    }

    public void addPayMentCard()throws Throwable{
        Thread.sleep(3999);
        //get card Number from excel sheet
        String cardNumber = fetchValueFromExcelSheet(1,8);
        System.out.println("value of cardNumber "+ cardNumber);
        int cardNumberLength = cardNumber.length();
        for(int i=0; i<cardNumberLength;i++) {
            pressKeyCode(cardNumber.charAt(i)+"");
        }
        pressKeyCode("done");
        //enter expiry card date
        String expiryDate = fetchValueFromExcelSheet(1,9);
        System.out.println("expiry Date: "+expiryDate);
        String month = expiryDate.substring(0,2);
        int mongthLength = month.length();
        for(int i=0; i<mongthLength;i++) {
            pressKeyCode(month.charAt(i)+"");
        }
        String year = expiryDate.substring(2,4);
        String fullYear = "20"+year;
        System.out.println("Month: "+month+" and Year :"+fullYear);
        int yearLength = fullYear.length();
        for(int i=0; i<yearLength;i++) {
            pressKeyCode(fullYear.charAt(i)+"");
        }
//        pressKeyUsingKeyCode();
        Thread.sleep(1999);
        clickTabButton();
    }

    public void enterOTPOrPinCode()throws Throwable{
        //get card pin
        Thread.sleep(3999);
        String cardPin = fetchValueFromExcelSheet(1,11);
        System.out.println("value of amountOfExelSheet : "+ cardPin);
        //enter otp if card is based on OTP
        //implement Logic
        int len = cardPin.length();
        System.out.println("pin length: "+ len);
        if(len>2){
            //enter pin code
            System.out.println("entering...pin code");
            moveToNextInputField();
            moveToNextInputField();
            moveToNextInputField();
            moveToNextInputField();
            int len3 = cardPin.length();
            for(int i=0; i<len3;i++) {
                Thread.sleep(999);
                char pinByDigit = cardPin.charAt(i);
                System.out.println("pin digit "+ pinByDigit);
                String digit = ""+pinByDigit;
//                pressKeyCode(digit);
//                adb shell "input keyboard text 'Paste%stext%son%sAndroid%sDevice'";
                if(digit.equals("0")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_0\"");
                }
                if(digit.equals("1")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_1\"");
                }
                if(digit.equals("2")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_2\"");
                }
                if(digit.equals("3")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_3\"");
                }
                if(digit.equals("4")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_4\"");
                }
                if(digit.equals("5")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_5\"");
                }
                if(digit.equals("6")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_6\"");
                }
                if(digit.equals("7")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_7\"");
                }
                if(digit.equals("8")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_8\"");
                }
                if(digit.equals("9")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_9\"");
                }

            }
            Thread.sleep(1999);
            moveToNextInputField();
            Thread.sleep(1999);
            System.out.println("first move: ");
            moveToNextInputField();
//            Thread.sleep(1999);
            System.out.println("second move: ");
            moveToNextInputField();
            System.out.println("third move: ");
//            Thread.sleep(1999);
            moveToNextInputField();
            System.out.println("Final move: ");
            Thread.sleep(999);
            pressKeyCode("ENTER");

        }else {
            //enter CVV
            Thread.sleep(4999);
            String cvv = fetchValueFromExcelSheet(1,10);
            System.out.println("CVV: "+ cvv);
            pressKeyCode("1");
            pressKeyCode("CLEAR");
            int len2 = cvv.length();
            for(int i=0; i<3;i++) {
                System.out.println("digit of cvv: "+cvv.charAt(i));
                pressKeyCode(cvv.charAt(i)+"");

            }
            pressKeyCode("NEXT");
            pressKeyCode("DONE");
//            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            Thread.sleep(14999);
            String bankOTP = fetchAndExtractBankOtpFromAPI();
//            String bankOTP = "852369";
            System.out.println("bank OTP:"+bankOTP);
            pressKeyCode("NEXT");
            System.out.println("First Move");
            Thread.sleep(999);
            pressKeyCode("NEXT");
            System.out.println("Second Move");
            Thread.sleep(999);
            pressKeyCode("NEXT");
            System.out.println("Third Move");
            Thread.sleep(999);
//            pressKeyCode("NEXT");
//            System.out.println("Forth Move");
            Thread.sleep(999);
            int otpLength = bankOTP.length();
            for(int i=0; i<otpLength;i++) {
                Thread.sleep(999);
                char otpDigit = bankOTP.charAt(i);
                System.out.println("otp digit "+ otpDigit);
                String otpDigit1 = ""+otpDigit;
//                pressKeyCode(bankOTP.charAt(i)+"");
                System.out.println("otp digit: "+ bankOTP.charAt(i));
                if(otpDigit1.equals("0")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_0\"");
                }
                if(otpDigit1.equals("1")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_1\"");
                }
                if(otpDigit1.equals("2")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_2\"");
                }
                if(otpDigit1.equals("3")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_3\"");
                }
                if(otpDigit1.equals("4")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_4\"");
                }
                if(otpDigit1.equals("5")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_5\"");
                }
                if(otpDigit1.equals("6")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_6\"");
                }
                if(otpDigit1.equals("7")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_7\"");
                }
                if(otpDigit1.equals("8")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_8\"");
                }
                if(otpDigit1.equals("9")) {
                    executeCommand("adb shell input keyevent \"KEYCODE_9\"");
                }
            }

//            getDriver().findElement(By.id("pay-secure-otp")).sendKeys(bankOTP);
            clickButtonUsingClassname("android.widget.Button","Submit");
            Thread.sleep(4999);
        }

    }

    @AndroidFindBy(className = "android.view.View")
    private WebElement reference_text;
    public void getAndWriteReferenceNumber() throws Throwable{
//        String dummyReferenceText = "Your transaction is processed successfully. Please note down the receipt no. #HGA3P0F3390339355662 and BBPS REF NO. HD011328BA3AAAAUJKMV for future reference.";
        Thread.sleep(25999);
        //get success text
        int len = getDriver().findElements(By.className("android.view.View")).size();
        int i;
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className("android.view.View")).get(i).getText();
            System.out.println("i = "+i);
            System.out.println("message :"+str);
            if(str.contains("Payment processing")){
                Thread.sleep(20999);
            }
        }

        String successMessageText = getDriver().findElements(By.className("android.view.View")).get(7).getText();
        String dummyReferenceText = getDriver().findElements(By.className("android.view.View")).get(9).getText();
        //above code
        String segments[] = dummyReferenceText.split("BBPS REF NO. ");
        String BBPS_REF_NO  = segments[segments.length - 1];
        System.out.println("BBPS_REF_No :"+BBPS_REF_NO);
        String[] split = BBPS_REF_NO.split(" for");
        String firstSubStringBBPSNo = split[0];
        System.out.println("aftre extracting BBPS REF NO. : "+firstSubStringBBPSNo);
        //write into excel  testdatadummy

        String receipt[] = dummyReferenceText.split("receipt no. ");
        String receipt_no  = receipt[segments.length - 1];
        System.out.println("receipt no. :"+receipt_no);
        String[] split2 = receipt_no.split(" and BBPS REF NO");
        String firstSubStringRecieptNo = split2[0];
        System.out.println("after extracting receipt NO. : "+firstSubStringRecieptNo);
        writeDataIntoExcelSheet(1,14,firstSubStringBBPSNo);
        writeDataIntoExcelSheet(1,15,firstSubStringRecieptNo);
        writeDataIntoExcelSheet(1,16,successMessageText);
    }

    public void runTestCaseInLoop(int loop) throws Throwable{
        int row=loop;
        int col=0;
        int loginCellNo = 0;
        int loginPinCellNo =1;
        int serviceNameCellNo=2;
        int billerNameCellNo=3;
        int kNumberCellNo=4;
        int amountCellNo=5;
        int cardOwnerName = 7;
        int cardNumberCellNo = 8;
        int cardExpiryDateCellNo = 9;
        int cvvCellNo=10;
        int pinCellNo=11;
        int otpMobileNumberCellNo=12;
        int promoCodeCellNo=13;
        int referenceNoCellNo=14;
        int bbpsNoCellNo=15;
        int remarkCellNo=16;
        int totalRow = getRowNumberOfExcelSheet();
        System.out.println("Total row: "+totalRow);
//        for(row=loop;row<totalRow;row++){
            System.out.println("row "+row);
            String loginId = fetchValueFromExcelSheet(row,loginCellNo);
            System.out.println("Login id: "+ loginId);
            String loginPin = fetchValueFromExcelSheet(row,loginPinCellNo);
            System.out.println("Login Pin: "+ loginPin);
            String serviceName = fetchValueFromExcelSheet(row,serviceNameCellNo);
            System.out.println("service name: "+ serviceName);
            String billerName = fetchValueFromExcelSheet(row,billerNameCellNo);
            System.out.println("Biller Name: "+ billerName);
            String kNumber = fetchValueFromExcelSheet(row,kNumberCellNo);
            System.out.println("KNumber: "+ kNumber);
            String amount = fetchValueFromExcelSheet(row,amountCellNo);
            System.out.println("amount: "+ amount);
            String cardOwner = fetchValueFromExcelSheet(row,cardOwnerName);
            System.out.println("card Owner: "+ cardOwner);
            String cardNumber = fetchValueFromExcelSheet(row,cardNumberCellNo);
            System.out.println("card Number: "+ cardNumber);
            String cardExpiryDate = fetchValueFromExcelSheet(row,cardExpiryDateCellNo);
            System.out.println("Card Expiry Date: "+ cardExpiryDate);
            String cvv = fetchValueFromExcelSheet(row,cvvCellNo);
            System.out.println("card cvv: "+ cvv);
            String pin = fetchValueFromExcelSheet(row,pinCellNo);
            System.out.println("card pin: "+ pin);
            String otpMobieNumber = fetchValueFromExcelSheet(row,otpMobileNumberCellNo);
            System.out.println("otp Mobile Number: "+ otpMobieNumber);
            String promoCode = fetchValueFromExcelSheet(row,promoCodeCellNo);
            System.out.println("promo code: "+ promoCode);

//        }

    }
    public void printotp()throws Throwable{
        fetchAndExtractBankOtpFromAPI();
    }

    public void deleteTheCard()throws Throwable{
//        clickButtonUsingClassname("android.widget.Button","GO TO HOME");
        int len2 = getDriver().findElements(By.className("android.view.View")).size();
        int webViewLength = getDriver().findElements(By.className("android.webkit.WebView")).size();
        int btnLength = getDriver().findElements(By.className("android.widget.Button")).size();
        System.out.println("view class length after payment: "+len2);
        System.out.println("web View Length after payment: "+ webViewLength);
        System.out.println("btn Length after payment: "+ btnLength);
        String successMessageText = getDriver().findElements(By.className("android.view.View")).get(7).getText();
        if((len2>20 && btnLength ==2) || successMessageText.contains("technical failure") ||successMessageText.contains("SUCCESS")) {
            pressKeyCode("BACK");
            pressKeyCode("BACK");
            Thread.sleep(999);
            pressKeyCode("BACK");
            Thread.sleep(2999);
            clickButtonUsingClassname("android.widget.TextView", "Linked cards");
            pressKeyCode("NEXT");
            Thread.sleep(1999);
            pressKeyCode("NEXT");
        Thread.sleep(999);
            pressKeyCode("NEXT");
        Thread.sleep(500);
            pressKeyCode("NEXT");
        Thread.sleep(500);
            pressKeyCode("NEXT");
        Thread.sleep(500);
            pressKeyCode("NEXT");
//        System.out.println("last Next");
        Thread.sleep(500);
            pressKeyCode("DONE");
            Thread.sleep(2000);
//            pressKeyCode("NEXT");
//            Thread.sleep(500);
//            pressKeyCode("NEXT");
            Thread.sleep(500);
            pressKeyCode("ENTER");
            Thread.sleep(1999);
            pressKeyCode("DOUBLEBACK");


        }
    }

    //excute command
    public void executeCommand (String command){
        try {
            Process result = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            // TODO Auto-generated catch block**
           e.printStackTrace();
}
    }

    public void selectUtilityBillPayTypeFromExcelAndClickOnOption(int rowNumber) throws Throwable{
        waitForLoadPage();
        //select utility Bill pay type
        String billPayType = fetchValueFromExcelSheet(rowNumber,2);
        System.out.println("value of Bill PayType : "+ billPayType);
        String xpthBillPayType = "//*[@text=\""+billPayType+"\"]";
        int xpthBillPayTypeLength = getDriver().findElements(By.xpath(xpthBillPayType)).size();
        System.out.println("xpthBillPayLength lenght: "+ xpthBillPayTypeLength);
        if(xpthBillPayTypeLength>0) {
//            clickButtonUsingClassname("android.widget.TextView", billPayType);
            getDriver().findElement(By.xpath(xpthBillPayType)).click();
        }

    }

    public void getBillerNameFromExcelAndSelectonApp(int rowNumber) throws Throwable{
        //select BillerName/Distributer name from Excel and select on app
        String distributorName = fetchValueFromExcelSheet(rowNumber,3);
        System.out.println("value of distributer name : "+ distributorName);
        String arr[] = distributorName.split(" ", 2);
        String distributorNameFirstWord = arr[0];   //first word of distributor name for searching purpose
        System.out.println("value of distributor first word : "+ distributorNameFirstWord);
        String recentField = "//*[@text=\"Recent\"]";
        int recentFieldFieldLength = getDriver().findElements(By.xpath(recentField)).size();
        System.out.println("x path of recentFieldFieldLength for Biller name dropdown list: "+ recentFieldFieldLength);
        if(recentFieldFieldLength>0) {

            biller_input_field.click();
            for (int i = 0; i < 5; i++) {
//            clickButtonUsingClassname("android.widget.Button", distributorNameFirstWord.charAt(i)+"");
                pressKeyCode(distributorNameFirstWord.charAt(i) + "");
//            Thread.sleep(500);
            }
            int index = distributorName.lastIndexOf(" ");
            String exceptLastWord = distributorName.substring(0, index);
            System.out.println("Biller name (ignore last world):" + exceptLastWord);
            biller_input_field.click();
            Thread.sleep(999);
//        scrollToElement(""+exceptLastWord);
//        Thread.sleep(1999);
            clickButtonUsingClassname("android.view.View", "" + exceptLastWord);
//            Thread.sleep(1999);
        }
    }

    public void enterKNumber(int rowNumber) throws Throwable{
        //get K Number
        String consumerKNumberField = "//*[@text=\"ENTER CONSUMER DETAILS\"]";
        int consumerKNumberFieldLength = getDriver().findElements(By.xpath(consumerKNumberField)).size();
        System.out.println("x path of consumerKNumberFieldLength : "+ consumerKNumberFieldLength);
        if(consumerKNumberFieldLength>0) {
            String kNumber = fetchValueFromExcelSheet(rowNumber, 4);
            System.out.println("value of kNumber : " + kNumber);
            Thread.sleep(500);
            SendValueUsingClassname("android.widget.EditText", "", kNumber);
            Thread.sleep(999);
        }
    }

    public void matchBilAmountAndPrintSameOrNotSameAmountInExcel(int rowNumber) throws Throwable{
//        waitForTextToAppear("Billstatus:",20999);
        int webViewLength = getDriver().findElements(By.className("android.webkit.WebView")).size();
        int btnLength = getDriver().findElements(By.className("android.widget.Button")).size();
        System.out.println("web View Length on Pay Now page: "+ webViewLength);
        System.out.println("btn class Length on Pay Now page: "+ btnLength);
        String btnName = getDriver().findElements(By.className("android.widget.Button")).get(0).getText();
        System.out.println("Button name : "+ btnName);
//        Thread.sleep(1999);
        if(webViewLength==2 && btnName.equals("PAY NOW")) {
            // if webview length is less than 2 then it means user is not on Pay Now Page
//            Thread.sleep(999);
            String amountOfExelSheet = fetchValueFromExcelSheet(rowNumber, 5);
            System.out.println("value of amountOfExelSheet : " + amountOfExelSheet);
            double excelSheetAmount = Double.parseDouble(amountOfExelSheet);
            System.out.println("value of amountOfExelSheet in double format : " + excelSheetAmount);
            String str1 = getDriver().findElements(By.className("android.widget.EditText")).get(0).getText();
            if(str1.length()>1){
            double paymentPageAmount = Double.parseDouble(str1);
            System.out.println("amouunt of payment1 page" + str1);
            System.out.println("amouunt of payment1 page in double format" + paymentPageAmount);
            if (excelSheetAmount == paymentPageAmount) {
                System.out.println("amount is same");
                // pay the amount , click Pay Now if amount is same
                clickButtonUsingClassname("android.widget.Button", "PAY NOW");
                Thread.sleep(1999);
            } else {
                System.out.println("amount is not same");
                //print into excel
                writeDataIntoExcelSheet(rowNumber, 16, "Amount is not same. amount in excel sheet is :" + amountOfExelSheet + " but amount on payment page is :" + paymentPageAmount);

            }
            }
        }
//        Thread.sleep(999);
//        clickButtonUsingClassname("android.widget.Button","PAY NOW");
//        Thread.sleep(3999);
    }
    public void addPayMentCard(int rowNumber)throws Throwable{
        waitForLoadPage();
        String  btnName;
        Thread.sleep(999);
        int webViewLength = getDriver().findElements(By.className("android.webkit.WebView")).size();
        int btnLength = getDriver().findElements(By.className("android.widget.Button")).size();
        System.out.println("web View Length on Pay Add Card popup: "+ webViewLength);
        System.out.println("btn Length on Pay Add Card popup: "+ btnLength);
        //get card Number from excel sheet
        if(btnLength>0){
             btnName = getDriver().findElement(By.className("android.widget.Button")).getText();
             System.out.println("Button name on Add Payment card popup ==> "+btnName);
            if(btnName.equals("Got It")) {
                String xpathGotit = "//*[@text=\"Got It\"]";
                getDriver().findElement(By.xpath(xpathGotit)).click();
                Thread.sleep(999);
            }
        }

        webViewLength = getDriver().findElements(By.className("android.webkit.WebView")).size();
        btnLength = getDriver().findElements(By.className("android.widget.Button")).size();

        if(webViewLength==0 && btnLength==0){
//        String cardNumber = fetchValueFromExcelSheet(rowNumber,8);
//        System.out.println("value of cardNumber "+ cardNumber);
//        int cardNumberLength = cardNumber.length();
//        for(int i=0; i<cardNumberLength;i++) {
//            pressKeyCode(cardNumber.charAt(i)+"");
//        }
//        pressKeyCode("done");
//        //enter expiry card date
//        String expiryDate = fetchValueFromExcelSheet(rowNumber,9);
//        System.out.println("expiry Date: "+expiryDate);
//        String month = expiryDate.substring(0,2);
//        int mongthLength = month.length();
//        for(int i=0; i<mongthLength;i++) {
//            pressKeyCode(month.charAt(i)+"");
//        }
//        String year = expiryDate.substring(2,4);
//        String fullYear = "20"+year;
//        System.out.println("Month: "+month+" and Year :"+fullYear);
//        int yearLength = fullYear.length();
//        for(int i=0; i<yearLength;i++) {
//            pressKeyCode(fullYear.charAt(i)+"");
//        }
//
            System.out.println("first Move ..");
            pressKeyCode("NEXT");
            Thread.sleep(999);
            System.out.println("second Move ..");
            pressKeyCode("NEXT");
            pressKeyCode("DONE");
//            System.out.println("second Move ..");
//            pressKeyCode("NEXT");
//            Thread.sleep(999);
//
//        clickTabButton();
            Thread.sleep(4999);
        }
    }

    public void enterOTPOrPinCode(int rowNumber)throws Throwable{
        //get card pin
        Thread.sleep(4999);
//        waitForLoadPage();  //need to remove this waiting
        int webViewLength = getDriver().findElements(By.className("android.webkit.WebView")).size();
        int btnLength = getDriver().findElements(By.className("android.widget.Button")).size();
        System.out.println("web View Length on OTP or Pin Popup: "+ webViewLength);
        System.out.println("btn Length on OTP or Pin Popup: "+ btnLength);
        if((webViewLength==0 && btnLength==0) ||(webViewLength==2 && btnLength==0)) {
            String cardPin = fetchValueFromExcelSheet(rowNumber, 11);
            String cardIsBasedOn = fetchValueFromExcelSheet(rowNumber, 6);
            System.out.println("value of amountOfExelSheet : " + cardPin);
            //enter otp if card is based on OTP
            //implement Logic
            int len = cardPin.length();
            System.out.println("pin length: " + len);
            if (cardIsBasedOn.equals("pin")) {
                //enter pin code
                System.out.println("entering...pin code");
                moveToNextInputField();
                moveToNextInputField();
                moveToNextInputField();
                moveToNextInputField();
                int len3 = cardPin.length();
                for (int i = 0; i < len3; i++) {
                    Thread.sleep(999);
                    char pinByDigit = cardPin.charAt(i);
                    System.out.println("pin digit " + pinByDigit);
                    String digit = "" + pinByDigit;
//                pressKeyCode(digit);
//                adb shell "input keyboard text 'Paste%stext%son%sAndroid%sDevice'";
                    if (digit.equals("0")) {
                        executeCommand("adb shell input keyevent \"KEYCODE_0\"");
                    }
                    if (digit.equals("1")) {
                        executeCommand("adb shell input keyevent \"KEYCODE_1\"");
                    }
                    if (digit.equals("2")) {
                        executeCommand("adb shell input keyevent \"KEYCODE_2\"");
                    }
                    if (digit.equals("3")) {
                        executeCommand("adb shell input keyevent \"KEYCODE_3\"");
                    }
                    if (digit.equals("4")) {
                        executeCommand("adb shell input keyevent \"KEYCODE_4\"");
                    }
                    if (digit.equals("5")) {
                        executeCommand("adb shell input keyevent \"KEYCODE_5\"");
                    }
                    if (digit.equals("6")) {
                        executeCommand("adb shell input keyevent \"KEYCODE_6\"");
                    }
                    if (digit.equals("7")) {
                        executeCommand("adb shell input keyevent \"KEYCODE_7\"");
                    }
                    if (digit.equals("8")) {
                        executeCommand("adb shell input keyevent \"KEYCODE_8\"");
                    }
                    if (digit.equals("9")) {
                        executeCommand("adb shell input keyevent \"KEYCODE_9\"");
                    }

                }
                Thread.sleep(999);
                moveToNextInputField();
                Thread.sleep(999);
                System.out.println("first move: ");
                moveToNextInputField();
//            Thread.sleep(1999);
                System.out.println("second move: ");
                moveToNextInputField();
                System.out.println("third move: ");
//            Thread.sleep(1999);
                moveToNextInputField();
                System.out.println("Final move: ");
                Thread.sleep(999);
                pressKeyCode("ENTER");
                Thread.sleep(1999);
            } else if (cardIsBasedOn.equals("otp")) {
                //enter CVV
                Thread.sleep(1999);
                String cvv = fetchValueFromExcelSheet(rowNumber, 10);
                System.out.println("CVV: " + cvv);
                pressKeyCode("1");
                pressKeyCode("CLEAR");
                int len2 = cvv.length();
                for (int i = 0; i < 3; i++) {
                    System.out.println("digit of cvv: " + cvv.charAt(i));
                    pressKeyCode(cvv.charAt(i) + "");

                }
                pressKeyCode("NEXT");
                pressKeyCode("DONE");
//            getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                Thread.sleep(1999);
                String bankOTP = fetchAndExtractBankOtpFromAPI(rowNumber);
                System.out.println("bank otp: "+ bankOTP);
//            String bankOTP = "852369";
                String bankName = fetchValueFromExcelSheet(rowNumber, 17);
                System.out.println("bank name: "+bankName);
                if (bankName.equals("Zingoy_Transcop")) {
                    System.out.println("entering otp...");
                    pressKeyCode("NEXT");
//                    System.out.println("Second Move...");
                    pressKeyCode("NEXT");
//                    System.out.println("third Move...");
                    pressKeyCode("NEXT");
//                    System.out.println("fourth Move...");
                    pressKeyCode("NEXT");

//                    System.out.println("pressing key..");
                    Thread.sleep(999);
                    int n = bankOTP.length();
                    for (int i = 0; i < n; i++) {
                        System.out.println("digit of otp: " + bankOTP.charAt(i));
                        Thread.sleep(700);
                        char pinByDigit = bankOTP.charAt(i);
                        System.out.println("otp digit " + pinByDigit);
                        String digit = "" + pinByDigit;
                        if (digit.equals("0")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_0\"");
                        }
                        if (digit.equals("1")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_1\"");
                        }
                        if (digit.equals("2")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_2\"");
                        }
                        if (digit.equals("3")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_3\"");
                        }
                        if (digit.equals("4")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_4\"");
                        }
                        if (digit.equals("5")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_5\"");
                        }
                        if (digit.equals("6")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_6\"");
                        }
                        if (digit.equals("7")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_7\"");
                        }
                        if (digit.equals("8")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_8\"");
                        }
                        if (digit.equals("9")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_9\"");
                        }

                    }

//                    getDriver().findElement(By.id("otp")).sendKeys("0127");
//                    getDriver().findElement(By.id("otp")).sendKeys(bankOTP);
                    Thread.sleep(500);
                    System.out.println("first  Move ...");
                    pressKeyCode("NEXT");
                    Thread.sleep(500);
                    System.out.println("Second Move...");
                    pressKeyCode("NEXT");
                    Thread.sleep(500);
                    System.out.println("third Move...");
                    pressKeyCode("NEXT");
                    Thread.sleep(500);
                    pressKeyCode("ENTER");
                    Thread.sleep(500);
//                    getDriver().findElement(By.id("submitButtonId")).click();
//                    clickButtonUsingClassname("android.widget.Button", "Submit");
                    Thread.sleep(999);
                } else {
                    System.out.println("bank OTP:" + bankOTP);
                    pressKeyCode("NEXT");
                    System.out.println("First Move");
                    Thread.sleep(999);
                    pressKeyCode("NEXT");
                    System.out.println("Second Move");
                    Thread.sleep(999);
                    pressKeyCode("NEXT");
                    System.out.println("Third Move");
                    Thread.sleep(999);
//            pressKeyCode("NEXT");
//            System.out.println("Forth Move");
                    Thread.sleep(999);
                    int otpLength = bankOTP.length();
                    for (int i = 0; i < otpLength; i++) {
                        Thread.sleep(999);
                        char otpDigit = bankOTP.charAt(i);
                        System.out.println("otp digit " + otpDigit);
                        String otpDigit1 = "" + otpDigit;
//                pressKeyCode(bankOTP.charAt(i)+"");
                        System.out.println("otp digit: " + bankOTP.charAt(i));
                        if (otpDigit1.equals("0")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_0\"");
                        }
                        if (otpDigit1.equals("1")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_1\"");
                        }
                        if (otpDigit1.equals("2")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_2\"");
                        }
                        if (otpDigit1.equals("3")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_3\"");
                        }
                        if (otpDigit1.equals("4")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_4\"");
                        }
                        if (otpDigit1.equals("5")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_5\"");
                        }
                        if (otpDigit1.equals("6")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_6\"");
                        }
                        if (otpDigit1.equals("7")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_7\"");
                        }
                        if (otpDigit1.equals("8")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_8\"");
                        }
                        if (otpDigit1.equals("9")) {
                            executeCommand("adb shell input keyevent \"KEYCODE_9\"");
                        }
                    }
                    clickButtonUsingClassname("android.widget.Button", "Submit");
                    Thread.sleep(3999);
                }
            }
        }
    }



    public void getAndWriteReferenceNumber(int rowNumber) throws Throwable{
//        String dummyReferenceText = "Your transaction is processed successfully. Please note down the receipt no. #HGA3P0F3390339355662 and BBPS REF NO. HD011328BA3AAAAUJKMV for future reference.";
        waitForLoadPage();
        Thread.sleep(1999);
        for(int k=0;k<90;k++){
            int len3 = getDriver().findElements(By.className("android.view.View")).size();
            if(len3<7){
                Thread.sleep(999);
            }
        }

        int testLength = getDriver().findElements(By.className("android.webkit.WebView")).size();
        if(testLength == 0){
            System.out.println("after failed payment ..");
            pressKeyCode("NEXT");
            Thread.sleep(999);
            pressKeyCode("ENTER");
            Thread.sleep(999);
        }

        System.out.println("waiting time over : new waiting time");
        //get success text
        int len = getDriver().findElements(By.className("android.view.View")).size();
        int i;
        LOGGER.info("LEN : " + len);
        for (i = 0; i < len; i++) {
            String str = getDriver().findElements(By.className("android.view.View")).get(i).getText();
            System.out.println("i = "+i);
            System.out.println("message :"+str);
            if(str.contains("Payment processing")){
                Thread.sleep(5999);
                waitForLoadPage();
            }
        }
        //implement invalid otp/pin logic


        int len2 = getDriver().findElements(By.className("android.view.View")).size();
        int webViewLength = getDriver().findElements(By.className("android.webkit.WebView")).size();
        int btnLength = getDriver().findElements(By.className("android.widget.Button")).size();


        System.out.println("view class length after payment: "+len2);
        System.out.println("web View Length after payment: "+ webViewLength);
        System.out.println("btn Length after payment: "+ btnLength);

        if(len2>20 && btnLength ==2){
        String successMessageText = getDriver().findElements(By.className("android.view.View")).get(7).getText();
        String dummyReferenceText = getDriver().findElements(By.className("android.view.View")).get(9).getText();
        //above code
        String segments[] = dummyReferenceText.split("BBPS REF NO. ");
        String BBPS_REF_NO  = segments[segments.length - 1];
        System.out.println("BBPS_REF_No :"+BBPS_REF_NO);
        String[] split = BBPS_REF_NO.split(" for");
        String firstSubStringBBPSNo = split[0];
        System.out.println("aftre extracting BBPS REF NO. : "+firstSubStringBBPSNo);
        //write into excel  testdatadummy

        String receipt[] = dummyReferenceText.split("receipt no. ");
        String receipt_no  = receipt[segments.length - 1];
        System.out.println("receipt no. :"+receipt_no);
        String[] split2 = receipt_no.split(" and BBPS REF NO");
        String firstSubStringRecieptNo = split2[0];
        System.out.println("after extracting receipt NO. : "+firstSubStringRecieptNo);
        writeDataIntoExcelSheet(rowNumber,14,firstSubStringBBPSNo);
        writeDataIntoExcelSheet(rowNumber,15,firstSubStringRecieptNo);
        writeDataIntoExcelSheet(rowNumber,16,successMessageText);
        }else if(len2==8 && btnLength ==2){
            String successMessageText = getDriver().findElements(By.className("android.view.View")).get(7).getText();
            writeDataIntoExcelSheet(rowNumber,16,successMessageText);
        }
        else {
            System.out.println("something was wrong");
            writeDataIntoExcelSheet(rowNumber,16,"something was wrong, Bill not paid for this user");
        }

    }

    public void clickOnButton(String clsName, String btnname) throws InterruptedException{
        clickButtonUsingClassname(clsName,btnname);
        Thread.sleep(2999);
    }

    public void scrollToGivenElement(String txtName){
        scrollToElement(txtName);
    }

    public void clickOnPayNowButtonIfPayNowButtonIsVisibleOtherwiseRepeatTwoMoreTimes(int index)throws Throwable{
//        waitForLoadPage();
//        Thread.sleep(999);
//        waitForAnyRenderedElementOf(By.xpath("//*[@text=\"CONTINUE\"]"),By.xpath("//*[@text=\"PAY NOW\"]"));
//        try{
//            withTimeoutOf(15, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//*[@text=\"billDetails\"]"));
//        }catch (Exception e){
//            withTimeoutOf(15, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//*[@text=\"CONTINUE\"]"));
//        }

        for(int k=0;k<3;k++) {
            int buttonClassLength = getDriver().findElements(By.className("android.widget.Button")).size();
            if (buttonClassLength > 0) {
                String str = getDriver().findElements(By.className("android.widget.Button")).get(0).getText();
                if (str.equals("CONTINUE") || str.contains("CONTINUE")) {
//                    clickButtonUsingClassname("android.widget.Button", "CONTINUE");
                    getDriver().findElement(By.xpath("//*[@text=\"CONTINUE\"]")).click();
                    getBillerNameFromExcelAndSelectonApp(index);
                    enterKNumber(index);
                    clickConfirmButton();
//                    waitForLoadPage();
                    Thread.sleep(500);
                    if (k == 3) {
                        String str1 = getDriver().findElements(By.className("android.widget.Button")).get(0).getText();
                        if (str1.equals("CONTINUE") || str.contains("CONTINUE")) {
                            pressKeyCode("DOUBLEBACK");
                            goOnHomePage();
                            goOnHomePage();
                        }
                    }
                }
            }
        }
        int webviewElementLenght = getDriver().findElements(By.className("android.webkit.WebView")).size();
        int buttonClassLength1 = getDriver().findElements(By.className("android.widget.Button")).size();
        System.out.println("Length of web view class on paynow page: "+webviewElementLenght );
        System.out.println("Length of button class on paynow page : "+buttonClassLength1 );
        System.out.println("Scrolling started ...");
        if (webviewElementLenght==2 && buttonClassLength1==0){
            scrollToElement("PAY NOW");
        }
    }

    public void goOnHomePage()throws Throwable{
//        Thread.sleep(1999);
//        clickButtonUsingClassname("android.widget.TextView","Bill pay");
        int len = getDriver().findElements(By.className("android.widget.TextView")).size();
        int i;
        LOGGER.info("Looking for Bill pay button");
        int len3 = getDriver().findElements(By.xpath("android.widget.TextView[@text='Electricity']")).size();
        System.out.println("Electricty button lenghth: "+ len3);
        int len4 = getDriver().findElements(By.xpath("android.widget.TextView[@text()='Electricity']")).size();
        System.out.println("Electricty button lenghth: "+ len4);
        if(len3>0 || len4>0){
            pressKeyCode("BACK");
        }

    }
    public void clickOnBackButtonOfTextIsVisible()throws Throwable{
        waitForLoadPage();
        doubleClickOnBackButtonIfTextIsVisible("android.widget.TextView","Electricity");
    }

    public void goBackOnBillPayPageFromAnyPage() throws Throwable{
        Thread.sleep(1999);

        String xpthBillPayField = "//*[@text=\"Bill pay\"]";
        int xpthBillPayLength = getDriver().findElements(By.xpath(xpthBillPayField)).size();
        System.out.println("xpthBillPayLength lenght: "+ xpthBillPayLength);
        if(xpthBillPayLength == 0) {

            String xpth = "//*[@text=\"Utility / Bill Pay\"]";
            int len = getDriver().findElements(By.xpath(xpth)).size();
            System.out.println("x path of Utility / Bill Pay element : " + len);

            int classLength = getDriver().findElements(By.className("android.widget.TextView")).size();
            System.out.println("Length of Textview class element : " + classLength);
            Thread.sleep(999);

            //go previous page from Utility / Bill Pay Element
            if (len > 0) {
                pressKeyCode("BACK");
                System.out.println("user is on home page ..");
            }
            String xpthRecentTransaction = "//*[@text=\"RECENT TRANSACTIONS\"]";
            int xpthRecentTransactionLen = getDriver().findElements(By.xpath(xpthRecentTransaction)).size();
            System.out.println("x path of Recent Transaction : " + xpthRecentTransactionLen);
            if (xpthRecentTransactionLen > 0) {
                pressKeyCode("DOUBLEBACK");
                Thread.sleep(999);
                pressKeyCode("BACK");
            }

            String xpathOfPayNow = "//*[@text=\"PAY NOW\"]";
            int xpathOfPayNowLen = getDriver().findElements(By.xpath(xpathOfPayNow)).size();
            System.out.println("x path of Pay Now Button : " + xpathOfPayNowLen);
            if (xpathOfPayNowLen > 0) {
                pressKeyCode("DOUBLEBACK");
                Thread.sleep(999);
                pressKeyCode("BACK");
            }

            String xpthInvalidAccountNo = "//*[@text=\"Incorrect or invalid customer account\"]";
            int invalidKnumberMsgLength = getDriver().findElements(By.xpath(xpthInvalidAccountNo)).size();
            System.out.println("x path of invalidKnumberMsgLength : " + invalidKnumberMsgLength);
            if (invalidKnumberMsgLength > 0) {
                pressKeyCode("DOUBLEBACK");
                Thread.sleep(999);
                pressKeyCode("BACK");
            }
        }
        Thread.sleep(1999);
    }

    public void addPaymentCardOnLinkedCardPage(int rowNumber) throws Throwable{
        //do not add card if previous user and next userid ,CardNumber is same
        String currentUser =fetchValueFromExcelSheet(rowNumber,0);
        String previousUser = fetchValueFromExcelSheet(rowNumber-1,0);
        String currentUserCardNumber =fetchValueFromExcelSheet(rowNumber,8);
        String previusUserCardNumber = fetchValueFromExcelSheet(rowNumber-1,8);
        System.out.println("current UserId :"+currentUser +", and current user cardNumber: "+currentUserCardNumber);
        System.out.println("previous UserId :"+previousUser +", and previous user cardNumber: "+previusUserCardNumber);
        withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//*[@text=\"Linked cards\"]"));
//        Thread.sleep(999);
        if((currentUser.equals(previousUser)) && (currentUserCardNumber.equals(previusUserCardNumber))){
            //do nothing
        }
        else {
            clickButtonUsingClassname("android.widget.TextView", "Linked cards");
            //enter card holder name
            withTimeoutOf(10, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//*[@text=\"Add Card\"]"));
            waitForLoadPage();

            rowNumber = 1;
            int webViewLength = getDriver().findElements(By.className("android.webkit.WebView")).size();
            int btnLength = getDriver().findElements(By.className("android.widget.Button")).size();
            System.out.println("web View Length on Pay Add Card popup: " + webViewLength);
            System.out.println("btn Length on Pay Add Card popup: " + btnLength);
            //get card Number from excel sheet
//            String cardHolderName = "JaiParkash";
            String cardHolderName = fetchValueFromExcelSheet(rowNumber,7);
            int cardHolderLength = cardHolderName.length();
            for (int i = 0; i < cardHolderLength; i++) {
                pressKeyCode(cardHolderName.charAt(i) + "");
            }
            //move to down arrow
            Thread.sleep(999);
            System.out.println("move to card number field...");
            pressKeyCode("done");
            Thread.sleep(999);
            //
            if (webViewLength == 0 && btnLength == 1) {
                String cardNumber = fetchValueFromExcelSheet(rowNumber, 8);
                System.out.println("value of cardNumber " + cardNumber);
                int cardNumberLength = cardNumber.length();
                for (int i = 0; i < cardNumberLength; i++) {
                    pressKeyCode(cardNumber.charAt(i) + "");
                }
                pressKeyCode("done");
                //enter expiry card date
                String expiryDate = fetchValueFromExcelSheet(rowNumber, 9);
                System.out.println("expiry Date: " + expiryDate);
                String month = expiryDate.substring(0, 2);
                int mongthLength = month.length();
                for (int i = 0; i < mongthLength; i++) {
                    pressKeyCode(month.charAt(i) + "");
                }
                String year = expiryDate.substring(2, 4);
                String fullYear = "20" + year;
                System.out.println("Month: " + month + " and Year :" + fullYear);
                int yearLength = fullYear.length();
                for (int i = 0; i < yearLength; i++) {
                    pressKeyCode(fullYear.charAt(i) + "");
                }
//        pressKeyUsingKeyCode();
                Thread.sleep(500);
//            clickTabButton();
                getDriver().findElement(By.className("android.widget.Button")).click();
                waitForLoadPage();
                Thread.sleep(1999);
                pressKeyCode("BACK");
            }
        }
    }
    public void deleteTheCard(int rowNumber)throws Throwable{
//        clickButtonUsingClassname("android.widget.Button","GO TO HOME");
        int len2 = getDriver().findElements(By.className("android.view.View")).size();
        int webViewLength = getDriver().findElements(By.className("android.webkit.WebView")).size();
        int btnLength = getDriver().findElements(By.className("android.widget.Button")).size();
        System.out.println("view class length after payment: "+len2);
        System.out.println("web View Length after payment: "+ webViewLength);
        System.out.println("btn Length after payment: "+ btnLength);
        String successMessageText = getDriver().findElements(By.className("android.view.View")).get(7).getText();
        if((len2>20 && btnLength ==2) || successMessageText.contains("technical failure") ||successMessageText.contains("SUCCESS")) {
            pressKeyCode("BACK");
            pressKeyCode("BACK");
            Thread.sleep(999);
            pressKeyCode("BACK");
            //do not delete card if Next row Userid and Card umber is same
            String currentUser =fetchValueFromExcelSheet(rowNumber,0);
            String nextUser = fetchValueFromExcelSheet(rowNumber+1,0);
            String currentUserCardNumber =fetchValueFromExcelSheet(rowNumber,8);
            String nextUserCardNumber = fetchValueFromExcelSheet(rowNumber+1,8);
            System.out.println("current UserId :"+currentUser +", and current user cardNumber: "+currentUserCardNumber);
            System.out.println("Next UserId :"+nextUser +", and next user cardNumber: "+nextUserCardNumber);

            if ((currentUser.equals(nextUser)) && (currentUserCardNumber.equals(nextUserCardNumber))) {
                //do nothing
            }
            else {
                //delete the card
                Thread.sleep(2999);
                clickButtonUsingClassname("android.widget.TextView", "Linked cards");
                pressKeyCode("NEXT");
                Thread.sleep(1999);
                pressKeyCode("NEXT");
                Thread.sleep(999);
                pressKeyCode("NEXT");
                Thread.sleep(500);
                pressKeyCode("NEXT");
                Thread.sleep(500);
                pressKeyCode("NEXT");
                Thread.sleep(500);
                pressKeyCode("NEXT");
//        System.out.println("last Next");
                Thread.sleep(500);
                pressKeyCode("DONE");
                Thread.sleep(2000);
//            pressKeyCode("NEXT");
//            Thread.sleep(500);
//            pressKeyCode("NEXT");
                Thread.sleep(500);
                pressKeyCode("ENTER");
                Thread.sleep(1999);
                pressKeyCode("DOUBLEBACK");
            }

        }
    }

    public void extractOTP(){
        String otp = "564575 is your Zingoy Transcorp Card 0127 OTP. Dont share the OTP with anyone. Visit www.zingoy.com if unauthorized";
        String separator =" is your Zingoy";
        int sepPos = otp.lastIndexOf(separator);
        System.out.println("Substring before last separator = "+otp.substring(0,sepPos));
//        String s = otp.substring(0,sepPos);
//        String[] split = s.split("Zingoy Transcorp Card ");
//        String firstSubString = split[0];
//        String secondSubString = split[1];
//        System.out.println("firstSubString "+firstSubString);
//        System.out.println("secondSubString "+secondSubString);
        String StrinhOTP =otp.substring(0,sepPos);
        System.out.println("otp is "+ StrinhOTP);
    }
}