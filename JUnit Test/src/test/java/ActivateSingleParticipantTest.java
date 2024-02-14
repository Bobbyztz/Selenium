import common.PageLoadWaiter;
import common.WaitSeconds;
import login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class represents the testing for the manageParticipants Page.
 */
class ActivateSingleParticipantTest {

    private WebDriver driver;
    private ActivateSingleParticipantPage page;

    boolean doWait = true;

    void wait(int seconds) {
        if (doWait){
            try {
                Thread.sleep(seconds*500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is called before each test.
     * It sets up the ChromeDriver and initializes the WebForm page.
     * It also logs in as an admin and navigates to the manageParticipants page.
     * It waits for 3 seconds after each action. You can change the wait time if needed.
     * It clicks the manageParticipants button.
     */
    @BeforeEach
    void setUp() {
        this.driver = new ChromeDriver();
        this.page = new ActivateSingleParticipantPage(driver);
        LoginPage login = new LoginPage(driver);
        login.loginAsAdmin();
        PageLoadWaiter.wait(driver,3);
        page.goToManageParticipantsPage();
        PageLoadWaiter.wait(driver,2);
    }

    /**
     * This method is called after each test.
     * It quits the ChromeDriver.
     */
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     *
     * This method tests functionalities flow of deactivate and reactivate a member.
     *
     */
    @Test
    void testSingleParticipant() {

        //deactivate a member
        WaitSeconds.wait(5);
        page.enterSearch();
        WaitSeconds.wait(6);
        clickTableRow();
        WaitSeconds.wait(1);
        doesDeactivateButtonExist();
        deactivateParticipant();

        //reactivate a member
        WaitSeconds.wait(3);
        doesViewInactiveButtonExist();
        viewInactiveParticipants();
        WaitSeconds.wait(3);
        page.enterSearch();
        WaitSeconds.wait(1);
        clickTableRow();
        WaitSeconds.wait(1);
        doesReactivateButtonExist();
        reactivateParticipant();
    }

    ///////////////////////////////////// To deactivate the participant ///////////////////////////////////////




    /**
     * This method tests the click table row functionality.
     */
    public void clickTableRow() {
        boolean isTableRowExist = page.doesTableRowExist();
        assertTrue(isTableRowExist, "Table row does not exist");
        page.clickTableRow();
        // Add assertions to validate the action if needed.
    }

    /**
     * This method tests the deactivate button existence.
     */
    public void doesDeactivateButtonExist() {
        boolean isButtonExist = page.doesDeactivateButtonExist();
        assertTrue(isButtonExist, "Deactivate Button does not exist");
    }

    /**
     * This method tests the deactivate functionality.
     */
    public void deactivateParticipant() {
        boolean isButtonClickable = page.isDeactivateButtonClickable();
        assertTrue(isButtonClickable, "Deactivate Button is not clickable");
        page.clickDeactivateButton();
        // Add assertions to validate the action if needed.
    }

    ///////////////////////////////////// To reactivate the participant ///////////////////////////////////////

    /**
     * This method tests the view inactive button existence.
     */
    public void doesViewInactiveButtonExist() {
        boolean isButtonExist = page.doesViewInactiveButtonExist();
        assertTrue(isButtonExist, "View Inactive Button does not exist");
    }

    /**
     * This method tests the view inactive participants functionality.
     */
    public void viewInactiveParticipants() {
        boolean isButtonClickable = page.isViewInactiveButtonClickable();
        assertTrue(isButtonClickable, "View Inactive Button is not clickable");
        page.clickViewInactiveButton();
        // Add assertions to validate the action if needed.
    }

    /**
     * This method tests the reactivate button existence.
     */
    public void doesReactivateButtonExist() {
        boolean isButtonExist = page.doesReactivateButtonExist();
        assertTrue(isButtonExist, "View Reactivate Button does not exist");
    }

    /**
     * This method tests the reactivate functionality.
     */
    public void reactivateParticipant() {
        boolean isButtonClickable = page.isReactivateButtonClickable();
        assertTrue(isButtonClickable, "Reactivate Button is not clickable");
        page.clickReactivateButton();
    }

}