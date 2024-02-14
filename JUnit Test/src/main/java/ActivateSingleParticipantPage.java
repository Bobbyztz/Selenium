import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**

 * This class represents the manageParticipate Page for the testing.

 */
public class ActivateSingleParticipantPage {
    private final WebDriver DRIVER;
    private final String EMAIL ="14@w.edu";

    private final String PAGE_URL = "/";
    private final By SEARCH_INPUT = By.cssSelector("input[type='search'][aria-controls='participant_table']");

    private final By TABLE_ROW = By.xpath("//tr[td='" + EMAIL + "']");

    private final By DEACTIVATE_BUTTON = By.id("deactivate_btn");

    private final By VIEW_INACTIVE_BUTTON = By.id("view_inactive_btn");

    private final By REACTIVATE_BUTTON = By.id("reactivate_btn");

    /**

     * Initializes a new instance of the ActivateSingleParticipantPage class.

     *

     * @param driver The WebDriver instance to use for interacting with the page.

     */
    public ActivateSingleParticipantPage(WebDriver driver) {
        this.DRIVER = driver;
    }

    /**

     * Click the manageParticipant.

     */
    public void goToManageParticipantsPage() {
        //driver.findElement(manageParticipantsLink).click();
        DRIVER.get(PAGE_URL);
    }

    /**

     * Enter the text to be searched in the textarea.

     */
    public void enterSearch() {
        DRIVER.findElement(SEARCH_INPUT).sendKeys(EMAIL);
    }

    /**

     * Check if the item exists after searching a certain member.

     */
    public boolean doesTableRowExist(){
        //return driver.findElement(tableRow).isDisplayed();
        try{
            return DRIVER.findElement(TABLE_ROW).isDisplayed();
        }catch (Exception e) {
            return false;
        }
    }

    /**

     * Click the required row which has the information after checking the existence.

     */
    public void clickTableRow() {
        DRIVER.findElement(TABLE_ROW).click();
    }

    /**

     * Check if the deactivate button exists.

     */
    public boolean doesDeactivateButtonExist() {
        return !DRIVER.findElements(DEACTIVATE_BUTTON).isEmpty();
    }


    /**

     * Check if the deactivate button is clickable.

     */
    public boolean isDeactivateButtonClickable() {
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(1)); // Adjust the timeout as needed
        try {
            wait.until(ExpectedConditions.elementToBeClickable(DEACTIVATE_BUTTON));
            return true;
        } catch (TimeoutException e) {
            //System.out.println("The button exists but is not clickable.");
            return false;
        }
    }

    /**

     * Click the deactivate button after checking the existence.

     */
    public void clickDeactivateButton() {
        DRIVER.findElement(DEACTIVATE_BUTTON).click();
    }

    /**

     * Check if the view inactive button exists.

     */
    public boolean doesViewInactiveButtonExist() {
        return !DRIVER.findElements(VIEW_INACTIVE_BUTTON).isEmpty();
    }

    /**

     * Check if the view inactive button is clickable.

     */
    public boolean isViewInactiveButtonClickable() {
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(1)); // Adjust the timeout as needed
        try {
            wait.until(ExpectedConditions.elementToBeClickable(VIEW_INACTIVE_BUTTON));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**

     * Click the View inactivate button.

     */
    public void clickViewInactiveButton() {
        DRIVER.findElement(VIEW_INACTIVE_BUTTON).click();
    }

    public boolean doesReactivateButtonExist() {
        return !DRIVER.findElements(REACTIVATE_BUTTON).isEmpty();
    }

    /**

     * Check if the reactivate button is clickable.

     */
    public boolean isReactivateButtonClickable() {
        WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(1)); // Adjust the timeout as needed
        try {
            wait.until(ExpectedConditions.elementToBeClickable(REACTIVATE_BUTTON));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**

     * Click the reactivate button.

     */
    public void clickReactivateButton() {
        DRIVER.findElement(REACTIVATE_BUTTON).click();
    }


}
