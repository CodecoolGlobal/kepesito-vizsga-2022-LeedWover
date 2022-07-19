import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwoInputFields {
    WebDriver driver;
    public TwoInputFields(WebDriver driver) {
        this.driver = driver;
    }

    private final String pageUrl = "https://demo.seleniumeasy.com/basic-first-form-demo.html";
    private final By inputA = By.xpath("//input[@id=\"sum1\"]");
    private final By inputB = By.xpath("//input[@id=\"sum2\"]");
    private final By getTotalButton = By.xpath("//form[@id=\"gettotal\"]/button");
    private final By value = By.xpath("//span[@id=\"displayvalue\"]");


    public void navigate() {
        driver.navigate().to(pageUrl);
    }

    public int sumOfTwoNumbers(String numA, String numB) {
        driver.findElement(inputA).sendKeys(numA);
        driver.findElement(inputB).sendKeys(numB);

        driver.findElement(getTotalButton).click();
        String resultValue = driver.findElement(value).getText();
        return Integer.parseInt(resultValue);
    }

}
