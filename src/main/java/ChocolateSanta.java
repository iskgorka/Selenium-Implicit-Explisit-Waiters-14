import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChocolateSanta {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            System.out.println("Current URL is: " + driver.getCurrentUrl());
            WebElement searchGoogleField = driver.findElement(By.id("APjFqb"));
            searchGoogleField.sendKeys("prom ua");

            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='pcTkSc']")));
            List<WebElement> searchGoogleResults = driver.findElements(By.xpath("//div[@class='pcTkSc']"));
            searchGoogleResults.get(0).click();

            WebElement searchGoogleResult = driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
            searchGoogleResult.click();
            System.out.println("Current URL is: " + driver.getCurrentUrl());

            WebElement searchPromField = driver.findElement(By.xpath("//div/input[@type='search']"));
            searchPromField.sendKeys("шоколадний дід мороз");
            searchPromField.sendKeys(Keys.ENTER);

            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='l-GwW js-productad']")));
            List<WebElement> searchPromResults = driver.findElements(By.xpath("//div[@class='l-GwW js-productad']"));
            searchPromResults.get(1).click();

            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@data-qaid='product_name']")));
            WebElement searchResultTitle = driver.findElement(By.xpath("//h1[@data-qaid='product_name']"));
            searchResultTitle.isDisplayed();
            System.out.println(searchResultTitle.getText());

            WebElement buyButton = driver.findElement(By.xpath("//button[@class='VS-Ex uTnwV YY-wN vtaL-']"));
            System.out.println(buyButton.getText());
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(buyButton));
            buyButton.click();

            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("react-portal")));
            WebElement cartPopup = driver.findElement(By.id("react-portal"));
            System.out.println(cartPopup.getText());

            System.out.println(buyButton.getText());
            buyButton.click();

            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='remove_btn']")));
            WebElement removeButton = driver.findElement(By.xpath("//button[@data-testid='remove_btn']"));
            removeButton.click();

            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-testid='snackbar']")));
            WebElement finalMessage = driver.findElement(By.xpath("//div[@data-testid='snackbar']"));
            System.out.println(finalMessage.getText());

        } finally {
            driver.quit();
        }
    }
}
