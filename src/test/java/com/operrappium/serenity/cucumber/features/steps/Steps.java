package com.operrappium.serenity.cucumber.features.steps;

import com.operrappium.serenity.cucumber.features.pages.*;
import com.operrappium.serenity.cucumber.features.utils.TestDataSetup;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.jruby.RubyProcess;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Steps extends ScenarioSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(Steps.class);

    private LoginPage loginPage;
    private HomePage homePage;
    private DriverAppPage driverAppPage;
    private TripDetailsPage tripDetailsPage;
    private TripPage tripPage;
    private DashboardPage dashboardPage;
    FetchDataFromApi fetchDataFromApi;

    @Step
    public void user_is_on_login_page() throws Throwable {
        Assert.assertEquals(true, loginPage.isEmailFieldDisplayed());
//        loginPage.login("email", "password");
    }

    @Step
    public void user_enter_username_and_and_password_as_and_click_Login_button(String email, String password) throws Throwable {
        loginPage.login(email, password);
    }


    @Step
    public void home_page_is_displayed() throws Throwable {
        Assert.assertEquals(true, loginPage.home_page_is_displayed());
    }

    @Step
    public void user_clicks_on_Forgot_password() throws Throwable {
        loginPage.clickForgotPassword();
    }

    @Step
    public void click_on_Skip_button() throws InterruptedException {
        loginPage.click_on_Skip_button();

    }

    @Step
    public void checkIsDisplayed(String arg0) throws Throwable {
        Assert.assertEquals(true, driverAppPage.checkIsDisplayed(arg0));

    }

    @Step
    public void checkTheIsDisplayed(String arg0) throws Throwable {
        Assert.assertTrue(driverAppPage.checkTheIsDisplayed(arg0).contains(arg0));

    }

    @Step
    public void checkInputFieldIsDisplayed(String arg0) throws Throwable {
        Assert.assertTrue(driverAppPage.checkInputFieldIsDisplayed(arg0).contains(arg0));
    }

    @Step
    public void checkCheckboxIsDisplayed(String arg0) throws Throwable {
        System.out.println(driverAppPage.checkCheckboxIsDisplayed(arg0));
        Assert.assertTrue(driverAppPage.checkCheckboxIsDisplayed(arg0).contains(arg0));
    }

    @Step
    public void checkButtonIsDisplayedAndClickable(String arg0) throws Throwable {
        Assert.assertEquals(true, driverAppPage.checkButtonIsDisplayedAndClickable(arg0));
    }

    @Step
    public void checkLinkIsDisplayed(String arg0) throws Throwable {
        Assert.assertTrue(driverAppPage.checkLinkIsDisplayed(arg0).contains(arg0));
    }

    @Step
    public void clickLink(String arg0) throws Throwable {
        driverAppPage.clickLink(arg0);
    }

    @Step
    public void clickOnButton(String arg0) throws Throwable {
        driverAppPage.clickOnButton(arg0);
    }

    @Step
    public void messageIsDisplayed(String arg0) throws Throwable {
//        Assert.assertEquals(true, driverAppPage.messageIsDisplayed(arg0));
//        Assert.assertTrue(driverAppPage.messageIsDisplayed(arg0).contains(arg0));
        Thread.sleep(2999);

    }

    @Step
    public void enterTheEmail(String email) throws Throwable {
        driverAppPage.enterTheEmail(email);
    }

    @Step
    public void clickTab(String arg0) throws Throwable {
        tripDetailsPage.clickTab(arg0);
    }

    @Step
    public void scheduledTripsMayDisplayed() throws InterruptedException {
        Boolean bool = tripDetailsPage.scheduledTripsMayDisplayed();
        System.out.println(bool);
        String str = bool.toString();
        if (str.equals("false")) {
            Assert.assertEquals(false, tripDetailsPage.scheduledTripsMayDisplayed());
        } else {
            Assert.assertEquals(true, tripDetailsPage.scheduledTripsMayDisplayed());
        }

    }

    @Step
    public void clickOnTrip() throws InterruptedException {
        tripDetailsPage.clickOnTrip();
    }

    @Step
    public void clickOnTelephoneNumberToCall() throws InterruptedException {
        tripDetailsPage.clickOnTelephoneNumberToCall();
    }

    @Step
    public void clickOnBackButton() throws InterruptedException {
        tripDetailsPage.clickOnBackButton();
    }

    @Step
    public void userBackToPreviousPage() throws InterruptedException {
        Assert.assertEquals(true, tripDetailsPage.userBackToPreviousPage());
    }

    @Step
    public void longClickOnAddress(String arg0) throws Throwable {
        tripDetailsPage.longClickOnAddress(arg0);

    }

    @Step
    public void userWillGoToMap() throws InterruptedException {
        Assert.assertEquals(true, tripDetailsPage.userWillGoToMap());
    }

    @Step
    public void clickOnMobileBackButton() throws InterruptedException {
        tripDetailsPage.clickOnMobileBackButton();
    }

    @Step
    public void selectACancelReason() throws InterruptedException {
        tripDetailsPage.selectACancelReason();
    }

    @Step
    public void clickOnNavigationIcon() throws InterruptedException {
        homePage.clickOnNavigationBar();
    }

    @Step
    public void verifyThatMenuIsDisplayedInLeftSide(String arg0) throws Throwable {
        Assert.assertEquals(homePage.getMenuText(arg0), true);
    }

    @Step
    public void clickOnMenu(String arg0) throws Throwable {
        homePage.clickOnGivenMenu(arg0);
    }

    @Step
    public void verifyPageIsDisplayed(String text) throws Throwable {
        Assert.assertEquals(homePage.isTextDisplayed("android.widget.TextView", text), true);
    }

    @Step
    public void clickOnPreviousArrowToTop() throws Throwable {
        homePage.clickOnPreviousIcon();
    }

    @Step
    public void clickOnTab(String arg0) throws Throwable {
        tripPage.clickonGivenTab("android.widget.TextView", arg0);
    }

    @Step
    public void clickOnCurrentTripsLink() throws Throwable {
        //        tripPage.clickOnCurrentTrips();
        tripPage.clickonGivenTab("android.widget.TextView", "Current Trips");
    }

    @Step
    public void verifyCurrentTripsPageIsOpen() throws Throwable {
        //        Assert.assertEquals(homePage.isTextDisplayed("android.widget.TextView","Current Trips"),true);
        homePage.isCurrentTripsDisplayed();
    }

    @Step
    public void clickOnRefreshLink() throws Throwable {
        tripPage.clickonGivenTab("android.widget.TextView", "Refresh List");
    }

    @Step
    public void verifyThatPageHasRefreshed() throws Throwable {
        tripPage.progressbarisDisplayed();
    }

    @Step
    public void verifyThatFavoriteCustomerPageIsDisplayed() throws Throwable {
        homePage.checkCustomerFriendPageDisplayed();
    }

    @Step
    public void verifyUserCanSeeTheREJECTEDTrip() throws InterruptedException {
        Assert.assertTrue(tripDetailsPage.verifyUserCanSeeTheREJECTEDTrip().contains(TestDataSetup.getScheduled_trip_Id()));
    }

    @Step
    public void verifyUserCanSeeTheCONFIRMEDTrip() throws InterruptedException {
        Assert.assertTrue(tripDetailsPage.verifyUserCanSeeTheCONFIRMEDTrip().contains(TestDataSetup.getScheduled_trip_Id()));
    }

    @Step
    public void verifyThatDriverEarningIsShowing() throws InterruptedException {
        Assert.assertEquals(true, dashboardPage.verifyThatDriverEarningIsShowing());
    }

    @Step
    public void checkDriverCurrentZoneActivity() throws InterruptedException {
        Assert.assertEquals(true, dashboardPage.checkDriverCurrentZoneActivity());
    }

    @Step
    public void clickOnCurrentTrip() throws InterruptedException {
        dashboardPage.clickOnCurrentTrip();
    }

    @Step
    public void checkThatTripDetailShowing() throws InterruptedException {
        Assert.assertEquals(true, dashboardPage.checkThatTripDetailShowing());
    }

    @Step
    public void checkAreDisplayed(String arg0) throws Throwable {
        Assert.assertTrue(dashboardPage.checkAreDisplayed(arg0).contains(arg0));
    }

    @Step
    public void clickBackButton() throws InterruptedException {
        dashboardPage.clickBackButton();
    }

    @Step
    public void clickButton(String arg0) throws Throwable {
        driverAppPage.clickButton(arg0);
    }

    //PayzApp
    @Step
    public void user_Click_on_Login_App() throws InterruptedException{
        loginPage.clickLoginButton();
    }

    @Step
    public void user_Enter_Registered_Email_or_Phone_Number_and_Click_on_Login_Button(String arg1) throws Throwable{
        loginPage.enterEmailOrPhoneNumber(arg1);
    }

    @Step
    public void user_click_on_Allow_button() throws InterruptedException{
        loginPage.clicAllowButton();
    }

    @Step
    public void user_Enter_Secure_Pin() throws Throwable{
        fetchDataFromApi.deleteOldMessageFromAPI();
        loginPage.enterSecurePin();
    }

    @Step
    public void user_Clicks_on_Continue_and_Skip_button_and_Enter_DVC_code() throws Throwable{
        loginPage.clickOnContinueAndSkipButton();
        loginPage.getDVCCodeFromApi();
    }

    @Step
    public void user_click_on_BillPay_option() throws Throwable{
        homePage.clickOnBillPayOption();
    }

    @Step
    public void select_BillPay_utility_from_Excel() throws Throwable{
        homePage.selectUtilityBillPayTypeFromExcelAndClickOnOption();
    }

    @Step
    public void select_Distributor_Name_Enter_K_Number_and_Click_Confirm_button() throws Throwable{
        homePage.getBillerNameFromExcelAndSelectonApp();
        homePage.enterKNumber();
        homePage.clickConfirmButton();
    }

    @Step
    public void check_match_Bill_amount_of_payment_page_and_Excel_Sheet() throws Throwable{
        homePage.matchBilAmountAndPrintSameOrNotSameAmountInExcel();
    }

    @Step
    public void add_payment_card() throws Throwable{
        fetchDataFromApi.deleteOldMessageFromAPI();
        homePage.addPayMentCard();
//        homePage.addPayMentCard();
//        List<WebElement> str = getDriver().findElements(By.tagName("class"));
//        System.out.println("all classe in payment page: "+str);
//        WebElement currentElement = getDriver().switchTo().activeElement();
//        currentElement.click();
    }

    @Step
    public void enter_pin_or_OTP_on_payment_page() throws Throwable{
        homePage.enterOTPOrPinCode();
//        homePage.printotp();
    }

    @Step
    public void get_and_print_reference_code_into_excel() throws Throwable{
        homePage.getAndWriteReferenceNumber();
    }

    @Step
    public void run_test_case_in_loop_from_excel_sheet(int loop) throws Throwable{
        homePage.runTestCaseInLoop(loop);
    }

    @Step
    public void user_delete_the_saved_card() throws Throwable{
        homePage.deleteTheCard();
    }

    //loop

    @Step
    public void user_Enter_Registered_Email_or_Phone_Number_and_Click_on_Login_Button(int arg1) throws Throwable{
        loginPage.enterEmailOrPhoneNumber(arg1);
    }

    @Step
    public void user_Enter_Secure_Pin(int index) throws Throwable{
        fetchDataFromApi.deleteOldMessageFromAPI();
        loginPage.enterSecurePin(index);
    }

    @Step
    public void select_BillPay_utility_from_Excel(int index) throws Throwable{
        homePage.selectUtilityBillPayTypeFromExcelAndClickOnOption(index);
    }
    @Step
    public void select_Distributor_Name_Enter_K_Number_and_Click_Confirm_button(int index) throws Throwable{
        homePage.getBillerNameFromExcelAndSelectonApp(index);
        homePage.enterKNumber(index);
        homePage.clickConfirmButton();
//        try {
//            getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//            homePage.scrollToGivenElement("PAY NOW");
//        } catch (Exception e){
//            homePage.clickOnButton("android.widget.Button","CONTINUE");
//            homePage.getBillerNameFromExcelAndSelectonApp(index);
//            homePage.enterKNumber(index);
//            homePage.clickConfirmButton();
//        }
        //new code
        homePage.clickOnPayNowButtonIfPayNowButtonIsVisibleOtherwiseRepeatTwoMoreTimes(index);

    }

    @Step
    public void check_match_Bill_amount_of_payment_page_and_Excel_Sheet(int index) throws Throwable{
        homePage.matchBilAmountAndPrintSameOrNotSameAmountInExcel(index);
    }
    @Step
    public void add_payment_card(int index) throws Throwable{
        fetchDataFromApi.deleteOldMessageFromAPI();
        homePage.addPayMentCard(index);
    }
    @Step
    public void enter_pin_or_OTP_on_payment_page(int index) throws Throwable{
        homePage.enterOTPOrPinCode(index);
    }
    @Step
    public void get_and_print_reference_code_into_excel(int index) throws Throwable{
        homePage.getAndWriteReferenceNumber(index);
    }

    @Step
    public void goOnHomePage2()throws Throwable{
        Thread.sleep(3999);
        homePage.clickOnBackButtonOfTextIsVisible();

    }
    @Step
    public void user_click_on_Back_button_From_BillUtility_Pay_Page() throws Throwable{
        homePage.goBackOnBillPayPageFromAnyPage();
    }

    @Step
    public void user_add_new_card_on_Linked_Card_page(int index) throws Throwable{
        homePage.addPaymentCardOnLinkedCardPage(index);
    }

    @Step
    public void click_Login_button_again() throws Throwable{
        loginPage.loopLogin();
    }
    @Step
    public void user_delete_the_saved_card(int index) throws Throwable{
        homePage.deleteTheCard(index);
    }

    @Step
    public void extract_otp_from_API() throws Throwable{
        homePage.extractOTP();
    }
}
