import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectList {
    WebDriver driver;
    public SelectList(WebDriver driver) {
        this.driver = driver;
    }

    private final String pageUrl = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";
    private final By selectList = By.xpath("//select[@id=\"select-demo\"]");
    private final By selectValue = By.xpath("//option[@value=\"Sunday\"]");
    private final By selectedValue = By.xpath("//p[@class=\"selected-value\"]");


    public void navigate() {
        driver.navigate().to(pageUrl);
    }

    public String selectListItem() {
        driver.findElement(selectList).click();
        driver.findElement(selectValue).click();

        return driver.findElement(selectedValue).getText().split(":- ")[1];
    }
}
