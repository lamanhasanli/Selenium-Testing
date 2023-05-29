import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://coursehunter.net/category/python");
    }    

    private By radioBy = By.xpath("//*[@id='filter-form']/div[1]/div[1]/div[2]/div/div/label[1]");
    private By radioBtnGroupBy = By.xpath("//*[@role='group']");

    public FilteredPage radioButton() {
        driver.findElement(radioBy).click();
        return new FilteredPage(driver);
    }   
    
    public void SelectedRadioButton() {
        WebElement radioButtonGroup = driver.findElement(radioBtnGroupBy);
        WebElement selectedRadioButton = radioButtonGroup.findElement(By.cssSelector("input[type='radio']:checked"));
        String selectedValue = selectedRadioButton.getAttribute("value");
        System.out.println("Selected Value: " + selectedValue);
    }   
}