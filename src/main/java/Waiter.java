import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Waiter {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        try {
            driver.get("https://hotline.ua/");
            WebElement element = driver.findElement(By.xpath("//div[@class='informer-translation-error content']"));
            System.out.println(isElementLoaded(driver, element));
        } finally {
            driver.quit();
        }
    }

    public static String isElementLoaded(WebDriver driver, WebElement loadElement) {
        WebElement f = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds((long) 20.0))
                .pollingEvery(Duration.ofSeconds((long) 5.0))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(loadElement));
        return f.getText();
    }
}
/*
Example 1 .elementToBeClickable()
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            //Initialize and wait till element became clickable - timeout in 10 seconds
            driver.get("https://hotline.ua/");
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='informer-translation-error content']")));
            System.out.println(element.getText());
        } finally {
            driver.quit();
        }

Example 2 .visibilityOfElementLocated()
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://www.softserveinc.com/uk-ua");

            driver.findElement(By.xpath("//a[@class='menu__search menu__search_background_white']")).click();

            new WebDriverWait(driver, Duration.ofSeconds(4))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@class='form-input__text']")));
            WebElement searchInput = driver.findElement(By.xpath("//div/input[@class='form-input__text']"));
            searchInput.sendKeys("academy");
            searchInput.sendKeys(Keys.ENTER);

            new WebDriverWait(driver, Duration.ofSeconds(4))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='search-card__title']")))
                    .isDisplayed();
            List<WebElement> results = driver.findElements(By.xpath("//h3[@class='search-card__title']"));
            String firstResultTitle = results.get(0).getText();

            System.out.println(firstResultTitle.equals("IT Академія"));
        } finally {
            driver.quit();
        }

Example 3 .implicitlyWait()
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        try {
            driver.get("https://www.softserveinc.com/uk-ua");

            driver.findElement(By.xpath("//a[@class='menu__search menu__search_background_white']")).click();

            WebElement searchInput = driver.findElement(By.xpath("//div/input[@class='form-input__text']"));
            searchInput.sendKeys("academy");
            searchInput.sendKeys(Keys.ENTER);

            List<WebElement> results = driver.findElements(By.xpath("//h3[@class='search-card__title']"));
            String firstResultTitle = results.get(0).getText();

            System.out.println(firstResultTitle.equals("IT Академія"));
        } finally {
            driver.quit();
        }

Example 4 fluent wait
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        try {
            driver.get("https://hotline.ua/");
            WebElement element = driver.findElement(By.xpath("//div[@class='informer-translation-error content']"));
            System.out.println(isElementLoaded(driver, element));
        } finally {
            driver.quit();
        }
    }

    public static String isElementLoaded(WebDriver driver, WebElement loadElement) {
        WebElement f = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds((long) 20.0))
                .pollingEvery(Duration.ofSeconds((long) 5.0))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOf(loadElement));
        return f.getText();
    }
 */
