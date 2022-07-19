import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TestInput() {
        TwoInputFields twoInputFields = new TwoInputFields(driver);

        twoInputFields.navigate();
        int actual = twoInputFields.sumOfTwoNumbers("4", "3");
        int expected = 7;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SelectDayTest() {
        SelectList selectList = new SelectList(driver);

        selectList.navigate();
        String actual = selectList.selectListItem();
        String expected = "Sunday";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void AlertTest() {
        HandleAlert handleAlert = new HandleAlert(driver);

        handleAlert.navigate();
        String actual = handleAlert.readFromModal();
        String expected = "This is the place where the content for the modal dialog displays";
        handleAlert.closeModal();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NamecardTest() {
        NameCards nameCards = new NameCards(driver);
        nameCards.navigate();

        List<String> actual =  nameCards.readNamesFromList();
        List<String> expected = Arrays.asList("Tyreese Burn", "Brenda Tree", "Glenn Pho shizzle", "Brian Hoyies", "Glenn Pho shizzle", "Arman Cheyia");

        Assertions.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void TableTest() {
        String fileName = "names.txt";
        WriteToFile writeToFile = new WriteToFile(driver);

        writeToFile.navigate();
        writeToFile.writeNamesToFile(fileName);
        String actual = writeToFile.readFromFile(fileName);
        String expected = "Name Position\n" +
                "Tiger Nixon\n" +
                "Garrett Winters\n" +
                "Ashton Cox\n" +
                "Cedric Kelly\n" +
                "Airi Satou\n" +
                "Brielle Williamson\n" +
                "Herrod Chandler\n" +
                "Rhona Davidson\n" +
                "Colleen Hurst\n" +
                "Sonya Frost\n" +
                "Jena Gaines\n" +
                "Quinn Flynn\n" +
                "Charde Marshall\n" +
                "Haley Kennedy\n" +
                "Tatyana Fitzpatrick\n" +
                "Michael Silva\n" +
                "Paul Byrd\n" +
                "Gloria Little\n" +
                "Bradley Greer\n" +
                "Dai Rios\n" +
                "Jenette Caldwell\n" +
                "Yuri Berry\n" +
                "Caesar Vance\n" +
                "Doris Wilder\n" +
                "Angelica Ramos\n" +
                "Gavin Joyce\n" +
                "Jennifer Chang\n" +
                "Brenden Wagner\n" +
                "Fiona Green\n" +
                "Shou Itou\n" +
                "Michelle House\n";
        writeToFile.clearFileContent();
        Assertions.assertEquals(expected, actual);
    }

}
