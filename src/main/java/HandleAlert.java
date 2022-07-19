import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandleAlert {
    WebDriver driver;
    public HandleAlert(WebDriver driver) {
        this.driver = driver;
    }

    private final String pageUrl = "https://demo.seleniumeasy.com/bootstrap-modal-demo.html#";
    private final By launchModalButton = By.xpath("//a[contains(@href, 'myModal0')]");
    private final By modalBody = By.xpath("//div[@id=\"myModal0\"]//div[@class=\"modal-body\"]");
    private final By closeButtons = By.xpath("//div[@class=\"modal-header\"]/button[@class=\"close\"]");


    public void navigate() {
        driver.navigate().to(pageUrl);
    }

    public String readFromModal() {
        driver.findElement(launchModalButton).click();
        return driver.findElement(modalBody).getAttribute("innerText").trim();
    }
    public void closeModal() {
        driver.findElements(closeButtons).get(0).click();
    }
}
