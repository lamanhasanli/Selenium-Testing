import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class SeleniumTest {
    public WebDriver driver;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testSignInPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLanguage();
        homePage.clickLogin();
    }

    @Test
    public void testLoadSignUpPage() {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.clickSignUp();
        Assert.assertTrue(signUpPage.getBodyText().contains("Please sign up to continue"));
    }

    @Test
    public void testLoadSignInPage()
    {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickSignIn();
        Assert.assertTrue(signInPage.getBodyText().contains("Please sign in to continue"));
    }

    @Test
    public void testLoadDashboardPage()
    {
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isPageOpen());
        Assert.assertTrue(dashboardPage.getPageTitle().contains("CourseHunter"));
    }

    @Test
    public void testNavigateSignUpPage() {
        SignInPage signInPage = new SignInPage(driver);
        SignUpPage signUpPage = signInPage.clickSignUpBtn();
        Assert.assertTrue(signUpPage.getBodyText().contains("Please sign up to continue"));
    }

    @Test
    public void testValidLogin() {
        SignInPage signInPage = new SignInPage(driver);
        DashboardPage dashboardPage = signInPage.loginValidUser("jejijow995@mevori.com", "jejijow995@mevori.com");
        Assert.assertTrue(dashboardPage.getBodyText().contains("Learn It! - Developer courses")); //jejijow995@mevori.com
    }
    
    @Test
    public void testValidLoginEnter() {
        SignInPage signInPage = new SignInPage(driver);
        DashboardPage dashboardPage = signInPage.loginValidUserEnter("jejijow995@mevori.com", "jejijow995@mevori.com");
        Assert.assertTrue(dashboardPage.getBodyText().contains("Learn It! - Developer courses")); //jejijow995@mevori.com
    }

    @Test
    public void testInvalidLogin() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.loginInvalidUser("jejijow995@mevori.com", "jejijow995");
        Assert.assertTrue(signInPage.getBodyText().contains("Wrong password"));
    }

    @Test
    public void testLogOut() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        HomePage homePage = dashboardPage.clickLogout();
        Assert.assertTrue(homePage.getBodyText().contains("SIGN UP"));
    }

    // it is needed to update user and password for each test
    // @Test
    // public void testValidSignUp() {
    //     SignUpPage signUpPage = new SignUpPage(driver);
    //     SignUpSuccessPage signUpSuccessPage = signUpPage.signUpUser("bala@lipa.com", "bala@lipa.com", "bala@lipa.com");
    //     Assert.assertTrue(signUpSuccessPage.getBodyText().contains("Success")); 
    // }

    @Test
    public void testInvalidSignUp() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpInvalidUser("jejijow995@mevori.com", "jejijow995@mevori.com", "jejijow995@mevori.com");
        Assert.assertTrue(signUpPage.getBodyText().contains("Email already exists"));
    }

    @Test
    public void testSearch() {
        DashboardPage dashboardPage = new DashboardPage(this.driver);
        SearchResultPage searchResultPage = dashboardPage.search("CSS");
        Assert.assertTrue(searchResultPage.getBodyText().contains("CSS"));
    }
    
    @Test
    public void testSearchMultiple() {
        String[] searchQueries={"CSS","","JS"};  
        for(String searchQuery : searchQueries) {  
            DashboardPage dashboardPage = new DashboardPage(this.driver);
            SearchResultPage searchResultPage = dashboardPage.search(searchQuery);
            Assert.assertTrue(searchResultPage.getBodyText().contains("CSS"));
        }  
    }

    @Test
    public void testRadioButton() {
        CategoryPage categoryPage = new CategoryPage(driver);
        FilteredPage filteredPage = categoryPage.radioButton();
        categoryPage.SelectedRadioButton();
        Assert.assertTrue(filteredPage.getBodyText().contains("4.5"));
    }

    @Test
    public void testHover() {
        FilteredPage filteredPage = new FilteredPage(driver);
        CategoryPage categoryPage = filteredPage.hoverAndClick();
        Assert.assertTrue(categoryPage.getBodyText().contains("Python"));
    }

    @Test
    public void testHistoryBrowser() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
        driver.navigate().back();
        String currentPageUrl = driver.getCurrentUrl();
        System.out.println("Current Page URL: " + currentPageUrl);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}