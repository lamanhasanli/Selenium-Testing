import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


class FilteredPage extends BasePage {

    public FilteredPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://coursehunter.net/category/python?sort=created_at&order=desc&rating=4.5");
    }

    private By menuOption = By.xpath("/html/body/header/div/div[1]/div/ul/li[1]");
    private By submenuOption = By.xpath("/html/body/header/div/div[1]/div/ul/li[1]/ul/li[2]");
    private By selectMenuOption = By.xpath("/html/body/header/div/div[1]/div/ul/li[1]/ul/li[2]/ul/li[2]");
    
    public CategoryPage hoverAndClick() {
        //Creating object of an Actions class
        Actions action = new Actions(driver);
        
        //Performing the mouse hover action on the target element
        action.moveToElement(driver.findElement(menuOption)).perform();
    	System.out.println("Done Mouse hover on 'Category'");
    	
        action.moveToElement(driver.findElement(submenuOption)).perform();
    	System.out.println("Done Mouse hover on 'Backend'");
    	
        driver.findElement(selectMenuOption).click();
    	System.out.println("Selected 'Python'");
        return new CategoryPage(driver);
    }
}