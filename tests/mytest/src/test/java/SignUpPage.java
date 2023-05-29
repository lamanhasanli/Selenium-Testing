import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


class SignUpPage extends BasePage {
    
    private By userBy = By.xpath("//div//input[contains(@name,'email')]");
    private By passwordBy = By.xpath("//div//input[@name = 'password']");
    private By confirmPasswordBy = By.xpath("//div//input[@name = 'password_confirm']");
    private By sigUpBy = By.xpath("//div//button[@type = 'submit']");


    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://coursehunter.net/sign-up");
    }   

    public SignUpSuccessPage signUpUser(String userName, String password, String confirm_password) {
        driver.findElement(userBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(confirmPasswordBy).sendKeys(confirm_password);
        driver.findElement(sigUpBy).click();
        return new SignUpSuccessPage(driver);
    }

    public void signUpInvalidUser(String userName, String password, String confirm_password) {
        driver.findElement(userBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(confirmPasswordBy).sendKeys(confirm_password);
        driver.findElement(sigUpBy).click();
    }
}