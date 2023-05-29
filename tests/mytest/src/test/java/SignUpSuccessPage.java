import org.openqa.selenium.WebDriver;

class SignUpSuccessPage extends BasePage {

    public SignUpSuccessPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://coursehunter.net/sign-up-success");
    }   
}