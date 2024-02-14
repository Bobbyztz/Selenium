import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    private WebDriver driver;

    // Page URL
    private static final String PAGE_URL = "https://www.google.com/";

    // Web elements selectors using By
    private By searchBox = By.name("q");
    private By searchButton = By.name("btnK");

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to Google home page
    public void navigateToGoogleHomePage() {
        driver.get(PAGE_URL);
    }

    // Enter text into the search box
    public void enterSearchText(String text) {
        driver.findElement(searchBox).sendKeys(text);
    }

    // Click the search button
    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}
