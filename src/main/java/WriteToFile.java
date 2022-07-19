import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class WriteToFile {
    WebDriver driver;
    public WriteToFile(WebDriver driver) {
        this.driver = driver;
    }

    private final String pageUrl = "https://demo.seleniumeasy.com/table-data-download-demo.html";
    private final By nameList = By.tagName("tr");


    public void navigate() {
        driver.navigate().to(pageUrl);
    }

    public void writeNamesToFile(String fileName) {
        List<WebElement> elements = driver.findElements(nameList);
        for(WebElement element : elements) {
            try {
                FileWriter writer = new FileWriter(fileName, true);
                // ha az element.findElement(By.xpath("./td"))- vel próbálkoztam, akkor akárhogy variáltam, soha nem találta meg a td-t.
                // Talán az zavarhatta meg, hogy az első sorom th, nem td. Már nem volt időm megfejteni sajnos. :(
                writer.write(element.getText().split(" ")[0] + " " + element.getText().split(" ")[1] + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    public String readFromFile(String fileName) {
        String result = "";
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result += data + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return result;
    }

    public void clearFileContent() {
        try {
            FileWriter writer = new FileWriter("names.txt");
            writer.write("");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
