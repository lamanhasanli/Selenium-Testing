import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

class SignInPage extends BasePage {
    
    private By userBy = By.xpath("//div//input[contains(@name, 'email')]");
    private By passwordBy = By.xpath("//div//input[contains(@id, 'password')]");
    private By loginBy = By.xpath("//form//div[contains(@class, 'btn-group')]"); 
    private By signUpBtnBy = By.xpath("//div[@class='auth-group']//a[text()='Sign Up']");

    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://coursehunter.net/sign-in");
    }   

    public DashboardPage loginValidUser(String userName, String password) {
        driver.findElement(userBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();
        return new DashboardPage(driver);
    }

    public DashboardPage loginValidUserEnter(String userName, String password) {
        driver.findElement(userBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password + Keys.RETURN);
        return new DashboardPage(driver);
    }

    public void loginInvalidUser(String userName, String password) {
        driver.findElement(userBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginBy).click();
    }

    public SignUpPage clickSignUpBtn() {
        driver.findElement(signUpBtnBy).click();
        return new SignUpPage(driver);
    }
}