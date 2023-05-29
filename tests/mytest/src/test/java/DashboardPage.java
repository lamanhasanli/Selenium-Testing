import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://coursehunter.net/");
        if (!driver.getTitle().contains("CourseHunter")) {
            throw new IllegalStateException("This is not HomePage of logged in user," +
                  " current page is: " + driver.getCurrentUrl());
          }
    }    

    private By searchBarTogglerBy = By.xpath("//button[@class='main-header-search']");
    private By searchBarBy = By.xpath("//input[@class='main-search-input']");
    private By logoutBy = By.xpath("//div[contains(@class, 'main-header-side-right')]"); 

    public SearchResultPage search(String searchQuery) {
        this.waitAndReturnElement(searchBarTogglerBy).click();
        this.waitAndReturnElement(searchBarBy).sendKeys(searchQuery + "\n");
        return new SearchResultPage(this.driver);
    }

    public boolean isPageOpen() {
        return driver.getTitle().contains("CourseHunter");
    }

    public HomePage clickLogout() {
        this.waitAndReturnElement(logoutBy).click();
        return new HomePage(this.driver);
    }         
}