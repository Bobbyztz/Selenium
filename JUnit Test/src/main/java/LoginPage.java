import java.util.NoSuchElementException;
import org.openqa.selenium.*;

import common.PageLoadWaiter;

/**
 * This class is responsible for managing login operations.
 * 
 * Usage Example:
 * 
 * WebDriver driver = new ChromeDriver();//create your driver
 * LoginPage login = new LoginPage(driver);//navigate to the login page and init
 * login.logAsAdmin();//login as admin
 * // after log in, the drivers url will be in the home page
 * @author Rui Zhang
 * @created 2023/09/22
 */
public class LoginPage {
    protected WebDriver driver;

    static final String LOGIN_URL = "https://";
    static final int PAGE_RELOAD_WAIT_TIME = 10;//base on second
    static final String ADMIN_EMAIL="adm@rks.com";
    static final String ADMIN_PASSWORD="fadwwdewdwew";
    // Web elements for the login page
    protected WebElement emailInput;
    protected WebElement passwordInput;
    protected WebElement signInButton;
    protected WebElement signInPageHeader;
    protected WebElement logoutLink;

    // Selectors for the web elements
    protected static final By emailInputSelector = By.name("login");
    protected static final By passwordInputSelector = By.name("password");
    protected static final By signInButtonSelector = By.className("primaryAction");
    protected static final By signInPageHeaderSelector = By.xpath("//h1[text()='Existing User? Sign In Now']");
    protected static final By logoutLinkSelector = By.xpath("//a[@href='/logout/']");


    /**
     * Constructor for LoginPage.
     * @param driver WebDriver instance.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    /**
     * Initializes web elements.
     */
    protected void initializeWebElements(){
        emailInput = driver.findElement(emailInputSelector);
        passwordInput = driver.findElement(passwordInputSelector);
        signInButton = driver.findElement(signInButtonSelector);
        signInPageHeader = driver.findElement(signInPageHeaderSelector);
    }

    protected void navigateToPage(){
        driver.get(LOGIN_URL);
    }
    /**
     * Logs in as admin.
     */
    public void loginAsAdmin() {
        navigateToPage();
        PageLoadWaiter.wait(driver);
        initializeWebElements();
        login(ADMIN_EMAIL,ADMIN_PASSWORD);
    }

    /**
     * Logs in with provided email and password.
     * @param emailAddress Email address.
     * @param password Password.
     */
    protected void login(String emailAddress, String password) {
        if (!isOnLoginPage()) {
            throw new IllegalStateException("Not on the login page");
        }
        // enter the info
        enterEmail(emailAddress);
        enterPassword(password);
        //click the login button
        clickSignInButton();
        //wait for respond and get the top link elements
        PageLoadWaiter.wait(driver);

        if (!isLoggedIn()) {
            throw new IllegalStateException("Login failed");
        }
    }

    /**
     * Enters email.
     * @param emailAddress Email address.
     */
    protected void enterEmail(String emailAddress) {
        emailInput.sendKeys(emailAddress);
    }

    /**
     * Enters password.
     * @param password Password.
     */
    protected void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    /**
     * Clicks login button.
     */
    protected void clickSignInButton() {
        signInButton.click();
    }

    /**
     * Checks if on login page.
     * @return True if on login page, false otherwise.
     */
    protected boolean isOnLoginPage() {
        return signInPageHeader != null;
    }

    /**
     * Checks if already log in. Depend on if the log out link exist
     * @return True if already log in, false otherwise.
     */
    protected  boolean isLoggedIn(){
        return isLogoutLinkPresent();
    }

    /**
     * Checks if logout link is present.
     * @return True if logout link is present, false otherwise.
     */
    protected boolean isLogoutLinkPresent() {
        try{
            logoutLink = driver.findElement(logoutLinkSelector);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
