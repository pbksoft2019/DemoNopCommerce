package WebTest;

import org.openqa.selenium.By;

public class HomePage extends Utils
{
    private By _registerLink = org.openqa.selenium.By.linkText("Register");
    private By _compareFirstProduct = org.openqa.selenium.By.xpath("//div/div[2]/div/div[2]/div[3]/div[2]/input[@value='Add to compare list']");
    private By _compareSecondProduct = org.openqa.selenium.By.xpath("//div/div[3]/div/div[2]/div[3]/div[2]/input[@value='Add to compare list']");
    private By _compareProduct = org.openqa.selenium.By.linkText("product comparison");
    private By _displayBarField = org.openqa.selenium.By.cssSelector("div.bar-notification.success");
    private By _productClick = org.openqa.selenium.By.linkText("Apple MacBook Pro 13-inch");
    private By _email = org.openqa.selenium.By.className("button-2 email-a-friend-button");
    private By _clickOnBook = org.openqa.selenium.By.linkText("Books");
    public void clickOnRegisterButton() {
        clickOnElement(_registerLink);

    }
    public void clickOnCompareProduct()
    {
        clickOnElement(_compareFirstProduct);
        //verifying
        verifyElementIsDisplayed(_displayBarField);

        clickOnElement(_compareSecondProduct);
        //verifying
        verifyElementIsDisplayed(_displayBarField);

        //
        clickOnElement(_compareProduct);

    }
    public void clickOnProduct()
    {
        waitForClickable(_productClick,10);
        sleep(3);
//        clickOnElement(_productClick);
        scrollAndClick(_productClick);
    }
    public void clickOnBookCategory()
    {
        clickOnElement(_clickOnBook);

    }

}
