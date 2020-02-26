package WebTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// util class created to store reusable methods
public class Utils
{   // declared web driver
    static protected WebDriver driver;

    // method created for wait for clickable
    public void waitForClickable(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until( ExpectedConditions.elementToBeClickable(by));
    }


    public void waitForVisibility(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //wait for element present
    public void waitForElementsPresent(By by,int time)
    {  WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void dropDrownVisibletext(By by,String text)
    { Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    //
    public void dropDownIndex(By by,int number)
    {Select select = new Select(driver.findElement(by));
        select.selectByIndex(number);
    }

    public void dropDownValue(By by,String text)
    { Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    public static String timeStamp()
    {
        DateFormat dateFormat = new SimpleDateFormat("ddmmyyhhmmss");
        Date date=new Date();
        return dateFormat.format(date);
    }
    public static void clickOnElement(By by)

    {
        driver.findElement(by).click();
    }

    public void clearAndEnterText(By by, String text)
    {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void checkBoxClick(By by)
    {
        driver.findElement( by ).click();
    }

    public void enterText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    public static String getTextElement(By by)
    {
        String get_text = driver.findElement( by ).getText();
        return get_text;
    }

    public static void assertTextMessage(String massage, String expected, By by)
    {
        String actual =  getTextElement(by);
        Assert.assertEquals(massage,expected,actual);
    }

    public static void assertURL(String text)
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(text));

    }

    public static void sleep(int time)
    {
        try {
            Thread.sleep(time *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void verifyElementIsDisplayed(By by)
    {
        Assert.assertTrue(driver.findElement(by).isDisplayed());
    }

    public static void scrollAndClick(By by){
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
}
