import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class NameCards {
    WebDriver driver;
    public NameCards(WebDriver driver) {
        this.driver = driver;
    }

    private final String pageUrl = "https://demo.seleniumeasy.com/data-list-filter-demo.html";
    private final By cardNames = By.xpath("//h4[contains(text(),\"Name\")]");


    public void navigate() {
        driver.navigate().to(pageUrl);
    }

    public List<String> readNamesFromList() {
        List<WebElement> nameElements = driver.findElements(cardNames);
        List<String> nameList = Arrays.asList(new String[nameElements.size()]);
        for(int i = 0; i < nameElements.size(); i++) {
            nameList.set(i, nameElements.get(i).getText().split(": ")[1]);
        }
        return nameList;
    }
}
