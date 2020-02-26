package WebTest;

import org.openqa.selenium.By;

public class CompareSuccessPage extends Utils
{
    private By _compareSuccessMassage = By.xpath("//div[@class='page-title']");
    String expected = "Compare products";
    public void verifyUserShouldSeeCompareSuccessMassage()
    {
        assertURL("compareproducts");
        //assertTextMessage("Compare massage not display",expected,_compareSuccessMassage);

    }
}
