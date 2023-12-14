import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BuyMonitorTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement searchGoogleField = driver.findElement(By.id("APjFqb"));
        searchGoogleField.sendKeys("prom ua");

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pcTkSc']")));
        List<WebElement> searchGoogleResults = driver.findElements(By.xpath("//div[@class='pcTkSc']"));
        searchGoogleResults.get(4).click();

        WebElement searchGoogleResult = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        searchGoogleResult.click();

        List<WebElement> catalogList = driver.findElements(By.xpath("//a[@class='_0cNvO JcwiH']"));
        new Actions(driver)
                .moveToElement(catalogList.get(3))
                .perform();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='nSa3G']")));
        List<WebElement> computersCatalog = driver.findElements(By.xpath("//div/a[@data-qaid='submenu_category']"));
        computersCatalog.get(2).click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='Ekgwv df3jW CSxkQ Jo-HX xHm8h']")));
        List<WebElement> places = driver.findElements(By.xpath("//label[@class='Ekgwv df3jW CSxkQ Jo-HX xHm8h']"));
        places.get(0).click();

        WebElement typeOfMatrix = driver.findElement(By.xpath("//button[@data-qatype='Тип матриці']"));
        typeOfMatrix.click();

        List<WebElement> typesOfMatrix = driver.findElements(By.xpath("//li/label[@class='Ekgwv df3jW']"));
        typesOfMatrix.get(25).click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='l-GwW js-productad']")));
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='l-GwW js-productad']"));
        searchResults.get(3).click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MafxA _6xArK WIR6H']")));
        WebElement textOfMonitor = driver.findElement(By.xpath("//div[@class='MafxA _6xArK WIR6H']"));
        System.out.println(textOfMonitor.getText());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
