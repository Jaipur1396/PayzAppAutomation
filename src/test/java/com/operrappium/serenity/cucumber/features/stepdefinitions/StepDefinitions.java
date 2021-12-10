package com.operrappium.serenity.cucumber.features.stepdefinitions;

import com.operrappium.serenity.cucumber.features.pages.BasePage;
import com.operrappium.serenity.cucumber.features.pages.HomePage;
import com.operrappium.serenity.cucumber.features.pages.LoginPage;
import com.operrappium.serenity.cucumber.features.steps.Steps;
import com.operrappium.serenity.cucumber.features.utils.TestDataSetup;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefinitions extends BasePage{

    public static final Logger LOGGER = LoggerFactory.getLogger(StepDefinitions.class);

    @net.thucydides.core.annotations.Steps
    Steps steps;
    LoginPage loginPage;

    @Before
    public void setPlatform() {
        String platform = System.getProperty("testEnvironment");
        if (platform == null) {
            platform = "Android";
        }
        LOGGER.info("The platform is " + platform);
        if (platform.compareToIgnoreCase("android") == 0) {
            BasePage.setAndroid(true);
            BasePage.setIOS(false);
        } else {
            BasePage.setAndroid(false);
            BasePage.setIOS(true);
        }
    }

    @After
    public void closeApp() {
        loginPage.closeApp();
    }


    @Given("^user is on login page$")
    public void user_is_on_login_page() throws Throwable {
        LOGGER.info("user is on login page");
        steps.user_is_on_login_page();
    }

    @Given("^user enter username and \"([^\"]*)\" and password as \"([^\"]*)\" and click Login button$")
    public void user_enter_username_and_and_password_as_and_click_Login_button(String email, String password) throws Throwable {
        steps.user_enter_username_and_and_password_as_and_click_Login_button(email, password);
    }

    @Then("^home page is displayed$")
    public void home_page_is_displayed() throws Throwable {
        steps.home_page_is_displayed();
    }

    @Given("^user clicks on Forgot password$")
    public void user_clicks_on_Forgot_password() throws Throwable {
        steps.user_clicks_on_Forgot_password();
    }

    @Then("^click on Skip button$")
    public void click_on_Skip_button() throws InterruptedException {
        steps.click_on_Skip_button();

    }

    @And("^check \"([^\"]*)\" is displayed$")
    public void checkIsDisplayed(String arg0) throws Throwable {
        steps.checkIsDisplayed(arg0);

    }

    @And("^check the \"([^\"]*)\" is displayed$")
    public void checkTheIsDisplayed(String arg0) throws Throwable {
        steps.checkTheIsDisplayed(arg0);
    }

    @And("^check \"([^\"]*)\" input field is displayed$")
    public void checkInputFieldIsDisplayed(String arg0) throws Throwable {
        steps.checkInputFieldIsDisplayed(arg0);
    }

    @And("^check \"([^\"]*)\" checkbox is displayed$")
    public void checkCheckboxIsDisplayed(String arg0) throws Throwable {
        steps.checkCheckboxIsDisplayed(arg0);
    }

    @And("^check \"([^\"]*)\" button is displayed and clickable$")
    public void checkButtonIsDisplayedAndClickable(String arg0) throws Throwable {
        steps.checkButtonIsDisplayedAndClickable(arg0);
    }

    @And("^check \"([^\"]*)\" link is displayed$")
    public void checkLinkIsDisplayed(String arg0) throws Throwable {
        steps.checkLinkIsDisplayed(arg0);
    }

    @And("^click \"([^\"]*)\" link$")
    public void clickLink(String arg0) throws Throwable {
        steps.clickLink(arg0);

    }

    @And("^click on \"([^\"]*)\" button$")
    public void clickOnButton(String arg0) throws Throwable {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.clickOnButton(arg0);
        }
    }

    @Then("^message \"([^\"]*)\" is displayed$")
    public void messageIsDisplayed(String arg0) throws Throwable {
        steps.messageIsDisplayed(arg0);
    }

    @Then("^enter the email \"([^\"]*)\"\\.$")
    public void enterTheEmail(String email) throws Throwable {
        steps.enterTheEmail(email);
    }

    @And("^click \"([^\"]*)\" Tab$")
    public void clickTab(String arg0) throws Throwable {
        steps.clickTab(arg0);
    }

    @Then("^Scheduled Trips may displayed$")
    public void scheduledTripsMayDisplayed() throws InterruptedException {
        steps.scheduledTripsMayDisplayed();
    }

    @And("^click on trip$")
    public void clickOnTrip() throws InterruptedException {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.clickOnTrip();
        }
    }

    @Then("^click on Telephone number to call$")
    public void clickOnTelephoneNumberToCall() throws InterruptedException {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.clickOnTelephoneNumberToCall();
        }
    }

    @And("^Click on Back button$")
    public void clickOnBackButton() throws InterruptedException {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.clickOnBackButton();
        }
    }

    @Then("^user Back to previous page$")
    public void userBackToPreviousPage() throws InterruptedException {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.userBackToPreviousPage();
        }
    }

    @And("^Long Click on \"([^\"]*)\" address$")
    public void longClickOnAddress(String arg0) throws Throwable {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.longClickOnAddress(arg0);
        }

    }

    @Then("^user will go to map$")
    public void userWillGoToMap() throws InterruptedException {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.userWillGoToMap();
        }
    }

    @Then("^click on mobile back button$")
    public void clickOnMobileBackButton() throws InterruptedException {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.clickOnMobileBackButton();
        }

    }

    @Then("^Select a Cancel Reason$")
    public void selectACancelReason() throws InterruptedException {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.selectACancelReason();
        }
    }

    @And("^Click on navigation icon$")
    public void clickOnNavigationIcon() throws InterruptedException {
        steps.clickOnNavigationIcon();
    }

    @Then("^Verify that \"([^\"]*)\" menu is displayed in left side$")
    public void verifyThatMenuIsDisplayedInLeftSide(String menuName) throws Throwable {
        steps.verifyThatMenuIsDisplayedInLeftSide(menuName);
    }

    @And("^click on \"([^\"]*)\" menu$")
    public void clickOnMenu(String arg0) throws Throwable {
        steps.clickOnMenu(arg0);
    }

    @Then("^Verify \"([^\"]*)\" page is displayed$")
    public void verifyPageIsDisplayed(String arg0) throws Throwable {
        steps.verifyPageIsDisplayed(arg0);
    }

    @And("^Click on previous arrow to Top$")
    public void clickOnPreviousArrowToTop() throws Throwable {
        steps.clickOnPreviousArrowToTop();
    }

    @Then("^Verify \"([^\"]*)\" tab is displayed$")
    public void verifyTabIsDisplayed(String arg0) throws Throwable {
        steps.verifyPageIsDisplayed(arg0);
    }

    @And("^Click on \"([^\"]*)\" tab$")
    public void clickOnTab(String arg0) throws Throwable {
        steps.clickOnTab(arg0);
    }

    @And("^click on current Trips link$")
    public void clickOnCurrentTripsLink() throws Throwable {
        steps.clickOnCurrentTripsLink();
    }

    @Then("^Verify current trips page is open$")
    public void verifyCurrentTripsPageIsOpen() throws Throwable {
        steps.verifyCurrentTripsPageIsOpen();
    }

    @And("^click on Refresh link$")
    public void clickOnRefreshLink() throws Throwable {
        steps.clickOnRefreshLink();
    }

    @Then("^Verify that page has refreshed$")
    public void verifyThatPageHasRefreshed() throws Throwable {
        steps.verifyThatPageHasRefreshed();
    }

    @Then("^Verify that Favorite customer page is displayed$")
    public void verifyThatFavoriteCustomerPageIsDisplayed() throws Throwable {
        steps.verifyThatFavoriteCustomerPageIsDisplayed();
    }

    @Then("^Verify user can see the REJECTED trip$")
    public void verifyUserCanSeeTheREJECTEDTrip() throws InterruptedException {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.verifyUserCanSeeTheREJECTEDTrip();
        }
    }

    @Then("^Verify user can see the CONFIRMED trip$")
    public void verifyUserCanSeeTheCONFIRMEDTrip() throws InterruptedException {
        if (TestDataSetup.getDoNotSkipStep().equalsIgnoreCase("N")) {
            System.out.println("Need to skip the test as scheduled trip is not present");
        } else {
            steps.verifyUserCanSeeTheCONFIRMEDTrip();
        }
    }

    @Then("^Verify that driver earning is showing$")
    public void verifyThatDriverEarningIsShowing() throws InterruptedException {
        steps.verifyThatDriverEarningIsShowing();
    }

    @And("^Check driver current zone activity$")
    public void checkDriverCurrentZoneActivity() throws InterruptedException {
        steps.checkDriverCurrentZoneActivity();
    }

    @And("^click on current trip$")
    public void clickOnCurrentTrip() throws InterruptedException {
        steps.clickOnCurrentTrip();
    }

    @And("^Check that trip detail showing$")
    public void checkThatTripDetailShowing() throws InterruptedException {
        steps.checkThatTripDetailShowing();
    }

    @And("^check \"([^\"]*)\" are displayed$")
    public void checkAreDisplayed(String arg0) throws Throwable {
        steps.checkAreDisplayed(arg0);
    }

    @And("^Click Back button$")
    public void clickBackButton() throws InterruptedException {
        steps.clickBackButton();
    }

    @And("^click \"([^\"]*)\" button$")
    public void clickButton(String arg0) throws Throwable {
        steps.clickButton(arg0);
    }

    //PayzApp
    @Given("^User Click on Login App$")
    public void user_Click_on_Login_App() throws InterruptedException{
        steps.user_Click_on_Login_App();
    }

    @Then("^User Enter Registered Email or Phone Number \"([^\"]*)\" and Click on Login Button$")
    public void user_Enter_Registered_Email_or_Phone_Number_and_Click_on_Login_Button(String arg1) throws Throwable{
        steps.user_Enter_Registered_Email_or_Phone_Number_and_Click_on_Login_Button(arg1);
    }

    @Given("^User click on Allow button$")
    public void user_click_on_Allow_button() throws InterruptedException{
        steps.user_click_on_Allow_button();
    }

    @Then("^User Enter Secure Pin$")
    public void user_Enter_Secure_Pin() throws Throwable{
        steps.user_Enter_Secure_Pin();
    }

    @Given("^User Clicks on Continue and Skip button and Enter DVC code$")
    public void user_Clicks_on_Continue_and_Skip_button_and_Enter_DVC_code() throws Throwable{
        steps.user_Clicks_on_Continue_and_Skip_button_and_Enter_DVC_code();
    }

    @Then("^User click on BillPay option$")
    public void user_click_on_BillPay_option() throws Throwable{
        steps.user_click_on_BillPay_option();
    }


    @Then("^Select BillPay utility from Excel$")
    public void select_BillPay_utility_from_Excel() throws Throwable{
        steps.select_BillPay_utility_from_Excel();
    }

    @Then("^Select Distributor Name  Enter K Number and Click Confirm button$")
    public void select_Distributor_Name_Enter_K_Number_and_Click_Confirm_button() throws Throwable{
        steps.select_Distributor_Name_Enter_K_Number_and_Click_Confirm_button();
    }

    @Then("^check match Bill amount of payment page and Excel Sheet$")
    public void check_match_Bill_amount_of_payment_page_and_Excel_Sheet() throws Throwable{
        steps.check_match_Bill_amount_of_payment_page_and_Excel_Sheet();
    }

    @Given("^Add payment card$")
    public void add_payment_card() throws Throwable{
        steps.add_payment_card();
    }

    @Then("^Enter pin or OTP on payment page$")
    public void enter_pin_or_OTP_on_payment_page() throws Throwable{
        steps.enter_pin_or_OTP_on_payment_page();
    }

    @Given("^get and print reference code into excel$")
    public void get_and_print_reference_code_into_excel() throws Throwable{
        steps.get_and_print_reference_code_into_excel();
    }

    @Given("^Run test case in loop from excel sheet$")
    public void run_test_case_in_loop_from_excel_sheet() throws Throwable{
//        int rowNumber = getRowNumberOfExcelSheet();
        int rowNumber = 2;
        setPlatform();
        System.out.println("login loop: "+ rowNumber);
        for(int i= 1 ; i < rowNumber; i++) {
            if(i==1) {
                steps.user_is_on_login_page();
                steps.user_Click_on_Login_App();
                steps.user_Enter_Registered_Email_or_Phone_Number_and_Click_on_Login_Button(i);
                steps.user_click_on_Allow_button();
                steps.user_Enter_Secure_Pin(i);
                steps.user_Clicks_on_Continue_and_Skip_button_and_Enter_DVC_code();
                loginPage.loopLogin();
            }
            //add remaining steps here
            try {
                steps.user_add_new_card_on_Linked_Card_page(i);
                steps.user_click_on_BillPay_option();
            steps.select_BillPay_utility_from_Excel(i);
            steps.select_Distributor_Name_Enter_K_Number_and_Click_Confirm_button(i);
            steps.check_match_Bill_amount_of_payment_page_and_Excel_Sheet(i);
                steps.add_payment_card(i);
                steps.enter_pin_or_OTP_on_payment_page(i);
                steps.get_and_print_reference_code_into_excel(i);
                steps.user_delete_the_saved_card(i);
            }catch (Exception e){}


            int nextRow = i+1;
            int col = 0;
            if(rowNumber!=nextRow){
            String currentLoginUserId = fetchValueFromExcelSheet(i,col);
            String nextLoginUserId = fetchValueFromExcelSheet(nextRow,col);
            System.out.println("current user :" +currentLoginUserId);
            System.out.println("next user :" +nextLoginUserId);
            System.out.println("_____________");
                Thread.sleep(999);
            if (currentLoginUserId.equals(nextLoginUserId)){
                System.out.println("next user is same...");
                steps.user_click_on_Back_button_From_BillUtility_Pay_Page();
            }

            else if (!currentLoginUserId.equals(nextLoginUserId)){
                System.out.println("next user is not same... Close the app and reopen again for new user....");
                closeApp();
                setPlatform();
                LOGGER.info("user is on login page"+ i);
                steps.user_is_on_login_page();
                steps.user_Click_on_Login_App();
                steps.user_Enter_Registered_Email_or_Phone_Number_and_Click_on_Login_Button(i+1);
                steps.user_click_on_Allow_button();
                steps.user_Enter_Secure_Pin(i+1);
                steps.user_Clicks_on_Continue_and_Skip_button_and_Enter_DVC_code();
            }
            if(nextLoginUserId.equals("END")){
                return;
            }
            }
        }

    }

    @Given("^user delete the saved card$")
    public void user_delete_the_saved_card() throws Throwable{
     steps.user_delete_the_saved_card();
    }

    @Given("^User click on Back button From BillUtility Pay Page$")
    public void user_click_on_Back_button_From_BillUtility_Pay_Page() throws Throwable{
        steps.user_click_on_Back_button_From_BillUtility_Pay_Page();
    }

    @Then("^user add new card on Linked Card page$")
    public void user_add_new_card_on_Linked_Card_page() throws Throwable{
        steps.user_add_new_card_on_Linked_Card_page(1);
    }

    @Given("^click Login button again$")
    public void click_Login_button_again() throws Throwable{
     steps.click_Login_button_again();
    }

    @Given("^extract otp from API$")
    public void extract_otp_from_API() throws Throwable{
        steps.extract_otp_from_API();
    }

}
