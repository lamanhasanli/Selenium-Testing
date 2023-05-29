import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver.get("https://coursehunter.net/");
    } 

    private By clickLanguageBy = By.xpath("//div//button[@title= 'English']");
    private By signInBy = By.xpath("//div//a[@href='https://coursehunter.net/sign-in']");
    private By signUpBy = By.xpath("//div//a[@href='https://coursehunter.net/sign-up']");

    public void clickLanguage() {
		driver.findElement(clickLanguageBy).click();
	}

    public void clickLogin() {
		driver.findElement(signInBy).click();
	}

    public SignInPage clickSignIn() {
        driver.findElement(signInBy).click();
        return new SignInPage(driver);
	}

    public SignUpPage clickSignUp() {
        driver.findElement(signUpBy).click();
        return new SignUpPage(driver);
	}
}