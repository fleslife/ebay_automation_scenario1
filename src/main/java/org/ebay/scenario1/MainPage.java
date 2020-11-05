package org.ebay.scenario1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {
    private WebDriver driver;
    JavascriptExecutor js;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test() throws InterruptedException {
        //Maximize browser
        driver.manage().window().maximize();

        //Open site "ebay.com"
        driver.get("https://www.ebay.com");

        //Click "Navigate Menu"
        driver.findElement(By.id("gh-shop-ei")).click();

        //Click "Cell phones & accessories"
        driver.findElement(By.linkText("Cell phones & accessories")).click();

        //Click "Cell Phones & Smartphones"
        driver.findElement(By.xpath("//a[contains(text(),'Cell Phones & Smartphones')]")).click();

        //Scroll to "More refinements"
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor MoreRefinements = (JavascriptExecutor) driver;
        WebElement _MoreRefinements = driver.findElement(By.xpath("//button[contains(text(),'More refinements')]"));
        MoreRefinements.executeScript("arguments[0].scrollIntoView(true);", _MoreRefinements);

        //Click "More refinements"
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[contains(text(),'More refinements')]")).click();
                
        //Select "Screen Size
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//form[@id='x-overlay__form']//child::div)[11]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='c3-subPanel-Screen%20Size_6%20in%20or%20More_cbx']")).click();
       
        //Select "Price"
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id='c3-mainPanel-price']")).click();
      
        //Input field "Price from"
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement PriceFrom = driver.findElement(By.xpath("(//input[@class='x-textrange__input x-textrange__input--from'])[2]"));
        PriceFrom.sendKeys("1000000");

        //Input field "Price to"
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement PriceTo = driver.findElement(By.xpath("(//input[@class='x-textrange__input x-textrange__input--to'])[2]"));
        PriceTo.sendKeys("8000000");

        //Select "Item Location"
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@id='c3-mainPanel-location']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//input[@data-value='Asia'])[2]")).click();

        //Click "Apply"
        driver.findElement(By.xpath("//button[@aria-label='Apply']")).click();
        
        //Go to Filter result
        driver.get("https://www.ebay.com/b/6-Inch-or-More-Cell-Phones-Smartphones/9355/bn_80192836?rt=nc&_udlo=1000000&_udhi=8000000&LH_PrefLoc=6");

        //Verify Filter Result
        driver.findElement(By.xpath("//*[text()='6 Inch or More Cell Phones & Smartphones between IDR1,000,000.00 and IDR8,000,000.00']"));
        Thread.sleep(5000);
   }

}
