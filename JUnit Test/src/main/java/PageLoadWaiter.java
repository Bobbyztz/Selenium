import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is used to wait page till it finish reloading
 * 
 * Usage Example:
 * 
 * //driver will keep waiting till it's page finish reloading, or throw exception after PAGE_RELOAD_WAIT_TIME(10) sec
 * PageLoadWaiter.wait(YourWebDriver)
 * 
 * //driver will keep waiting till it's page finish reloading, or throw exception after LimitTime sec
 * PageLoadWaiter.wait(YourWebDriver,LimitTime)
 */
public class PageLoadWaiter {
    protected static int PAGE_RELOAD_WAIT_TIME = 10;
    /**
     * Waits for page to load for 10 sec.
     * @param the driver need wait.
     */
    public static void wait(WebDriver driver) {
        wait(driver, PAGE_RELOAD_WAIT_TIME);
    }

    /**
     * Waits for page to load for a specified duration.
     * @param the web driver need wait.
     * @param sec The number of seconds to wait for the page to load.
     * @throws TimeoutException if the page does not load within the specified duration.
     */
    public static void wait(WebDriver driver,int sec) {
        // If the specified duration is less than or equal to 0, return immediately without waiting
        if(sec <=0 ){
            return;
        }
        // Use WebDriverWait to wait until the page's readyState is 'complete', indicating that the page has fully loaded
        // If the page does not load within the specified duration, a TimeoutException is thrown
        try {
            new WebDriverWait(driver, Duration.ofSeconds(PAGE_RELOAD_WAIT_TIME)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (TimeoutException e) {
            throw new TimeoutException("Page did not load within " + sec + " seconds.");
        }
    }
}
