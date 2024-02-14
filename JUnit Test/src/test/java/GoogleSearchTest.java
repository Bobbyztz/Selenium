import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import example.GoogleSearchPage;

public class GoogleSearchTest {

    private WebDriver driver;
    private GoogleSearchPage googleSearchPage;

    @BeforeEach
    public void setUp() {
        // This will automatically download and set up the ChromeDriver for you
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Initialize GoogleSearchPage object
        googleSearchPage = new GoogleSearchPage(driver);
    }

    @Test
    public void testGoogleSearch() {
        googleSearchPage.navigateToGoogleHomePage();
        googleSearchPage.enterSearchText("OpenAI");
        googleSearchPage.clickSearchButton();

        // Here you can add assertions based on the search results, for simplicity, I'm skipping them in this example.
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
